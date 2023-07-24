package com.view;

import java.awt.EventQueue;

import com.service.AdminService;
import com.service.AdminServiceImpl;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Transaction extends JDialog {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField searchtxt;
	private JButton search;
	private JLabel lblNewLabel;
	private JLabel lblPrint;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transaction() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("                                                                         Transaction");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getSearchtxt());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPrint());
		contentPane.add(getLblNewLabel_1());
		
		
		display();
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 82, 590, 313);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"BillNo.", "C.Name", "P.Name", "Quantity", "MRP. ", "Price", "Payment Method"
				}
			));
		}
		return table;
	}
	private JTextField getSearchtxt() {
		if (searchtxt == null) {
			searchtxt = new JTextField();
			searchtxt.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					String s = searchtxt.getText().trim();
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					tmodel.setRowCount(0);
					AdminService aa = new AdminServiceImpl();
					ResultSet rs = aa.searchtran(s);
					
					try {
						while(rs.next()) {
						tmodel.addRow(new Object[] {rs.getString("bid"),rs.getString("custname"),rs.getString("product_name"),rs.getInt("quantity"),rs.getInt("product_mrp"),rs.getInt("price"),rs.getString("pmethod")});
						
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			searchtxt.setBounds(250, 41, 186, 30);
			searchtxt.setColumns(10);
		}
		return searchtxt;
	}
	
	private void display() {

		AdminService aa = new AdminServiceImpl();
		ResultSet rs = aa.alltran();
		
		try {
			while(rs.next()) {
			DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
			tmodel.addRow(new Object[] {rs.getString("bid"),rs.getString("custname"),rs.getString("product_name"),rs.getInt("quantity"),rs.getInt("product_mrp"),rs.getInt("price"),rs.getString("pmethod")});
			
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Transaction Details");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(220, 11, 175, 19);
		}
		return lblNewLabel;
	}
	private JLabel getLblPrint() {
		if (lblPrint == null) {
			lblPrint = new JLabel("Print");
			lblPrint.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						table.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}
			});
			lblPrint.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\print.png"));
			lblPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrint.setBounds(527, 406, 104, 26);
		}
		return lblPrint;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Search");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(163, 44, 88, 22);
		}
		return lblNewLabel_1;
	}
}
