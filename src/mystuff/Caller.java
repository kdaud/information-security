package mystuff;


public class Caller {
	
	public static void main(String[] args) {
		Patient patient = new Patient();
		int sum=patient.add(10, 7);
		System.out.println(sum);
	}
	
}
