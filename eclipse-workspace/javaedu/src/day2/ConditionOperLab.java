package day2;
public class ConditionOperLab {
	public static void main(String[] args) {
		int num = (int) (Math.random() * 5) + 1;
		int result =0;
		if(num ==1) {
			result=300+500;
		}else if(num==2) {
			result=300-500;
		}else if(num==3) {
			result=300*500;
		}else if(num==4) {
			result=300/500;
		}else {
			result=300%500;
		}
		System.out.println("결과값 : "+result);
	}
}
