package day5;

public class TwoArrayLab4 {
	public static void main(String[] args) {
		int[][] ary = {
				{10, 20, 30, 40, 50},		
				{5, 10, 15},		
				{11, 22, 33, 44},		
				{9, 8, 7, 6, 5, 4, 3, 2, 1},		
		};
		int sum =0;
		for(int i = 0; i < ary.length; i++) {
			for(int j =0; j < ary[i].length; j++) {
				sum += ary[i][j];
			}
			System.out.println(i+1+"행의 합은 "+sum+"입니다.");
			sum =0;
		}
	}
}
