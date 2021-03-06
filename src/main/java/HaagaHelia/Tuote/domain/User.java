package HaagaHelia.Tuote.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="uid", nullable = false, updatable = false)
	private Long uid;
		
	@Column(name ="username", nullable = false, unique = true)
	private String username;
	
	@Column(name ="password", nullable = false)
	private String passwordHash;
	
	@Column(name ="role", nullable = false)
	private String role;
	
	public User() {
	}
	public User(String role, String username, String passwordHash) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
		public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role
				+ "]";
	}
	
}