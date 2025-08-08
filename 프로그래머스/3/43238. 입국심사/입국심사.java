import java.io.*;
import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        int max = Arrays.stream(times).max().getAsInt();
        System.out.println(max);
        long left = 1, right = (long) max * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 시간 동안 처리 가능한 총 인원수 계산
            long count = Arrays.stream(times).mapToLong(i -> mid / i).sum();

            if (count < n) {
                // 부족하므로 시간을 늘림
                left = mid + 1;
            } else {
                // 충분하므로 시간을 줄이면서 더 짧은 시간 탐색
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }

}