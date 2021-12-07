package HospitalProject;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) 
	{
		Connection c = null ;
		PreparedStatement ps = null;
		String query = null;
		SQL_Connection sq = new SQL_Connection(c, ps);
		sq.connect();
		
		
		System.out.println(sq.getFirstName(2)  );
		System.out.println(sq.getLastName(2)  );
		System.out.println(sq.getUserType(2)  );
		sq.delete(1);
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		User u = new User(3, "Jim", "Milan", "Doctor", "pass456");
		sq.add(u.getID(), u.getFirstName(), u.getLastName(), u.getUserType(), u.getPw(), "NA");
		//sq.delete(u.getFirstName(),u.getLastName());
		//sq.add(2, "Selina", "Spring", "Patient", "pass123", "Ave");
		
		/*
		query = "INSERT INTO `users` "
				+ "(`ID`, `FirstName`, `LastName`, `UserType`, "
				+ "`Password`, `Address`) VALUES ('1', 'Jim', 'Milan', 'Doctor', 'pass123', 'NA')";
		try {
			ps = sq.getConnection().prepareStatement(query);
			ps.executeUpdate();
			System.out.println("INSERT SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

}
