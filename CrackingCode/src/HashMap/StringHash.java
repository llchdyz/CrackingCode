package HashMap;

public class StringHash {
	private int hashcode = -1;
	private char[] str;
	
	public StringHash(String str){
		this.str = str.toCharArray();
	}
	
	public int getStringHash(){
		if (hashcode != -1){
			return hashcode;
		}
		System.out.println("Here");
		for (int i = 0; i < str.length; i++){
			hashcode = str[i] + hashcode * 31;
		}
		return hashcode;
	}
	
	public static void main(String[] args){
		StringHash str = new StringHash("you");
		System.out.println(str.getStringHash());
		System.out.println(str.getStringHash());
	}
}
