import java.util.Scanner;
public class Fibonacci{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);

		// while(scanner.hasNext()){

			long f = scanner.nextLong();

			System.out.println(getFibonacci(f));
		// }
	}

	// public static long getFibonacci(long f){
	// 	if(f == 1 || f == 2){
	// 		return 1;
	// 	}
	// 	return (getFibonacci(f-1)+getFibonacci(f-2))%10007;
	// }

	public static long getFibonacci(long f){
		long result=0;
		if(f == 1 || f == 2){
			return result = 1;
		}
		long f1 = 1, f2 = 1;
		for(long i = 3 ; i <= f ; i++){
			result = (f1+f2)%10007;
			f2 = f1;
			f1 = result;
		}
		return result;
	}
}