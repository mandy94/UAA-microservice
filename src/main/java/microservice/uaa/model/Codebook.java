package microservice.uaa.model;

import java.util.ArrayList;
import java.util.List;

import microservice.uaa.model.additions.City;
import microservice.uaa.model.additions.Fuel;
import microservice.uaa.model.additions.Manufacturer;
import microservice.uaa.model.additions.Model;


public class Codebook {

	private ArrayList<Fuel> fuels;
	private ArrayList<Model> models;
	private ArrayList<Manufacturer> manufacturers;
	private ArrayList<City> cities;
	
	public List<Fuel> getFuels() {
		return fuels;
	}
	public void setFuels(List<Fuel> fuels) {
		this.fuels = new ArrayList<Fuel>(fuels);
	}
	public ArrayList<Model> getModels() {
		return models;
	}
	public void setModels(List<Model> models) {
		this.models = new ArrayList<Model>(models);
	}
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = new ArrayList<Manufacturer>(manufacturers);
	}
	@Override
	public String toString() {
		return "Codebook [fuels=" + fuels + ", models=" + models + ", manufacturers=" + manufacturers + "]";
	}
	public ArrayList<City> getCities() {
		return cities;
	}
	public void setCities(List<City> list) {
		this.cities = new ArrayList<City>(list);
	}

}

