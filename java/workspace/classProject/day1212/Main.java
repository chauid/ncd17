package day1212;

public class Main {
	public static void main(String[] args) {
		int a, b, m, n;
		a = b = 5;
		m = ++a;
		n = b++;
		System.out.printf("a=%d, b=%d, m=%d, n=%d\n", a, b, m, n);

		a = b = m = n = 5;
		m += a++ * ++b;
		System.out.printf("a=%d, b=%d, m=%d, n=%d\n", a, b, m, n);

		a = b = m = n = 5;
		n = a++ + ++b;
		System.out.printf("a=%d, b=%d, m=%d, n=%d\n", a, b, m, n);

		a = 10;
		b = 4;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println((double)a/b);
		System.out.println(a%b);
	}
}
