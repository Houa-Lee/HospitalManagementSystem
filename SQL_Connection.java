package HospitalProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class SQL_Connection 
{
	private Connection c;
	private PreparedStatement prepareStatement;
	final String url = "jdbc:mysql://localhost/hospitalmanagement";
	final String username = "root";
	final String pw = "";
	
	public SQL_Connection(Connection c, PreparedStatement pState)
	{
		this.c = c;
		this.prepareStatement = pState;
	}
	public Connection connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.c = DriverManager.getConnection(this.url, this.username, this.pw);
			return this.c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setPrepareStatement(String ps)
	{
		try {
			this.prepareStatement = this.c.prepareStatement(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPreparedStatement()
	{
		return this.prepareStatement;
	}
	
	public Connection getConnection()
	{
		return this.c;
	}
	//add new user to database
	public void add(JPanel jpanel, int id, String fName, String lName, String userType, String pw, String address)
	{
		String query = "INSERT INTO `users` "
				+ "(`ID`, `FirstName`, `LastName`, `UserType`, "
				+ "`Password`, `Address`) VALUES ('%d', '%s', '%s', '%s', '%s', '%s')".formatted(id, fName, lName, userType, pw, address);
		try {
			this.prepareStatement = this.c.prepareStatement(query);
			this.prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(jpanel, "%s %s has been added to the system".formatted(fName, lName));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(jpanel, "User exist or information entered incorrect. Please check information.");
		}
	}
	
	public void addSchedule(JPanel jpanel, int id, String fName, String lName, String date)
	{
		String query = "INSERT INTO `appointments` "
				+ "(`ID`, `FirstName`, `LastName`, `Date`, "
				+ "`Confirmation_ID`) VALUES ('%d', '%s', '%s', '%s', '%s')".formatted(id, fName, lName, date,this.randGenerator());
		try {
			this.prepareStatement = this.c.prepareStatement(query);
			this.prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(jpanel, "%s %s appointment set.".formatted(fName, lName));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(jpanel, "User exist or information entered incorrect. Please check information.");
		}
	}
	
	
	//Delete using ID
	public void delete(int id)
	{
		String query = "DELETE FROM users WHERE ID=%d".formatted(id);
		try {
			this.prepareStatement = this.c.prepareStatement(query);
			this.prepareStatement.executeUpdate();
			System.out.println("Delete SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Delete Using firstname and lastname
	public void delete(String fName, String lName)
	{
		String query = "DELETE FROM users WHERE FirstName='%s' AND LastName='%s'".formatted(fName,lName);
		try {
			this.prepareStatement = this.c.prepareStatement(query);
			this.prepareStatement.executeUpdate();
			System.out.println("Delete SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateInfo(JPanel jpanel, String id, String first, String last, String date)
	{
		
		try {
			String query = "update `appointments` SET `FirstName` = '%s', "
					+ "`LastName` = '%s', `Date` = '%s' where "
					+ "`appointments`.`ID` = '%s'".formatted(first, last, date, id);
			
			this.prepareStatement = this.c.prepareStatement(query);
			this.prepareStatement.executeUpdate();
			JOptionPane.showMessageDialog(jpanel, "%s %s appointment updated!.".formatted(first, last));
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(jpanel, "User exist or information entered incorrect. Please check information.");
		}
	}
	
	public String getFirstName(int id)
	{
		String name=null;
		String query = "SELECT * FROM users WHERE ID=%d".formatted(id);
		try {
			Statement statement = this.c.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				name = rs.getString("FirstName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	public String getLastName(int id)
	{
		String name=null;
		String query = "SELECT * FROM users WHERE ID=%d".formatted(id);
		try {
			Statement statement = this.c.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				name = rs.getString("LastName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	public String getUserType(int id)
	{
		String userType=null;
		String query = "SELECT * FROM users WHERE ID=%d".formatted(id);
		try {
			Statement statement = this.c.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				userType = rs.getString("userType");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userType;
	}
	
	public String randGenerator()
	{
		
		String str = "";
		String randomStr = "abcdefghijklmnopqrstuvwxyz0123456789";
		
		Random rand = new Random();
		int randintStr= 0; 
		
		for(int i=0; i < 12; i++)
		{
			randintStr = rand.nextInt(35);
			str += randomStr.charAt(randintStr);
		}
		return str;
	}

}
