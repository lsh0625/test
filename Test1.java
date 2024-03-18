package Test;

import java.util.Random;
import java.util.Scanner;

public class Test1{

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int random=(int)(Math.random()*100+1);
		int i=1;
		System.out.println("=== 숫자맞추기 게임을 시작합니다. ===" );
		System.out.println("컴퓨터가 숫자를 생각했습니다." );
		if(random % 2 == 0){
			System.out.println("힌트는 짝수입니다." );
		}else{
			System.out.println("힌트는 홀수입니다." );
		}		 
		while(true){
			System.out.println("1~100 사이의 값을 입력 >>" );
			try {
			int number=scanner.nextInt();
			if(number < 1 || number > 100) {
				throw new IllegalArgumentException("1부터 100 사이의 값을 입력해야 합니다.");
			}
			if(number > random){
				System.out.println("더 작은 수입니다." );
				i++;
			}else if(number < random){
				System.out.println("더 큰 수입니다." );
				i++;
			}else{
				System.out.println(i+"회 만에 맞췄습니다.");
				System.out.println("=== 게임을 종료합니다. ===");
				break;
			}	
		}catch(NumberFormatException e) {
			 System.out.println("숫자를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
	}
		scanner.close();
	}
}