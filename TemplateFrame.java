package HospitalProject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TemplateFrame extends JFrame {

	private JPanel contentPane;
	
	public TemplateFrame() {
		// Establish Connection to SQL server & DataBase
		Connection c = null ;
		PreparedStatement ps = null;
		String query = null;
		SQL_Connection sq = new SQL_Connection(c, ps);
		sq.connect();
		
		setTitle("TEMPLATE");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		Dimension getSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(getSize.width/2-this.getSize().width/2, getSize.height/2-this.getSize().height+50);
		setVisible(true);
		setContentPane(contentPane);
	}
	

}
