package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Cashier;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierPanel extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JSeparator separator;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel CreateBill;
	private JLabel SearchBilll;
	private JLabel ProductInfo;
	private JLabel Sales;
	private JLabel Exit;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierPanel frame = new CashierPanel();
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
	public CashierPanel() {
		setForeground(new Color(192, 192, 192));
		setBackground(new Color(192, 192, 192));
		setTitle("Quick Bill");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getSeparator());
		contentPane.add(getPanel_1());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(10, 1, 25));
			panel.setBounds(0, 0, 684, 64);
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
			panel.add(getCreateBill());
			panel.add(getLblNewLabel_2_1_1());
			panel.add(getLblNewLabel_2_1_1_1());
			panel.add(getLblNewLabel_2_1_1_1_1());
			panel.add(getLblNewLabel_2_1_1_1_1_1());
		}
		return panel;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 72, 668, 2);
		}
		return separator;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(192, 192, 192));
			panel_1.setBounds(0, 74, 678, 305);
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
			lblNewLabel_1.setBounds(0, 0, 83, 64);
		}
		return lblNewLabel_1;
	}
	private JLabel getCreateBill() {
		if (CreateBill == null) {
			CreateBill = new JLabel("Create Bill");
			CreateBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					new CreateBill().setVisible(true);

					
				}
			});
			CreateBill.setVerticalAlignment(SwingConstants.TOP);
			CreateBill.setFont(new Font("Tahoma", Font.PLAIN, 8));
			CreateBill.setForeground(new Color(255, 255, 255));
			CreateBill.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\create.png"));
			CreateBill.setBounds(93, 0, 96, 64);
		}
		return CreateBill;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (SearchBilll == null) {
			SearchBilll = new JLabel("Search Bill");
			SearchBilll.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					new SearchBill().setVisible(true);
					
				}
			});
			SearchBilll.setVerticalAlignment(SwingConstants.TOP);
			SearchBilll.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\search.png"));
			SearchBilll.setForeground(Color.WHITE);
			SearchBilll.setFont(new Font("Tahoma", Font.PLAIN, 8));
			SearchBilll.setBounds(189, 0, 100, 64);
		}
		return SearchBilll;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (ProductInfo == null) {
			ProductInfo = new JLabel("Product Information");
			ProductInfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					new ProductInformation().setVisible(true);
				}
			});
			ProductInfo.setVerticalAlignment(SwingConstants.TOP);
			ProductInfo.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\product.png"));
			ProductInfo.setForeground(Color.WHITE);
			ProductInfo.setFont(new Font("Tahoma", Font.PLAIN, 8));
			ProductInfo.setBounds(289, 0, 136, 64);
		}
		return ProductInfo;
	}
	private JLabel getLblNewLabel_2_1_1_1_1() {
		if (Sales == null) {
			Sales = new JLabel("Sales");
			Sales.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					new Sales().setVisible(true);
					
				}
			});
			Sales.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Sales.png"));
			Sales.setVerticalAlignment(SwingConstants.TOP);
			Sales.setForeground(Color.WHITE);
			Sales.setFont(new Font("Tahoma", Font.PLAIN, 8));
			Sales.setBounds(425, 0, 83, 64);
		}
		return Sales;
	}
	private JLabel getLblNewLabel_2_1_1_1_1_1() {
		if (Exit == null) {
			Exit = new JLabel("Exit");
			Exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});
			Exit.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\exit.png"));
			Exit.setVerticalAlignment(SwingConstants.TOP);
			Exit.setForeground(Color.WHITE);
			Exit.setFont(new Font("Tahoma", Font.PLAIN, 8));
			Exit.setBounds(554, 0, 124, 64);
		}
		return Exit;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Billings.png"));
			lblNewLabel.setBounds(0, 0, 684, 305);
		}
		return lblNewLabel;
	}
}
