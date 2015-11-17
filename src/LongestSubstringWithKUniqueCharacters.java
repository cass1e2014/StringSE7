import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
	public static String maxSubstringKUniqueChars(String s, int k) {
		int max = 0;
		int leftbound = 0;
		String maxSubstring = null;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s.length(); i++){
			//add each char to the counter
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, 1);
			}
			
			if(map.size() == k + 1){
				//get maximum
				max = Math.max(max, i - leftbound + 1);
				maxSubstring = s.substring(leftbound, i + 1);
			}
			
			//move leftbound toward right, so that substring contains only k characters
			while(map.size() > k){
				char first = s.charAt(leftbound);
				int count = map.get(first);
				if(count > 1){
					map.put(first, count - 1);
				}else{
					map.remove(first);
				}
				leftbound ++;
			}
		}
		
		if(map.size() == k && max == 0){
			return s;
		}
		return maxSubstring;
	}
}
