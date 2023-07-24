package com.view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Product;
import com.service.AdminService;
import com.service.AdminServiceImpl;

public class Sales extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JTextField tsa;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField hsa;
	private JTextField lsa;
	private JTextField tsp;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
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
	public Sales() {
		setTitle("                                                                                     Sales");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getSeparator());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTsa());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1());
		contentPane.add(getHsa());
		contentPane.add(getLsa());
		contentPane.add(getTsp());
		contentPane.add(getScrollPane());
		display();
		getHLTA();
		getTSP();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sales Details");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(239, 11, 135, 24);
		}
		return lblNewLabel;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(284, 46, 7, 368);
		}
		return separator;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Total Sales Amount: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 66, 126, 24);
		}
		return lblNewLabel_1;
	}
	private JTextField getTsa() {
		if (tsa == null) {
			tsa = new JTextField();
			tsa.setBounds(133, 69, 126, 20);
			tsa.setColumns(10);
		}
		return tsa;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Highest Sale Amount:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(10, 115, 126, 24);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Lowest Sale Amount:");
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_1.setBounds(10, 163, 126, 24);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("Top Sale Product:");
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_1_1.setBounds(10, 214, 126, 24);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getHsa() {
		if (hsa == null) {
			hsa = new JTextField();
			hsa.setColumns(10);
			hsa.setBounds(133, 118, 126, 20);
		}
		return hsa;
	}
	private JTextField getLsa() {
		if (lsa == null) {
			lsa = new JTextField();
			lsa.setColumns(10);
			lsa.setBounds(133, 166, 126, 20);
		}
		return lsa;
	}
	private JTextField getTsp() {
		if (tsp == null) {
			tsp = new JTextField();
			tsp.setColumns(10);
			tsp.setBounds(133, 217, 126, 20);
		}
		return tsp;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(295, 66, 321, 329);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private void display() {
		AdminService aa = new AdminServiceImpl();
		
		List<Bill> blist = aa.allbill(); 
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Bill b : blist) {

			tmodel.addRow(new Object[] {b.getBid(),b.getCustname(),b.getDate(),b.getTotal(),b.getPmethod()});
		}
		
	}
	
	private void getTSP() {
		AdminService aa = new AdminServiceImpl();
		String val = aa.gettsp();
		
		tsp.setText(val);
	}
	
	private void getHLTA() {
		AdminService aa = new AdminServiceImpl();
		int[] value = aa.gethlta();
		
		tsa.setText(Integer.toString(value[0]));
		hsa.setText(Integer.toString(value[1]));
		lsa.setText(Integer.toString(value[2]));	
	}

	
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"BillNo", "C.Name", "Date", "Amount", "Payment Method"
				}
			));
		}
		return table;
	}
}
