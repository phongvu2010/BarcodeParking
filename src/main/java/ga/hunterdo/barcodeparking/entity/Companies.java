package ga.hunterdo.barcodeparking.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "companies", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
public class Companies implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String address;
	private String phone;
	private Set<Usernames> usernames = new HashSet<Usernames>(0);

	public Companies () { }

	public Companies (String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Id
	@Column(name = "code", unique = true, nullable = false, length = 2)
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", nullable = true, length = 10)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy = "company")
	public Set<Usernames> getUsernames() {
		return usernames;
	}
	public void setUsernames(Set<Usernames> usernames) {
		this.usernames = usernames;
	}
}