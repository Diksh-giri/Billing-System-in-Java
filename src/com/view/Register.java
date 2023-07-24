package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.model.Admin;
import com.service.AdminService;
import com.service.AdminServiceImpl;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField fnametxt;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblR;
	private JTextField lnametxt;
	private JTextField unametxt;
	private JPasswordField passwordField;
	private JPasswordField pswdtxt;
	private JLabel lblBirthdate;
	private JDateChooser BDay;
	private JLabel lblAddress;
	private JButton Cancel;
	private JButton Register;
	private JLabel Login;
	private JTextField adrtxt;
	private JPasswordField rpswdtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 1, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getFnametxt());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getLblR());
		contentPane.add(getLnametxt());
		contentPane.add(getUnametxt());
		contentPane.add(getPasswordField());
		contentPane.add(getPswdtxt());
		contentPane.add(getLblBirthdate());
		contentPane.add(getBDay());
		contentPane.add(getLblAddress());
		contentPane.add(getCancel());
		contentPane.add(getRegister());
		contentPane.add(getLogin());
		contentPane.add(getTextField_4());
		contentPane.add(getRpswdtxt());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("First Name: ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 21, 95, 22);
		}
		return lblNewLabel;
	}
	private JTextField getFnametxt() {
		if (fnametxt == null) {
			fnametxt = new JTextField();
			fnametxt.setForeground(new Color(255, 255, 255));
			fnametxt.setBackground(new Color(192, 192, 192));
			fnametxt.setBounds(86, 24, 150, 20);
			fnametxt.setColumns(10);
		}
		return fnametxt;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name: ");
			lblLastName.setForeground(Color.WHITE);
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLastName.setBounds(10, 59, 95, 22);
		}
		return lblLastName;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username: ");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsername.setBounds(10, 92, 95, 22);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(10, 125, 95, 22);
		}
		return lblPassword;
	}
	private JLabel getLblR() {
		if (lblR == null) {
			lblR = new JLabel("Retype Password:");
			lblR.setForeground(Color.WHITE);
			lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblR.setBounds(10, 158, 125, 22);
		}
		return lblR;
	}
	private JTextField getLnametxt() {
		if (lnametxt == null) {
			lnametxt = new JTextField();
			lnametxt.setForeground(new Color(255, 255, 255));
			lnametxt.setBackground(new Color(192, 192, 192));
			lnametxt.setColumns(10);
			lnametxt.setBounds(86, 62, 150, 20);
		}
		return lnametxt;
	}
	private JTextField getUnametxt() {
		if (unametxt == null) {
			unametxt = new JTextField();
			unametxt.setForeground(new Color(255, 255, 255));
			unametxt.setBackground(new Color(192, 192, 192));
			unametxt.setColumns(10);
			unametxt.setBounds(86, 95, 150, 20);
		}
		return unametxt;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(231, 128, -143, 20);
		}
		return passwordField;
	}
	private JPasswordField getPswdtxt() {
		if (pswdtxt == null) {
			pswdtxt = new JPasswordField();
			pswdtxt.setForeground(new Color(255, 255, 255));
			pswdtxt.setBackground(new Color(192, 192, 192));
			pswdtxt.setBounds(86, 125, 150, 20);
		}
		return pswdtxt;
	}
	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("Birth Date:");
			lblBirthdate.setForeground(Color.WHITE);
			lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBirthdate.setBounds(10, 192, 95, 22);
		}
		return lblBirthdate;
	}
	private JDateChooser getBDay() {
		if (BDay == null) {
			BDay = new JDateChooser();
			BDay.setForeground(new Color(255, 255, 255));
			BDay.setBackground(new Color(192, 192, 192));
			BDay.setBounds(86, 191, 150, 20);
		}
		return BDay;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(Color.WHITE);
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAddress.setBounds(10, 237, 95, 22);
		}
		return lblAddress;
	}
	private JButton getCancel() {
		if (Cancel == null) {
			Cancel = new JButton("Cancel");
			Cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new MainPage().setVisible(true);
					dispose();
				}
			});
			Cancel.setForeground(Color.WHITE);
			Cancel.setBackground(new Color(210, 43, 43));
			Cancel.setBounds(26, 378, 133, 31);
		}
		return Cancel;
	}
	private JButton getRegister() {
		if (Register == null) {
			Register = new JButton("Register");
			Register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Admin a = new Admin();
					
					a.setFname(fnametxt.getText());
					a.setLname(lnametxt.getText());
					a.setUname(unametxt.getText());
					a.setPswd(pswdtxt.getText());
					a.setRpswd(rpswdtxt.getText());
					java.util.Date selectedDate = BDay.getDate();
					java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime()); // to get date ffeom j dastechooser
					a.setBdate(sqlDate);
					a.setAddress(adrtxt.getText());
					
					char[] p1 = pswdtxt.getPassword();
					char[] p2 = rpswdtxt.getPassword();
					
					String pw1 = new String(p1);
					String pw2 = new String(p2);
					
					if(pw1.equals(pw2)) {
						AdminService aa = new AdminServiceImpl();
						boolean res = aa.addadmin(a);
						if(res) {
							JOptionPane.showMessageDialog(null, "SignUP Success");
							new AdminLogin().setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "SignUp Failure");
						}
					} else {
						JOptionPane.showMessageDialog(rpswdtxt, "Password Doesn't Match");
					}
					
				}
			});
			Register.setForeground(Color.WHITE);
			Register.setBackground(new Color(31, 81, 255));
			Register.setBounds(228, 378, 133, 31);
		}
		return Register;
	}
	private JLabel getLogin() {
		if (Login == null) {
			Login = new JLabel("Click here to Login");
			Login.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					new AdminLogin().setVisible(true);
					dispose();
				}
			});
			Login.setForeground(Color.WHITE);
			Login.setFont(new Font("Tahoma", Font.BOLD, 13));
			Login.setBounds(127, 420, 150, 25);
		}
		return Login;
	}
	private JTextField getTextField_4() {
		if (adrtxt == null) {
			adrtxt = new JTextField();
			adrtxt.setForeground(Color.WHITE);
			adrtxt.setColumns(10);
			adrtxt.setBackground(Color.LIGHT_GRAY);
			adrtxt.setBounds(86, 240, 206, 104);
		}
		return adrtxt;
	}
	private JPasswordField getRpswdtxt() {
		if (rpswdtxt == null) {
			rpswdtxt = new JPasswordField();
			rpswdtxt.setForeground(Color.WHITE);
			rpswdtxt.setBackground(Color.LIGHT_GRAY);
			rpswdtxt.setBounds(142, 158, 150, 20);
		}
		return rpswdtxt;
	}
}
