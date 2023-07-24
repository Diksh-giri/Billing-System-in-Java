package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductInformation extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField psearchtxt;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInformation frame = new ProductInformation();
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
	public ProductInformation() {
		setTitle("                                                                                   Product Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPsearchtxt());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		
		displayData();
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product Information");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(171, 0, 205, 51);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Product");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_1.setBounds(61, 67, 70, 38);
		}
		return lblNewLabel_1;
	}
	private JTextField getPsearchtxt() {
		if (psearchtxt == null) {
			psearchtxt = new JTextField();
			psearchtxt.setBounds(171, 73, 176, 28);
			psearchtxt.setColumns(10);
		}
		return psearchtxt;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Search");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ptxt = psearchtxt.getText();
					CashierService cc = new CashierServiceImpl();
					List<Product> plist = cc.searchproduct(ptxt);
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					tmodel.setRowCount(0);
					
					for(Product p : plist) {

						tmodel.addRow(new Object[] {p.getPid(),p.getPname(),p.getPavailable(),p.getPmrp()});
					}
				}
			});
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\search-logo.png"));
			btnNewButton.setBounds(407, 73, 117, 29);
		}
		return btnNewButton;
	}
	private void displayData() {
		CashierService cc = new CashierServiceImpl();
		List<Product> plist = cc.getallproduct();
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Product p : plist) {

			tmodel.addRow(new Object[] {p.getPid(),p.getPname(),p.getPavailable(),p.getPmrp()});
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(45, 137, 536, 228);
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
					"Product Id", "Product Name", "Available", "MRP."
				}
			));
		}
		return table;
	}
}
