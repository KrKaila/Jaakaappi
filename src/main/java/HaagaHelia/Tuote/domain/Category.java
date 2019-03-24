package HaagaHelia.Tuote.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long category_id;
	private String categoryName;
	
	//linkittää Categoryn Tuote-entiteettiin
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Tuote> tuotteet;
	
	public Category() {}
	
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Tuote> getTuotteet() {
		return tuotteet;
	}
	public void setTuotteet(List<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", categoryName=" + categoryName + ", tuotteet=" + tuotteet
				+ "]";
	}
	
}