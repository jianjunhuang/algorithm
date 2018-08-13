package second;

import java.util.Scanner;

public class Main {

    public static void main(String ars[]) {
        Scanner in = new Scanner(System.in);
        int heapNum;
        int applesNum[];
        int queryTimes;
        int n;
        heapNum = in.nextInt();
        applesNum = new int[heapNum];
        //init
        for (int i = 0; i < heapNum; i++) {
            applesNum[i] = in.nextInt();
        }
        int nums[] = new int[heapNum];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num + applesNum[i];
            nums[i] = num;
        }
        queryTimes = in.nextInt();
        for (int i = 0; i < queryTimes; i++) {
            n = in.nextInt();
            for (int j = 0; j < nums.length; j++) {
                if(n <= nums[j]){
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }

}
