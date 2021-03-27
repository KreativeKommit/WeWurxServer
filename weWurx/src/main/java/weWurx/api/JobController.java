package weWurx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weWurx.core.domain.Job;
import weWurx.core.service.JobService;

@RestController
@RequestMapping(path = JobController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

	static final String REST_URL = "/api/job";

	@Autowired
	private JobService service;

	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public Job create(@RequestBody Job entity) {
		return service.create(entity);
	}
}
