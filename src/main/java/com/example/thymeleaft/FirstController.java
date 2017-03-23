package com.example.thymeleaft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	public  List<Example> listExample =new ArrayList<Example>(){
		
		private static final long serialVersionUID = 8497507301123368599L;

	{
		add(0, new Example(1L,"",""));
		add(1, new Example(2L,"",""));
		add(2, new Example(3L,"",""));
		add(3, new Example(4L,"",""));
		add(4, new Example(5L,"",""));
		add(5, new Example(6L,"",""));
		add(6, new Example(7L,"",""));
		add(7, new Example(8L,"",""));
		add(8, new Example(9L,"",""));
		add(9, new Example(10L,"",""));
	}};
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getAll(){
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("lst", listExample);
		return model;
	}
	
	@RequestMapping( value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam int id){
		ModelAndView model = new ModelAndView("welcome");
		for(Example e : listExample){
			if(e.getId().intValue() == id){
				System.out.println("Delete Object: "+e);
				listExample.remove(e);
				break;
			}
		}
		model.addObject("lst", listExample);
		return model;
	}
	
	@RequestMapping( value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam Long id, @RequestParam String name, @RequestParam String description){
		ModelAndView model = new ModelAndView("welcome");
//		Example ex = new Example();
		for(Example e : listExample){
			if(e.getId() == id){
				e.setName(name);
				e.setDescription(description);
			}
		}
		
		model.addObject("lst", listExample);
		return model;
	}
	
	@RequestMapping( value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam String name, @RequestParam String description){
		ModelAndView model = new ModelAndView("welcome");
		System.out.println("add object");
		Example example = new Example(1L + listExample.size(),name,description);
		listExample.add(example);
		model.addObject("lst", listExample);
		return model;
	}
	
}
