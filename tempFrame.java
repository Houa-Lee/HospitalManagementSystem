package HospitalProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.management.ImmutableDescriptor;
import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class tempFrame extends JFrame {

	private JPanel contentPane;
	private Connection c;
	private SQL_Connection sq;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	public tempFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.sq = new SQL_Connection(this.c, ps);
		this.c = sq.connect();
		
		setVisible(true);
		
		JTable table = new JTable();
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
				System.out.println("%s %s %s %s %s ".formatted(id,fName,lName,Date,conf_ID));
		
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
		table.setBounds(69, 44, 542, 381);
		contentPane.add(table);
		
	}
	
	public void setTableName(JTable jtable, int col_index, String name)
	{
		jtable.getColumnModel().getColumn(col_index).setHeaderValue(name);
	}
}
