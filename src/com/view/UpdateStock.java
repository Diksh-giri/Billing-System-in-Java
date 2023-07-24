package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.AdminService;
import com.service.AdminServiceImpl;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStock extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JTextField pid;
	private JTextField pname;
	private JTextField pavailable;
	private JTextField padded;
	private JTextField pmrp;
	private JButton New;
	private JButton Update;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;
	private int sid =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setTitle("                                                                                                       Update Stock");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 465);
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
		contentPane.add(getPid());
		contentPane.add(getPname());
		contentPane.add(getPavailable());
		contentPane.add(getPadded());
		contentPane.add(getPmrp());
		contentPane.add(getNew());
		contentPane.add(getUpdate());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());
		displayData();
	}
	

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Update Stock");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(126, 11, 177, 42);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Product Id:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 90, 82, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Product Name:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(10, 126, 82, 14);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Quantity Available:");
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_2.setBounds(10, 159, 101, 14);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("Quantity Added");
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_3.setBounds(10, 195, 101, 14);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("MRP. :");
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_4.setBounds(10, 235, 82, 14);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getPid() {
		if (pid == null) {
			pid = new JTextField();
			pid.setBounds(145, 88, 135, 20);
			pid.setColumns(10);
		}
		return pid;
	}
	private JTextField getPname() {
		if (pname == null) {
			pname = new JTextField();
			pname.setColumns(10);
			pname.setBounds(145, 124, 135, 20);
		}
		return pname;
	}
	private JTextField getPavailable() {
		if (pavailable == null) {
			pavailable = new JTextField();
			pavailable.setColumns(10);
			pavailable.setBounds(145, 157, 135, 20);
		}
		return pavailable;
	}
	private JTextField getPadded() {
		if (padded == null) {
			padded = new JTextField();
			padded.setColumns(10);
			padded.setBounds(145, 193, 135, 20);
		}
		return padded;
	}
	private JTextField getPmrp() {
		if (pmrp == null) {
			pmrp = new JTextField();
			pmrp.setColumns(10);
			pmrp.setBounds(145, 233, 135, 20);
		}
		return pmrp;
	}
	private JButton getNew() {
		if (New == null) {
			New = new JButton("New");
			New.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Product p =new Product();
					
					p.setPid(Integer.parseInt(pid.getText()));
					p.setPname(pname.getText());
					p.setPavailable(Integer.parseInt(pavailable.getText()));
					p.setPadded(Integer.parseInt(padded.getText()));
					p.setPmrp(Integer.parseInt(pmrp.getText()));
					
					AdminService aa = new  AdminServiceImpl();
					boolean res = aa.addstock(p);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Added Success");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Added Failure");
						
						DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
						tmodel.addRow(new Object[] {p.getPid(),p.getPname(),p.getPavailable(),p.getPmrp()});
						
					}
					
				}
			});
			New.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\new.png"));
			New.setBounds(10, 313, 126, 42);
		}
		return New;
	}
	private JButton getUpdate() {
		if (Update == null) {
			Update = new JButton("Update");
			Update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					
					Product p =new Product();
					
					p.setPid(Integer.parseInt(pid.getText()));
					p.setPadded(Integer.parseInt(padded.getText()));
					p.setPavailable(Integer.parseInt(pavailable.getText()));
					
					AdminService aa = new  AdminServiceImpl();
					boolean res = aa.updatestock(p);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Update Successfull");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Update Failure");
					}
					
					pid.setText("");
					pname.setText("");
					pavailable.setText("");
					padded.setText("");
					pmrp.setText("");
					
					Update.setEnabled(false);
					New.setEnabled(true);
					
					
					
				}
			});
			Update.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\update .png"));
			Update.setBounds(177, 313, 126, 42);
		}
		return Update;
	}
		private void displayData() {
			AdminService aa = new AdminServiceImpl();
			List<Product> plist = aa.getProduct(); 
			
			DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
			tmodel.setRowCount(0);
			
			for(Product p : plist) {

				tmodel.addRow(new Object[] {p.getPid(),p.getPname(),p.getPavailable(),p.getPmrp()});
			}
		}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(362, 11, 1, 404);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(390, 32, 364, 342);
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
					"Product ID", "Product Name", "Available", "MRP."
				}
			));
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					
					int id =(int) table.getValueAt(table.getSelectedRow(), 0);
					String name =(String) table.getValueAt(table.getSelectedRow(), 1);
					int available =(int) table.getValueAt(table.getSelectedRow(), 2);
					int mrp = (int)table.getValueAt(table.getSelectedRow(), 3);

					pid.setText(Integer.toString(id));
					pname.setText(name);
					pavailable.setText(Integer.toString(available));
					pmrp.setText(Integer.toString(mrp));
					
					Update.setEnabled(true);
					New.setEnabled(false);
				}
		});
		}
		return table;
	}
}
