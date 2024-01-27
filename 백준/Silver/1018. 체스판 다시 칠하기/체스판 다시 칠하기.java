import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mn=br.readLine();
        int m=Integer.parseInt(mn.split(" ")[0]);
        int n=Integer.parseInt(mn.split(" ")[1]);
        boolean[][] board=new boolean[m][n];

        for(int i=0;i<m;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                if(str.charAt(j)=='W') board[i][j]=true;
                else board[i][j]=false;
            }
        }
        System.out.println(solution(board,m,n));
    }
    public static int solution(boolean[][] board,int m,int n){
        int ans=64;
        int temp1=64;
        int temp2=64;
        boolean[] b={false,true,false,true,false,true,false,true};
        boolean[] w={true,false,true,false,true,false,true,false};

        for(int i=0;i<m-7;i++){
            for(int j=0;j<n-7;j++){
                for(int k=0;k<8;k++){
                    for(int l=0;l<8;l++){
                        if(k%2==1) {
                            if (board[i + k][j + l] == b[l]) temp1--;
                            if (board[i + k][j + l] == w[l]) temp2--;
                        }
                        else{
                            if (board[i + k][j + l] == b[l]) temp2--;
                            if (board[i + k][j + l] == w[l]) temp1--;
                        }
                    }
                }
                ans=Math.min(ans,Math.min(temp1,temp2));
                temp1=temp2=64;
            }
        }
        return ans;
    }
}