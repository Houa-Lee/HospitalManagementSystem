package HospitalProject;
import java.sql.PreparedStatement;


public class User {
	public static int id;
	private String firstName, lastName, userType, password;
	public User(int id, String firstName, String lastName, String userType, String pw) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.password = pw;
	}
	public int getUserID() {
		return this.id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName()	{
		return this.lastName;
	}
	public String getUserType() {
		return this.userType;
	}
	public String getPw() {
		return this.password;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	public void setPw(String pw) {
		this.password = pw;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
