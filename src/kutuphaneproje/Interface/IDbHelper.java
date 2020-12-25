package kutuphaneproje.Interface;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbHelper {//1. Arayüz
   public Connection getConnection()throws SQLException;
   public void showErrorMessage(SQLException e);
}
