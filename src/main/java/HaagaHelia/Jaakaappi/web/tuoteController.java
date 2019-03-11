package HaagaHelia.Jaakaappi.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HaagaHelia.Jaakaappi.domain.LuokkaRepository;
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
	private LuokkaRepository lrepository;
	
	//näytä kaikki tuotteet
	@RequestMapping(value="/tuotelist")
	public String tuotelist(Model model) {
		model.addAttribute("tuotteet", trepository.findAll());
		return "tuotelist";		
	}
	
	//etsi tuote
	@RequestMapping(value="/tuote/{tuoteid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Tuote> findTuoteRest(@PathVariable("tuoteid") Long tuoteid) {
		return trepository.findById(tuoteid);
	}
	//lisää tuote
	@RequestMapping(value="/add")
	@PreAuthorize("hasRole('ADMIN')")
	public String addTuote(Model model) {
		model.addAttribute("tuote", new Tuote());
		model.addAttribute("luokat", lrepository.findAll());
		return "addtuote";
	}
	
	@RequestMapping(value="/edit{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String editTuote(@PathVariable("tuoteid") Long tuoteid, Model model) {
		model.addAttribute("tuote", trepository.findById(tuoteid));
		model.addAttribute("luokat", lrepository.findAll());
		return "edittuote";
	}
	//tallenna tuote
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public String save(Tuote tuote) {
		trepository.save(tuote);
		return "redirect:tuotelist";
	}
	//poista tuote
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
		public String deleteTuote(@PathVariable("tuoteid") Long tuoteid, Model model) {
		trepository.deleteById(tuoteid);
		return "redirect:..tuotelist";
		
	}
}
