package com.digitalBooks.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalBooks.booksHelper.BooksList;
import com.digitalBooks.components.Book;
import com.digitalBooks.components.User;
import com.digitalBooks.controller.apiHelper.HttpComponentsClientHttpRequestWithBodyFactory;
import com.digitalBooks.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	RestTemplate resTemplate;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") int userId) {

		User user = userService.getUser(userId);
		return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return ResponseEntity.status(HttpStatus.CREATED).body((userService.createUser(user)));

	}

	@GetMapping("/find")
	public ResponseEntity<Object> getUserByNameAndPassword(@RequestBody User loginUser) {

		Optional<User> user = userService.getUserByUserNameAndPassword(loginUser.getUserName(),
				loginUser.getPassword());
		if (user.isPresent()) {
			return new org.springframework.http.ResponseEntity<>(user.get(), HttpStatus.OK);

		} else {
			return new org.springframework.http.ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}

	// For create book
	@PostMapping("/create/book")
	public HttpStatus createBook(@RequestBody Book book) {
		// System.out.println(user.getUserName());
		// HttpEntity<Book> request = new HttpEntity<>(new Book(book)); inserting null
		// resTemplate.setRequestFactory(new
		// HttpComponentsClientHttpRequestWithBodyFactory());

		// ResponseEntity<String> response =
		// resTemplate.exchange("http://Book-service/book/create", HttpMethod.POST,
		// request, String.class);
		resTemplate.exchange("http://Book-service/book/create", HttpMethod.POST, new HttpEntity<>(book), String.class);
		return HttpStatus.CREATED;

	}

	// For put book
	@PutMapping("/update/book")
	public HttpStatus updateBook(@RequestBody Book book) {

		HttpEntity<Book> request = new HttpEntity<>(new Book(book));

		resTemplate.exchange("http://Book-service/book/update", HttpMethod.PUT, new HttpEntity<>(book), String.class);
		return HttpStatus.OK;

	}

	// Subscibe a book
	@GetMapping("/subscribe/book/{authorId}/{subscribedBy}")
	public Long subscribeBook(@PathVariable Long authorId, @PathVariable String subscribedBy) {

		// HttpEntity<Book> request = new HttpEntity<>(new Book(book));

		String id = resTemplate.getForObject("http://Book-service/book/subscribe/" + authorId + "/" + subscribedBy,
				String.class);
		return Long.valueOf(id);

	}

	// For get book
	@GetMapping("/search/book")
	public ResponseEntity<Book> getBook(@RequestBody Book book) {

		// HttpEntity<Book> request = new HttpEntity<>(new Book(book));
		resTemplate.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());
		ResponseEntity<Book> searchedbook = resTemplate.exchange("http://Book-service/book/search", HttpMethod.GET,
				new HttpEntity<>(book), Book.class);
		return searchedbook;

	}

	@GetMapping("/book/getAll")
	public List<Book> getAllBooks(@RequestBody Book book) {

		resTemplate.setRequestFactory(new HttpComponentsClientHttpRequestWithBodyFactory());
		ResponseEntity<Book> allBooks = resTemplate.exchange("http://Book-service/book/search", HttpMethod.GET,
				new HttpEntity<>(book), Book.class);
		List<Book> result = Arrays.asList(allBooks.getBody());
		return result;

	}

	// Get all subscribed books by reader WIP
	@GetMapping("/searchBySubsName/{subscribedBy}")
	public List<Book> getUser(@PathVariable String subscribedBy) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("subsciberId", "1");
		params.put("userName", "aviansh");

//				BooksList  response = resTemplate.getForObject("http://Book-service/book/subsciberSearch"+"/subscribedBy", BooksList.class);
		ResponseEntity<Book[]> response = resTemplate
				.getForEntity("http://Book-service/book/subsciberSearch" + "/subscribedBy", Book[].class);

		List<Book> searchedBooks = Arrays.asList(response.getBody());
		return searchedBooks;

	}

}
