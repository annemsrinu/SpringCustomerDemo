/**
 * 
 */
package com.learner.capg.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.learner.capg.model.Customer;

/**
 * @author DELL
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addCustomer(Customer c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(c);
		logger.info("Customer saved successfully, Person Details=" + c);
	}

	public void updateCustomer(Customer c) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Customer updated successfully, Person Details=" + c);

	}

	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Customer");
		List<Customer> custlist = query.list();
		for (Customer c : custlist) {
			logger.info("Customer List::" + c);
		}
		return custlist;
	}

	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Customer loaded successfully, Customer details=" + c);
		return c;
	}

	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer c = (Customer) session.load(Customer.class, new Integer(id));
		if (null != c) {
			session.delete(c);
		}
		logger.info("Customer deleted successfully, person details=" + c);
	}

}
