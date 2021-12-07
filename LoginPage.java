package HospitalProject;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {

	private JPanel frame;
	private JLabel pw_Label;
	private JButton login_Button;
	private JTextField id_Input;
	private JPasswordField pw_Input;
	private JLabel mainLogo;
	private Connection c;
	private SQL_Connection sq;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query = "";


	public LoginPage() {
		setSize(new Dimension(650, 450));
		setPreferredSize(new Dimension(600, 600));
		c = null ;
		ps = null;
		query = null;
		sq = new SQL_Connection(c, ps);
		sq.connect();
		this.c = sq.connect();
		
		Dimension getSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = new JPanel();
		frame.setPreferredSize(new Dimension(0, 0));
		frame.setMinimumSize(new Dimension(0, 0));
		setTitle("Hospital Management System");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBorder(null);
		setContentPane(frame);
		
		//setLocation(getSize.width/2-this.getSize().width/2, getSize.height/2-this.getSize().height+50);
		
		JLabel id_Label = new JLabel("ID");
		id_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		pw_Label = new JLabel("Password");
		pw_Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		id_Input = new JTextField();
		id_Input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		id_Input.setColumns(10);
		
		pw_Input = new JPasswordField();
		pw_Input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		login_Button = new JButton("LOGIN");
		login_Button.setFont(new Font("Tahoma", Font.BOLD, 12));
		login_Button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		mainLogo = new JLabel("Hospital Management System");
		mainLogo.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prompt = (JOptionPane.showConfirmDialog(null, "Exit System?", "WARNING",JOptionPane.YES_NO_OPTION));
				if (prompt == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		
		exitButton.setForeground(new Color(255, 0, 0));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout grouplayout_frame = new GroupLayout(frame);
		grouplayout_frame.setHorizontalGroup(
			grouplayout_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout_frame.createSequentialGroup()
					.addGroup(grouplayout_frame.createParallelGroup(Alignment.LEADING)
						.addGroup(grouplayout_frame.createSequentialGroup()
							.addGap(89)
							.addComponent(mainLogo, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
						.addGroup(grouplayout_frame.createSequentialGroup()
							.addGap(147)
							.addGroup(grouplayout_frame.createParallelGroup(Alignment.LEADING)
								.addComponent(pw_Label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(id_Label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(grouplayout_frame.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pw_Input)
								.addComponent(id_Input, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
								.addComponent(login_Button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
					.addGap(149))
		);
		grouplayout_frame.setVerticalGroup(
			grouplayout_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout_frame.createSequentialGroup()
					.addGap(27)
					.addComponent(mainLogo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(grouplayout_frame.createParallelGroup(Alignment.BASELINE)
						.addComponent(id_Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(id_Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(grouplayout_frame.createParallelGroup(Alignment.TRAILING)
						.addComponent(pw_Label, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(pw_Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(login_Button, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		frame.setLayout(grouplayout_frame);
	}
	
	
	public void login()	{
		if(!isNumeric(id_Input.getText())) {
			JOptionPane.showMessageDialog(frame, "Please Enter number only for ID");
		}
		else if(id_Input.getText().length() <= 0 ) {
			JOptionPane.showMessageDialog(frame, "Login Information Incorrect");
		}
		else if(Integer.parseInt(id_Input.getText()) < 1000) {
			if(authenticate(this.id_Input.getText(), this.pw_Input.getText())) {
				Doctor_Frame docframe = new Doctor_Frame();
				frame.setVisible(false);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(frame, "Login Information Incorrect");
			}
		}
		else if (Integer.parseInt(id_Input.getText())>1000 && Integer.parseInt(id_Input.getText())<10000) {
			if(authenticate(this.id_Input.getText(), this.pw_Input.getText())) {
				Admin_Frame adminFrame = new Admin_Frame();
				frame.setVisible(false);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(frame, "Login Information Incorrect");
			}
		}
		else if (Integer.parseInt(id_Input.getText())>10000 && Integer.parseInt(id_Input.getText())<100000) {
			if(authenticate(this.id_Input.getText(), this.pw_Input.getText())) {
				Patient_Frame patientFrame = new Patient_Frame();
				frame.setVisible(false);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(frame, "Login Information Incorrect");
			}
		}
		else if(Integer.parseInt(id_Input.getText())>=100000 ) {
			JOptionPane.showMessageDialog(frame, "ID do not exist in the system. \n\tPlease try Again");
		}
	
	}
	public boolean authenticate(String id, String pass)
	{
		id = id_Input.getText();
		pass = pw_Input.getText();
		query = "SELECT * FROM users WHERE ID='%s' AND Password='%s'".formatted(id,pass);
		ResultSet rs;
		try {
			ps = sq.getConnection().prepareStatement(query);;
			rs = ps.executeQuery(query);
			
			if(rs.next()) {
				System.out.println("LOG IN SUCCESS!");
				User.id = Integer.parseInt(id_Input.getText());
				System.out.println("User ID is now: " + User.id);
				return true;
			} else { 
				System.out.println("FAILED");
				return false; 
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	
	public boolean isNumeric(String str) {
		for (char i: str.toCharArray())	{
			if (!Character.isDigit(i)) {
				return false;
			}
		}
		return true;
	}
}
