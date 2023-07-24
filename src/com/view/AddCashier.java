package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;

import com.service.AdminService;
import com.service.AdminServiceImpl;

import java.awt.Toolkit;

public class AddCashier extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JTextField cashieridtxt;
	private JTextField cashiernametxt;
	private JTextField mobiletxt;
	private JTextField adrtxt;
	private JTextField emailtxt;
	private JPasswordField passwordtxt;
	private JButton add;
	private JButton update;
	private JButton delete;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private int cid =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("                                                                                                                        Add Cashier");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 918, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_2());
		contentPane.add(getLblNewLabel_1_3());
		contentPane.add(getLblNewLabel_1_4());
		contentPane.add(getLblNewLabel_1_5());
		contentPane.add(getCashieridtxt());
		contentPane.add(getCashiernametxt());
		contentPane.add(getMobiletxt());
		contentPane.add(getAdrtxt());
		contentPane.add(getEmailtxt());
		contentPane.add(getPasswordtxt());
		contentPane.add(getAdd());
		contentPane.add(getUpdate());
		contentPane.add(getDelete());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		displayData();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Add Cashier Details");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(93, 0, 153, 41);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cashier Id:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 84, 84, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Cashier Name:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(10, 117, 84, 14);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Mobile Number: ");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_2.setBounds(10, 149, 101, 14);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("Address:");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_3.setBounds(10, 186, 84, 14);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("Email-Id:");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_4.setBounds(10, 222, 84, 14);
		}
		return lblNewLabel_1_4;
	}
	private JLabel getLblNewLabel_1_5() {
		if (lblNewLabel_1_5 == null) {
			lblNewLabel_1_5 = new JLabel("Password:");
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_5.setBounds(10, 254, 84, 14);
		}
		return lblNewLabel_1_5;
	}
	private JTextField getCashieridtxt() {
		if (cashieridtxt == null) {
			cashieridtxt = new JTextField();
			cashieridtxt.setBounds(183, 82, 158, 20);
			cashieridtxt.setColumns(10);
		}
		return cashieridtxt;
	}
	private JTextField getCashiernametxt() {
		if (cashiernametxt == null) {
			cashiernametxt = new JTextField();
			cashiernametxt.setColumns(10);
			cashiernametxt.setBounds(183, 115, 158, 20);
		}
		return cashiernametxt;
	}
	private JTextField getMobiletxt() {
		if (mobiletxt == null) {
			mobiletxt = new JTextField();
			mobiletxt.setColumns(10);
			mobiletxt.setBounds(183, 146, 158, 20);
		}
		return mobiletxt;
	}
	private JTextField getAdrtxt() {
		if (adrtxt == null) {
			adrtxt = new JTextField();
			adrtxt.setColumns(10);
			adrtxt.setBounds(183, 184, 158, 20);
		}
		return adrtxt;
	}
	private JTextField getEmailtxt() {
		if (emailtxt == null) {
			emailtxt = new JTextField();
			emailtxt.setColumns(10);
			emailtxt.setBounds(183, 220, 158, 20);
		}
		return emailtxt;
	}
	private JPasswordField getPasswordtxt() {
		if (passwordtxt == null) {
			passwordtxt = new JPasswordField();
			passwordtxt.setBounds(183, 252, 158, 20);
		}
		return passwordtxt;
	}
	private JButton getAdd() {
		if (add == null) {
			add = new JButton("Add");
			add.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\add-new.png"));
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cashier c = new Cashier();
					
					c.setCid(Integer.parseInt(cashieridtxt.getText()));
					c.setCname(cashiernametxt.getText());
					c.setCmobile(mobiletxt.getText());
					c.setCemail(emailtxt.getText());
					c.setCaddress(adrtxt.getText());
					c.setCpswd(passwordtxt.getText());
					
					AdminService aa = new AdminServiceImpl();
					boolean res = aa.addcashier(c);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Succesfully Added");
					}else {
						JOptionPane.showMessageDialog(null, "Failure");
					}
					
					displayData();
				}
			});
			add.setBounds(10, 298, 122, 35);
		}
		return add;
	}
	private JButton getUpdate() {
		if (update == null) {
			update = new JButton("Update");
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int crow = table.getSelectedRow();
					cid = (int) table.getModel().getValueAt(crow, 0);
					
					Cashier c = new Cashier(); 
							
							
					
					c.setCid(cid);
					c.setCid(Integer.parseInt(cashieridtxt.getText()));
					c.setCname(cashiernametxt.getText());
					c.setCmobile(mobiletxt.getText());
					c.setCemail(emailtxt.getText());
					c.setCaddress(adrtxt.getText());
					c.setCpswd(passwordtxt.getText());
					
					
					AdminService aa = new AdminServiceImpl();
					boolean res = aa.updateCashier(c);
				
				
				if(res) {
					JOptionPane.showMessageDialog(null, "Update Success");
					displayData();
				}else {
					JOptionPane.showMessageDialog(null, "Update Failure");
				}
					
				cashieridtxt.setText("");
				cashiernametxt.setText("");
				mobiletxt.setText("");
				emailtxt.setText("");
				adrtxt.setText("");
				passwordtxt.setText("");
				
				add.setEnabled(true);
				update.setEnabled(false);
				
				}
					
				
			});
			update.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\update .png"));
			update.setBounds(142, 298, 122, 35);
		}
		return update;
	}
	private JButton getDelete() {
		if (delete == null) {
			delete = new JButton("Delete");
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int crow = table.getSelectedRow();
					cid = (int) table.getModel().getValueAt(crow, 0);
					
					AdminService aa = new AdminServiceImpl();
					if(aa.deletecashier(cid)) {
						JOptionPane.showMessageDialog(null, "Deleted Success");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Deleted Failure");
					}
					
				}
			});
			delete.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\delete.png"));
			delete.setBounds(274, 298, 122, 35);
		}
		return delete;
	}
	

	private void displayData() {
		
		AdminService aa = new AdminServiceImpl();
		List<Cashier> clist = aa.getcashier(); 
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for(Cashier c : clist) {

			tmodel.addRow(new Object[] {c.getCid(),c.getCname(),c.getCmobile(),c.getCaddress(),c.getCemail(),c.getCpswd()});
		}
	}
	
	
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(445, 0, 16, 378);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(460, 5, 432, 350);
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
					"ID", "Name", "Mno.", "Address", "Email", "Password"
				}
			));
			table.addMouseListener(new MouseAdapter() {
				/**
				 *
				 */
				@Override
				public void mousePressed(MouseEvent e) {
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					
					int id =(int) table.getValueAt(table.getSelectedRow(), 0);
					String name =(String) table.getValueAt(table.getSelectedRow(), 1);
					String mno =(String) table.getValueAt(table.getSelectedRow(), 2);
					String adde = (String)table.getValueAt(table.getSelectedRow(), 3);
					String emal = (String)table.getValueAt(table.getSelectedRow(), 4);
					String ps = (String)table.getValueAt(table.getSelectedRow(), 5);

					cashieridtxt.setText(Integer.toString(id));
					cashiernametxt.setText(name);
					mobiletxt.setText(mno);
					adrtxt.setText(adde);
					emailtxt.setText(emal);
					passwordtxt.setText(ps);
					
					update.setEnabled(true);
					add.setEnabled(false);
				}
		});
		}
		return table;
	}
}
