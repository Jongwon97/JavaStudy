package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl2 implements IBookManager {
	
	private static Map<Integer,Book> books=new HashMap<Integer,Book>();	
	private static BookManagerImpl2 instance=new BookManagerImpl2(); 	// 싱글톤 객체 생성
	private BookManagerImpl2() {}  // private 생성자 -> 객체를 생성하지 못하게 함
	private static int num=0;
	
	public static IBookManager getInstance(){
		return instance;
	}
	// 1.도서정보 등록하는 add 메소드
	public void add(Book book) {
		books.put(num,book);
		num++;
	}
	// 2.고유번호로 도서정보 삭제하는 remove 메소드
	public void remove(String isbn) {
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getIsbn().equals(isbn)){
				// 맨 뒤에있는 것을 삭제한 자리로 옮김
				books.remove(i);
				books.put(i, books.get(num-1));
				books.remove(num-1);
				System.out.println("***********************"+isbn+" 삭제 완료!"+"***********************");
				num--;
				break;
			}
		}
	}
	// 3.도서 리스트를 반환하는 메소드
	public Book[] getList() {
		Book[] book=new Book[books.size()];

		for(int i=0;i<books.size();i++) {
			book[i]=books.get(i);
		}
		return book;
	}
	// 4.고유번호로 도서정보 반환하는 메소드
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getIsbn().equals(isbn)){
				return books.get(i);
			}
		}
		System.out.println("해당 고유번호의 책이 없습니다!");
		return null;
	}
	// 5. 도서 제목을 포함검색
	public Book[] searchByTitle(String title) {
		// 도서 제목을 포함하는 책이 몇개있는지 계산
		ArrayList<Book> temp=new ArrayList<Book>();
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getTitle().contains(title)) {  // contains 메소드는 해당 문자열이 포함되어 있을 경우 true를 반환하는 메소드
				temp.add(books.get(i));
			}
		}
		Book[] bo=new Book[temp.size()];
		for(int i=0;i<temp.size();i++) {
			bo[i]=temp.get(i);
		}
		return bo;

	}
	// 6. 잡지리스트를 반환하는 메소드
	public Magazine[] getMagazines() {
		ArrayList<Magazine> ml=new ArrayList<Magazine>();
		for(int i=0;i<books.size();i++) {
			if(books.get(i) instanceof Magazine) {
				ml.add((Magazine) books.get(i)); 	// 명시적 형 변환
			}
		}
		Magazine[] mz_list=new Magazine[ml.size()];
		for(int i=0;i<ml.size();i++) {
			mz_list[i]=ml.get(i);
		}
		return mz_list;
	}
	// 7. 잡지가 아닌 일반도서 리스트를 반환하는 메소드
	public Book[] getBooks() {
		ArrayList<Book> bo=new ArrayList<Book>();
		for(int i=0;i<books.size();i++) {
			if(!(books.get(i) instanceof Magazine)) {
				bo.add(books.get(i));
			}
		}
		Book[] bk_list=new Book[bo.size()];
		for(int i=0;i<bo.size();i++) {
			bk_list[i]=bo.get(i);
		}
		return bk_list;
	}
	// 8. 도서리스트의 가격의 총합을 반환하는 메소드
	public int getTotalPrice() {
		int sum=0;
		for(int i=0;i<books.size();i++) {
			sum+=books.get(i).getPrice();
		}
		return sum;
	}
	// 9. 도서가격의 평균을 반환하는 메소드
	public double getPriceAvg() {
		double avg=0.0;
		int sum=0;
		for(int i=0;i<books.size();i++) {
			sum+=books.get(i).getPrice();
		}
		avg=(double)sum/books.size();
		return avg;
	}
}
