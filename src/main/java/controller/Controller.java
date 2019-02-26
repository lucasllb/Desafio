package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ConsultaCidadeService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private ConsultaCidadeService consultacidadeservice;
	
	@RequestMapping("/")
	public ModelAndView index()  {
		try {
			consultacidadeservice.alimentaBanco();
		}catch(Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("botaoMenu","index");
		return mv;
	}

}
