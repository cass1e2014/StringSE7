import java.util.LinkedList;
import java.util.Queue;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author cassie9082
 * 
 */

/*
 * 所以构建当前行的字符串要依据上一行的字符串。“小陷阱就是跑完循环之后记得把最后一个字符也加上，因为之前只是计数而已。”
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "1";
		}
		int start = 1;
		String oldString = "1";
		while (start < n) {
			StringBuilder sb = new StringBuilder();
			char[] oldChar = oldString.toCharArray();
			for (int i = 0; i < oldChar.length; i++) {
				int count = 1;
				//当遇到相同时，count＋＋，记得也要把i＋＋
				while ((i + 1) < oldChar.length && oldChar[i] == oldChar[i + 1]) {
					count++;
					i++;
				}
				 //int --> String && char[] --> String
				sb.append(String.valueOf(count));
				sb.append(String.valueOf(oldChar[i]));
			}
			oldString = sb.toString();//oldString要返回给下一次while loop
			start++;
		}
		return oldString;
	}
	
	
	public String countAndSay2(int n) {
        if(n <= 0)  return "";
        int start = 1;
        String oldString = "1";
        while(start < n){
            StringBuilder sb = new StringBuilder();
            char[] oldChar = oldString.toCharArray();
            char prev = oldChar[0];
            int count = 1;
            for(int i = 1; i < oldChar.length; i++){
                char c = oldChar[i];
                if(c == prev){
                    count ++;
                }else{
                	sb.append(count);
                    sb.append(prev);
                    prev = c;
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(prev);
            oldString = sb.toString();
            start ++;
        }
        return oldString;
    }

	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay2(4));
	}
}
