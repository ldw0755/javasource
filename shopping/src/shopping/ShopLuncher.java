package shopping;

public class ShopLuncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyShop shop = new MyShop();
		
		//�����̸� ����
		shop.setTitle("MyShop");
		
		//user ����
		shop.genUser();
		
		//��ǰ ����
		shop.genProduct();
		
		//���� ����
		shop.start();
	}

}
