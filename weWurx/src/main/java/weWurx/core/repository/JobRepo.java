package weWurx.core.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import weWurx.core.domain.Job;

@Repository
@Transactional
public interface JobRepo extends PagingAndSortingRepository<Job, UUID>, JpaSpecificationExecutor<Job> {

	
}
