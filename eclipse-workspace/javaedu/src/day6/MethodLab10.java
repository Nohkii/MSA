package day6;
public class MethodLab10 {
	public static void main(String[] args) {
		int a1[] = new int[] { 1, 2, 3, 4, 5 };
		MethodLab7.printArray(a1); // 같은패키지 내 다른 클래스 호출할 때는 '.'사용해서 호출
		powerArray(a1, 3);
		MethodLab7.printArray(a1);

		int a2[] = new int[] { 10, 20, 30, 40, 50, 60 };
		MethodLab7.printArray(a2);
		powerArray(a2, 10);
		MethodLab7.printArray(a2);
	}
	static void powerArray(int[] ary, int num) {
		if (num < 2 || num > 5) {
			return;
		}
		for (int i = 0; i < ary.length; i++) {
			ary[i] = ary[i] * num;
		}
	}
}
