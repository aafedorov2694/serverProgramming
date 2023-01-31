package com.example.BookStore.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



@Controller
@ResponseBody
public class BookController {
	
	@RequestMapping("/index")
	public String greeting() {
		
		
		return "This is the book store";
	}

}
