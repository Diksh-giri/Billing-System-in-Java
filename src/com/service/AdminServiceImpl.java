package com.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Admin;
import com.model.Bill;
import com.model.Cashier;
import com.model.Product;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean addadmin(Admin a) {
		
		String sql ="INSERT INTO Billing.admin (fname,lname,uname,pswd,rpswd,Bdate,address) VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setString(1, a.getFname());
			pstm.setString(2, a.getLname());
			pstm.setString(3, a.getUname());
			pstm.setString(4, a.getPswd());
			pstm.setString(5, a.getRpswd());
			pstm.setDate(6,a.getBdate());
			pstm.setString(7, a.getAddress());
		
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean adminlogin(Admin a) {
		
String sql = "Select * from billing.admin where uname like '"+a.getUname()+"' ";
		
		try {
			
			Statement st = DB.getConnection().createStatement();
			ResultSet rs =st.executeQuery(sql);
			
			if(rs.next()) {
				if(a.getPswd().equals(rs.getString("pswd"))) {
					return true;
				}
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addcashier(Cashier c) {
		
		
String sql ="INSERT INTO Billing.cashier (cid,cname,cmobile,caddress,cemail,cpswd) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, c.getCid());
			pstm.setString(2, c.getCname());
			pstm.setString(3, c.getCmobile());
			pstm.setString(4, c.getCaddress());
			pstm.setString(5, c.getCemail());
			pstm.setString(6, c.getCpswd());
		
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletecashier(int cid) {
		 String sql="Delete from Billing.cashier where cid ="+cid;
		 
		 try {
			Statement st  = DB.getConnection().createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public List<Cashier> getcashier() {

		List<Cashier> clist = new ArrayList<>();
		
		String sql ="Select * from Billing.cashier";
		
		Statement st;
		try {
			st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Cashier c = new Cashier();
				
			
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setCmobile(rs.getString("cmobile"));
				c.setCaddress(rs.getString("caddress"));
				c.setCemail(rs.getString("cemail"));
				c.setCpswd(rs.getString("cpswd"));
				
				clist.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return clist;
	}

	@Override
	public boolean updateCashier(Cashier c) {
String sql ="Update Billing.cashier set cname =? ,cmobile =?,caddress =?,cemail =? ,cpswd =? where cid=?";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setString(1, c.getCname());
			pstm.setString(2, c.getCmobile());
			pstm.setString(3, c.getCaddress());
			pstm.setString(4, c.getCemail());
			pstm.setString(5, c.getCpswd());
			pstm.setInt(6, c.getCid());
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;

	}
	@Override
	public boolean addstock(Product p) {
		
String sql ="Insert Billing.product (pid, pname, pavailable, padded, pmrp) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, p.getPid());
			pstm.setString(2, p.getPname());
			pstm.setInt(3, p.getPavailable());
			pstm.setInt(4,p.getPavailable());
			pstm.setInt(5, p.getPmrp());
			
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean updatestock(Product p) {
		
		int avai = p.getPavailable() +p.getPadded(); 
		
String sql ="Update Billing.product set pavailable =? where pid=?";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1,avai);
			pstm.setInt(2, p.getPid());
			
			pstm.execute();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public List<Product> getProduct() {

List<Product> plist = new ArrayList<>();
		
		String sql ="Select * from Billing.product";
		
		Statement st;
		try {
			st = DB.getConnection().createStatement();
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
	public ResultSet searchtran(String s) {

		String sql = "Select * from billing.bill as b join billing.billitem as bi on bi.bid = b.bid where b.bid ='"+s+"' OR custname = '"+s+"' ";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public ResultSet alltran() {

String sql = "Select * from billing.bill as b join billing.billitem as bi on bi.bid = b.bid ";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Bill> allbill() {
		
		List<Bill> blist = new ArrayList<>();
		
		String sql = "Select * from billing.bill ";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Bill b = new Bill();
				
				
				b.setBid(rs.getInt("bid"));
				b.setCustname(rs.getString("custname"));
				b.setDate(rs.getString("date"));
				b.setTotal(rs.getInt("total"));
				b.setPmethod(rs.getString("pmethod"));
				blist.add(b);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blist;
	}
	public int gettsi() {
		
		int amt;
		String sql = "SELECT SUM(total) as total_sum FROM billing.bill";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				amt = rs.getInt("total_sum");
				return amt;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int[] gethlta() {
		int value[] = new int[3];
		String sql ="SELECT SUM(total) AS ts, MAX(total) AS ha, MIN(total) AS la FROM billing.bill";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				value[0] = rs.getInt("ts");
				value[1] = rs.getInt("ha");
				value[2] = rs.getInt("la");
				return value;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String gettsp() {
		
		String hi;
		 String sql = "SELECT product_name, COUNT(product_name) AS frequency " +
                 "FROM billing.billitem " +
                 "GROUP BY product_name " +
                 "ORDER BY frequency DESC " +
                 "LIMIT 1";

		 Statement st;
		try {
			st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
			     hi = rs.getString("product_name");
					
					return hi;
		}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return null;
	}

	}