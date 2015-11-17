import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * @author cassie9082
 * 
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        //hashmap
        if(s == null || s.length() == 0)    return true;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if(map.containsKey(letter)){
                map.put(letter, map.get(letter) + 1);
            }else{
                map.put(letter, 1);
            }
        }
        
        int tolerance = 0;
        Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            if((int)pair.getValue() % 2 != 0){
                tolerance ++;
            }
        }
        
        if(s.length()%2 == 0){
            return tolerance == 0;
        }else{
            return tolerance == 1;
        }
    }
}
