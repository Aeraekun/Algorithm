class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String s = new_id;
        s = s.toLowerCase();
        for(char c:s.toCharArray()){
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.') sb.append(c);
        }
        s = sb.toString();
        sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(sb.length()==0||c!='.'||sb.charAt(sb.length()-1)!='.')sb.append(c);
        }
        if(sb.length()>0 && sb.charAt(0)=='.') sb.deleteCharAt(0);
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        if(sb.length()==0)sb.append('a');
        if(sb.length()>=16) sb.delete(15,sb.length());
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        if(sb.length()<=2) sb.append(sb.charAt(sb.length()-1));
        if(sb.length()<=2) sb.append(sb.charAt(sb.length()-1));
        System.out.println(sb);
        return sb.toString();
    }
}