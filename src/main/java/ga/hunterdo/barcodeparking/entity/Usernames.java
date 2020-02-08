package ga.hunterdo.barcodeparking.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usernames", uniqueConstraints = {
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email")
})
public class Usernames implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String email;
	private String role;
	private Companies company;
	private boolean enabled;
	private Set<Codes> codes = new HashSet<Codes>(0);
	private Set<Tokens> tokens = new HashSet<Tokens>(0);

	public Usernames() { }
/*
	public Usernames(String username) {
		this.username = username;
	}

	public Usernames(Object[] object) {
		this.username = (String) object[0];
		this.password = (String) object[1];
		this.email = (String) object[2];
		this.role = (String) object[3];
		this.enabled = Boolean.parseBoolean((String) object[4]);
	}
*/
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 25)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", unique = true, nullable = false, length = 120)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "role", nullable = false, length = 25)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company", nullable = false)
	public Companies getCompany() {
		return company;
	}
	public void setCompany(Companies company) {
		this.company = company;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}

	@OneToMany(mappedBy = "username")
	public Set<Codes> getCodes() {
		return codes;
	}
	public void setCodes(Set<Codes> codes) {
		this.codes = codes;
	}

	@OneToMany(mappedBy = "username")
	public Set<Tokens> getTokens() {
		return tokens;
	}
	public void setTokens(Set<Tokens> tokens) {
		this.tokens = tokens;
	}
}