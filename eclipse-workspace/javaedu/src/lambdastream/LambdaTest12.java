package lambdastream;

interface ActionExpression {
	void exec(Object... param); // 가변형 매개변수[배열로 전달]를 가진 메소드
}

interface FuncExpression<T> {
	T exec(Object... param); // 가변형 매개변수[배열로 전달] + 타입파라미터와 같은 객체 리턴하는 메소드
}

public class LambdaTest12 {
	public static void Test1(ActionExpression action) {
		action.exec("hello world-test1");
	}

	public static void Test2(FuncExpression<String> func) {
		String ret = func.exec("hello world-test2");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		Test1(new ActionExpression() {
			public void exec(Object... data) {
				System.out.println("Test1 - " + data[0]);
			}
		});
		Test2(new FuncExpression<String>() {
			public String exec(Object... data) {
				System.out.println(data[0]);
				return "OK1";
			}
		});

		Test1((Object... data) -> System.out.println("Test2 - " + data[0]));

		Test2((Object... data) -> {
			System.out.println(data[0]);
			return "OK2";
		});
	}
}
