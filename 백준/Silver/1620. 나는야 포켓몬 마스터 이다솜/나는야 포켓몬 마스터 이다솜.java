import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> pokemon=new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		String [] pok=new String[n];
		String ans;
		for(int i=0;i<n;i++) {
			String temp=br.readLine();
			pokemon.put(temp,i+1);
			pok[i]=temp;
		}
		for(int i=0;i<m;i++) {
			ans=new String(br.readLine());
			try {
				Integer.parseInt(ans);
				System.out.println(pok[Integer.parseInt(ans)-1]);
			}
			catch (NumberFormatException e){
				System.out.println(pokemon.get(ans));
			}
		}
	}
}

