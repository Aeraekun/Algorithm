import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum=0;
		boolean end = false;
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr);
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-arr[i]-arr[j]==100) {
					for(int k=0;k<9;k++) {
						if(k==i||k==j) continue;
						System.out.println(arr[k]);
					}
					end=true;
					break;
				}
			}
			if(end) break;
		}
	}
}