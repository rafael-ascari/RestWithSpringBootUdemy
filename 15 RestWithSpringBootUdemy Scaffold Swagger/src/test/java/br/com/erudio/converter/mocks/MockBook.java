package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.model.Book;
import br.com.erudio.data.vo.v1.BookVO;

public class MockBook {

	private Book mockEntity(Integer number) {
		Book b = new Book();
		b.setId(number.longValue());
		b.setAuthor("Author"+number);
		b.setTitle("Title"+number);
		b.setLaunchDate(new Date());
		b.setPrice(number.doubleValue());
		return b;
	}
	
	private BookVO mockVO(Integer number) {
		BookVO b = new BookVO();
		b.setKey(number.longValue());
		b.setAuthor("Author"+number);
		b.setTitle("Title"+number);
		b.setLaunchDate(new Date());
		b.setPrice(number.doubleValue());
		return b;
	}
	
	public Book mockEntity() {
		return mockEntity(0);
	}
	
	public BookVO mockVO() {
		return mockVO(0);
	}
	
	
	public List<Book> mockEntityList() {
		List<Book> l = new ArrayList<>();
		for (int i = 0; i<= 14; i++) {
			l.add(mockEntity(i));
		}
		return l;
	}
	
	public List<BookVO> mockVOList() {
		List<BookVO> l = new ArrayList<>();
		for (int i = 0; i<= 14; i++) {
			l.add(mockVO(i));
		}
		return l;
	}	
	
}
