package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.book.components.Book;
import com.book.components.SubscriberDetails;
import com.book.components.User;
import com.book.repository.BooksRepository;
import com.book.repository.SubscriberDetailsRepository;

@Service


public class BookServiceImpl implements BookService{
	@Autowired
	private BooksRepository booksRepo;
	
	@Autowired
	SubscriberDetailsRepository subsRepo;
	
//	@PersistenceContext
//    private EntityManager entityManager;
	
//	@PersistenceUnit(unitName = "readwrite.config")
//	private EntityManagerFactory entityManagerFactory;

//	@Override
//	public List<Book> getBooks(int authorId) {
		
//		List<Book> books = new ArrayList<Book>();
//		Book book1 = new Book(12, "Rich dad poor dad", "Economical", 500, "Active");
//		Book book2 = new Book(15, "XYZ", "Fiction", 400, "Inactive");

//		books.add(book1);
//		books.add(book2);

		//return books.stream().filter(e->e.getAuthorId()== authorId).collect(Collectors.toList());
	//}

	
	@Override
	public Book searchBook(Book book) {
		
		return null;
	}

	@Override
	public List<Book> getAllBooksSubscribedByUser(String subscribedBy) {
		List<Book> subscribedBooks = booksRepo.searchBooksBySubscription(subscribedBy);
		return subscribedBooks;
	}

	@Override
	public int subscribeBook(Book book, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createBook(Book book) {
		
		booksRepo.save(book);
		return "CREATED";
	}

	@Override
	public String updateBook(Book book) {
		
//		Book oldBook = new Book(book);
//		oldBook.setAuthorId(booksRepo.findBookByAuthorId(book.getAuthorId()).getAuthorId());
//		book.setActive(oldBook.getActive());
		
		booksRepo.save(book);
		return "UPDATED";
	}

	//Get all books for geust, author and reader
	@Override
	public List<Book> getAllBooks(Book book) {
		List<Book> books = booksRepo.findAll();
		return books;
	}

	@Override
	public Book findBookByAuthorId(int authorId) {
		return null;
	}

	@Override
	public Book searchBookByTitleAndAuthorName(Book book) {
		//book.getBookTitle(), book.getAuthor()
		Book searchedBook = booksRepo.searchBookByTitleAndAuthor(book.getBookTitle(), book.getAuthor());
		return searchedBook;
	}

	@Override
	public Long subscribeBook(Long authorId, String subscribedBy) {
		
		//Book book =  booksRepo.findBookByAuthorId(authorId);
		SubscriberDetails subDetails = new SubscriberDetails();
		subDetails.setSubscribedBy(subscribedBy);
		subDetails.setAuthorId(authorId);
		
		subsRepo.save(subDetails) ; 
		//insertWithQuery(subDetails);
		
		//subsRepo.insertSubscriberDetails(authorId, subscribedBy);
		List<SubscriberDetails> subList = subsRepo.findAll();
		
		return subList.stream().filter(s->s.getSubscribedBy().equalsIgnoreCase(subscribedBy) && s.getAuthorId().equals(authorId)).findAny().get().getSubId();
	}
	
	@Transactional
	public void insertWithQuery(SubscriberDetails entity) {
//		entityManager.getTransaction().begin();
//	    entityManager.createQuery("INSERT INTO SubscriberDetails (authorId, subscribedBy) VALUES (?,?)")
//	      .setParameter(1, authorId)
//	      .setParameter(2, subscribedBy)	      
//	      .executeUpdate();
//	    
//	    entityManager.getTransaction().commit();
		
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//		entityManager.getTransaction().begin();
//		if (!ObjectUtils.isEmpty(entity) && !entityManager.contains(entity)) {
//		   entityManager.persist(entity);
//		   entityManager.flush();
//		}
//		entityManager.getTransaction().commit();
		
//		Query query = entityManager.createNativeQuery("INSERT INTO SubscriberDetails (authorId, subscribedBy) VALUES (:authorId , :subscribedBy);");
//		entityManager.getTransaction().begin();
//		query.setParameter("id", "5");
//		query.setParameter("name", "Harley");
//		query.executeUpdate();
		//entityManager.getTransaction().commit();
		
		
		
	}
	
	
	
	
//	@Override
//	public Book findBookByAuthorId(int authorId) {
//		return booksRepo.getById(authorId);
//		
//		
//	}

	
}
