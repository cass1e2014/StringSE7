import java.util.ArrayList;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, 
 * path = "/home/", => "/home" 
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 * 
 * @author cassie9082
 * 
 */
public class simplifyPath {
	public String simplifyPath(String path) {
		if(path == null || path.length() == 0){
			return null;
		}
		
		String[] splitStrings = path.split("/+");
		String result = "/";
		ArrayList<String> paths = new ArrayList<String>();
		for(String splitString : splitStrings){
			if(splitString.equals("..")){
				if(paths.size() > 0){
					paths.remove(paths.size() - 1);
				}
			}else if(!splitString.equals(".") && !splitString.equals("")){
				paths.add(splitString);
			}
		}
		for(String s : paths){
			result += s + "/";
		}
		if(result.length() > 1){
			result = result.substring(0, result.length() - 1);//要去掉最后一位"/"
		}
		return result;
	}
}
