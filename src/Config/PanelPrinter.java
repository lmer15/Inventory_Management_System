package Config;

import java.awt.*;
import java.awt.print.*;
import javax.swing.JPanel;

public class PanelPrinter implements Printable {

    private JPanel panelToPrint;

    public PanelPrinter(JPanel panelToPrint) {
        this.panelToPrint = panelToPrint;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        double panelWidth = panelToPrint.getWidth();
        double panelHeight = panelToPrint.getHeight();
        double pageWidth = pageFormat.getImageableWidth();
        double pageHeight = pageFormat.getImageableHeight();

        // Calculate scale factor to fit the panel within the printable area
        double scaleX = pageWidth / panelWidth;
        double scaleY = pageHeight / panelHeight;
        double scaleFactor = Math.min(scaleX, scaleY);

        // Apply scaling
        g2d.scale(scaleFactor, scaleFactor);

        // Render the panel
        panelToPrint.printAll(g2d);

        return Printable.PAGE_EXISTS;
    }

    public void printPanel() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
