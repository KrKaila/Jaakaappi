package HaagaHelia.Tuote.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HaagaHelia.Tuote.domain.CategoryRepository;
import HaagaHelia.Tuote.domain.Tuote;
import HaagaHelia.Tuote.domain.TuoteRepository;

//Kapellimestari, joka käskyttää kaikkia muita luokkia
@Controller
public class tuoteController {
	//tuoterepository
	@Autowired
	private TuoteRepository trepository;
	//luokkarepository
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
    public String login() {	
    return "tuotelist";
    }	
	@RequestMapping(value="/login?logout")	
	public String logout() {
		return "redirect:..login";
	}
	
	// Show all products
    @RequestMapping(value="/tuotelist")
    public String studentList(Model model) {	
        model.addAttribute("tuotteet", trepository.findAll());
        return "tuotelist";
    }
	//RESTillä tehty haku
	@RequestMapping(value="/tuotteet")
	public @ResponseBody List<Tuote> tuoteListRest() {
		return (List<Tuote>) trepository.findAll();
	}
	//RESTillä yksittäisen tuotteen haku
	@RequestMapping(value="/tuote/{tuoteid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Tuote> findTuoteRest(@PathVariable("tuoteid") Long tuoteid){
		return trepository.findById(tuoteid);
	}
	//lisää tuote
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/add")
	public String addTuote(@Valid String name, Model model) {
		model.addAttribute("tuote", new Tuote());
		model.addAttribute("categories", crepository.findAll());
		return "addtuote";
	}
	//tallenna tuote
	//	@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/save", method = RequestMethod.POST)
		public String save(Tuote tuote) {
			trepository.save(tuote);
			return "redirect:tuotelist";
		}
		//poista tuote
		//value sama kuin tuotelistin komento
	//	@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
		//id tässä keksitty, samoin attribuutit
		public String deleteTuote(@PathVariable("id") Long tuoteId, Model model) {
			//tuoteId sama kuin attribuutti
			trepository.deleteById(tuoteId);
			return "redirect:..tuotelist";
		}	
		//muokkaa tuotetta
	//	@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value="/edit{id}")
		public String addTuote(@PathVariable("id") Long tuoteid, Model model) {
		model.addAttribute("tuote", trepository.findById(tuoteid));
		model.addAttribute("categories", crepository.findAll());
		return "edittuote";
	}
}
