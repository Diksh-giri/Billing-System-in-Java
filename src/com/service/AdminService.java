package com.service;

import java.sql.ResultSet;
import java.util.List;

import com.model.Admin;
import com.model.Bill;
import com.model.Cashier;
import com.model.Product;


public interface AdminService {
	
	boolean addadmin(Admin a);
	
	boolean adminlogin(Admin a);
	
	boolean addcashier(Cashier c);

	boolean deletecashier(int cid);

	List<Cashier> getcashier();

	boolean updateCashier(Cashier c);

	boolean updatestock(Product p);

	List<Product> getProduct();

	boolean addstock(Product p);

	ResultSet searchtran(String s);

	ResultSet alltran();

	List<Bill> allbill();

	int[] gethlta();

	String gettsp();

	
	
	

}
