import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int startTime;
    int endTime;

    public Lecture(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Lecture other) {
        return Integer.compare(endTime, other.endTime);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }
        Arrays.sort(lectures, Comparator.comparingInt(lecture -> lecture.startTime));

        PriorityQueue<Lecture> minHeap = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            if (!minHeap.isEmpty() && lecture.startTime >= minHeap.peek().endTime) {
                minHeap.poll();
            }
            minHeap.offer(lecture);
        }
        System.out.println(minHeap.size());
    }
}
