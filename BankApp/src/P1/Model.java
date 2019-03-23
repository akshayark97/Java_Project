package P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;

	public Model()
	{
		try
		{
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	private String name;
	private String accno;
	private String balance;
	private String custid;
	private String pwd;
	private String email;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getAccno() {
		return accno;
	}
	public String getBalance() {
		return balance;
	}
	public String getCustid() {
		return custid;
	}
	public String getPwd() {
		return pwd;
	}
	public String getEmail() {
		return email;
	}
	
	public boolean login()
	{
		try 
		{
			pstmt=con.prepareStatement("SELECT * FROM BANK_APP WHERE CUSTID=? AND PWD=?");
			pstmt.setString(1,custid);
			pstmt.setString(2,pwd);
			res=pstmt.executeQuery();
			if(res.next()==true)
			{
				accno=res.getString("accno");
				return true;
			}
		} 
		
catch(Exception e)
{
	e.printStackTrace();
}
		return false;
	}
}


















