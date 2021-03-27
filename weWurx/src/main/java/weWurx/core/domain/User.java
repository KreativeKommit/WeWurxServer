package weWurx.core.domain;



import java.util.Collection;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users", uniqueConstraints =
{ @UniqueConstraint(columnNames = "email", name = "user_unique_email_idx"),
		@UniqueConstraint(columnNames = "username", name = "user_unique_username_idx"),
		@UniqueConstraint(columnNames = "mobileNo", name = "user_unique_mobileno_idx")})
public class User extends AuthUser
{
	private String firstName;
	private String middleName;
	private String lastName;
	private Locale locale = Locale.getDefault();

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@BatchSize(size = 200)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@Column(name = "role")
	private Set<Role> roles = EnumSet.noneOf(Role.class);

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Locale getLocale()
	{
		return locale;
	}

	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Collection<Role> roles)
	{
		this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
	}

	public void addRole(Role role)
	{
		roles.add(role);
	}

}
