package org.book.controller;

import java.util.List;

import org.book.dto.ApiResponse;
import org.book.dto.BookRequest;
import org.book.model.Book;
import org.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService service;

    @GetMapping("/allBooks")
    public ResponseEntity<ApiResponse<List<Book>>> getAll() {

        List<Book> list = service.findAll();

        ApiResponse<List<Book>> res = ApiResponse.<List<Book>>builder()
                .code(200)
                .message("success")
                .data(list)
                .build();


        return ResponseEntity.ok(res);
    }

    @PostMapping("/addBook")
    public ResponseEntity<ApiResponse<Book>> create(@RequestBody BookRequest req) {
        Book book = Book.builder()
                .title(req.getTitle())
                .descriptions(req.getDescriptions())
                .build();

        Book saved = service.create(book);
        ApiResponse<Book> res = ApiResponse.<Book>builder()
                .code(201)
                .message("success")
                .data(saved)
                .build();


        return ResponseEntity.status(201).body(res);
    }
}
