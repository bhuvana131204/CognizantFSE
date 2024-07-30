package singleton;

public class SingletonTest {
	public static void main(String args[]) {
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		
		log1.log("First log message");
		log2.log("Second log message");
		
		if(log1 == log2) {
			System.out.println("Both logger instances have same instance");
		}else {
			System.out.println("Logger instances are different");
		}
	}
}
