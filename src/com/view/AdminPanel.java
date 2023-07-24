package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel Cashier;
	private JLabel Transaction;
	private JLabel Stock;
	private JLabel Sales;
	private JLabel Exit;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("Quick Bill");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(10, 1, 25));
			panel.setBounds(0, 0, 684, 64);
			panel.setLayout(null);
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_1_1());
			panel.add(getCashier());
			panel.add(getTransaction());
			panel.add(getStock());
			panel.add(getSales());
			panel.add(getExit());
		}
		return panel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(342, 5, 0, 0);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
			lblNewLabel_1_1.setBounds(0, 0, 83, 64);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getCashier() {
		if (Cashier == null) {
			Cashier = new JLabel("Cashier");
			Cashier.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					new AddCashier().setVisible(true);
					
				}
			});
			Cashier.setFont(new Font("Tahoma", Font.PLAIN, 8));
			Cashier.setForeground(new Color(255, 255, 255));
			Cashier.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\ashier.png"));
			Cashier.setBounds(83, 0, 88, 64);
		}
		return Cashier;
	}
	private JLabel getTransaction() {
		if (Transaction == null) {
			Transaction = new JLabel("Transaction");
			Transaction.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					new Transaction().setVisible(true);
					
				}
			});
			Transaction.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Transaction.png"));
			Transaction.setForeground(Color.WHITE);
			Transaction.setFont(new Font("Taho ma", Font.PLAIN, 8));
			Transaction.setBounds(172, 0, 109, 64);
		}
		return Transaction;
	}
	private JLabel getStock() {
		if (Stock == null) {
			Stock = new JLabel("Stock");
			Stock.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					new UpdateStock().setVisible(true);
					
				}
			});
			Stock.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\stock.png"));
			Stock.setForeground(Color.WHITE);
			Stock.setFont(new Font("Tahoma", Font.PLAIN, 8));
			Stock.setBounds(282, 0, 96, 64);
		}
		return Stock;
	}
	private JLabel getSales() {
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
			Sales.setBounds(378, 0, 83, 64);
		}
		return Sales;
	}
	private JLabel getExit() {
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
			Exit.setBounds(550, 0, 124, 64);
		}
		return Exit;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Cashierpic.png"));
			lblNewLabel_2.setBounds(0, 64, 684, 317);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(391, 64, 293, 317);
		}
		return lblNewLabel_3;
	}
}
