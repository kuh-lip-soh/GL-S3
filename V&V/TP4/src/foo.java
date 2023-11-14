
public class foo {
	public static void foo (int y) {
		int x;
		x=0;
		while(y>100) {
			x= x+10;
			y=y-x;
		}
		if(y<90)
			System.out.println(x);
		else
			System.out.println(y);
	}
}
