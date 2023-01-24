package com.ssafy.ws.step3;

class Magazine extends Book {
	private int year;
	private int month;
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc,int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	// 다형성을 이용하여 해당 메소드가 실행되게함
	@Override
	public String toString() {
		return super.getIsbn()+"	| "+super.getTitle()+"	| "+super.getAuthor()+"	| "+super.getPublisher()+"	| "+super.getPrice()+"	| "+super.getDesc()+"	| "+year+"	| "+month;
	}
	
}