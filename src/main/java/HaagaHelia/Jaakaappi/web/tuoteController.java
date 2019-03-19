package HaagaHelia.Jaakaappi.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HaagaHelia.Jaakaappi.domain.CategoryRepository;
import HaagaHelia.Jaakaappi.domain.Tuote;
import HaagaHelia.Jaakaappi.domain.TuoteRepository;

//Kapellimestari, joka käskyttää kaikkia muita luokkia
@Controller
public class tuoteController {
	//tuoterepository
	@Autowired
	private TuoteRepository trepository;
	//luokkarepository
	@Autowired
	private CategoryRepository crepository;
	
	// Show all students
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

	@RequestMapping(value="/add")
	public String addTuote(@Valid String name, Model model) {
		
		model.addAttribute("tuote", new Tuote());
		model.addAttribute("categoryNames", crepository.findAll());
		return "addtuote";
	}
	//tallenna tuote

		@RequestMapping(value="/save", method = RequestMethod.POST)
		public String save(Tuote tuote) {
			trepository.save(tuote);
			return "redirect:tuotelist";
		}
		//poista tuote
	
		@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
		public String deleteTuote(@PathVariable("tuoteid") Long tuoteId, Model model) {
			trepository.deleteById(tuoteId);
			return "redirect:..tuotelist";
		}	
		//muokkaa tuotetta
	
		@RequestMapping(value="/edit{id}")
		public String editTuote(@PathVariable("tuoteid") Long tuoteid, Model model) {
		model.addAttribute("tuote", trepository.findById(tuoteid));
		model.addAttribute("categories", crepository.findAll());
		return "redirect:..tuotelist";
	}
}
