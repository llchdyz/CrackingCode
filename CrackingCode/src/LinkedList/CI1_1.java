package LinkedList;
import java.util.HashSet;

// unique char in a string
public class CI1_1 {
	
	public static boolean isAllUnique(String str){
		HashSet<String> charSet = new HashSet<String>();
		for (int i = 0; i < str.length(); i++){
			String charStr = str.substring(i, i + 1);
			if (charSet.contains(charStr)){
				return false;
			} else {
				charSet.add(charStr);
			}
		}
		return true; 
	}
	
	public static void main(String[] args){
		String str = "liangec";
		boolean judge = isAllUnique(str);
		if (judge){
			System.out.println("All unique!");			
		} else {
			System.out.println("Not all unique");
		}
		
	}
}
