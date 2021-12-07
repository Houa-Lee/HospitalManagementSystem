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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Patient_Frame extends JFrame {
	private JPanel patientPanel;
	private Connection c = null ;
	private PreparedStatement ps = null;
	
	public Patient_Frame() {
		setTitle("Patient Portal");
		SQL_Connection sq = new SQL_Connection(c, ps);
		sq.connect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		Dimension getSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(getSize.width/2-this.getSize().width/2, getSize.height/2-this.getSize().height+50);
		setVisible(true);
		
		patientPanel = new JPanel();
		patientPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(patientPanel);
		patientPanel.setLayout(null);
		
		JButton logoutButt = new JButton("Log Out");
		logoutButt.setFont(new Font("Bell MT", Font.BOLD, 15));
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
		
		logoutButt.setBounds(427, 11, 89, 23);
		patientPanel.add(logoutButt);
		
		JLabel scheduleAppt = new JLabel("Schedule Appointment");
		scheduleAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scheduleAppt.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				scheduleAppt.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				scheduleAppt.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				scheduleAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
				scheduleAppt.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new TemplateFrame();
				df.setTitle("Schedule Appointment");
			}
		});
		scheduleAppt.setBounds(40, 92, 234, 30);
		patientPanel.add(scheduleAppt);
		
		JLabel manageAppt = new JLabel("Manage Appointment");
		manageAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		manageAppt.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				manageAppt.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				manageAppt.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				manageAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
				manageAppt.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new TemplateFrame();
				df.setTitle("Manage Appointment");
			}
		});
		manageAppt.setBounds(40, 148, 234, 30);
		patientPanel.add(manageAppt);
		
		
		/*
		JLabel lblNewLabel_3 = new JLabel("----------------------");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lblNewLabel_3.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				lblNewLabel_3.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_3.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new TemplateFrame();
				df.setTitle("TEST");
			}
		});
		lblNewLabel_3.setBounds(40, 196, 234, 30);
		patientPanel.add(lblNewLabel_3);
		*/ 
		
		
		JLabel help_Butt = new JLabel("Help");
		help_Butt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		help_Butt.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				help_Butt.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				help_Butt.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				help_Butt.setFont(new Font("Tahoma", Font.PLAIN, 15));
				help_Butt.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				TemplateFrame df = new TemplateFrame();
				df.setTitle("Help");
				
			}
		});
		help_Butt.setBounds(40, 247, 234, 30);
		patientPanel.add(help_Butt);
		
		JLabel patientPortal = new JLabel("Patient Portal");
		patientPortal.setFont(new Font("Bell MT", Font.BOLD, 30));
		patientPortal.setBounds(40, 11, 297, 51);
		patientPanel.add(patientPortal);
		
		JLabel patientId = new JLabel("Patient ID: ");
		patientId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		patientId.setText(patientId.getText() + User.id);
		patientId.setBounds(403, 336, 171, 14);
		patientPanel.add(patientId);
	}
}
