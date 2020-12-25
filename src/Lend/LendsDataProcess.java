package Lend;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import kutuphaneproje.DbHelper;
import kutuphaneproje.Interface.IDataList;
import kutuphaneproje.Interface.ILendsDataProcess;

public class LendsDataProcess implements ILendsDataProcess{ //implements ILendsDataProcess<Lends> {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;
    Cursor cr=null;
    String SqlQuery=null;
    
    ArrayList<Lends> _Lends=null;
    ArrayList<Lend> _Lend=null;
    DbHelper Helper=new DbHelper();
    
        public void Delete() throws SQLException {
            
        }

        public void Update(int _UserID,int _BookID,String _LendDateReceived,boolean _LendStatus) throws SQLException {
             SqlQuery="UPDATE Lend SET  LendDateReceived=?,LendStatus=? WHERE BookID = '"+ _BookID + "' AND UserID= '"+ _UserID + "'";
        try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            
            preparedStatement.setString(1, _LendDateReceived);
            preparedStatement.setBoolean(2, _LendStatus);
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
        }
         public void Update(int  _lendDay,int _lendID) throws SQLException {
        SqlQuery="UPDATE Lend SET LendDay=? WHERE  LendID='"+ _lendID + "'";
        try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            
            preparedStatement.setInt(1, _lendDay);
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
        }

        public void Add(int _UserID,int _BookID,String _LendDate,String _LendDateReceived,boolean _LendStatus,int _LendDay) throws SQLException {
        SqlQuery="INSERT INTO Lend(UserID,BookID,LendDate,LendDateReceived,LendStatus,LendDay) VALUES(?,?,?,?,?,?)";
        
         try{
         connection=Helper.getConnection();
         preparedStatement= connection.prepareStatement(SqlQuery);
         
        preparedStatement.setInt(1, _UserID);
        preparedStatement.setInt(2, _BookID);
        preparedStatement.setString(3, _LendDate);
        preparedStatement.setString(4, _LendDateReceived);
        preparedStatement.setBoolean(5, _LendStatus);
        preparedStatement.setInt(6, _LendDay);
         
         preparedStatement.executeUpdate();
         }
         catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
        }


    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override//Buraya Lend ile ilgili bir hata olduğunu bildirir bir mesaj döndür ve bu methodu bastır
    public void showErrorMessage(SQLException e) {
         System.out.println("Error: "+ e.getMessage());
         System.out.println("Error Code: "+ e.getErrorCode());
    }
    
             // ---------------- İNNER CLASS ----------------
     public class DataList implements IDataList<Lend>{

        @Override
        public ArrayList<Lend> GetAll() throws SQLException {//Teslim Edilmiş Emanet Kayıtları
            SqlQuery="SELECT Lend.LendID, Users.Name, Users.LastName,Users.TC, Books.BookISBN, Books.BookName, Lend.LendDate, Lend.LendDateReceived, Lend.LendStatus, Lend.LendDay FROM Books INNER JOIN (Users INNER JOIN Lend ON Users.UserID = Lend.UserID) ON Books.BookID = Lend.BookID WHERE Lend.LendStatus=1";

            try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           
           _Lend=new ArrayList<Lend>();
           
           while(resultSet.next()){
               _Lend.add(new Lend(
                            resultSet.getInt("LendID"),
                            resultSet.getString("Name"),
                            resultSet.getString("LastName"),
                            resultSet.getString("TC"),
                            resultSet.getString("BookISBN"),
                            resultSet.getString("BookName"),
                            resultSet.getString("LendDate"),
                            resultSet.getString("LendDateReceived"),
                            resultSet.getBoolean("LendStatus"),
                            resultSet.getInt("LendDay")
                            ));
           }
        }
        catch(SQLException e){
            Helper.showErrorMessage(e);
        }
        finally{
            statement.close();
            connection.close();
        }
        return _Lend;
        }
        
        
         public ArrayList<Lend> GetAll(String _Query) throws SQLException {//Teslim Edilmemiş Emanet Kayıtları
            SqlQuery=_Query;
            try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           
           _Lend=new ArrayList<Lend>();
           
           while(resultSet.next()){
               _Lend.add(new Lend(
                            resultSet.getInt("LendID"),
                            resultSet.getString("Name"),
                            resultSet.getString("LastName"),
                             resultSet.getString("TC"),
                            resultSet.getString("BookISBN"),
                            resultSet.getString("BookName"),
                            resultSet.getString("LendDate"),
                            resultSet.getString("LendDateReceived"),
                            resultSet.getBoolean("LendStatus"),
                            resultSet.getInt("LendDay")
                            ));
           }
        }
        catch(SQLException e){
            Helper.showErrorMessage(e);
        }
        finally{
            statement.close();
            connection.close();
        }
        return _Lend;
        }

        public ArrayList<Lend> GetAll(String StrValue, int intValue) throws SQLException //TC ye Göre Arama İşlemi
        {
           SqlQuery="SELECT Lend.LendID, Users.Name, Users.LastName,Users.TC, Books.BookISBN, Books.BookName, Lend.LendDate, Lend.LendDateReceived, Lend.LendStatus, Lend.LendDay FROM Books INNER JOIN (Users INNER JOIN Lend ON Users.UserID = Lend.UserID) ON Books.BookID = Lend.BookID WHERE Lend.LendStatus=1 AND Users.TC='"+ StrValue + "'";
        try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
            _Lend=new ArrayList<Lend>();
           
           while(resultSet.next()){
               _Lend.add(new Lend(
                            resultSet.getInt("LendID"),
                            resultSet.getString("Name"),
                            resultSet.getString("LastName"),
                             resultSet.getString("TC"),
                            resultSet.getString("BookISBN"),
                            resultSet.getString("BookName"),
                            resultSet.getString("LendDate"),
                            resultSet.getString("LendDateReceived"),
                            resultSet.getBoolean("LendStatus"),
                            resultSet.getInt("LendDay")
                            ));
           }
        }
        catch(SQLException e){
            Helper.showErrorMessage(e);
        }
        finally{
            statement.close();
            connection.close();
        }
        return _Lend;
        }
             // ---------------- İNNER CLASS ----------------
		
    }
 
}
