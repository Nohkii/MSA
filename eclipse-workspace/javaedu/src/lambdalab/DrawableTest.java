package lambdalab;
import java.util.Random;

@FunctionalInterface
interface Drawable {
	void draw();
}

class Rect implements Drawable {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}

class Diamond implements Drawable {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		if (num == 0)
			output(() -> System.out.println("사각형을 그립니다."));
		else if (num == 1)
			output(() -> System.out.println("원을 그립니다."));
		else if (num == 2)
			output(() -> System.out.println("마름모를 그립니다."));
	}
	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}
