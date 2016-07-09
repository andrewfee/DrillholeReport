package servlet;

import java.util.*;


//Summary: this class represents a Drillhole Record as stored in the database
public class DrillholeRecord{

	public String id;
	public double length;
	public double easting;
	public double northing;
	public double elevation;
	public String area;
	public String driller;
	public double casing;
	public Date drilldate;
	

	//Accessor methods
	public String getId() {
		return id;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getEasting() {
		return easting;
	}
	
	public double getNorthing() {
		return northing;
	}
	
	public double getElevation() {
		return elevation;
	}
	
	public String getArea() {
		return area;
	}
	
	public String getDriller() {
		return driller;
	}
	
	public double getCasing() {
		return casing;
	}
	
	public Date getDrilldate(){
		return drilldate;
	}
	
	//Constructor
	DrillholeRecord(String id, double length, double easting, double northing, double elevation, String area, String driller, double casing, Date drilldate){
		this.id = id;
		this.length = length;
		this.easting = easting;
		this.northing = northing;
		this.elevation = elevation;
		this.area = area;
		this.driller = driller;
		this.casing = casing;
		this.drilldate = drilldate;
	}

}