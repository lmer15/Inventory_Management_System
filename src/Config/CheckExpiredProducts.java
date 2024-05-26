package Config;

import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckExpiredProducts {

    public static void checkAndMoveExpiredProducts() {

        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = dbc.getConnection();
            conn.setAutoCommit(false);

            // Get current date
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDateStr = dateFormat.format(currentDate);

            // Query to select expired products from output table
            String selectQuery = "SELECT * FROM output WHERE O_ExpiryDate < ?";
            pst = conn.prepareStatement(selectQuery);
            pst.setString(1, currentDateStr);
            rs = pst.executeQuery();

            while (rs.next()) {
                int productID = rs.getInt("product_ID");
                String manufacturingDate = rs.getString("O_ManufacturingDate");
                String expiryDate = rs.getString("O_ExpiryDate");

                String insertDamageQuery = "INSERT INTO damageproduct (product_ID, DamageQuantity, ManufacturingDate, ExpiryDate, Status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertDamagePst = conn.prepareStatement(insertDamageQuery);
                insertDamagePst.setInt(1, productID);
                insertDamagePst.setInt(2, rs.getInt("O_Quantity"));
                insertDamagePst.setString(3, manufacturingDate);
                insertDamagePst.setString(4, expiryDate);
                insertDamagePst.setString(5, "EXPIRED");
                insertDamagePst.executeUpdate();

                String deleteQuery = "DELETE FROM output WHERE product_ID = ? AND O_ManufacturingDate = ? AND O_ExpiryDate = ?";
                PreparedStatement deletePst = conn.prepareStatement(deleteQuery);
                deletePst.setInt(1, productID);
                deletePst.setString(2, manufacturingDate);
                deletePst.setString(3, expiryDate);
                deletePst.executeUpdate();
            }

            conn.commit(); // Commit transaction
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback transaction in case of error
                }
            } catch (SQLException e) {
                Logger.getLogger(CheckExpiredProducts.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(CheckExpiredProducts.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // Reset auto-commit
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(CheckExpiredProducts.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
