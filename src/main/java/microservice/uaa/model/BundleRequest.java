package microservice.uaa.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BundleRequest {
		
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
		Long whoasked;
		Long whoposted;
		
		@OneToMany(mappedBy = "rent_id")
		List<RequestedCarTerm> requests = new ArrayList<RequestedCarTerm>();
		
		// GETTERS ADN SETTERS 
		
	
		public List<RequestedCarTerm> getRequests() {
			return requests;
		}
		public void setRequests(List<RequestedCarTerm> requests) {
			this.requests = requests;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getWhoasked() {
			return whoasked;
		}
		public void setWhoasked(Long whoasked) {
			this.whoasked = whoasked;
		}
		public Long getWhoposted() {
			return whoposted;
		}
		public void setWhoposted(Long whoposted) {
			this.whoposted = whoposted;
		}

}
