import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		  String host="localhost";
		  String port="3306";
		  String databasename="QADBTesting";
		  String MySQLURL = "jdbc:mysql://"+host+":"+port+"/"+databasename;
	      String databseUserName = "root";
	      String databasePassword = "Texas@123";
	      
	      Connection conn = DriverManager.getConnection(MySQLURL,databseUserName,databasePassword);
	      
	      Statement stat = conn.createStatement();
	      
	      ResultSet rs = stat.executeQuery("select * from EmployeeInfo where id=2");
	      while(rs.next())
	      {
	    	  System.out.println(rs.getString("name"));
	    	  System.out.println(rs.getString("location"));
	    	  System.out.println(rs.getString("age"));
	    	  //after this we can use datas from database in our selenium testing
	      }

	}

}
