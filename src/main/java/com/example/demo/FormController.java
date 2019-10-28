package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import antlr.collections.List;


@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	/*
	@RequestMapping("/")
	public String details() {
		return "customer";
	}*/
	@RequestMapping("/")
	public String detailss() {
		//repo.save(customers);
		return "customer";
	}
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		
		return "viewCustomerDetails";
	}

/*
@GetMapping("customer")
public String show() {
	return "customer";
}

*/
@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam int cid){
	
	ModelAndView mv = new ModelAndView("Retrive");
	Customers customers = repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
}

@RequestMapping("/customers")
@ResponseBody
public List<Customers> customers() {
	return repo.findAll();
}

@RequestMapping("/customers/{cid}")
@ResponseBody
public Optional<Customers> getcustomers(@PathVariable("cid") int cid) {
	return repo.findById(cid);
}

@PostMapping("/customers") //新しいデータを作る
public Customers getCustomerCreate(@RequestBody Customers customers) {
	return repo.save(customers);
}

@DeleteMapping("/customers/{cid}") //削除メテオドを作りました。
public Customers getCustomerDelete(@PathVariable("cid") int cid) {
	Customers cust = repo.getOne(cid);
	repo.delete(cust);
	return cust;

}


}

