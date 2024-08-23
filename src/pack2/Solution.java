package pack2;

import java.util.Scanner;

public class Solution {
    static int n,m,arr[][];
    public static int cells(int i,int j){
        if(((i<0 || j<0) || (i>=n || j>=m))  ||  arr[i][j] == 0 || arr[i][j] == -1 )
            return 0;
        arr[i][j] = -1;
        return 1 + 
        		cells(i-1,j-1) + 
        		cells(i-1,j) + 
        		cells(i-1,j+1) + 
        		cells(i,j-1) + 
        		cells(i,j+1) + 
        		cells(i+1,j-1) + 
        		cells(i+1,j) + 
        		cells(i+1,j+1);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
        int large=0;
        n = scan.nextInt();
        m = scan.nextInt();
        scan.nextLine();
        arr = new int[n][m];
        for(int i = 0;i<n;i++){
            String input[] = scan.nextLine().split(" ");
            for(int j=0;j<input.length;j++){
                arr[i][j] = Integer.parseInt(input[j]);
                //System.out.println(arr[i][j]);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 1)
                    large = Math.max(large,cells(i,j));
            }
        }
        System.out.print(large);
    }
}