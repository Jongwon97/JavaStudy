package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {

		// 도서 객체 등록, 삭제, 조회를 테스트할 코드작성
		BookManager BM=new BookManager();  // 북 매니저 객체 생성
		
		// 도서 객체 등록
		Book Bk1=new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본문법");
		BM.add(Bk1);
		Book Bk2=new Book("21425","Java Pro2","김하나","jaen.kr",25000,"Java 응용");
		BM.add(Bk2);
		Book Bk3=new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		BM.add(Bk3);
		Book Bk4=new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",2021,1);    // 다형성
		BM.add(Bk4);
		
		// 도서 리스트 반환
		Book[] book=BM.books;

		// 도서 리스트 출력	
		System.out.println("***********************도서 전체 목록***********************");
		for(int i=0;i<BM.size;i++) {
			System.out.println(book[i].toString());
		}
		
		// 일반 도서 목록 출력
		System.out.println("***********************일반 도서 목록***********************");
		Book[] general_books=BM.getBooks();
		for(int i=0;i<general_books.length;i++) {
			System.out.println(general_books[i].toString());
		}
		
		// 잡지 목록 출력
		System.out.println("***********************잡지 목록***********************");
		Book[] magazine_list=BM.getMegazines();
		for(int i=0;i<magazine_list.length;i++) {
			System.out.println(magazine_list[i].toString());
		}
		
		// 도서 제목 포함 검색
		System.out.println("***********************도서 제목 포함검색: Java***********************");
		Book[] book_searchByTitle=BM.serchByTitle("Java");  // 고유번호로 도서정보 반환
		for(int i=0;i<book_searchByTitle.length;i++) {
			System.out.println(book_searchByTitle[i].toString());
		}
		
		// 도서 가격 총합
		System.out.println("도서 가격 총합: "+BM.getTotalPrice());
		// 도서 가격 평균
		System.out.println("도서 가격 평균: "+BM.getPriceAvg());

	}

}