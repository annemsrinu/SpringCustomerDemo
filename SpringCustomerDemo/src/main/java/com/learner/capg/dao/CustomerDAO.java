/**
 * 
 */
package com.learner.capg.dao;

import java.util.List;

import com.learner.capg.model.Customer;

/**
 * @author DELL
 *
 */
public interface CustomerDAO {

	public void addCustomer(Customer c);

	public void updateCustomer(Customer c);

	public List<Customer> listCustomers();

	public Customer getCustomerById(int id);

	public void removeCustomer(int id);

}
