package shopping;

public class SmartTV extends Product {
	
	private String resolution; //해상도
	
	
	public SmartTV(String pname, int price,String resolution) {
		super(pname,price); 
		this.resolution = resolution;
	}


	@Override
	void printExtra() {
		// TODO Auto-generated method stub
		System.out.println("해상도 정보: " +resolution);
	}

}
