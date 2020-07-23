package microservice.uaa.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserDTO {

	Long id;
	String username;
	String fullName;
	String status;
	String email;
	String role;
	boolean enabled;
	public UserDTO() {}
	public UserDTO(User body) {
		this.username = body.getUsername();
		this.fullName = body.getFirstName() + " " + body.getLastName();
		this.id = body.getId();
		this.email = body.getEmail();
		this.username = body.getUsername();
		this.status = body.getStatus();
		this.role = parseAuthorities( body.getAuthorities());
		this.enabled = body.isEnabled();
	}
	private String parseAuthorities(Collection<? extends GrantedAuthority> authorities) {
	String res;
		for(GrantedAuthority auth : authorities) {
			if(auth.getAuthority().endsWith("USER")) return "KOIRSNIK";
			if(auth.getAuthority().endsWith("AGENCY")) return "AGENCIJA";
			if(auth.getAuthority().endsWith("ADMIN")) return "ADMINISTRTOR";
		}
		return "";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
