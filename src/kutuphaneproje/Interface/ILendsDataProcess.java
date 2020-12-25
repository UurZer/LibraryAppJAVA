package kutuphaneproje.Interface;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ILendsDataProcess extends IDbHelper{//3.Arayüz
     
    public void Delete() throws SQLException;
    
    public void Update(int _UserID,int _BookID,String _LendDateReceived,boolean _LendStatus)throws SQLException;
    
    public void Add(int _UserID,int _BookID,String _LendDate,String _LendDateReceived,boolean _LendStatus,int LendDay) throws SQLException;
}