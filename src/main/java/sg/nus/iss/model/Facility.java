package sg.nus.iss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@Column(name = "facilityid")
	private int facilityId;
	@Column(name = "name")
	private String facilityname;
	@Column(name = "description")
	private String facilitydescription;
	@Column(name = "location")
	private String location;
	@Column(name = "facilitystatus")
	private String facilitystatus;
	//@ManyToOne
	@Column(name = "categoryid")
	private int categoryId;

	//getters & Setters
	public int getFacilityId() {
		return facilityId;
	}

	public String getFacilityname() {
		return facilityname;
	}

	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public String getFacilitydescription() {
		return facilitydescription;
	}

	public void setFacilitydescription(String facilitydescription) {
		this.facilitydescription = facilitydescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFacilitystatus() {
		return facilitystatus;
	}

	public void setFacilitystatus(String facilitystatus) {
		this.facilitystatus = facilitystatus;
	}

	public int getCategoryId() {
		return categoryId;
	}

	// Default Constructor
	public Facility() {
		// TODO Auto-generated constructor stub
	}

	// Constructor using fields
	public Facility(String facilityname, String facilitydescription, String location, String facilitystatus,
			int categoryId) {
		super();
		this.facilityname = facilityname;
		this.facilitydescription = facilitydescription;
		this.location = location;
		this.facilitystatus = facilitystatus;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", facilityname=" + facilityname + ", facilitydescription="
				+ facilitydescription + ", location=" + location + ", facilitystatus=" + facilitystatus
				+ ", categoryId=" + categoryId + "]";
	}
	
	

}
