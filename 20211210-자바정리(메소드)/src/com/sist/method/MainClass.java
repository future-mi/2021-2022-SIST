package com.sist.method;
/*
 * 자바구조
 * package → 한번만 사용이 가능
 * import → 라이브러릴 읽기(여러개)
 * 
 * public class ClassName
 * {
 * ==================================================================
 * 		멤버변수 → 클래스에서 사용되는 변수
 * 		  (1) 인스턴스변수(개별변수) → new사용시마다 따로 저장  ex)사람이름
 * 		  (2) 정적변수(static) → 범위(공유변수)			 ex)학교명
 * 
 * 		→ 생성시기
 * 			(1) 인스턴스 → new, delete(자바 → 가비지컬렉션 : 자동회수)
 * 				       → 바로 메모리에서 해제(System.gc())   ex)멀티미디어(동영상)
 * 			(2) static → 클래스가 JVM에서 로딩(읽어 온 경우에)
 * 
 * 		[접근범위]
 * 		 ====================================================
 *  	  자신의 클래스  |  같은 패키지에  |  상속이 있는 경우  | 모든 클래스
 *  	 				있는 클래스     다른 패키지에 있는 
 *  									  클래스
 * 		 ====================================================
 * private	   O
 * 		 ====================================================
 * default     O			O
 * 		 ====================================================
 * protected   O			O				O
 * 		 ====================================================
 * public      O			O				O			O
 * 
 * 			private : 은닉화(다른 클래스에서 접근 금지) → 캡슐화
 * 						- 변수
 *			public : 공개(모든 곳에서 사용이 가능)
 * 						- 메소드,클래스,생성자
 * 			소스코딩 → 캡슐화(getter/setter)
 * 					변수 → 기능(getter - 읽기/ setter - 쓰기)
 * 

 * 
 * ================================================== 활용
 * 	검색, 저장, 수정, 삭제 → 기능(메소드) → 필요시마다 재사용
 *  - 기능을 새롭게 추가 : 오버로딩(메소드 추가)
 *  - 기존의 기능 변경 : 오버라이딩(메소드 재정의)
 *  
 *  	[메소드 제작(변수/연산자/제어문)]
 * 		1. 구성요소
 * 		    메소드 : 선언부  /  구현부
 * 		  - 선언부 : 리턴형 → 사용자 요청시에 요청 처리에 대한 결과값
 * 							한개만 리턴(일반 데이터형), 여러개인경우 묶어서 전송(배열,클래스) 
 * 				   매개변수 → 요청자가 요청한 값
 * 					웹 → 사용자가 입력 → 메소드의 매개변수로 들어온다
 * 
 * 		2. 메소드 형식
 * 			접근지정어(public) 리턴형(결과값) 메소드명(매개변수...) 선언부
 * 							→ 결과값이 없는 경우(void)
 * 							→ 처리가 메소드 안에서 이루어짐 
 * 		{
 * 				구현부	
 * 		}
 * 		메소드는 {} 구현 → 메모리 저장이 가능
 * 		메소드가 선언만 되어 있으면 → 메모리에 저장 불가능
 * 							  미완성 클래스 (추상,인터페이스)
 * 
 *  	=================================
 *  			리턴형 		매개변수
 *  	=================================
 *  			 O			  O 
 *  	=================================
 *  			 O			  X
 *  			SELECT
 *  	=================================
 *  			 X(void)	  O 
 *  			 → INSERT / UPDATE / DELETE
 *  	=================================
 *  			 X(void)	  X    → 극히 드물다
 *  	==================================
 *  
 *  		네트워크(게임,실시간채팅) → 쓰레드 
 *  		데이터베이스(웹)		  → 메소드 이용
 *  
 * =========================
 * 		1. 멤버변수 → 초기값
 * 			- 명시적인 초기화 : String id="admin"
 * 			- 외부에서 데이터읽기(파일,오라클) 
 * 				→ class영역에서는 사용이 불가능(구현 → {} )
 * 					생성자 : 멤버변수의 초기화
 * 							클래스 동일
 * 							리턴형이 없다
 * 							오버로딩을 지원
 * 							서버연결 / 오라클 드라이버 설정 
 * 			- 초기화블록
 * 				class A
 * 				{
 * 					선언
 * 					{
 * 						구현 → 인스턴스 블록
 * 					}
 * 					static
 * 					{
 * 						정적블록
 * 					}
 *  			}
 * =========================
 * }
 * 
 * 	***
 *  함수 VS 메소드
 *  함수 : 독립적으로 수행
 *  메소드 : 클래스안에서 작업
 * 
 * 	객체지향프로그램 → 모아서 처리(관련된 기능만 처리) → 재사용
 * 	메소드 → 한가지 기능만 수행이 가능하게 만듦
 * 
 * 	모든 클래스의 메소드 제작
 *  1. 입력
 *  2. 처리 → 세부화(여러개)
 *  3. 출력
 *  4. 조립
 * 
 * 		JVM(자바 가상머신)
 * ================================
 * 	메소드(static)
 * ================================
 *  지역변수(매개변수,메소드안의 변수) → 스택
 *  → 메모리에 의해서 자동으로 관리
 * ================================
 *  멤버변수 → 힙(가비지컬렉션)
 *  → 사용자에 의해서 처리가 되는 영역
 *  (프로그램 종료시까지 사용가능)
 * ================================
 * 
 * 
 * 
 * 	======달력 → 공통적으로 사용하는 데이터(멤버변수)			→ heap에 저장
 * 				메소드 안에서만 사용하는 변수(지역변수)
 * 				지역변수 : 블록변수(블록이 종료되면 사라지는 변수) → stack에 저장
 * 
 * 	1. 입력 - 년도 / 월  → year, month
 *  2. 1일자의 요일      → year, month, lastdat, week
 *  3. 화면에 출력		  → year, month, lastday, week
 *  4. 조립
 * 
 */

import java.util.*; // Scanner → IO(BufferedReader)
// IO → System.in(키보드 입력값을 읽을 경우에), System.out(화면출력)

class MyDate
{
	// 데이터 변질 → 은닉화(MyDate에서 사용하는 변수)
	private int year,month,week;
	private int[] lastday={31,28,31,30,31,30,
						  31,31,30,31,30,31};  // 각달의 마지막 날짜
	
	// 사용자 입력
	// 메소드 → 구조화(단락), 반복제거, 한가지 기능을 수행
	public int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println(msg+" 입력:");
		return scan.nextInt();
	}
	// 1일자의 요일을 생성
	public int getWeek()
	{
		int week=0;
		// 1. 전년도 까지의 총 날수(1년도1월1일 → 월요일) %7
		int total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400; //윤년 계산법
		// 2. 전달까지의 총 날수
		if((year%4==0 && year%100!=0 || year%400==0))  // 윤년이라면
			lastday[1]=29;
		else
			lastday[1]=28;
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
		}
		
		// 3. +1
		total++;
		// ======요청한 날짜의 1일자의 요일 확인 가능
		week=total%7;
		return week;
	}
	// 사용자가 요청한 달력을 보여준다
	public void datePrint()
	{
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek)
		{
			System.out.print(s+"\t");
		}
		System.out.println("\n");
		for(int i=1;i<=lastday[month-1];i++)
		{
			if(i==1)		// 첫줄에 공백
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i); 		// 달력출력
			week++;
			if(week>6)		// 토요일이면
			{
				week=0;		// 일요일로 변경
				System.out.println();		// 다음줄에 출력
			}
		}
	}
	// 조립 → 기능없이 합쳐준다
	public void process() // 조립 후 출력 → 결과값이 없다(void)
	{
		// 사용자 요청값 받기
		year=input("년도");
		month=input("월"); 	// lastday[month-1] → lastday[-1]
		week=getWeek();
		datePrint();
		System.out.println(year+"년도 "+month+"월");
	}
	
	
}

public class MainClass {
	
	public static void main(String[] args) {
		// 1. 메모리 할당
		MyDate md=new MyDate();
		md.process();
		
		
	}
	
	
}
