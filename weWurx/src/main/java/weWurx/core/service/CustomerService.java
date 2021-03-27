package weWurx.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weWurx.core.domain.Customer;
import weWurx.core.repository.CustomerRepo;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	public Customer create(Customer customer) {
	return	repo.save(customer);
	}
}
