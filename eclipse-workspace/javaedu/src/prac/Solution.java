package prac;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] people, int limit) {
        // 구출했으면 배열에서 값을 빼야함 (remove())
        // 만약 더했을 때 limit을 넘어가면 다시 빼고 다른 사람을 더해야 함
        int answer = 0;
        ArrayList<Integer> ary = new ArrayList<>();
        for(int i : people){
            ary.add(i);
        }
        for(int i : ary){
            System.out.println(i+" ");
        }
        return answer;

	}
    public static void main(String[] args) {
    	int[] people = {70, 80,50};
    	int limit = 100;
    	Solution sol = new Solution();
    	int result = sol.solution(people, limit);
		System.out.println(result);
	}
}