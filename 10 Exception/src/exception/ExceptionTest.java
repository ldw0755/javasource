package exception;

/* Exception�� Error(�ذ� X - ex. �� �ٿ�)
 * 
 *Exception(����)
 *
 *������ ���� - �ڵ� �� by Eclipse
 *��Ÿ�� ���� - ���� �� 
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		//������ ����
		try {
			Class.forName("java.lang.String2");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("�Է°��� Ȯ�����ּ���.");
		}

	}

}
