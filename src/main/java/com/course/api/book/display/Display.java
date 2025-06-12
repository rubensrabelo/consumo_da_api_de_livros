package com.course.api.book.display;

import com.course.api.book.repository.AuthorRepository;
import com.course.api.book.repository.BookRepository;
import com.course.api.book.repository.LanguageRepository;

import java.util.Scanner;

public class Display {
    private Scanner input = new Scanner(System.in);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;

    public Display() {
    }

    public Display(BookRepository bookRepository,
                   AuthorRepository authorRepository,
                   LanguageRepository languageRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
    }

    public void showMenu() {
        int options = -1;

        while(options != 0) {
            String menu = """
                    [1] Buscar livros
                    [0] Sair
                    """;

            System.out.println(menu);
            options = input.nextInt();
            input.nextLine();

            switch (options) {
                case 0:
                    System.out.println("Saindo ...");
                    break;
                case 1:
                    searchBooksWeb();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void searchBooksWeb() {}
}
