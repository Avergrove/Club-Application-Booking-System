package sg.nus.iss.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category categoryId;
	@Transient
	@OneToMany
	@JoinColumn(name = "faciltiyid")
	private List<Booking> facilityset = new ArrayList<Booking>();

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

	public Category getCategoryId() {
		return categoryId;
	}

	public List<Booking> getFacilityset() {
		return facilityset;
	}

	public void setFacilityset(List<Booking> facilityset) {
		this.facilityset = facilityset;
	}

	// Default Constructor
	public Facility() {
		// TODO Auto-generated constructor stub
	}

	// Constructor using fields
	public Facility(String facilityname, String facilitydescription, String location, String facilitystatus,
			Category categoryId) {
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
