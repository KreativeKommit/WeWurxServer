package weWurx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weWurx.core.domain.Customer;
import weWurx.core.service.CustomerService;

@RestController
@RequestMapping(path = CustomerController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

	static final String REST_URL = "/api/customer";

	@Autowired
	private CustomerService service;

	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public Customer create(@RequestBody Customer city) {
		return service.create(city);
	}
}
