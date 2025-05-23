package sr.ice.server;

import Demo.A;
import Demo.Calc;
import Demo.NoInput;
import com.zeroc.Ice.Current;

public class CalcI implements Calc {
	private static final long serialVersionUID = -2448962912780867770L;
	long counter = 0;

	@Override
	public long add(int a, int b, Current __current) {
		System.out.println("ADD: a = " + a + ", b = " + b + ", result = " + (a + b));
		System.out.println(__current.id);

		if (a > 1000 || b > 1000) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		if (__current.ctx.values().size() > 0) {
			System.out.println("There are some properties in the context");
		}

		return a + b;
	}

	@Override
	public long subtract(int a, int b, Current __current) {
		System.out.println("SUB: a = " + a + ", b = " + b + ", result = " + (a - b));
		System.out.println(__current.id);
		if (a > 1000 || b > 1000) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		if (__current.ctx.values().size() > 0) {
			System.out.println("There are some properties in the context");
		}

		return a - b;
	}

	@Override
	public double avg(long[] numbers, Current current) throws NoInput {
		if (numbers.length == 0) {
			throw new NoInput();
		}
		double sum = 0;
		for(long number : numbers) {
			sum += number;
		}
		return sum / numbers.length;
	}


	@Override
	public /*synchronized*/ void op(A a1, short b1, Current current) {
		System.out.println("OP" + (++counter));
		try {
			Thread.sleep(500);
		} catch (java.lang.InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}