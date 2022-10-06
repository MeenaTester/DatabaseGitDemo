import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SauceLabJDBCConnection {

	public static void main(String[] args) throws SQLException {
		String host="localhost";
		String port="3306";
		String databasename = "saucelabDB";
		String MYSQLURL="jdbc:mysql://"+host+":"+port+"/"+databasename;
		System.out.println(MYSQLURL);
		Connection conn = DriverManager.getConnection(MYSQLURL,"root","Texas@123");
		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from credentials");
		while(rs.next())
		{
			System.out.println("git commands downloads+ "+rs.getString("username"));
			System.out.println("git commands downloads+ "+rs.getString("password"));
			System.out.println("git commands eclipse worspace");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\revan\\OneDrive\\Desktop\\Selenium_Notes\\SeleniumGrid\\SeleniumGrid\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			driver.findElement(By.id("login-button")).click();
			driver.close();
		}
		

	}
	public static void GitDemoDownload()
	{
		System.out.println("added for git demo download");
	}

}
