package weWurx.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import weWurx.core.domain.User;
import weWurx.core.service.UserService;

@RestController
@RequestMapping(path = UserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController{
	static final String REST_URL = "/api/user";

	@Autowired
	UserService userService;
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("permitAll()")
	public User register(@RequestBody User userInfo)
	{
		userInfo.setUsername(userInfo.getEmail().toLowerCase().trim());
		userInfo = userService.register(userInfo);
		return userInfo;
	}

}
