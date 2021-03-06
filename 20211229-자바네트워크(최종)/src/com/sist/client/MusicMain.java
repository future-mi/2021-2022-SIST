package com.sist.client;
// 윈도우 → HTML 
import java.awt.*;
import javax.swing.*;

import com.sist.common.Function;
import java.awt.event.*;
//
import java.io.*;
import java.net.*;
import java.util.*;
public class MusicMain extends JFrame implements Runnable,ActionListener{
	CardLayout card=new CardLayout();
	Login login=new Login();
	MusicView mv=new MusicView();
	Socket s; 	
   
	OutputStream out;
	BufferedReader in;
	public MusicMain()
	{
		setLayout(card);	// BorderLayer 변경
		// 화면 → 모아둔다 
		/*
		 * login → 서버연결
		 * music → 음악목록, 음악찾기
		 */
		add("LOGIN",login);
		add("MV",mv);
		
		// 크기결정
		setSize(800,640);
		// 윈도우를 보여달라
		setVisible(true);
		// 종료버튼 클릭시 윈도우 해제
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 버튼 클릭시 → 등록해야 자동 호출
		login.b1.addActionListener(this);	//로그인
		login.b2.addActionListener(this);	//취소
		mv.b1.addActionListener(this);		//검색
		mv.b2.addActionListener(this);		//목록
	}
	public static void main(String[] args) {
		// 생성자만 호출
		new MusicMain();
	}
	// 버튼 클릭시 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// 사용자요청
		if(e.getSource()==login.b1)
		{
			// 서버와 연결
			// ID읽기 → 강제로 입력 → 웹(유효성 검사)
			String id=login.tf1.getText();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력");
				login.tf1.requestFocus();
				return;
			}
			// 이름읽기
			String name=login.tf2.getText();
			if(name.length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름를 입력");
				login.tf2.requestFocus();
				return;
			}
			// 서버와 연결
			try {
				s=new Socket("localhost",3355);
				// Socket("서버주소(IP)",서버에서 설정된 PORT)
				// 송수신 위치 확인 
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				/*
				 *   클라이언트: Socket(서버정보) → 서버 IP
				 *   서버 : Socket(클라이언트 정보) → 클라이언트 IP
				 */
				//로그인요청
				out.write((Function.LOGIN+"|"+id+"|"+name+"\n").getBytes());
			} catch (Exception ex) {}
			// ID,이름 → Login을 요청
			// 서버에서 들어오는 데이터를 받아서 출력한다
			new Thread(this).start();
		}
		else if(e.getSource()==login.b2)
		{
			// 취소 → 프로그램종료
			System.exit(0); // 0 → 정상종료
		}	
		else if(e.getSource()==mv.b1)
		{
			// 검색어 읽어서 검색된 내용을찾아달라 요청
			String ss=mv.tf.getText(); // 입력한 문자를 읽어 온다
			if(ss.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어 입력");
				mv.tf.requestFocus();
				return;
			}
			// 서버로 전송
			 try {
				out.write((Function.FIND+"|"+ss+"\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 mv.tf.setText("");
		}
		else if(e.getSource()==mv.b2)
		{
			// 전체목록요청
			try {
				out.write((Function.LIST+"|\n").getBytes());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// 서버에서 보내준 데이터 출력
	@Override
	public void run() {
		try {
			while(true)
			{
				// 서버로부터 데이터 받기
				String msg=in.readLine();
				System.out.println("Server →"+msg);
				// 구분
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
					case Function.MYLOG:
					{
						card.show(getContentPane(), "MV");
						setTitle(st.nextToken());
					}
					break;
					case Function.LIST:
					{
						// 테이블내용을 지우고 다시 채운다
						for(int i=mv.model.getRowCount()-1;i>=0;i--)
						{
							mv.model.removeRow(i);
							
						}
						String data=st.nextToken();
						String[] music=data.split("\\^");
						for(String m:music)
						{
							String[] mdata=m.split("\\%");
							mv.model.addRow(mdata);
						}
					}
					break;
					case Function.FIND:
					{
						for(int i=mv.model.getRowCount()-1;i>=0;i--)
						{
							mv.model.removeRow(i);
							
						}
						String data=st.nextToken();
						String[] music=data.split("\\^");
						for(String m:music)
						{
							String[] mdata=m.split("\\%");
							mv.model.addRow(mdata);
						}
					}
					break;
				}
			}
		} catch (Exception ex) {}
	}
}
