package HaagaHelia.Jaakaappi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Luokka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long luokkaid;
	private String lname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "luokka")
	private List<Tuote> tuotteet;
	
	public Luokka() {}

	
	public Luokka(String name) {
		super();
		this.lname = lname;
	}
	

	public Long getLuokkaid() {
		return luokkaid;
	}


	public void setLuokkaid(Long luokkaid) {
		this.luokkaid = luokkaid;
	}


	public String getName() {
		return lname;
	}


	public void setName(String name) {
		this.lname = lname;
	}


	public List<Tuote> getTuotteet() {
		return tuotteet;
	}


	public void setTuotteet(List<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}


	@Override
	public String toString() {
		return "Luokka [luokkaid=" + luokkaid + ", lname=" + lname + "]";
	}
	
	

}
