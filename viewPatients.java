package HospitalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class viewPatients extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private Statement st;
	private ResultSet rs;
	
	
	public viewPatients() {
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
		
		
		JLabel lblNewLabel = new JLabel("Patients");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 11, 349, 29);
		contentPane.add(lblNewLabel);
		
		JTable table = new JTable();
		String[] col_Data = {"ID","FirstName","LastName","Address"};
		DefaultTableModel df = new DefaultTableModel(col_Data,0);
		try { 
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM `users` WHERE ID>10000;");
			
			while(rs.next())
			{
				String id = String.valueOf(rs.getInt("ID"));
				String fName = rs.getString("FirstName");
				String lName = rs.getString("LastName");
				String address = rs.getString("Address");
				
				String[] tableData = {id,fName,lName,address};
				//df.addColumn(col_Data);
				df.addRow(tableData);
				//System.out.println("%s %s %s %s %s ".formatted(id,fName,lName,Date,conf_ID));
		
			}
			c.close();
			/*
			this.ps = c.prepareStatement("select * from users");
			this.rs = this.ps.executeQuery();
		
			this.myTable.setModel(DbUtils.resultSetToTableModel(rs));
			*/
			
		} catch (SQLException e){
			System.out.println("ERROR");
		}

		table = new JTable(df);
		table.setBounds(69, 94, 542, 331);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(69, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Firstname");
		lblNewLabel_1_1.setBounds(204, 73, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Lastname");
		lblNewLabel_1_2.setBounds(343, 69, 97, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setBounds(477, 69, 134, 14);
		contentPane.add(lblNewLabel_1_3);
		
	}
}