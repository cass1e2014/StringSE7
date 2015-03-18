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

	}

	/*
	 * 而第二种方法是用动态规划，思路比较复杂一些，但是实现代码会比较简短。基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
	 * 过程中使用的历史信息是从i
	 * +1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。这种方法使用两层循环，时间复杂度是O
	 * (n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间，代码如下：
	 */
	public String longestPalindrome2(String s) {

	}

	/*
	 * 第一种方法就是挨个检查，维护全局最长，时间复杂度为O（n3），会TLE。
	 */
	public String longestPalindrome3(String s) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
