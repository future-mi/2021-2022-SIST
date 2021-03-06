package com.sist.lib;
/*
 *  replace(char c1,char c2) 			→ c1을 c2로 바꿔라
 *  replace(String s1,String s2) 		→ s1을 s2로 바꿔라
 *  replaceAll(String regex,String s) 	→ regex를 s로 바꾸는데 정규식 사용
 *  
 *  [문자의 형식]
 *  211.238.142.181
 *  127.0.0.1
 *  211.63.64.10
 *  211.238.142.1
 *  → [0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3} → 이런식으로 형식 regex
 *  
 *  맛있는 맛있고 맛있게 맛있고.....
 *  → 맛있+ (+는 뒤에 한글자있다는 뜻?)
 */
public class MainClass6 {
	public static void main(String[] args) {
		String s="Hello Java!!";
		String s1=s.replace('a', 'b');
		System.out.println(s1);		// Hello Jbvb!!
		String s2=s.replace("ll", "LL");
		System.out.println(s2);		// HeLLo Java!!
		
		String data="AAABBBcccddd1234567890 안녕하세요 자바입니다";
		String ss=data.replaceAll("[A-Za-z0-9]", "");
		System.out.println("ss= "+ss);
		String ss1=data.replaceAll("[^A-Z]", "");
		System.out.println("ss1= "+ss1);
		
		//[A-Z] → 알파벳 대문자 전체
		// [^A-Z] → 대문자를 제외하고
		String ss2=data.replaceAll("[^a-z]", "");
		// 소문자 → a-z
		System.out.println(ss2);
		String ss3=data.replaceAll("[^0-9]", "");
		// 숫자 → 0-9
		System.out.println(ss3);
		String ss4=data.replaceAll("[^가-힣]", "");
		// 한글 → 가-힣
		// ^부정(제외하고)
		// [^]부정
		// ^[가-힣] → 한글로 시작한 모든 문자
		// [0-9]$ → 숫자로 끝나는 모든 것
		// ^[가|나] → 가 or 나로 시작하는 모든 문자열
		// * → 0번이상
		// + → 1번이상
		// ^,$,|,+,* → 사용되는 기호 / *, + → 실제문자를 찾을 때는 \\+ 이런식으로 입력해야함
		System.out.println(ss4);		
	}
}
