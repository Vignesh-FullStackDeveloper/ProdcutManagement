package com.launchpod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.launchpod.entity.Customer;
import com.launchpod.entity.Distributor;
import com.launchpod.entity.Product;
import com.launchpod.entity.Sales;
import com.launchpod.model.SalesOrder;
import com.launchpod.repository.CustomerRepository;
import com.launchpod.repository.DistributorRepository;
import com.launchpod.repository.SalesRepository;

@Service
public class SalesService {
	@Autowired
	private SalesRepository repo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	public List<Sales> listAll() {		
		return repo.findAll();
	}
	
	public void save(Sales sales) {
		repo.save(sales);
	}
	
	public Sales get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<SalesOrder> getAllSalesOrder() {
		SalesOrder tempsalesOrder;
		Customer customer;
		Product product;
		List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
		List<Sales> salesList = listAll();
		for(Sales sales : salesList) {
			tempsalesOrder = new SalesOrder();
			customer = customerService.get(sales.getIdcustomer());
			product =  productService.get(sales.getIdproduct());
			
			tempsalesOrder.setCustomerName(customer.getName());
			tempsalesOrder.setCustomerContact(customer.getContactNumber());
			tempsalesOrder.setCustomerEmail(customer.getEmail());
			tempsalesOrder.setProduct(product.getProductName());
			tempsalesOrder.setManufacturer(product.getManufacturer());
			tempsalesOrder.setPrice(sales.getPrice());
			tempsalesOrder.setDiscount(sales.getDiscount());
			
			salesOrderList.add(tempsalesOrder);
		}
		return salesOrderList;
	}
	
	public SalesOrder getSaleOrder(Long id) {
		SalesOrder tempsalesOrder;
		Customer customer;
		Product product;
		Sales sales = get(id);
		
	    tempsalesOrder = new SalesOrder();
	    customer = customerService.get(sales.getIdcustomer());
	    product =  productService.get(sales.getIdproduct());
	    tempsalesOrder.setId(sales.getIdsales());
	    tempsalesOrder.setCustomerName(customer.getName());
		tempsalesOrder.setCustomerContact(customer.getContactNumber());
		tempsalesOrder.setCustomerEmail(customer.getEmail());
		tempsalesOrder.setProduct(product.getProductName());
		tempsalesOrder.setManufacturer(product.getManufacturer());
		tempsalesOrder.setPrice(sales.getPrice());
		tempsalesOrder.setDiscount(sales.getDiscount());
		
		return tempsalesOrder;
	}
	
	public void deleteSaleOrder(Long id) {
		Product product;
		Sales sales = get(id);
		product =  productService.get(sales.getIdproduct());
		product.setInStock(product.getInStock() - 1);
		product.setInStock(product.getInStock() - 1);
		delete(id);
	}
	
//	public SalesOrder saveSaleOrder(SalesOrder salesOrder) {
//		SalesOrder tempsalesOrder;
//		Customer customer;
//		Product product;
//		Sales sales = get(id);
//		
//	    tempsalesOrder = new SalesOrder();
//	    customer = customerService.get(sales.getIdcustomer());
//	    product =  productService.get(sales.getIdproduct());
//	    tempsalesOrder.setIdsales(sales.getIdsales());
//	    tempsalesOrder.setCustomerName(customer.getName());
//		tempsalesOrder.setCustomerContact(customer.getContactNumber());
//		tempsalesOrder.setCustomerEmail(customer.getEmail());
//		tempsalesOrder.setProduct(product.getProductName());
//		tempsalesOrder.setManufacturer(product.getManufacturer());
//		tempsalesOrder.setPrice(sales.getPrice());
//		tempsalesOrder.setDiscount(sales.getDiscount());
//		
//		return tempsalesOrder;
//	}
}
