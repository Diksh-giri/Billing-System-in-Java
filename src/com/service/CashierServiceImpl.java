package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.db.DB;
import com.model.Bill;
import com.model.Cashier;
import com.model.Product;

public class CashierServiceImpl implements CashierService {

	@Override
	public boolean cashierlogin(Cashier c) {
String sql = "Select * from billing.cashier where cid like '"+c.getCid()+"' ";
		
		try {
			
			Statement st = DB.getConnection().createStatement();
			ResultSet rs =st.executeQuery(sql);
			
			if(rs.next()) {
				if(c.getCpswd().equals(rs.getString("cpswd"))) {
					return true;
				}
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Product> searchproduct(String ptxt) {
		List<Product> plist = new ArrayList<>(); 

		String sql ="Select * from Billing.product where pid ='%" + ptxt + "%' OR pname ='%" + ptxt + "%' " ;
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				Product p = new Product();
				
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPavailable(rs.getInt("pavailable"));
				p.setPmrp(rs.getInt("pmrp"));
				
				plist.add(p);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public List<Product> getallproduct() {

		List<Product> plist = new ArrayList<>(); 

		String sql ="Select * from Billing.product" ;
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				Product p = new Product();
				
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setPavailable(rs.getInt("pavailable"));
				p.setPmrp(rs.getInt("pmrp"));
				
				plist.add(p);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public boolean addbill(Bill b) {

String sql ="INSERT INTO Billing.bill (bid,custname, date,total,pmethod) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, b.getBid());
			pstm.setString(2, b.getCustname());
			pstm.setString(3, b.getDate());
			pstm.setInt(4, b.getTotal());
			pstm.setString(5, b.getPmethod());
		
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addbillItem(int bid, int product_id, String product_name, int quantity, int product_mrp,int discount, int price) {

		
String sql ="INSERT INTO Billing.billitem (bid,pid,product_name,quantity,product_mrp,discount,price) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, bid);
			pstm.setInt(2, product_id);
			pstm.setString(3, product_name);
			pstm.setInt(4, quantity);
			pstm.setInt(5, product_mrp);
			pstm.setInt(6, discount);
			pstm.setInt(7, price);
		
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public Bill searchBill(int billn) {
		
		String sql ="Select * from Billing.bill where bid ="+billn ;
		Bill b = new Bill();
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				
				
				b.setBid(rs.getInt("bid"));
				b.setCustname(rs.getString("custname"));
				b.setDate(rs.getString("date"));
				b.setTotal(rs.getInt("total"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public Product searchproduct_bill(String id) {
		Product p = new Product(); 
	
String sql ="Select * from Billing.product where pid ="+id ;
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {

				p.setPname(rs.getString("pname"));
				p.setPmrp(rs.getInt("pmrp"));
				p.setPavailable(rs.getInt("pavailable"));

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
		

}
