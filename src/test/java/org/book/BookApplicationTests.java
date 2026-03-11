package org.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.book.controller.BookController;
import org.book.dto.ApiResponse;
import org.book.dto.BookRequest;
import org.book.model.Book;
import org.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class BookApplicationTests {

	private final BookService service = mock(BookService.class);
    private final BookController controller = new BookController(service);


	@Test
	void testInsert() {
		BookRequest req = new BookRequest("Title1", "Description1");
		Book book = new Book(1L, "Title1", "Description1");

		when(service.create(any(Book.class))).thenReturn(book);

		ResponseEntity<ApiResponse<Book>> res = controller.create(req);

		// cek status code
		assertEquals(201, res.getBody().getCode());

		// cek response body
		ApiResponse<Book> body = res.getBody();
		assertNotNull(body);
		assertEquals(201, body.getCode());
		assertEquals("success", body.getMessage());
	}

	@Test
	void testGetAll() {
		List<Book> list = List.of(new Book(1L, "Title1", "Descriptions1"));

		when(service.findAll()).thenReturn(list);

		ResponseEntity<ApiResponse<List<Book>>> res = controller.getAll();
		
		// cek status code
		assertEquals(200, res.getBody().getCode());

		// cek response body
		ApiResponse<List<Book>> body = res.getBody();
		assertNotNull(body);
		assertEquals(200, body.getCode());
		assertEquals("success", body.getMessage());
	}	

}
