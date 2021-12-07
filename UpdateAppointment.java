package HospitalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.management.monitor.MonitorSettingException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;	

public class UpdateAppointment extends JFrame {

	private JPanel contentPane;
	
	private JTextField idField = new JTextField();
	private JTextField lnameField= new JTextField();
	private JTextField fnameField= new JTextField();
	private JTextField date= new JTextField();
	private JTextField dateField= new JTextField();
	
	public UpdateAppointment(String id, String first, String last, String date) {

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

		
		JLabel registerPatient = new JLabel("Update Appointment");
		registerPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerPatient.setBounds(32, 11, 243, 23);
		contentPane.add(registerPatient);
		
		idField = new JTextField(id);
		idField.setBounds(52, 65, 86, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		lnameField = new JTextField(last);
		lnameField.setColumns(10);
		lnameField.setBounds(415, 65, 86, 20);
		contentPane.add(lnameField);
		
		fnameField = new JTextField(first);
		fnameField.setColumns(10);
		fnameField.setBounds(232, 65, 86, 20);
		contentPane.add(fnameField);
		
		dateField = new JTextField(date);
		dateField.setBounds(78, 131, 149, 20);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
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
		
		//DefaultTableModel df = (DefaultTableModel);
		
		
		JButton updateButt = new JButton("Update");
		updateButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isNumeric(idField.getText()))
				{
					int prompt = (JOptionPane.showConfirmDialog(null, "update appointment?", 
							"confirmation",JOptionPane.YES_NO_OPTION));
					if (prompt == JOptionPane.YES_OPTION) {
						sq.updateInfo(contentPane, idField.getText(), fnameField.getText(), 
								lnameField.getText(), dateField.getText());
						
						/*System.out.println(idField.getText() + fnameField.getText() + 
							lnameField.getText() + dateField.getText());*/
						
						dispose();
					} else {
					JOptionPane.showMessageDialog(contentPane, "ID has to be numbers.");
					}
				}
				
			}
			
		});
		updateButt.setFont(new Font("Tahoma", Font.BOLD, 15));
		updateButt.setBounds(32, 253, 89, 23);
		contentPane.add(updateButt);
		
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
