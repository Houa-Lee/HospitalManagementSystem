package HospitalProject;
import java.awt.Color;
import java.awt.Dimension;
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

@SuppressWarnings("serial")
public class Admin_Frame extends JFrame 
{
	private JPanel adminPanel;
	public Admin_Frame() {
		setTitle("Administrator Portal");
		Connection c = null ;
		PreparedStatement ps = null;
		
		SQL_Connection sq = new SQL_Connection(c, ps);
		sq.connect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		Dimension getSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(getSize.width/2-this.getSize().width/2, getSize.height/2-this.getSize().height+50);
		setVisible(true);
		
		adminPanel = new JPanel();
		adminPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(adminPanel);
		adminPanel.setLayout(null);
		
		JButton logoutButt = new JButton("Log Out");
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
		logoutButt.setFont(new Font("Bell MT", Font.BOLD, 15));
		logoutButt.setBounds(440, 25, 89, 23);
		adminPanel.add(logoutButt);
		
		JLabel adminPortal = new JLabel("Administrator Portal");
		adminPortal.setFont(new Font("Bell MT", Font.BOLD, 30));
		adminPortal.setBounds(40, 11, 304, 47);
		adminPanel.add(adminPortal);
		
		JLabel scheduleAppointment = new JLabel("Schedule Appointments");
		scheduleAppointment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scheduleAppointment.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				scheduleAppointment.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				scheduleAppointment.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				scheduleAppointment.setFont(new Font("Tahoma", Font.PLAIN, 15));
				scheduleAppointment.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ScheduleAppointment schPat = new ScheduleAppointment();
				schPat.setVisible(true);
				schPat.setTitle("Schedule Appointments");
				//dispose();
			}
		});
		scheduleAppointment.setBounds(40, 87, 187, 32);
		adminPanel.add(scheduleAppointment);
		
		JLabel viewEditAppt = new JLabel("View/Edit Appointments");
		viewEditAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewEditAppt.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				viewEditAppt.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				viewEditAppt.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				viewEditAppt.setFont(new Font("Tahoma", Font.PLAIN, 15));
				viewEditAppt.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAppointment_Frame v_Appt = new ViewAppointment_Frame();
				v_Appt.setTitle("View/Edit Appointment");
				v_Appt.setVisible(true);
				//dispose();
			}
		});
		viewEditAppt.setBounds(40, 130, 187, 31);
		adminPanel.add(viewEditAppt);
		
		JLabel addNewPatient = new JLabel("Add New Patient");
		addNewPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addNewPatient.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				addNewPatient.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				addNewPatient.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				addNewPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
				addNewPatient.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addPatient addnewPatient = new addPatient();
				addnewPatient.setTitle("Add Patient");
				addnewPatient.setVisible(true);
				//dispose();
			}
		});
		addNewPatient.setBounds(41, 221, 187, 14);
		adminPanel.add(addNewPatient);
		
		JLabel viewPatient = new JLabel("View Patients");
		viewPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewPatient.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				viewPatient.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				viewPatient.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				viewPatient.setFont(new Font("Tahoma", Font.PLAIN, 15));
				viewPatient.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				viewPatients view_Patients = new viewPatients();
				view_Patients.setTitle("View Patients");
				view_Patients.setVisible(true);
				
				//dispose();
			}
		});
		viewPatient.setBounds(40, 181, 158, 14);
		adminPanel.add(viewPatient);
		
		JLabel add_Doctor = new JLabel("Add Doctor");
		add_Doctor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add_Doctor.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				add_Doctor.setFont(new Font("Bell MT", Font.CENTER_BASELINE, 16));
				add_Doctor.setForeground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				add_Doctor.setFont(new Font("Tahoma", Font.PLAIN, 15));
				add_Doctor.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AddDoctor_Frame addDoctor = new AddDoctor_Frame();
				addDoctor.setVisible(true);;
				//dispose();
			}
		});
		add_Doctor.setBounds(41, 264, 119, 14);
		adminPanel.add(add_Doctor);
		
		JLabel adminId = new JLabel("Administrator ID: ");
		adminId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		adminId.setBounds(416, 336, 158, 14);
		adminId.setText(adminId.getText() + User.id);
		adminPanel.add(adminId);
	}
}
