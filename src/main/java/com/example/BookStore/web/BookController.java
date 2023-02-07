package com.example.BookStore.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller

public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catrepository;
	
	/*@RequestMapping("/index")
	public String greeting() {
		
		
		return "This is the book store";
	}*/
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return "addBook";
	}
	
	@PostMapping("/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {

		repository.deleteById(id);
		return "redirect:../booklist";
			
	}
	
	@RequestMapping("/edit/{id}")
	public String modify(@PathVariable("id") long id, Model model) {

	Book book =	repository.findById(id);
	model.addAttribute("categories", catrepository.findAll());
	model.addAttribute("book", book);
		return "editBook";
			
	}
	
	@PostMapping("/update/{id}")
	public String editBook(@PathVariable("id") long id, Book book) {
		repository.save(book);
		return "redirect:../booklist";
	}

}
