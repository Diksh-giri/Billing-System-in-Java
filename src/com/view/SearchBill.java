package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBill extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField billno;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
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
	public SearchBill() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("                                                                                              Search Bill");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBillno());
		contentPane.add(getScrollPane());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnNewButton());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Search Bill");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(246, 11, 166, 36);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Bill No");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(43, 84, 98, 27);
		}
		return lblNewLabel_1;
	}
	private JTextField getBillno() {
		if (billno == null) {
			billno = new JTextField();
			billno.setBounds(136, 84, 159, 25);
			billno.setColumns(10);
		}
		return billno;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(544, 136, -499, 206);
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(43, 136, 532, 232);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"BillNo", "Customer Name", "Amount", "Date"
				}
			));
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Search");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int billn = Integer.parseInt(billno.getText());
					
					CashierService cc = new CashierServiceImpl();
					Bill b = cc.searchBill(billn);
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					tmodel.addRow(new Object[] {b.getBid(),b.getCustname(),b.getTotal(),b.getDate()});
					
					
				}
			});
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\search-logo.png"));
			btnNewButton.setBounds(360, 84, 135, 27);
		}
		return btnNewButton;
	}
}
