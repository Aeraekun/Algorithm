import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int S = 0;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String operate = st.nextToken();
			
			if(operate.equals("all")) {
				S = (1 << 20) - 1;
			}
			else if(operate.equals("empty")) {
				S = 0;
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				
				if(operate.equals("add")) {
					S = S | (1 << (num-1));
				}
				else if(operate.equals("remove")) {
					S = S & ~(1 << (num-1));
				}
				else if(operate.equals("check")) {
					int checkNum = S & (1 << (num-1));
					if(checkNum != 0) sb.append(1).append("\n");
					else sb.append(0).append("\n");
				}
				else if(operate.equals("toggle")) {
					S = S ^ (1 << (num-1));
				}
			}
			
		}	
		System.out.println(sb);
	}

}