package shopping;

public class CelPhone extends Product {
	
	private String carrier; //��Ż�.
	
	
	public CelPhone(String pname, int price, String carrier) {
		super(pname, price);
		this.carrier = carrier;
	}


	@Override
	void printExtra() {
		// TODO Auto-generated method stub
		System.out.println("��Ż� ���� :" +carrier);
	}

}
