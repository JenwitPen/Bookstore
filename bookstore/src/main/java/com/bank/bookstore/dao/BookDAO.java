package com.bank.bookstore.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

import org.springframework.stereotype.Repository;

import com.bank.bookstore.model.Book;
 
@Repository
public class BookDAO {
	 private static final Map<String, Book> hashMap = new HashMap<String, Book>();
	 
	    static {
	        initEmps();
	    }
	 
	    private static void initEmps() {
	    	Book book1 = new Book(1, "An American Princess: The Many Lives of Allene Tew 2222",
					"Annejet van der Zijl,Michele Hutchison 2", 149.00, true);
	    	Book book2 = new Book(2, "An L Princess: The Many Lives of Allene Tew 2222", "Annejet van der Zijl,Michele Hutchison ", 149.00,
					true);
	    
	 
	    	hashMap.put(Integer.toString(book1.getId()), book1);
	    	hashMap.put(Integer.toString(book2.getId()), book2);

	    }
	  
	    public Book getBook(String userid) {
	        return hashMap.get(userid);
	    }
	  
	    public Book addBook(Book book) {
	    	hashMap.put(Integer.toString(book.getId()), book);
	        return book;
	    }
	 
	    public Book updateBook(Book book) {
	    	hashMap.put(Integer.toString(book.getId()), book);
	        return book;
	    }
	 
	    public void deleteBook(String book) {
	    	hashMap.remove(book);
	    }
	 
	    public List<Book> getAllBook() {
	        Collection<Book> c = hashMap.values();
	        List<Book> list = new ArrayList<Book>();
	        list.addAll(c);
	        return list;
	    }
}
