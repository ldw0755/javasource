package shopping;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.java.util.jar.pack.Instruction.Switch;

public class MyShop implements IShop {
	
	//쇼핑몰 이름.
	private String title; 
	//등록 상품
//	CellPhone[] = new Cell[5] // X
	Product[] products = new Product[10];
	//장바구니
	ArrayList<Product> carts = new ArrayList<Product>();
	//사용자
	User user[] = new User[2]; //null로 최기화 되어있음.
	//키보드 입력 처리.
	Scanner scan = new Scanner(System.in);
	
	int selUser; //
	
	
	@Override
	public void setTitle(String title) {
		this.title = title;		
	}

	@Override
	public void genUser() {
		//쇼핑몰 사용자 생성. 후 배열에 담기
		//user 객체 이용.
//		User user1[] = new User ("서수성", PayType.CARD);
//		User user2[] = new User ("서금성", PayType.CASH);
//		user[0] = user1;
//		user[1] = user2;

		user[0] = new User ("서수성", PayType.CARD);
		user[1] = new User ("서금성", PayType.CASH);
	}

	@Override
	public void genProduct() {
		//쇼핑몰에서 판매하는 제품 생성.
		//CellPhone, SmartTV
		products[0] = new SmartTV("삼성 SmartTV", 100000, "4k");
		products[1] = new SmartTV("엘지 SmartTV", 100000, "hd");
		products[2] = new SmartTV("삼성 SmartTV", 150000, "pullhd");
		products[3] = new SmartTV("샤오미 SmartTV", 100000, "4k");
		products[4] = new SmartTV("미지아 SmartTV", 100000, "4k");
		products[5] = new CelPhone("IPhone 6", 200000, "lte");
		products[6] = new CelPhone("IPhone 7", 200000, "5g");
		products[7] = new CelPhone("IPhone 8", 200000, "4g");
		products[8] = new CelPhone("IPhone 9", 200000, "lte");
		products[9] = new CelPhone("IPhone10", 200000, "3g");
		
		
	}

	@Override
	public void start() { //시작하는 메소드.
		System.out.println(title + ": 메인 화면 - 계정선택");
		System.out.println("=========================");
		
		int i = 0;
		for (User u: user) {
			System.out.printf("[%d] %s(%s) \n", i++,u.getName(),u.getPaytype());
		}
		System.out.println("[x] 종 료");
		System.out.print("선택 : ");
		
		//사용자한테 user번호를 입력받은 후 
		// 0, 1, x
		String input = scan.next();
		switch (input) {
		case "0": case "1":
			System.out.println("### " +input+" 선택 ###");
			selUser = Integer.parseInt(input); //동일한 user처리.
			productList(); // 리스트 불러오기.
			break;
		case "x": case "X":
			System.out.println("SHOP을 종료합니다.");
			
		default:
			System.out.println("\n 입력값을 확인해 주세요. \n");
			start();
			break;
		}			
	}
		public void productList() { //제품 목록 출력.
			System.out.println(title + ": 메인 화면 - 계정선택");
			System.out.println("=========================");
			
			int i = 0;
			for(Product p: products) {
				System.out.printf("[%d]",i++);
				p.printDetail();
			}
			System.out.println("[h] 메인화면");
			System.out.println("[c] 체크아웃");
			System.out.println("선택 : ");
			
			// 0~9, h, c
			String input = scan.next();
			
			//입력값에 의해 처리하기.
			switch (input) {
			case "h":
				start();
				break;
			case "c":
				checkout();
				break;
			case "0": case "1": case "2": case "3": case "4": 
			case "5": case "6": case "7": case "8": case "9":
			
				//카트에 담기.
				carts.add(products[Integer.parseInt(input)]); //input
				//다시 상품 목록 보여준다.
				productList();
				break;
				
			default:
				System.out.println("입력값을 확인해 주세요!");
				productList();
				break;
			}
			
	}
		public void checkout() {
			System.out.println(title+ " : 체크아웃");
			System.out.println("=========================");
			
			int i = 0;
			int total = 0; //장바구니 합계
			for (Product p:carts) {
				System.out.printf("[%d]%s(%s)\n", i++, p.getPname(), p.getPrice());
				total += p.getPrice(); //장바구니 물건 값의 합계 구하기.
							
			}
			System.out.println("=========================");
			System.out.println("결제 방법: " +user[selUser].getPaytype());
			System.out.println("합계 : " +total+ " 원 입니다.");
			System.out.println("[p] 이전, [q] 결제 완료");
			System.out.println("선택 : ");
		
			//p : checkout();
			//q : 프로그램 종료.
			String input = scan.next();
			switch (input) {
			case "p":
				productList();
				break;
			case "q":
				System.out.println("결제가 완료되었습니다.");
				break;
			default:
				System.out.println("입력값을 확인해주세요.");
				checkout();
				break;
			}
			
}
}
