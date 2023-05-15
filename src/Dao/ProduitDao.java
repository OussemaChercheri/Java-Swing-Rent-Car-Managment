
package Dao;

import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProduitDao {
    java.sql.Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public int getMaxRow(){
        int row = 0;
        try{
            st = con.createStatement();
            rs = st.executeQuery("select max(id) from produit");
            while (rs.next()) {
                row = rs.getInt(1);
                
            }
        } catch (SQLException ex){
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    public boolean isIDExist (int id){
        try{
            ps = con.prepareStatement("select * from produit where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void getProduit(JTable table, String search){
        String sql = "select * from produit where concat(id, nom, cat) like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+search+"%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object [] row;
            while(rs.next()){
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
        } catch (SQLException ex){
            Logger.getLogger(ProduitDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

}
