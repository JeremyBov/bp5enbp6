

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnector {
    
    public DBconnector(){
        
    }
    
    private Connection createConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String strConnectionString = "jdbc:mysql://localhost:3306/bp5";
            conn = DriverManager.getConnection(strConnectionString,"root","password");
            
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return conn;
    }
    
    public ResultSet getData(String strSQL){
        ResultSet result = null;
        try{
            Statement stmt = createConnection().createStatement();
            result = stmt.executeQuery(strSQL);            
        }catch(Exception e){
            
        }
        return result;
    }
    
    public int executeDML(String sql) {
        int result = 0;
        try {
            Statement stmt = createConnection().createStatement();
            result = stmt.executeUpdate(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
