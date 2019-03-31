package HaagaHelia.Tuote.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tuote {
//id ja generatedValue tekevät yksilöllisen primary keyn tuotteille
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="tuoteId", nullable = false, updatable = false)
	private Long tuoteId;
	//ei saa olla tyhjä kenttä
	@NotNull
	private String name;
	
	@Column(name ="date", nullable = false, updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	// linkittää Tuotteen Categorytauluun 
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Tuote() {}
	
	public Tuote(@NotNull String name, Date date, Category category) {
	super();
	this.name = name;
	this.date = date;
	this.category = category;
	}
	public Tuote(@NotNull String name, Date date) {
	super();
	this.name = name;
	this.date = date;
	}
	public Tuote(@NotNull String name, Category category) {
	super();
	this.name = name;
	}
	public Tuote(@NotNull String name) {
		super();
		this.name = name;
	}
	public Long getTuoteId() {
		return tuoteId;
	}
	public void setTuoteId(Long tuoteId) {
		this.tuoteId = tuoteId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null)
			return "Tuote [tuoteId=" + tuoteId + ", name=" + name + ", date=" + date + " category =" + this.getCategory() + "]";
		else
		return "Tuote [tuoteId=" + tuoteId + ", name=" + name + ", date =" + date + "]";
	}
}
