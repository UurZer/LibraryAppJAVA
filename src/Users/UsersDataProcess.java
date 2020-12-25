 package Users;

import java.awt.Cursor;
import java.sql.*;
import java.util.*;
import kutuphaneproje.DbHelper;
import kutuphaneproje.Interface.IDataList;
import kutuphaneproje.Interface.IUserDataProcess;

public class UsersDataProcess implements IUserDataProcess,IDataList<Users>{ 
    // ------ VALUES -------
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;
    Cursor cr=null;
    String SqlQuery=null;
    ArrayList<Users> _Users=null;
     
    DbHelper Helper=new DbHelper();
    
    public void Delete(String _DeleteTC) throws SQLException {// SİLME
        SqlQuery="DELETE FROM Users WHERE TC = '"+ _DeleteTC + "'";
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
    
    public void Update(String _Name,String _LastName,String _TC,String _BirthDay,String _Adress,String _UpdateTc) throws SQLException {
        SqlQuery="UPDATE Users SET Name = ?,LastName = ?,TC = ? ,BirthDay = ? ,Adress = ? WHERE TC = '"+ _UpdateTc + "'";;
        try{
            connection = Helper.getConnection();
            preparedStatement = connection.prepareStatement(SqlQuery);
            
            preparedStatement.setString(1, _Name);
            preparedStatement.setString(2, _LastName);
            preparedStatement.setString(3, _TC);
            preparedStatement.setString(4, _BirthDay);
            preparedStatement.setString(5, _Adress);
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
             Helper.showErrorMessage(e);
         }
         finally{
             preparedStatement.close();
             connection.close();
         }
    }   
    
    public void Add(String _Name,String _LastName,String _TC,String _BirthDay,String _Adress) throws SQLException
    {
        SqlQuery="INSERT INTO Users(Name,LastName,TC,BirthDay,Adress) VALUES(?,?,?,?,?)";
        
         try{
         connection=Helper.getConnection();
         preparedStatement= connection.prepareStatement(SqlQuery);
         
         preparedStatement.setString(1, _Name);
         preparedStatement.setString(2, _LastName);
         preparedStatement.setString(3, _TC);
         preparedStatement.setString(4, _BirthDay);
         preparedStatement.setString(5, _Adress);
         
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
    public ArrayList<Users> GetAll() throws SQLException
    {
        SqlQuery="SELECT * FROM Users";

        try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           _Users=new ArrayList<Users>();
           
           while(resultSet.next()){
               _Users.add(new Users(
                            resultSet.getInt("UserID"),
                            resultSet.getString("Name"),
                            resultSet.getString("LastName"),
                            resultSet.getString("TC"),
                            resultSet.getString("BirthDay"),
                            resultSet.getString("Adress")
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
        return _Users;
    }
     @Override
    public ArrayList<Users> GetAll(String StrValue, int intValue) throws SQLException {
         SqlQuery="SELECT * FROM Users WHERE TC= '"+ StrValue + "'";

        try{
           connection=Helper.getConnection();
           statement= connection.createStatement();
           resultSet= statement.executeQuery(SqlQuery);
           _Users=new ArrayList<Users>();
           
           while(resultSet.next()){
               _Users.add(new Users(
                            resultSet.getInt("UserID"),
                            resultSet.getString("Name"),
                            resultSet.getString("LastName"),
                            resultSet.getString("TC"),
                            resultSet.getString("BirthDay"),
                            resultSet.getString("Adress")
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
        return _Users;
    }
    
    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showErrorMessage(SQLException e) {
       System.out.println("Error: "+ e.getMessage());
       System.out.println("Error Code: "+ e.getErrorCode());
    }

}
