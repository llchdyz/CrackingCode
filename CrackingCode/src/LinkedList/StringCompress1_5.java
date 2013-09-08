package LinkedList;



public class StringCompress1_5 {
	
	public static String StringCompress(String str){
		
		int length = str.length();
		StringBuffer list = new StringBuffer(length);
		int count = 1;
		for (int i = 0; i < length; i = i + count){
			char current = str.charAt(i);
			list.append(current);
			count = 1;
			System.out.println("i " + i);
			if (list.length() + 1 >= length){
				return str;// can't compress
			}
			
			if (i + 1 == length){
				list.append(count);
				break; 
			}
			
			while (str.charAt(i + count) == current){
				
				count++;
				
				if (i + count >= length){
					break;// count to the end
				}
			}

			list.append(count);
		
		}	
	
		String newStr = list.toString();
		return newStr;
		
	}
	
	public static void main(String[] args){
		String str = "aaaabbbeead";
		String newStr = StringCompress(str);
		System.out.println(newStr);
	}
}
