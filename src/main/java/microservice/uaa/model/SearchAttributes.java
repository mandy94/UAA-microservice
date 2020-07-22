package microservice.uaa.model;

import java.util.List;

import microservice.uaa.model.additions.*;


public class SearchAttributes {

	private List<Model> models; 
	private List<Fuel> fuels;
	private List<Manufacturer> manufacturers;
	private List<GearBoxType> gearType;
	private List<CarClass> cclass;
	public List<Model> getModels() {
		return models;
	}
	public void setModels(List<Model> models) {
		this.models = models;
	}
	public List<Fuel> getFuels() {
		return fuels;
	}
	public void setFuels(List<Fuel> fuels) {
		this.fuels = fuels;
	}
	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}
	public List<GearBoxType> getGearType() {
		return gearType;
	}
	public void setGearType(List<GearBoxType> gearType) {
		this.gearType = gearType;
	}
	public List<CarClass> getCclass() {
		return cclass;
	}
	public void setCclass(List<CarClass> cclass) {
		this.cclass = cclass;
	}
	
	
	
}
