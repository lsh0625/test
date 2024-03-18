package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhonManager extends Phone{

	public PhonManager(String name, String tel, String add) {
		super(name, tel, add);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {		
		//Phone phone=new Phone(getName(), getTel(), getAdd());
		Scanner scanner = new Scanner(System.in);
		System.out.println("인원수 >>");

		int num=scanner.nextInt();
		scanner.nextLine();
		Map<String, String> phonBook = new HashMap<>();
		for(int i=0;i<num;i++){
			System.out.println("이름과 전화번호(번호는 연속적으로 입력), 주소 >>");
			String s=scanner.nextLine();
			String[] str = s.split(" ");
			if(str.length >= 3) {
				String name = str[0];
				String tel = str[1];
				String add = str[2];
				phonBook.put(name, "의 번호와 주소는 "+tel+", "+add+" 입니다.");
		 	}
		}
			System.out.println("저장되었습니다...");
			while(true) {
				System.out.println("검색할 이름 >>");
				String search = scanner.nextLine();
			if(search.equals("exit")) {
				System.out.println("프로그램을 종료합니다...");
				scanner.close();
				break;
			}else if(phonBook.containsKey(search)) {	
				System.out.println(search+phonBook.get(search));
			}else {
				System.out.println(search+"은(는) 없습니다.");
			}
		}
	}
}
class Phone {
    private String name;
    private String tel;
    private String add;
    
    public Phone(String name, String tel, String add) {
        this.name = name;
        this.tel = tel;
        this.add = add;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTel() {
        return tel;
    }
    
    public String getAdd() {
        return add;
    }
}