package Recursive;

public class Currency {
	public static int makeChange(int total, int denom){
		int nextDenom = 0;
		switch (denom){
		case 25 : nextDenom = 10; break;
		case 10 : nextDenom = 5; break;
		case 5 : nextDenom = 1; break;
		case 1 : return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= total; i++){
			ways += makeChange(total - i * denom, nextDenom);
		}
		return ways;
	}
	
	public static int steps(int total, int[] map){
		if (map[total] != 0){
			return map[total];
		}
		if (total == 1){
			map[total] = 1;
			return 1;
		}
		if (total == 2){
			map[total] = 2;
			return 2;
		}
		if (total == 3){
			map[total] = 4;
			return 4;
		}
		
		map[total] = steps(total - 1, map) + steps(total - 2, map) + steps(total - 3, map);
		return map[total];
	}
	
	
	
	public static void main(String[] args){
		int N = 100;
		//System.out.println(makeChange(N,25));
		
		int[] map = new int[N];
		for (int i = 0; i < N; i++){
			map[i] = 0;
		}
		System.out.println(steps(N-1, map));
	}
}
