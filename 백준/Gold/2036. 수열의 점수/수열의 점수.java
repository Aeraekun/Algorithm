import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger ans = BigInteger.valueOf(0);
        int n = Integer.parseInt(br.readLine());
        List<Long> m_num = new ArrayList<>();
        List<Long> p_num = new ArrayList<>();
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            long temp = Integer.parseInt(br.readLine());
            if (temp == 0) zero = true;
            else if (temp == 1) ans = ans.add(BigInteger.valueOf(1));
            else if (temp > 1) p_num.add(temp);
            else m_num.add(temp);
        }
        Collections.sort(m_num);
        Collections.sort(p_num, Collections.reverseOrder());
        if (!m_num.isEmpty()) {
            if (m_num.size() % 2 == 1) {
                if (zero) m_num.remove(m_num.size() - 1);
                else {
                    ans = ans.add(BigInteger.valueOf(m_num.get(m_num.size() - 1)));
                    m_num.remove(m_num.size() - 1);
                }
            }
            for (int i = 0; i < m_num.size(); i += 2) {
                ans = ans.add(BigInteger.valueOf(m_num.get(i) * m_num.get(i + 1)));
            }
        }
        if (!p_num.isEmpty()) {
            if (p_num.size() % 2 == 1) {
                ans = ans.add(BigInteger.valueOf(p_num.get(p_num.size() - 1)));
                p_num.remove(p_num.size() - 1);
            }
            for (int i = 0; i < p_num.size(); i += 2) {
                ans = ans.add(BigInteger.valueOf(p_num.get(i) * p_num.get(i + 1)));
            }
        }
        System.out.println(ans);
    }
}
