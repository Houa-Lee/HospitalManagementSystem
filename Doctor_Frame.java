package HospitalProject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class Doctor_Frame extends JFrame {

	private JPanel doctorPanel;
	private JLabel doctor_Portal, doctor_ID, viewPatientRecord, admitTest, changePatientRecord;
	private JButton logoutButt;
	private User user;
	public Doctor_Frame() {
		setTitle("Doctor Portal");
		Connection c = null ;
		PreparedStatement ps = null;
		String query = null;
		SQL_Connection sq = new SQL_Connection(c, ps);
		sq.connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		Dimension getSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(getSize.width/2-this.getSize().width/2, getSize.height/2-this.getSize().height+200);
		setVisible(true);
		
		doctorPanel = new JPanel();
		doctorPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(doctorPanel);
		doctorPanel.setLayout(null);
		
		logoutButt = new JButton("Log Out");
		logoutButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int prompt = (JOptionPane.showConfirmDialog(null, "Log out of system?", "WARNING",JOptionPane.YES_NO_OPTION));
				if (prompt == JOptionPane.YES_OPTION) {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		
		this.logoutButt.setBounds(429, 19, 89, 23);
		doctorPanel.add(logoutButt);
		
		this.viewPatientRecord = new JLabel("View Patient Record");
		viewPatientRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.viewPatientRecord.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				viewPatientRecord.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				viewPatientRecord.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				viewPatientRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
				viewPatientRecord.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new ViewPatientRecord();
				df.setTitle("View Record");
			}
		});
		viewPatientRecord.setBounds(40, 91, 149, 23);
		doctorPanel.add(viewPatientRecord);
		
		admitTest = new JLabel("Admit Test");
		admitTest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		admitTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				admitTest.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				admitTest.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				admitTest.setFont(new Font("Tahoma", Font.PLAIN, 15));
				admitTest.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new ViewPatientRecord();
				df.setTitle("Admit Patient Test");
			}
		});
		admitTest.setBounds(40, 206, 149, 23);
		doctorPanel.add(admitTest);
		
		
		
		changePatientRecord = new JLabel("Change Patient Record");
		changePatientRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		changePatientRecord.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				changePatientRecord.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				changePatientRecord.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				changePatientRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
				changePatientRecord.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new ViewPatientRecord();
				df.setTitle("Change Patient Record");
			}
		});
		changePatientRecord.setBounds(40, 145, 206, 23);
		doctorPanel.add(changePatientRecord);
		
		doctor_Portal = new JLabel("Doctor Portal");
		doctor_Portal.setFont(new Font("Bell MT", Font.BOLD, 30));
		doctor_Portal.setBounds(40, 11, 263, 32);
		doctorPanel.add(doctor_Portal);
		
		doctor_ID = new JLabel("Doctor ID: ");
		doctor_ID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		doctor_ID.setText(doctor_ID.getText() + User.id);
		doctor_ID.setBounds(429, 336, 154, 14);
		doctorPanel.add(doctor_ID);
		
		JLabel viewSchedule = new JLabel("View Schedule");
		viewSchedule.setBounds(40, 266, 206, 14);
		doctorPanel.add(viewSchedule);
		viewSchedule.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				viewSchedule.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				viewSchedule.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				viewSchedule.setFont(new Font("Tahoma", Font.PLAIN, 15));
				viewSchedule.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new ViewPatientRecord();
				df.setTitle("Schedule");
			}
		});
	}
	public void setDoctorID(String setDocID)
	{
		this.doctor_ID.setText(setDocID);
	}
	public String getDoctorID()
	{
		return this.doctor_ID.getText();
	}
}
