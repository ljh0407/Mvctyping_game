package Typing_game.View;


import java.util.ArrayList;
import java.util.Scanner;

import Typing_game.Controller.Control;
import Typing_game.DTO.QuizDTO;
import Typing_game.DTO.RangkingDTO;
import Typing_game.Controller.GControl;
import Typing_game.DTO.SginupDTO;

public class Mainpage {
	Scanner scanner = new Scanner(System.in);
	Control control = new Control();
	private static Mainpage mainp = new Mainpage();
	private Mainpage() {}
	private Mainpage getInstance() {return mainp;}

	public static void main(String[] args) {
		
		Mainpage view = new Mainpage();
		view.메인페이지();
	}
	
	public void 메인페이지() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.로그아웃");
			int ch = scanner.nextInt();
			if( ch== 1 ) {회원가입();}
			if( ch== 2 ) {로그인();}
			if( ch== 3 ) {}
		}
	}
	
	public void 회원가입() {
		System.out.println("아이디 : "); String mid= scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("이름 : ");	String mname = scanner.next();
		System.out.println("닉네임 : "); String mnn = scanner.next();
		
		SginupDTO Dto = new SginupDTO(0, mid, pw, mname, mnn);
		
		boolean result = GControl.getInstance().회원가입(Dto);
		if(result) {System.out.println("회원가입 성공");}
		else {System.out.println("회원가입 실패");}
		
	}
	
	public void 로그인() {
		System.out.print("아이디 : "); String mid = scanner.next();
		System.out.print("비밀번호 :"); String pw = scanner.next();
		
		boolean result =GControl.getInstance().로그인(mid,pw);
		if(result) {System.out.println("로그인성공");}
		else {System.out.println("로그인실패");}
		
		
	}

	
	
	void mainpage() {
		while (true) {
			System.out.println("==============타자게임=============");
			System.out.println("1.회원가입\t2.게임하기3.랭킹순위");
			int ch = scanner.nextInt();
			
			if( ch == 1) {}
			else if ( ch == 2 ) {quiz();}
			else if ( ch == 3 ) {Rangking();}
			
		}
		
	}
	
	
	// 1. 회원가입
	
	
	
	
	
	// 2. 퀴즈출력
	void quiz() {
		System.out.println("화면에 나오는 글자를 똑같이 치세요.");
		
		ArrayList<QuizDTO> list = control.read();
			System.out.println("번호\t문제");
			int score = 0;
			for( QuizDTO qdto : list) {
				System.out.println(qdto.getQno());
				System.out.println(qdto.getQmsg());
				String input = scanner.next();//행동
				if(qdto.getQmsg().equals(input) ) {
					score++;
					System.out.println("정답."+score);
					
				}else {System.out.println("오답"+score);}
			
				
				
				/*
				 * if(score += 1) { System.out.println("정답입니다."+score+"점수 : "); score++; }else
				 * {System.out.println("틀렸습니다.");}
				 */
			}// for end	
			
			System.out.println("문제 끝" + score+"점" );
				
	} // 퀴즈출력 end
			
			
			
				
				
				
		
	//랭킹순위
	
	void Rangking() {
		
		System.out.println("순위\t점수 : "); int mno = scanner.nextInt();
		System.out.println( mno  );	int ss = scanner.nextInt();
		
		
	} // Rangking end
	
	}
	
	
	

