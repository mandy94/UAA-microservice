package microservice.uaa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RequestedCarTerm {
	
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "advert_id")
	Advert advert;
	
	@ManyToOne
	@JoinColumn(name = "rent_id")
@JsonIgnore
	RentingRequest rent;
	
	
	@Column
	String rentingDate;
	@Column
	String returningDate;
	@Column
	String rentingTime;
	@Column
	String returningTime;
	
	public RequestedCarTerm() {}
	public RequestedCarTerm(Advert reqAdvert) {
		this.advert = reqAdvert;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Advert getAdvert() {
		return advert;
	}
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}
	public String getRentingDate() {
		return rentingDate;
	}
	public void setRentingDate(String rentingDate) {
		this.rentingDate = rentingDate;
	}
	public String getReturningDate() {
		return returningDate;
	}
	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}
	public String getRentingTime() {
		return rentingTime;
	}
	public void setRentingTime(String rentingTime) {
		this.rentingTime = rentingTime;
	}
	public String getReturningTime() {
		return returningTime;
	}
	public void setReturningTime(String returningTime) {
		this.returningTime = returningTime;
	}	
	

}
