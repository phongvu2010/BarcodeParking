package ga.hunterdo.barcodeparking.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tokens", uniqueConstraints = @UniqueConstraint(columnNames = {"token"}))
public class Tokens implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String token;
	private String type;
	private Date createdDate;
	private Date activedDate;
	private Usernames username;
	private boolean status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}

	@Column(name = "token", unique = true, nullable = false, length = 60)
	public String getToken() {
		return token;
	}
	public void setToken(String tokenID) {
		this.token = tokenID;
	}

	@Column(name = "type", nullable = false, length = 20)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actived_date", nullable = true)
	public Date getActivedDate() {
		return activedDate;
	}
	public void setActivedDate(Date date) {
		this.activedDate = date;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	public Usernames getUsername() {
		return username;
	}
	public void setUsername(Usernames username) {
		this.username = username;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}