package com.course.api.book.display;

import com.course.api.book.data.dto.ApiResponse;
import com.course.api.book.data.dto.BookDTO;
import com.course.api.book.repository.AuthorRepository;
import com.course.api.book.repository.BookRepository;
import com.course.api.book.repository.LanguageRepository;
import com.course.api.book.service.ApiConsumption;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.util.Scanner;

public class Display {
    private Scanner input = new Scanner(System.in);
    private HttpClient client = HttpClient.newHttpClient();
    private ApiConsumption consumption = new ApiConsumption(client);
    private final String Address = "https://gutendex.com/books/";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LanguageRepository languageRepository;
    private ObjectMapper objectMapper;

    public Display(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            LanguageRepository languageRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.languageRepository = languageRepository;
        this.objectMapper = new ObjectMapper();
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

    public void searchBooksWeb() {
        try {
            var json = consumption.getData(Address + "?search=dom+casmurro");

            ApiResponse<BookDTO> response = objectMapper.readValue(
                    json, new TypeReference<ApiResponse<BookDTO>>() {}
            );

            for(BookDTO dto : response.results()) {
                System.out.println(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
