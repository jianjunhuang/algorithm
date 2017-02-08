import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int total = input.nextInt();
			String nums[] = new String[total];
			if(total > 0){
				for(int var = 0 ; var < total ; var++){
					nums[var] = input.next();
				}
				sort(nums);
				for(int var2 = 0 ; var2 < total ; var2++){
					System.out.print(nums[var2]);
				}
				System.out.println();
			}
			
		}
	}

	public static void sort(String nums[]){
		for(int var = 0 ; var < nums.length ; var++){
			for(int var2 = var+1 ; var2 < nums.length ; var2++){
				if((nums[var]+nums[var2]).compareTo(nums[var2]+nums[var])<0){
					String temp = nums[var];
					nums[var] = nums[var2];
					nums[var2] = temp;
				}
			}
		}
	}
}