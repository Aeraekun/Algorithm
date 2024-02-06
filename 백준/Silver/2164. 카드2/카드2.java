import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		while(queue.size()>1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
