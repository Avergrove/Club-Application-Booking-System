package sg.nus.iss.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "categoryid")
	private int categoryId;
	@Column(name = "categoryname")
	private String categoryname;
	@Transient
	@OneToMany
	@JoinColumn(name = "categoryid")
	private List<Facility> faclist = new ArrayList<Facility>();
	
	//getters & Setters
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int i) {
	this.categoryId=i;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<Facility> getFaclist() {
		return faclist;
	}

	public void setFaclist(List<Facility> faclist) {
		this.faclist = faclist;
	}

	//default constructor
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public Category(int categoryId, String categoryname) {
		super();
		this.categoryId = categoryId;
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryname=" + categoryname + "]";
	}
	
	

}
