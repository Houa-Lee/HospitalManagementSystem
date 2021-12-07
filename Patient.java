package HospitalProject;

public class Patient extends User
{
	private String address;
	public Patient(int id, String fName, String lName, String userType, String pw, String address)
	{
		super(id,fName,lName,userType,pw);
		this.address = address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
