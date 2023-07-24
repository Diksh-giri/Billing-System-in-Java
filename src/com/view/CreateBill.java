package com.view;

import java.awt.EventQueue;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.db.DB;
import com.model.Bill;
import com.model.BillItem;
import com.model.Product;
import com.service.AdminService;
import com.service.AdminServiceImpl;
import com.service.CashierService;
import com.service.CashierServiceImpl;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;

public class CreateBill extends JDialog {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField billno;
	private JLabel lblCustomerName;
	private JLabel lblProductId;
	private JLabel lblName;
	private JLabel lblMrp;
	private JLabel lblDis;
	private JLabel lblDiscount;
	private JTextField custname;
	private JTextField pname;
	private JTextField pmrp;
	private JTextField pquantity;
	private JTextField pdiscount;
	private JButton addbill;
	private JButton removebill;
	private JLabel lblDate;
	private JTextField date;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblTotal;
	private JTextField total;
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboBox;
	private JButton save;
	private JLabel pmethodlbl;
	private JComboBox<String> pmethod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBill frame = new CreateBill();
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
	public CreateBill() {
		setTitle("                                                                                                Create Bill");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Java Workspace\\Billing System\\src\\photo\\Quickbill.png"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getBillno());
		contentPane.add(getLblCustomerName());
		contentPane.add(getLblProductId());
		contentPane.add(getLblName());
		contentPane.add(getLblMrp());
		contentPane.add(getLblDis());
		contentPane.add(getLblDiscount());
		contentPane.add(getCustname());
		contentPane.add(getPname());
		contentPane.add(getPmrp());
		contentPane.add(getPquantity());
		contentPane.add(getPdiscount());
		contentPane.add(getAddbill());
		contentPane.add(getRemovebill());
		contentPane.add(getLblDate());
		contentPane.add(date());
		contentPane.add(getScrollPane());
		contentPane.add(getLblTotal());
		contentPane.add(getTotal());
		contentPane.add(getLblNewLabel_1());
		
		total.setText("0");
		
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date.setText(currentDate.format(formatter));
        contentPane.add(getComboBox());
        contentPane.add(getSave());
        contentPane.add(getPmethodlbl());
        contentPane.add(getPmethod());
        String sql = "Select pid from Billing.product";
        
        try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String name= rs.getString("pid");
				comboBox.addItem(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Bill No. :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 12, 64, 20);
		}
		return lblNewLabel;
	}
	private JTextField getBillno() {
		if (billno == null) {
			billno = new JTextField();
			billno.setBounds(122, 12, 121, 20);
			billno.setColumns(10);
		}
		return billno;
	}
	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name:");
			lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCustomerName.setBounds(10, 52, 93, 20);
		}
		return lblCustomerName;
	}
	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id:");
			lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblProductId.setBounds(10, 92, 93, 20);
		}
		return lblProductId;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblName.setBounds(10, 132, 93, 20);
		}
		return lblName;
	}
	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP. :");
			lblMrp.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblMrp.setBounds(10, 172, 93, 20);
		}
		return lblMrp;
	}
	private JLabel getLblDis() {
		if (lblDis == null) {
			lblDis = new JLabel("Quantity:");
			lblDis.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDis.setBounds(10, 212, 93, 20);
		}
		return lblDis;
	}
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount:");
			lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDiscount.setBounds(10, 252, 93, 21);
		}
		return lblDiscount;
	}
	private JTextField getCustname() {
		if (custname == null) {
			custname = new JTextField();
			custname.setColumns(10);
			custname.setBounds(122, 52, 121, 20);
		}
		return custname;
	}
	private JTextField getPname() {
		if (pname == null) {
			pname = new JTextField();
			pname.setColumns(10);
			pname.setBounds(122, 132, 121, 20);
		}
		return pname;
	}
	private JTextField getPmrp() {
		if (pmrp == null) {
			pmrp = new JTextField();
			pmrp.setColumns(10);
			pmrp.setBounds(122, 172, 121, 20);
		}
		return pmrp;
	}
	private JTextField getPquantity() {
		if (pquantity == null) {
			pquantity = new JTextField();
			pquantity.setColumns(10);
			pquantity.setBounds(122, 212, 121, 20);
		}
		return pquantity;
	}
	private JTextField getPdiscount() {
		if (pdiscount == null) {
			pdiscount = new JTextField();
			pdiscount.setColumns(10);
			pdiscount.setBounds(122, 252, 121, 20);
		}
		return pdiscount;
	}
	private JButton getAddbill() {
		if (addbill == null) {
			addbill = new JButton("Add");
			addbill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					BillItem bit = new BillItem();
					
					if(pdiscount.getText().isBlank()) {
						bit.setDiscount(0);
					}
					else {
					bit.setDiscount(Integer.parseInt(pdiscount.getText()));}
					bit.setPid(Integer.parseInt(comboBox.getSelectedItem().toString()));
					bit.setPname(pname.getText());
					bit.setQuantity(Integer.parseInt(pquantity.getText()));
					bit.setPmrp(Integer.parseInt(pmrp.getText()));
					
					CashierService cc = new CashierServiceImpl();
						Product p =cc.searchproduct_bill(Integer.toString(bit.getPid()));
						p.setPid(bit.getPid());
						if(bit.getQuantity() > p.getPavailable()) {
							JOptionPane.showMessageDialog(null, "Insufficient Product available now , try later/less");
							return ;
						}else {
							int ava = p.getPavailable() - bit.getQuantity();
							p.setPavailable(ava);						
							JOptionPane.showMessageDialog(null, p.getPid());
							AdminService aa = new  AdminServiceImpl();
							boolean res = aa.updatestock(p);
							if(!res) {
								JOptionPane.showMessageDialog(null, "Error Occured");
							}
						
						
					
					int price = bit.getQuantity()*bit.getPmrp();
				if(bit.getDiscount() > 0) {
					double discountPercentage = bit.getDiscount() / 100.0;
					price = (int) (price - (discountPercentage * price));
					
				}					
					bit.setPrice(price);
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					tmodel.addRow(new Object[] {bit.getPid(),bit.getPname(),bit.getQuantity(),bit.getPmrp(),bit.getDiscount(),price});
					
					int sum = 0;
					for(int i=0;i<table.getRowCount();i++) {
						sum = sum + Integer.parseInt(table.getValueAt(i, 5).toString());
					}
					
					total.setText(Integer.toString(sum));
					
				}
			}

			});
			addbill.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\add-bill.png"));
			addbill.setBounds(10, 357, 121, 40);
		}
		return addbill;
	}
	private JButton getRemovebill() {
		if (removebill == null) {
			removebill = new JButton("Remove");
			removebill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any Row");
						return;
					}
					int srow = table.getSelectedRow();
					int price = (int) table.getModel().getValueAt(srow, 3);
					int sum = Integer.parseInt(total.getText());
					sum = sum - price;
				
					total.setText(Integer.toString(sum));
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					
					if(table.getSelectedRowCount() ==1) {
						tmodel.removeRow(table.getSelectedRow());
					} else {
						if(table.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "Table is empty");
						}
					}
					
					
					
					
				}
			});
			removebill.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\delete.png"));
			removebill.setBounds(152, 357, 121, 40);
		}
		return removebill;
	}
	

	
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date: ");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(387, 15, 64, 21);
		}
		return lblDate;
	}
	private JTextField date() {
		if (date == null) {
			date = new JTextField();
			date.setColumns(10);
			date.setBounds(493, 16, 180, 20);
		}
		return date;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(313, 58, 439, 303);
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
					"Product_id","Name","Quantity", "Mrp","Discount(%)", "Price"
				}
			));
		}
		return table;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total: ");
			lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTotal.setBounds(365, 376, 64, 21);
		}
		return lblTotal;
	}
	private JTextField getTotal() {
		if (total == null) {
			total = new JTextField();
			total.setColumns(10);
			total.setBounds(415, 377, 180, 20);
		}
		return total;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Print");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					try {
						table.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				
				}
				
			});
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\print.png"));
			lblNewLabel_1.setBounds(376, 420, 107, 32);
		}
		return lblNewLabel_1;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					String id = comboBox.getSelectedItem().toString();
						
					CashierService cc  = new CashierServiceImpl();
					Product p = cc.searchproduct_bill(id);
					pname.setText(p.getPname());
					pmrp.setText(Integer.toString(p.getPmrp()));
				}
			});

			comboBox.setBounds(122, 92, 121, 20);
		}
		return comboBox;
	}
	private JButton getSave() {
		if (save == null) {
			save = new JButton("Save");
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Bill b = new Bill();
					
					b.setBid(Integer.parseInt(billno.getText()));
					b.setCustname(custname.getText());
					b.setDate(date.getText());
					b.setTotal(Integer.parseInt(total.getText()));
					b.setPmethod(pmethod.getSelectedItem().toString());
					
					CashierService cc = new CashierServiceImpl();
					boolean res = cc.addbill(b);
					if(res) {
						JOptionPane.showMessageDialog(null, "Bill Saved");
					}else {
						JOptionPane.showMessageDialog(null, "Bill Not Saved");
					}
					
					DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
					for (int i = 0; i < table.getRowCount(); i++) {
						
					    int product_id = Integer.parseInt(table.getValueAt(i, 0).toString());
					    String product_name = table.getValueAt(i, 1).toString();
					    int quantity = Integer.parseInt(table.getValueAt(i, 2).toString());
					    int product_mrp = Integer.parseInt(table.getValueAt(i, 3).toString());
					    int discount = Integer.parseInt(table.getValueAt(i, 4).toString());
					    int price = Integer.parseInt(table.getValueAt(i, 5).toString());

					    boolean resu = cc.addbillItem(b.getBid(), product_id, product_name, quantity, product_mrp,discount, price);
					   
					    if(!resu) {
					    	JOptionPane.showMessageDialog(null, "Item Not Saved");
					    }
					}
					
					dispose();
					
					
				}
			});
			save.setIcon(new ImageIcon("D:\\Java Workspace\\Billing System\\src\\photo\\save.png"));
			save.setBounds(152, 426, 121, 40);
		}
		return save;
	}
	private JLabel getPmethodlbl() {
		if (pmethodlbl == null) {
			pmethodlbl = new JLabel("Payment Method:");
			pmethodlbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			pmethodlbl.setBounds(10, 292, 102, 21);
		}
		return pmethodlbl;
	}
	private JComboBox<String> getPmethod() {
		if (pmethod == null) {
			pmethod = new JComboBox<String>();
			pmethod.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Cheque", "Online"}));
			pmethod.setSelectedIndex(0);
			pmethod.setBounds(122, 292, 121, 22);
		}
		return pmethod;
	}
}
