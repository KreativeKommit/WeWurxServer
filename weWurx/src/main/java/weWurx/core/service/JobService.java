package weWurx.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weWurx.core.domain.Job;
import weWurx.core.repository.JobRepo;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepo repo;
	
	public Job create(Job job) {
		return repo.save(job);
	}
}
