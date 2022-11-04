package com.digitalBooks.booksHelper;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalBooks.components.Book;

public class FilterBooksList {

	public static List<Book> filterBooks(List<Book> returnedBooks, Book book) {
		if(returnedBooks.size() == 0) {
			
			return returnedBooks;
			
		}
		return returnedBooks.stream()
				.filter(bk -> (bk.getBookTitle() != null && bk.getBookTitle().equalsIgnoreCase(book.getBookTitle()))
						|| (bk.getAuthor() != null && bk.getAuthor().equalsIgnoreCase(book.getAuthor()))
						|| (bk.getCreatedBy() != null && bk.getCreatedBy().equalsIgnoreCase(book.getCreatedBy()))
						|| (bk.getCategory() != null && bk.getCategory().equalsIgnoreCase(book.getCategory())))
				.collect(Collectors.toList());
	}

}
