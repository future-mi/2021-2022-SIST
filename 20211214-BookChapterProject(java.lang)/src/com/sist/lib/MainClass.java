package com.sist.lib;
/*
 * 	자바를 잘 하려면
 * 	1. 문법 (1~8장 : 변수, 배열, 클래스, 연산자, 제어문, 메소드)
 * 	2. 용도 
 * 		- 클래스(인터페이스,메소드(리턴형,매개변수)
 * 			→ 예외처리(try~catch, throws)
 * 		- 메소드
 * 		- 변수(인스턴스,static)
 * 		
 * 	3. 조립하는 방법(사용자 정의 클래스+라이브러리)
 * 	4. 순서(알고리즘)
 * 		- 소스를 암기 → 순서
 * 		- 자바에서 가장 쉬운 프로그램(네트워크/데이터베이스) → 모든 개발자가 동일하게 코딩
 * 		- 구구단(2차 for) / 페이지(1차 for)
 * 		- 반복 / 위치확인 / CV → 분석
 * ==================================================================
 * 	java.lang  java.util java.io  java.net  java.sql  java.text
 * 	java.xml	org.w3c.dom		org.w3c.sax		javax.http(JSP)
 * 
 * 	1.java.lang : import를 생략 할 수 있다
 * 		1)Object : 모든 클래스(사용자정의,라이브러리)의 상속을 내리는 클래스
 * 			Class A(extends Object) 생략이 된다
 * 			- toString(객체를 문자열화)
 * 			- finalize() : 소멸자 메소드(객체가 메모리에서 해제, 자동호출되는 메소드)
 * 			- clone() : 복제 → 스프링(prototype)
 * 		2)String / StringBuffer /StringBuilder
 * 			라이브러리 : 원형, 용도를 기억하고 사용하기
 * 			(1) String(문자열을 제어하는 메소드)
 *	 			- length() : 문자갯수 →  ...
 *							 → 원형 : public int length()
 *				- equals() : 문자열 비교(==은 사용하지 않음) / 로그인, id중복체크시 사용 / 대소문자 구분
 *							 → 원형 : public boolean equals(String s)
 *				- equalsIngnoreCase() : 문자열 비교 / 대소문자 구분없음 / 검색할 때 사용
 *							 → 원형 : public boolean equalsIngnoreCase(String s)
 * 				- substring() : 원하는 부분만 문자열을 자르는 역할
 * 							 → 원형 : public String substring(int start)
 * 									 public String substring(int start,int end)
 *  			- trim() : 좌우 공백을 제거할 때 사용
 *  						→ 사용자가 실수로 space를 사용했을 때 왼쪽에 공백이 생겨서 찾기가 힘들 때 사용
 *  						→ 원형 : public String trim() → 공백문자 제거 후 다시 리턴
 *				- indexOf : 문자를 찾기(앞에서부터)
 *							→ 원형 : public int indexOf(String s)
 *									public int indexOF(char c) 
 *				- lastIndexOf : 문자를 찾기(뒤에서부터)
 *								→ 원형 : public int lastIndeOf(Sting s)
 *										public int lastIndexOf(char c)
 *				- split() : 문자열을 분리
 *							→ 원형 : public String[] split(String regex)
 *				- replace() : 문자 한 개를 변경
 *							→ 원형 : public String replace(char c1,char c2)
 *									public String replace(String s1,String s2)
 *				- replaceAll() : 문자 전체를 변경(정규식을 사용)
 *								→ 원형 : public String replaceAll(String s1,String s2)
 *										한글 [가-힣]
 *										영문 [A-Zz-z]
 *										숫자 [0-9]
 *				- charAt() : 문자열 중에 문자 한개를 자르는 경우
 *							→ 원형 : public char charAt(int index)
 * =============================================================
 *				- startsWith : 시작문자열이 바뀔 때 
 *								→ 원형 : public boolean statWith(String s)
 *				- endsWith : 끝나는 문자열이 바뀔 때 
 *							→ 원형 : public boolean endsWith(Sting s)
 *					→ 자동완성기(서제스트) → 검색기를 만들때 사용, Cookie구분
 * =============================================================
 * 				- toUpperCase : 대문자 변환
 * 								→ 원형 : public String toUpperCase()
 * 				- toLowerCase : 소문자 변환
 * 								→ 원형 : public String toLowerCase()
 * 				- valueOf() : 모든 데이터형을 문자열로 변환
 * 							→ 원형 : public static String valueOf(int a)
 * 									public static String valueOf(boolean a)
 * 									public static String valueOf(char a) ..... 등
 * 
 * 		3)Math
 * 			- ceil : 올림
 * 			- ramdom : 난수
 * 		4)Wrapper : 모든 데이터형을 클래스화
 * 			- byte → Byte
 * 			- short → Short
 * 			- int → Integer
 * 			- double → Double
 * 			- float → Float
 * 			- boolean → Boolean
 * 		5)System
 *			- System.in
 *			- System.out
 *			- System.gc() → 멀티미디어, 화상 등을 사용할 때 / 자동으로 메모리 회수 
 */
class Sawon
{
	private String name;
	public Sawon(String name)
	{
		//생성자 → 변수의 초기화
		System.out.println("Sawon 객체 메모리에 저장");
		this.name=name;
	}
	// 출력
	public void print()
	{
		// 객체 기능 활용
		System.out.println("이름:"+name);
	}
	
	// 메모리에 해제
	// 객체의 메모리에서 사라질 때 자동호출 되는 메소드(소멸자)
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("Sawon 객체 메모리 해제");
	}
	
	@Override
	public String toString() {
		return "Sawon이 가지고있는 이름은 "+name+"입니다";
	}
	// Object에서의 재정의(오버라이딩) → toString
}

public class MainClass {
	public static void main(String[] args) {
		// 사원 기능 사용
		// 1. 메모리 저장
		Sawon s=new Sawon("홍길동");
		System.out.println(s.toString());
		// 2. 활용
		s.print();
		// 3. 메모리 해제 s=null(GC)
		s=null; // 더 이상 사용하지 않는다 
		// 4. 직접해제
		System.gc(); // 가비지컬렉션 호출(메모리에서 사용하지 않거나, null일떄 회수)
		// finalize()가 호출되면 메모리에서 제거
	
	}
	
}
