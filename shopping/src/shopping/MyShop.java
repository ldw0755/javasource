package shopping;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.java.util.jar.pack.Instruction.Switch;

public class MyShop implements IShop {
	
	//���θ� �̸�.
	private String title; 
	//��� ��ǰ
//	CellPhone[] = new Cell[5] // X
	Product[] products = new Product[10];
	//��ٱ���
	ArrayList<Product> carts = new ArrayList<Product>();
	//�����
	User user[] = new User[2]; //null�� �ֱ�ȭ �Ǿ�����.
	//Ű���� �Է� ó��.
	Scanner scan = new Scanner(System.in);
	
	int selUser; //
	
	
	@Override
	public void setTitle(String title) {
		this.title = title;		
	}

	@Override
	public void genUser() {
		//���θ� ����� ����. �� �迭�� ���
		//user ��ü �̿�.
//		User user1[] = new User ("������", PayType.CARD);
//		User user2[] = new User ("���ݼ�", PayType.CASH);
//		user[0] = user1;
//		user[1] = user2;

		user[0] = new User ("������", PayType.CARD);
		user[1] = new User ("���ݼ�", PayType.CASH);
	}

	@Override
	public void genProduct() {
		//���θ����� �Ǹ��ϴ� ��ǰ ����.
		//CellPhone, SmartTV
		products[0] = new SmartTV("�Ｚ SmartTV", 100000, "4k");
		products[1] = new SmartTV("���� SmartTV", 100000, "hd");
		products[2] = new SmartTV("�Ｚ SmartTV", 150000, "pullhd");
		products[3] = new SmartTV("������ SmartTV", 100000, "4k");
		products[4] = new SmartTV("������ SmartTV", 100000, "4k");
		products[5] = new CelPhone("IPhone 6", 200000, "lte");
		products[6] = new CelPhone("IPhone 7", 200000, "5g");
		products[7] = new CelPhone("IPhone 8", 200000, "4g");
		products[8] = new CelPhone("IPhone 9", 200000, "lte");
		products[9] = new CelPhone("IPhone10", 200000, "3g");
		
		
	}

	@Override
	public void start() { //�����ϴ� �޼ҵ�.
		System.out.println(title + ": ���� ȭ�� - ��������");
		System.out.println("=========================");
		
		int i = 0;
		for (User u: user) {
			System.out.printf("[%d] %s(%s) \n", i++,u.getName(),u.getPaytype());
		}
		System.out.println("[x] �� ��");
		System.out.print("���� : ");
		
		//��������� user��ȣ�� �Է¹��� �� 
		// 0, 1, x
		String input = scan.next();
		switch (input) {
		case "0": case "1":
			System.out.println("### " +input+" ���� ###");
			selUser = Integer.parseInt(input); //������ useró��.
			productList(); // ����Ʈ �ҷ�����.
			break;
		case "x": case "X":
			System.out.println("SHOP�� �����մϴ�.");
			
		default:
			System.out.println("\n �Է°��� Ȯ���� �ּ���. \n");
			start();
			break;
		}			
	}
		public void productList() { //��ǰ ��� ���.
			System.out.println(title + ": ���� ȭ�� - ��������");
			System.out.println("=========================");
			
			int i = 0;
			for(Product p: products) {
				System.out.printf("[%d]",i++);
				p.printDetail();
			}
			System.out.println("[h] ����ȭ��");
			System.out.println("[c] üũ�ƿ�");
			System.out.println("���� : ");
			
			// 0~9, h, c
			String input = scan.next();
			
			//�Է°��� ���� ó���ϱ�.
			switch (input) {
			case "h":
				start();
				break;
			case "c":
				checkout();
				break;
			case "0": case "1": case "2": case "3": case "4": 
			case "5": case "6": case "7": case "8": case "9":
			
				//īƮ�� ���.
				carts.add(products[Integer.parseInt(input)]); //input
				//�ٽ� ��ǰ ��� �����ش�.
				productList();
				break;
				
			default:
				System.out.println("�Է°��� Ȯ���� �ּ���!");
				productList();
				break;
			}
			
	}
		public void checkout() {
			System.out.println(title+ " : üũ�ƿ�");
			System.out.println("=========================");
			
			int i = 0;
			int total = 0; //��ٱ��� �հ�
			for (Product p:carts) {
				System.out.printf("[%d]%s(%s)\n", i++, p.getPname(), p.getPrice());
				total += p.getPrice(); //��ٱ��� ���� ���� �հ� ���ϱ�.
							
			}
			System.out.println("=========================");
			System.out.println("���� ���: " +user[selUser].getPaytype());
			System.out.println("�հ� : " +total+ " �� �Դϴ�.");
			System.out.println("[p] ����, [q] ���� �Ϸ�");
			System.out.println("���� : ");
		
			//p : checkout();
			//q : ���α׷� ����.
			String input = scan.next();
			switch (input) {
			case "p":
				productList();
				break;
			case "q":
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			default:
				System.out.println("�Է°��� Ȯ�����ּ���.");
				checkout();
				break;
			}
			
}
}
