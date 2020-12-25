package kutuphaneproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import kutuphaneproje.Interface.IDbHelper;

public class DbHelper implements IDbHelper{
    
     @Override
     public Connection getConnection() throws SQLException{//C:\Users\o\Desktop\KutuphaneProjeDesign\KutuphaneProje\KutuphaneProje
         return DriverManager.getConnection("jdbc:ucanaccess://C://Users//o//Downloads//172119016_182120030_Kutuphane//VeriTabanı//LibraryJava.accdb");
     }
     
     @Override
     public void showErrorMessage(SQLException e){
         System.out.println("Error: "+ e.getMessage());
         System.out.println("Error Code: "+ e.getErrorCode());
     }
}
