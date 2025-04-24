package kz.sd.controller;

import kz.sd.model.Book;
import kz.sd.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}