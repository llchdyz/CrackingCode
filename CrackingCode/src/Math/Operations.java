package Math;

public class Operations {
	
	public static int add(int a, int b){
		return a+b;
	}
	
	// a-b
	public static int minus(int a, int b){
		return a + negate(b);
	}
	
	public static int multiplication(int a, int b){
		if (abs(a) < abs(b)){
			int temp = b;
			b = a;
			a = temp;
		}
		
		int result = 0;
		for (int i = 0; i < abs(b); i++){
			result += a;
		}
		
		result = b > 0 ? result : negate(result);
		return result;
	}
	
	public static int divide(int a, int b) throws ArithmeticException{
		if (b == 0){
			throw new ArithmeticException("Error");
		}
		
		int result = 0;
		int absA = abs(a);
		int absB = abs(b);
		int sumB = 0;
		
		while (sumB + absB <= absA){
			result++;
			sumB += absB;
		}
		
		if ((a > 0 && b > 0) || (a < 0 && b < 0)){
			return result;
		} else {
			return negate(result);
		}
	}
	
	public static int abs(int value){
		if (value >= 0){
			return value;
		} else {
			return negate(value);
		}
	}
	
	public static int negate(int value){
		int sign = value < 0 ? 1 : -1;
		int result = 0;
		while (value != 0){
			value += sign;
			result += sign;
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(divide(-10,-3));
	}
}
