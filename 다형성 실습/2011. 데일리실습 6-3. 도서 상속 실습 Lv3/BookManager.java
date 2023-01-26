package com.ssafy.ws.step3;

class BookManager {

	final int MAX_SIZE=100;
	Book[] books=new Book[MAX_SIZE];
	int size=0;     // 객체의 개수를 나타내는 변수
	
	// 도서정보 등록하는 add 메소드
	void add(Book book) {
		// 배열에 얼만큼 들어있는지 탐색
		books[size]=book;
		size++;
	}
	
	// 고유번호로 도서정보 삭제하는 remove 메소드
	void remove(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i]=null;    // 책 삭제
				// 뒤에 있는 책들 앞으로 옮기기
				for(int j=i;j<size-1;j++) {
					books[j]=books[j+1];
				}
				break;
			}
		}
		size--;
	}
	
	// 도서 리스트를 반환하는 메소드
	Book[] getList() {
		return this.books;
	}
	
	// 고유번호로 도서정보 반환하는 메소드
	Book searchByIsbn(String isbn) {
		Book temp = null;
		for(int i=0;i<size;i++) {
			// contains()는 특정 문자열이 존재하면 true 없으면 false를 반환하는 메소드
			if(books[i].getIsbn().equals(isbn)) {
				temp=books[i];
				break;
			}
		}
		return temp;
	}
	
	// 4. 도서 제목을 포함검색
	Book[] serchByTitle(String title) {
		// 도서 제목을 포함하는 책이 몇개있는지 계산
		int book_num=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title)) {  // contains 메소드는 해당 문자열이 포함되어 있을 경우 true를 반환하는 메소드
				book_num++;
			}
		}
		// 위에서 계산한 개수 크기의 배열 생성
		Book[] temp=new Book[book_num];
		int num=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title)) {
				temp[num]=books[i];
				num++;
			}
		}
		return temp;
	}
	
	// 5. 잡지가 아닌 일반도서 리스트를 반환하는 메소드
	Book[] getBooks() {
		int book_num=0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				book_num++;
			}
		}
		Book[] general_books=new Book[book_num];
		int num=0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				general_books[num]=books[i];
				num++;
			}
		}
		return general_books;
	}
	
	// 6. 잡지리스트를 반환하는 메소드
	Magazine[] getMegazines() {
		int book_num=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) { 		// instanceof는 객체 타입이 클래스와 일치할 경우 true 반환, 객체 instanceof 클래스 형태
				book_num++;
			}
		}
		Magazine[] megazine_list=new Magazine[book_num];
		int num=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				megazine_list[num]= (Magazine) books[i];   // 명시적 형 변환
				num++;
			}
		}
		return megazine_list;
	}
	
	// 7. 도서리스트의 가격의 총합을 반환하는 메소드
	int getTotalPrice() {
		int sum=0;
		for(int i=0;i<size;i++) {
			sum+=books[i].getPrice();
		}
		return sum;
	}
	
	// 8. 도서가격의 평균을 반환하는 메소드
	double getPriceAvg() {
		double avg=0.0;
		int sum=0;
		for(int i=0;i<size;i++) {
			sum+=books[i].getPrice();
		}
		avg=(double)sum/size;
		return avg;
	}
}