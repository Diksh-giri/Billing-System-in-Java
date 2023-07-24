package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Cashier;
import com.service.AdminService;
import com.service.AdminServiceImpl;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField cidtxt;
	private JPasswordField passwordtxt;
	private JButton Cancel;
	private JButton Login;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("CASHIER LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 1, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPassword());
		contentPane.add(getCidtxt());
		contentPane.add(getPasswordtxt());
		contentPane.add(getCancel());
		contentPane.add(getLogin());
		contentPane.add(getLblNewLabel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Cashier ID:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setBounds(40, 103, 133, 25);
		}
		return lblNewLabel;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPassword.setBackground(Color.WHITE);
			lblPassword.setBounds(40, 152, 112, 25);
		}
		return lblPassword;
	}
	private JTextField getCidtxt() {
		if (cidtxt == null) {
			cidtxt = new JTextField();
			cidtxt.setBackground(new Color(192, 192, 192));
			cidtxt.setBounds(162, 97, 168, 31);
			cidtxt.setColumns(10);
		}
		return cidtxt;
	}
	private JPasswordField getPasswordtxt() {
		if (passwordtxt == null) {
			passwordtxt = new JPasswordField();
			passwordtxt.setBackground(new Color(192, 192, 192));
			passwordtxt.setBounds(162, 146, 168, 31);
		}
		return passwordtxt;
	}
	private JButton getCancel() {
		if (Cancel == null) {
			Cancel = new JButton("Cancel");
			Cancel.setForeground(new Color(255, 255, 255));
			Cancel.setBackground(new Color(210, 43, 43));
			Cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MainPage().setVisible(true);
					dispose();
				}
			});
			Cancel.setBounds(40, 251, 133, 31);
		}
		return Cancel;
	}
	private JButton getLogin() {
		if (Login == null) {
			Login = new JButton("Login");
			Login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cashier c = new Cashier();
					c.setCid(Integer.parseInt(cidtxt.getText()));
					c.setCpswd(passwordtxt.getText());
					
					CashierService cc = new CashierServiceImpl();
					boolean res = cc.cashierlogin(c);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Login Success");
						new CashierPanel().setVisible(true);
						dispose();	
					}else {
						JOptionPane.showMessageDialog(null, "LoginFailure");
					}
				}
			});
			Login.setForeground(new Color(255, 255, 255));
			Login.setBackground(new Color(31, 81, 255));
			Login.setBounds(234, 251, 133, 31);
		}
		return Login;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cashier Login");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(147, 11, 133, 25);
		}
		return lblNewLabel_1;
	}
}
