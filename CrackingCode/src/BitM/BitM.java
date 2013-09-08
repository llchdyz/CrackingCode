package BitM;

public class BitM {
	private int num;
	public BitM(int num){
		this.num = num;
		
	}
	
	public BitM(){
		
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	public byte getBit(int loc){
		return (byte) (num >> (loc) & 1); 
	}
	
	public void setBit(int loc){
		this.num = this.num | 1 << (loc);
	}
	/**
	 * 
	 * @param start included
	 * @param end not included
	 */	
	public void clearRange(int start, int end){
		int toStart = (1 << start) - 1;
		int toEnd = ~((1 << end) - 1);
		int range = toStart | toEnd;
		this.num = this.num & range; 
	}
	
	public int value(){
		return this.num;
	}
	
	public String toBinary(){
		return Integer.toBinaryString(num);
	}
	
	public void update(int loc, int v){
		this.clearRange(loc, loc+1);
		this.num = this.num | (v << loc);
	}
	
	public static void main(String[] args){
		BitM num = new BitM(20);
		num.setBit(3);
		System.out.println(num.getBit(3));
		System.out.println(num.toBinary());
		num.clearRange(3, 4);
		System.out.println(num.toBinary());
		num.update(3, 1);
		System.out.println(num.toBinary());
		
	}
}
