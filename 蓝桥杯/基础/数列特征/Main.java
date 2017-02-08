import java.util.Scanner;
public class Main{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();

		int nums[] = new int[total];
		for(int var = 0 ; var < total ; var++){
			nums[var] = input.nextInt();
		}

		int max = nums[0] , min = nums[0] , sum = nums[0];
		for(int var2 = 1 ; var2 < total ; var2++){
			if(nums[var2] > max){
				max = nums[var2];
			}
			if(nums[var2] < min){
				min = nums[var2];
			}
			sum += nums[var2];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}