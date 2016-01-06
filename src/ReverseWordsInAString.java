import java.util.Stack;

/*
 * Given an input string, reverse the string word by word. 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */
public class ReverseWordsInAString {
	public static String reverseWords(String s) {
		if(s == null || s.length() == 0){
            return s;
        }   
        
        Stack<String> set = new Stack<String>();
        int start = 0;
        boolean prevIsChar = false;
        for(int i = 0; i < s.length(); i++){
            //每个单词的第一个字母
            if(!prevIsChar && s.charAt(i) != ' '){
                prevIsChar = true;
                start = i;
            }
            
            //每个单词的最后一个字母
            if(prevIsChar && s.charAt(i) == ' '){
                prevIsChar = false;
                set.add(s.substring(start, i));
            }
        }
        //最后一个字母
        if(prevIsChar && s.charAt(s.length() - 1) != ' '){
            set.add(s.substring(start));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!set.empty()){
            sb.append(set.pop());
            //最后一个单词加了以后不需要再加空格了
            if(!set.empty()){
                sb.append(" ");
            }
        }
        return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}
}
