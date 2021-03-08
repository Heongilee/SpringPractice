package com.brms.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookSearchService {

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() { }
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}

	public void initMethod() {
		// bean객체가 생성될 시점에 동작시킬 명령들...
		System.out.println("Initialize BookSearchService object by initMethod");
	}

	public void destroyMethod() {
		// ctx.close()에 의해 객체가 소멸될때 동작시킬 명령들...
		System.out.println("Destroyed BookSearchService object by destroyMethod");
	}
}
