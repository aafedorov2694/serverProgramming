package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Autowired
	private CategoryRepository catrepository;
	@Bean
	public CommandLineRunner book (BookRepository repository, CategoryRepository catrespository) {
	return (args) -> {
		Category funny = new Category("Funny");
		Category serious = new Category("Serious");
	
		catrespository.save(funny);
		catrespository.save(serious);

		repository.save(new Book("Generation P", "Viktor Pelevin", 1999, "556554-23", (float) 15.26, funny));
		repository.save(new Book("Animal Farm", "George Orwell", 1929, "55679874-23", (float) 15.26,  funny));
		repository.save(new Book("A Farwell to Arms", "Ernest Hemingway", 1945, "556554-23", (float) 15.26,  serious));
		
	};
	}

}
