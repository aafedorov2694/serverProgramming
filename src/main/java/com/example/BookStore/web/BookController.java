package com.example.BookStore.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BookStore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller

public class BookController {
	@Autowired
	private BookRepository repository;
	
	/*@RequestMapping("/index")
	public String greeting() {
		
		
		return "This is the book store";
	}*/
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}

}
