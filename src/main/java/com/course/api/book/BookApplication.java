package com.course.api.book;

import com.course.api.book.display.Display;
import com.course.api.book.repository.AuthorRepository;
import com.course.api.book.repository.BookRepository;
import com.course.api.book.repository.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final LanguageRepository languageRepository;

	public BookApplication(
			BookRepository bookRepository,
			AuthorRepository authorRepository,
			LanguageRepository languageRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.languageRepository = languageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Display display = new Display(bookRepository, authorRepository, languageRepository);
		display.showMenu();
	}
}
