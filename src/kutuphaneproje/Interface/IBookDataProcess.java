package kutuphaneproje.Interface;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookDataProcess extends IDbHelper {//3.Arayüz
    
    public void Delete(String _ISBN) throws SQLException;
    
    public void Update(String _BookName,String _BookAuthor,int _BookPage,String _BookDate,int _BookBaski,String _BookISBN,String _UpdateISBN,Boolean _UpdateStatus)throws SQLException;
    
    public void Add(String _BookName,String _BookAuthor,int _BookPage,String _BookDate,int _BookBaski,String _BookISBN) throws SQLException;
    
}
