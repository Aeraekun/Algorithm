class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] alphabet = new int[26];
        for(int i=0;i<skill.length();i++) {
            alphabet[skill.charAt(i)-'A']=i+1;
        }
        for(int i=0;i<26;i++){
            System.out.println(alphabet[i]);
        }
        for(String s : skill_trees) {
            int now=1;
            boolean check=true;
            for(int i=0;i<s.length();i++){
                if(alphabet[s.charAt(i)-'A']==now) now++;
                else if(alphabet[s.charAt(i)-'A']>now) {
                    check=false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}