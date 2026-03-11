package org.book.service.Impl;

import java.util.List;
import org.book.model.Book;
import org.book.repository.BookRepository;
import org.book.service.BookService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    
    @CacheEvict(value = "bookCache", allEntries = true)
    @Override
    public Book create(Book request) {
        return repository.save(request);
    }

    @Cacheable(value = "bookCache")
    @Override
    public List<Book> findAll() {
        return repository.findAll()
            .stream()
            .map(b -> Book.builder()
                .id(b.getId())
                .title(b.getTitle())
                .descriptions(b.getDescriptions())
                .build())
            .toList();
    }
    
}
