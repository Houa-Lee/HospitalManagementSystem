package HospitalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ScheduleAppointment extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField lnameField;
	private JTextField fnameField;
	private JTextField date;

	public ScheduleAppointment() {
		
		setTitle("Add Doctor");
		Connection c = null ;
		PreparedStatement ps = null;
		
		SQL_Connection sq = new SQL_Connection(c, ps);
		c = sq.connect();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel registerPatient = new JLabel("Schedule Appointment");
		registerPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerPatient.setBounds(32, 11, 243, 23);
		contentPane.add(registerPatient);
		
		idField = new JTextField();
		idField.setBounds(52, 65, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		lnameField = new JTextField();
		lnameField.setColumns(10);
		lnameField.setBounds(415, 65, 86, 20);
		contentPane.add(lnameField);
		
		fnameField = new JTextField();
		fnameField.setColumns(10);
		fnameField.setBounds(232, 65, 86, 20);
		contentPane.add(fnameField);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(72, 131, 108, 20);
		contentPane.add(date);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(32, 70, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(349, 70, 72, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(166, 71, 72, 14);
		contentPane.add(lblFirstName);
		
		JLabel dateLabel = new JLabel("Date");
		dateLabel.setBounds(32, 134, 35, 14);
		contentPane.add(dateLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(idField.getText()))
				{
					sq.addSchedule(contentPane, Integer.parseInt(idField.getText()), fnameField.getText(), 
							lnameField.getText(), date.getText());
					clear();
				} else {
					JOptionPane.showMessageDialog(contentPane, "ID has to be numbers.");
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(32, 253, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnReset.setForeground(Color.DARK_GRAY);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(166, 253, 89, 23);
		contentPane.add(btnReset);
	}
	public void clear()
	{
		this.fnameField.setText("");
		this.lnameField.setText("");
		this.idField.setText("");
		this.date.setText("");
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
