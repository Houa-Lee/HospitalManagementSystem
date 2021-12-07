package HospitalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAppointment_Frame extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement st;
	private ResultSet rs;
	private JTable table;
	public ViewAppointment_Frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("View/Edit Appointments");
		c = null ;
		PreparedStatement ps = null;
		SQL_Connection sq = new SQL_Connection(c, ps);
		c = sq.connect();
		
		
		JLabel lblNewLabel = new JLabel("Appointments");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 11, 349, 29);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		String[] col_Data = {"ID","FirstName","LastName","Date","Confirmation_ID"};
		DefaultTableModel df = new DefaultTableModel(col_Data,0);
		try { 
			st = c.createStatement();
			rs = st.executeQuery("select * from appointments");
			
			while(rs.next())
			{
				String id = String.valueOf(rs.getInt("ID"));
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String Date = rs.getString("Date");
				String conf_ID = rs.getString("Confirmation_ID");
				
				String[] tableData = {id,fName,lName,Date,conf_ID};
				//df.addColumn(col_Data);
				df.addRow(tableData);
				//System.out.println("%s %s %s %s %s ".formatted(id,fName,lName,Date,conf_ID));
		
			}
			c.close();
			
		} catch (SQLException e){
			System.out.println("ERROR");
		}

		table = new JTable(df);
		table.setBounds(69, 94, 542, 276);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(69, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Firstname");
		lblNewLabel_1_1.setBounds(175, 73, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Lastname");
		lblNewLabel_1_2.setBounds(286, 73, 97, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date");
		lblNewLabel_1_3.setBounds(393, 73, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Confirmatoin ID");
		lblNewLabel_1_4.setBounds(497, 73, 106, 14);
		contentPane.add(lblNewLabel_1_4);
		
		
		JButton updateButton = new JButton("Update Information");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] myData = getSelected();
				UpdateAppointment updateAppt = new UpdateAppointment(myData[0], 
						myData[1],myData[2], myData[3]);
				updateAppt.setVisible(true);
				
			}
		});
		
		
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateButton.setBounds(69, 405, 149, 23);
		contentPane.add(updateButton);
		
		JButton deleteButton = new JButton("Delete ");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		deleteButton.setForeground(Color.RED);
		deleteButton.setBounds(228, 405, 97, 23);
		contentPane.add(deleteButton);
	}
	
	public String[] getSelected()
	{
		String data[] = new String[4];
		
		int selection = this.table.getSelectedRow();
		TableModel myModel = this.table.getModel();
	
		for(int i=0; i<4; i++)
		{
			data[i] = myModel.getValueAt(selection, i).toString();
		}
		return data;
	}
}