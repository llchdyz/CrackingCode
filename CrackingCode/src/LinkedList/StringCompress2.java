package LinkedList;

public class StringCompress2 {
	public static String StringCompress(String str){
		
		int length = str.length();
		StringBuffer list = new StringBuffer(length);
		int count = 1;
		char current = str.charAt(0);
		for (int i = 1; i < length; i++){

			if (list.length() + 2 == length){
				return str;// can't compress
			}
			
			if (str.charAt(i) == current){
				count++;
			} else {
				list.append(current);
				list.append(count);
				current = str.charAt(i);
				count = 1;
			}
		}	
		
		list.append(current);
		list.append(count);
		String newStr = list.toString();
		return newStr;
		
	}
	
	public static void main(String[] args){
		String str = "aaadaaaeeeaadc";
		String newStr = StringCompress(str);
		System.out.println(newStr);
	}
}
