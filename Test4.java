package Test;

public class Test4 {

	public static void main(String[] args) {
		int[][] scores = {
			{80,60,70},{90,95,80},{75,80,100},{80,70,95},{100,65,80}
		};
		System.out.println("학생번호"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
		System.out.println("============================================");				
		for(int i=0;i<scores.length;i++) {
			int sum=0;
			System.out.print((i+1)+"번 학생:"+"\t");				
			for(int j=0;j<scores[i].length;j++) {
				sum += scores[i][j];
				System.out.print(scores[i][j]+"\t");				
				if(j == 2) {
					System.out.println(sum+"\t"+(double)Math.round(sum/3));			
				}
			}
		}
	}
}