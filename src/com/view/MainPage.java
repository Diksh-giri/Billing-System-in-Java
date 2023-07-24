package com.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton Admin;
	private JButton Cashier;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 1, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getAdmin());
		contentPane.add(getCashier());
		contentPane.add(getLblNewLabel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcom To SuperMarket Billing System");
			lblNewLabel.setForeground(new Color(254, 205, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(122, 11, 368, 51);
		}
		return lblNewLabel;
	}
	private JButton getAdmin() {
		if (Admin == null) {
			Admin = new JButton("Admin Login");
			Admin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			Admin.setBackground(new Color(73, 2, 82));
			Admin.setForeground(new Color(254, 205, 0));
			Admin.setFont(new Font("Tahoma", Font.BOLD, 16));
			Admin.setBounds(393, 108, 174, 51);
		}
		return Admin;
	}
	private JButton getCashier() {
		if (Cashier == null) {
			Cashier = new JButton("Cashier Login");
			Cashier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierLogin().setVisible(true);
					dispose();;
				}
			});
			Cashier.setForeground(new Color(254, 205, 0));
			Cashier.setBackground(new Color(73, 2, 82));
			Cashier.setFont(new Font("Tahoma", Font.BOLD, 16));
			Cashier.setBounds(393, 226, 174, 51);
		}
		return Cashier;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setForeground(new Color(149, 149, 255));
			lblNewLabel_1.setBackground(new Color(149, 149, 255));
			lblNewLabel_1.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
			lblNewLabel_1.setBounds(10, 62, 250, 256);
		}
		return lblNewLabel_1;
	}
}
