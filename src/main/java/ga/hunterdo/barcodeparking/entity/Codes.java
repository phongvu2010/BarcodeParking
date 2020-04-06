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
@Table(name = "codes", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
public class Codes implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String MOTO = "M";
	public static final String CAR = "C";

	private Integer id;
	private String code;
	private String type;
	private Usernames username;
	private Date createdDate;
	private Date exportDate;
	private Date expiryDate;
	private Date usedDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)	// , length = 15
	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, nullable = false, length = 12)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "type", nullable = false, length = 1)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = true)
	public Usernames getUsername() {
		return username;
	}
	public void setUsername(Usernames username) {
		this.username = username;
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
	@Column(name = "export_date", nullable = true)
	public Date getExportDate() {
		return exportDate;
	}
	public void setExportDate(Date date) {
		this.exportDate = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiry_date", nullable = true)
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date date) {
		this.expiryDate = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "used_date", nullable = true)
	public Date getUsedDate() {
		return usedDate;
	}
	public void setUsedDate(Date date) {
		this.usedDate = date;
	}
}