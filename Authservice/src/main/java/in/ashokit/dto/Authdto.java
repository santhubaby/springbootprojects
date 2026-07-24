package in.ashokit.dto;

import org.springframework.stereotype.Component;

@Component
public class Authdto{
	

public static class AuthRequest {
	    private String username;
	    private String password;
	    private String role;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "AuthRequest [username=" + username + ", password=" + password + ", role=" + role + "]";
		}
	    
	    
	    // getters and setters
	}

	public static  class AuthResponse {
	    private String token;
	    
	    public AuthResponse(String token)
	    { this.token = token;
	    }
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		@Override
		public String toString() {
			return "AuthResponse [token=" + token + "]";
		}
	    
		
	}

}

