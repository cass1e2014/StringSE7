/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author cassie9082
 * 
 */
public class LongestPalindromicSubstring {
	/*
	 * 这道题是比较常考的题目，求回文子串，一般有两种方法。
	 * 第一种方法比较直接，实现起来比较容易理解。基本思路是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙
	 * ，比如串abc,中心可以是a,b,c,或者是ab的间隙
	 * ，bc的间隙）往两边同时进行扫描，直到不是回文串为止。假设字符串的长度为n,那么中心的个数为2
	 * *n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂度为O
	 * (n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)，代码如下
	 */
	public String longestPalindrome1(String s) {
		if(s == null || s.length() == 1){
			return s;
		}
		
		String longest = s.substring(0, 1);
		for(int i = 0; i < s.length(); i++){
			//get the longest palindrome with center of i
			String temp = helper(s, i, i);
			if(temp.length() > longest.length()){
				longest = temp;
			}
			
			//get the longest palindrome with center of i + 1
			temp = helper(s, i, i + 1);
			if(temp.length() > longest.length()){
				longest = temp;
			}
		}
		return longest;
	}
	
	//Given a cneter, either one letter or two letters, find the longest palindrome
	public String helper(String s, int begin, int end){
		while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)){
			begin --;
			end ++;
		}
		return s.substring(begin + 1, end);
	}

	/*
	 * 而第二种方法是用动态规划，思路比较复杂一些，但是实现代码会比较简短。基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
	 * 过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。这种方法使用两层循环，时间复杂度是O
	 * (n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间，代码如下：
	 */
//	public String longestPalindrome2(String s) {
		
		
//	}
	
	/*
	 * "dabcba"
	 * 1 0 0 0 0 0 
	 * 0 1 0 0 0 1 
	 * 0 0 1 0 1 0 
	 * 0 0 0 1 0 0 
	 * 0 0 0 0 1 0 
	 * 0 0 0 0 0 1 
	 */

	/*
	 * 第一种方法就是挨个检查，维护全局最长，时间复杂度为O（n^3），会TLE。
	 */
	public String longestPalindrome3(String s) {
		if(s == null || s.length() == 0){
			return null;
		}
		
		int maxPalindromeLength = 0;
		String longestPalindrome = null;
		for(int i = 0; i < s.length(); i++){
			for(int j = i + 1; j < s.length(); j++){
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if(isPalindrome(curr)){
					if(len > maxPalindromeLength){
						longestPalindrome = curr;
						maxPalindromeLength = len;
					}
				}
			}
		}
		return longestPalindrome;
	}
	
	//看在string中字符是否对称
	public boolean isPalindrome(String s){
		for(int i = 0 ; i < s.length() - 1; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
