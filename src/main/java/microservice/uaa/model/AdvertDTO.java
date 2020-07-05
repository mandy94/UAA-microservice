package microservice.uaa.model;


public class AdvertDTO {
	

	    @Override
	public String toString() {
		return "\n\nAdvertDTO [id=" + id + ", title=" + title + ", priceList=" + priceList + ", manufacturer="
				+ manufacturer + ", model=" + model + ", gear=" + gear + ", cclass=" + cclass + ", imgmain=" + imgmain
				+ ", milage=" + milage + ", kidsSeat=" + kidsSeat + ", numberOfKidsSeat=" + numberOfKidsSeat
				+ ", CDWprotection=" + CDWprotection + ", user=" + user + "]\n\n";
	}
		private Long id;
	    private String title;
	    public Pricelist priceList;
		private String manufacturer;
		private String model;
		private String gear;
		private String fuel;
		private String cclass;
		private String imgmain;
		private Float milage;
		private Boolean kidsSeat;
		private Integer numberOfKidsSeat;
		private Boolean CDWprotection;
		
		private User user;
		
		public AdvertDTO(Advert adById) {
			this.id = adById.getId();
			this.title= adById.getTitle();
			this.priceList =adById.getPriceList();
			this.manufacturer = adById.getManufacturer().getTitle();
			this.gear = adById.getGear().getTitle();
			this.fuel = adById.getFuel().getTitle();
			this.model = adById.getModel();
			this.imgmain = adById.getImgmain();
			this.milage = adById.getMilage();
			this.kidsSeat = adById.getKidsSeat();
			this.numberOfKidsSeat = adById.getNumberOfKidsSeat();
			this.CDWprotection = adById.getCDWprotection();
		}
		public String getFuel() {
			return fuel;
		}
		public void setFuel(String fuel) {
			this.fuel = fuel;
		}
		public void setGear(String gear) {
			this.gear = gear;
		}
		public void setCclass(String cclass) {
			this.cclass = cclass;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Pricelist getPriceList() {
			return priceList;
		}
		public void setPriceList(Pricelist priceList) {
			this.priceList = priceList;
		}
		public String getManufacturer() {
			return manufacturer;
		}
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
	
		public String getImgmain() {
			return imgmain;
		}
		public void setImgmain(String imgmain) {
			this.imgmain = imgmain;
		}
		public Float getMilage() {
			return milage;
		}
		public void setMilage(Float milage) {
			this.milage = milage;
		}
		public Boolean getKidsSeat() {
			return kidsSeat;
		}
		public void setKidsSeat(Boolean kidsSeat) {
			this.kidsSeat = kidsSeat;
		}
		public Integer getNumberOfKidsSeat() {
			return numberOfKidsSeat;
		}
		public void setNumberOfKidsSeat(Integer numberOfKidsSeat) {
			this.numberOfKidsSeat = numberOfKidsSeat;
		}
		public Boolean getCDWprotection() {
			return CDWprotection;
		}
		public void setCDWprotection(Boolean cDWprotection) {
			CDWprotection = cDWprotection;
		}
		
}