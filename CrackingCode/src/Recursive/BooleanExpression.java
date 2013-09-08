package Recursive;

import java.util.HashMap;
import java.util.Map;

public class BooleanExpression {
	
	
	
	public static void main(String[] args){
		Map<String, Integer> map = new HashMap<>();
		String expression = "1&0|1|0";
		
		System.out.println(f(map, expression, true, 0, expression.length()-1));
		System.out.println(map.size());
		for (String key : map.keySet()){
			System.out.println(key + " " + map.get(key));
		}
	}

	public static int f(Map<String, Integer> map,
			String expression, boolean result, int start, int end) {
		String key = "" + start + end + result;
		if (map.containsKey(key)){
			return map.get(key);
		}
		
		if (start == end){
			if (expression.charAt(start) == '1' && result){
				return 1;
			} else if (expression.charAt(start) == '0' && !result){
				return 1;
			}
			return 0;
		} 
		
		int ways = 0;
		if (result){
			for (int i = start + 1; i < end; i += 2){
				if (expression.charAt(i) == '&'){
					ways += f(map, expression, true, start, i-1) * f(map, expression, true, i+1, end);
				} else if (expression.charAt(i) == '|'){
					ways += f(map, expression, true, start, i-1) * f(map, expression, true, i+1, end);
					ways += f(map, expression, true, start, i-1) * f(map, expression, false, i+1, end);
					ways += f(map, expression, false, start, i-1) * f(map, expression, true, i+1, end);
				} else {
					ways += f(map, expression, true, start, i-1) * f(map, expression, false, i+1, end);
					ways += f(map, expression, false, start, i-1) * f(map, expression, true, i+1, end);
				}
			}
		} else {
			for (int i = start + 1; i < end; i += 2){
				if (expression.charAt(i) == '&'){
					ways += f(map, expression, true, start, i-1) * f(map, expression, true, i+1, end);
					ways += f(map, expression, true, start, i-1) * f(map, expression, false, i+1, end);
					ways += f(map, expression, false, start, i-1) * f(map, expression, true, i+1, end);
				} else if (expression.charAt(i) == '|'){
					ways += f(map, expression, true, start, i-1) * f(map, expression, true, i+1, end);
				} else {
					ways += f(map, expression, true, start, i-1) * f(map, expression, false, i+1, end);
					ways += f(map, expression, false, start, i-1) * f(map, expression, true, i+1, end);					}
				}
		}
		map.put(key, ways);
		return ways;
		
	}
}
