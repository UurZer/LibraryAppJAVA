package Books;

import Users.Users;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import kutuphaneproje.DbHelper;
import kutuphaneproje.Interface.IBookDataProcess;
import kutuphaneproje.Interface.IDataList;

public class BooksDataProcess implements IBookDataProcess,IDataList<Books>{
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;
    Cursor cr=null;
    String SqlQuery=null;
    ArrayList<Books> _Books=null;
     
     
    DbHelper Helper=new DbHelper();
    
    public void Delete(String _ISBN) throws SQLException {
         SqlQuery="DELETE FROM Books WHERE BookISBN = '"+ _ISBN + "'";
        try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
    }

    //Kitabın güncellenmesi
  public void Update(String _BookName, String _BookAuthor, int _BookPage, String _BookDate, int _BookBaski, String _BookISBN, String _UpdateISBN, Boolean _UpdateStatus) throws SQLException {
     SqlQuery="UPDATE Books SET BookName = ?,BookAuthor = ?,BookPage= ? ,BookDate = ? ,BookBaski= ?,BookISBN=?,BookStatus=? WHERE BookISBN = '"+ _UpdateISBN + "'";
        try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            
            preparedStatement.setString(1, _BookName);
            preparedStatement.setString(2, _BookAuthor);
            preparedStatement.setInt(3, _BookPage);
            preparedStatement.setString(4, _BookDate);
            preparedStatement.setInt(5, _BookBaski);
            preparedStatement.setString(6, _BookISBN);
            preparedStatement.setBoolean(7, _UpdateStatus);
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
    }
  public void Update(String _UpdateISBN,boolean _bookStatus) throws SQLException{//Kitabın Durumunun güncellenmesi
           SqlQuery="UPDATE Books SET BookStatus=? WHERE BookISBN = '"+ _UpdateISBN + "'";
      try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            
            preparedStatement.setBoolean(1, _bookStatus);
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
  }

    public void Add(String _BookName, String _BookAuthor, int _BookPage, String _BookDate, int _BookBaski, String _BookISBN) throws SQLException {
        SqlQuery="INSERT INTO Books(BookName,BookAuthor,BookPage,BookDate,BookBaski,BookISBN,BookStatus) VALUES(?,?,?,?,?,?,?)";
        
         try{
         connection=Helper.getConnection();
         preparedStatement= connection.prepareStatement(SqlQuery);
         
        preparedStatement.setString(1, _BookName);
        preparedStatement.setString(2, _BookAuthor);
        preparedStatement.setInt(3, _BookPage);
        preparedStatement.setString(4, _BookDate);
        preparedStatement.setInt(5, _BookBaski);
        preparedStatement.setString(6, _BookISBN);
        preparedStatement.setBoolean(7, true);
         
         preparedStatement.executeUpdate();//Kaydet
         }
         catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();//Kapatma
             connection.close();//Kapatma
         }
    }


    public ArrayList<Books> GetAll() throws SQLException {//Listeleme
         SqlQuery="SELECT * FROM Books";
        try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           _Books = new ArrayList<Books>();
           
           while(resultSet.next()){
                _Books.add(new Books(
                            resultSet.getInt("BookID"),
                            resultSet.getString("BookName"),
                            resultSet.getString("BookAuthor"),
                            resultSet.getInt("BookPage"),
                            resultSet.getString("BookDate"),
                            resultSet.getInt("BookBaski"),
                            resultSet.getString("BookISBN"),
                            resultSet.getBoolean("BookStatus")
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
        return _Books;

    }
     public ArrayList<Books> GetAll(String StrValue, int intValue) throws SQLException {//Arama Bulma
         SqlQuery="SELECT * FROM Books WHERE BookISBN= '"+ StrValue + "'";
        try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           _Books = new ArrayList<Books>();
           
           while(resultSet.next()){
               _Books.add(new Books(
                            resultSet.getInt("BookID"),
                            resultSet.getString("BookName"),
                            resultSet.getString("BookAuthor"),
                            resultSet.getInt("BookPage"),
                            resultSet.getString("BookDate"),
                            resultSet.getInt("BookBaski"),
                            resultSet.getString("BookISBN"),
                            resultSet.getBoolean("BookStatus")
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
        return _Books;
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void showErrorMessage(SQLException e) {
       System.out.println("Error: "+ e.getMessage());
       System.out.println("Error Code: "+ e.getErrorCode());
    }


  

   
}
