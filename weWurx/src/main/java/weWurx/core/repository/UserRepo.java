package weWurx.core.repository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import weWurx.core.domain.AuthUser;
import weWurx.core.domain.User;

@Repository
@Transactional
public interface UserRepo extends PagingAndSortingRepository<User, UUID>, JpaSpecificationExecutor<AuthUser> {

	Optional<User> findByUsernameIgnoreCase(String username);

}
