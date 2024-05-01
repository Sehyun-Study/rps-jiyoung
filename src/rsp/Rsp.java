package rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

	String str[] = {"가위", "바위", "보"};
	int win, lose;
	int usrInput;
	int random;
	int playCnt;
	
	public void setCount(int count) {
		this.playCnt = count;
	}
	
	public void init() {
		//컴퓨터 랜덤 생성
		Random r = new Random();
		random = r.nextInt(3)+1;
		
		//초기화 및 사용자 입력
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("숫자로 입력해주세요 1.가위, 2.바위, 3.보: ");
			if(scan.hasNextInt()) {
				usrInput = scan.nextInt();
				if(usrInput <=0  || usrInput > 3) {
					System.out.println("숫자를 다시 입력해주세요: ");
					continue;
				} else {
					System.out.println("입력한 값은: " + str[usrInput-1]);
					break;
				}
			} else {
				System.out.println("숫자형식이 아닙니다.");
				scan.next();
			}
		}
	}
	
	public void play() {
		for (int i = 0; i < playCnt; i++) {
			init();
			if ((usrInput==1 && random==2) || (usrInput==2 && random==3) || (usrInput==3 && random==1)) {
				win++;
				System.out.println("이김");
			} else if (usrInput == random) {
				System.out.println("비김");
			} else {
				System.out.println("짐");
				lose++;
			}
		}
		print(win, lose);
	}
	
	public void print(int win, int lose) {
		//출력
		System.out.println(win + "번 이겼습니다.");
		System.out.println(lose + "번 졌습니다.");
		System.out.println("종료");
	}
}