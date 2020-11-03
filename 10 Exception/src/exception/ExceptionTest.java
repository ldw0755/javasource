package exception;

/* Exception과 Error(해결 X - ex. 컴 다운)
 * 
 *Exception(예외)
 *
 *컴파일 예외 - 코딩 시 by Eclipse
 *런타임 예외 - 실행 시 
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		//컴파일 예외
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("입력값을 확인해주세요.");
		}

	}

}
