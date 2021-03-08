package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean {
	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// bean객체가 생성될 시점에 동작시킬 명령들...
		System.out.println("Initialize BookRegisterService object by afterPropertiesSet method");
	}

	@Override
	public void destroy() throws Exception {
		// ctx.close()에 의해 객체가 소멸될때 동작시킬 명령들...
		System.out.println("Destroyed BookRegisterService object by destory method");
	}
}