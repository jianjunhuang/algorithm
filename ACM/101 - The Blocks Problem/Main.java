import java.io.BufferedReader;
import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	private int[][] form;
	private int[] arr;
	public static void main(String args[]) throws IOException{
		Main m = new Main();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//get num
		int num = Integer.parseInt(in.readLine());
		//init arrays
		m.init(num);
		String com1,com2;
		int pos1,pos2;
		String l = "";
		while(!("quit").equals(l = in.readLine())){
			StringTokenizer tokens = new StringTokenizer(l);
			//get commond ,move or pile
			com1 = tokens.nextToken();
			//get first block number
			pos1 = Integer.parseInt(tokens.nextToken());
			//get commond ,onto or over
			com2 = tokens.nextToken();
			//get second block number
			pos2 = Integer.parseInt(tokens.nextToken());
			if("move".equals(com1)){
				if("onto".equals(com2)){
					m.moveOnto(pos1,pos2);
				}else{
					m.moveOver(pos1,pos2);
				}
			}else if("pile".equals(com1)){
				if("onto".equals(com2)){
					m.pileOnto(pos1,pos2);
				}else{
					m.pileOver(pos1,pos2);
				}
			}
		}
		m.quit(num);
	}

	public void init(int n){
		form = new int[n][n];
		arr = new int[n];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(j == 0){
					form[i][j] = i;
				}else{
					form[i][j] = -1;
				}
			}
		}
	}

	public void moveOnto(int a , int b){
		if(check(a,b)){
			return;
		}
		clear(a);
		clear(b);
		int rowA = arr[a];
		int rowB = arr[b];
		int coloB = find(rowB);
		int coloA = find(rowA);
		form[rowB][coloB+1] = a;
		form[rowA][coloA] = -1;
		arr[a] = rowB;
	}

	public void moveOver(int a , int b){
		if(check(a,b)){
			return;
		}
		clear(a);
		int rowA = arr[a];
		int rowB = arr[b];
		int coloB = getHight(rowB);
		int coloA = find(a);
		form[rowB][coloB+1] = a;
		form[rowA][coloA] = -1;
		arr[a] = rowB;
	}

	public void pileOnto(int a , int b){
		if(check(a,b)){
			return;
		}
		clear(b);
		int rowA = arr[a];
		int rowB = arr[b];
		int coloA = find(a);
		int coloB = find(b);
		for(int i = coloA , j = coloB + 1; form[rowA][i] > 0 ; i++ , j++){
			form[rowB][j] = form[rowA][i];
			form[rowA][i] = -1;
			arr[form[rowA][i]] = rowB;
		}
	}

	public void pileOver(int a , int b){
		if(check(a,b)){
			return;
		}
		int rowA = arr[a];
		int rowB = arr[b];
		int coloA = find(a);
		int coloB = getHight(rowB);
		for(int i = coloA , j = coloB + 1; form[rowA][i] > 0 ; i++ , j++){
			form[rowB][j] = form[rowA][i];
			form[rowA][i] = -1;
			arr[form[rowA][i]] = rowB;
		}
	}

	public int getHight(int var){
		int hight;
		for(hight = 0 ; form[var][hight] != -1 ; hight++){

		}
		return hight-1;
	}

	public void clear(int var){
		int row = arr[var];
		int position = find(row);
		int num;
		int hight;
		for(int i = position+1 ; form[row][i] > 0 ; i++){
			num = form[row][i];
			hight = getHight(num);
			for(int j = hight+1 ; j > 1 ; j--){
				form[num][j+1] = form[num][j];
			}
			form[num][0] = num;
			arr[num] = num;
		}	
	}

	public int find(int var){
		int row = arr[var];
		int position = -1;
		for(int i = 0 ; form[row][i] >= 0 ; i++){
			if(form[row][i] == var){
				position = i;
				break;
			}
		}
		return position;
	}

	private boolean check(int a , int b){
		if(a == b || arr[a] == arr[b]){
			return true;
		}
		return false;
	}

	public void quit(int num){
		for(int i = 0 ; i < num ; i++){
			System.out.print(i+":");
			for(int j = 0 ; form[i][j] >= 0 ; j++){
				System.out.print(form[i][j]+" ");
			}
			System.out.println();
		}
	}
}