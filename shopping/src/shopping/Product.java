package shopping;

/*추상 클래스  - 객체 생성 불가
   		   - 단일 상속용 사용
		   - 추상메소드 + 일반 메소드 가질 수 있음.
*/
public abstract class Product {
	private String pname;
	private int price;
	
	
	public Product(String pname, int price) {
		super();
		this.pname = pname;
		this.price = price;
	}
	
	void printDetail() {
		System.out.println("상품 이름 : " + pname);
		System.out.println("가격 : " + price);
		printExtra();
	}
	abstract void printExtra();
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;

	}
	
}
