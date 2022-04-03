import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class DatabaseConnection {
    Connection conn = null;
   
    public static Connection ConnectDb() {
            try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root", "Mazahaka228!");;
        JOptionPane.showMessageDialog(null,"ConnectionEstablished");
        return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null;
}
    
    } 
    public static ObservableList<info> getDatainfo(){
        Connection conn = ConnectDb();
        ObservableList<info> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareCall("select * from class");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new info(Integer.parseInt(rs.getString("idclass")),rs.getString("kindclass"), rs.getString("nameclass"), rs.getString("infoclass")));            
            }         
        }catch(Exception e){  
        }
        return list;
    }
}
