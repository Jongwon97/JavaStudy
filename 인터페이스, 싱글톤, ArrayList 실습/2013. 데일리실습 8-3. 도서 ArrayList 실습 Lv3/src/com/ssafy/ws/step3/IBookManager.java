package com.ssafy.ws.step3;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	public abstract void add(Book book);
	public abstract void remove(String isbn);
	public abstract Book[] getList();
	public abstract Book searchByIsbn(String isbn);
	public abstract Book[] searchByTitle(String title);
	public abstract Magazine[] getMagazines();
	public abstract Book[] getBooks();
	public abstract int getTotalPrice();
	public abstract double getPriceAvg();	
}