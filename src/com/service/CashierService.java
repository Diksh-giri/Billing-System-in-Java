package com.service;

import java.util.List;

import com.model.Bill;
import com.model.BillItem;
import com.model.Cashier;
import com.model.Product;

public interface CashierService {

	boolean cashierlogin(Cashier c);

	List<Product> searchproduct(String ptxt);

	boolean addbill(Bill b);

	List<Product> getallproduct();

	boolean addbillItem(int bid, int product_id, String product_name, int quantity, int product_mrp,int discount, int price);

	Bill searchBill(int billn);

	Product searchproduct_bill(String id);


	
	
	
}
