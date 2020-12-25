package kutuphaneproje.Interface;


import java.sql.SQLException;

public interface IUserDataProcess<T> extends IDbHelper {//3.Arayüz
    public void Delete(String _TC) throws SQLException;
    
    public void Update(String _Name,String _LastName,String _TC,String _BirthDay,String _Adress,String _UpdateTc)throws SQLException;
    
    public void Add(String _Name,String _LastName,String _TC,String _BirthDay,String _Adress) throws SQLException;
    
}
