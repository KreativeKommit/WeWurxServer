package weWurx.core.domain;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

//@Entity
//@Table(name = "users", uniqueConstraints =
//{ @UniqueConstraint(columnNames = "email", name = "user_unique_email_idx"),
//		@UniqueConstraint(columnNames = "username", name = "user_unique_username_idx") })
@JsonInclude(value = Include.NON_NULL)
@MappedSuperclass
public class AuthUser extends AbstractEntity<AuthUser>
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Size(min = 5, max = 100)
	@Column(nullable = false)
	@NotBlank
	private String username;
	@Email
	@Size(max = 100)
	@Column(nullable = false)
	@NotBlank
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank
	@Size(min = 5, max = 100)
	private String password;
	private String mobileNo;
	@Column(nullable = false, columnDefinition = " bool default true")
	private boolean enabled = true;
	private boolean accountNonLocked;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}

	public void setAccountNonExpired(boolean accountNonExpired)
	{
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonExpired()
	{
		return accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked)
	{
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isAccountNonLocked()
	{
		return accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired)
	{
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isCredentialsNonExpired()
	{
		return credentialsNonExpired;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMobileNo()
	{
		return mobileNo;
	}

	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

}
