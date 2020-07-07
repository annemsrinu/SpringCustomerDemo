/**
 * 
 */
package com.learner.capg.service;

import java.util.List;

import com.learner.capg.model.Customer;

/**
 * @author DELL
 *
 */

public interface CustomerService {
	
	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public List<Customer> listCustomers();

	public Customer getCustomerById(int id);

	public void removeCustomer(int id);


}
