package sr.thrift.server;

import org.apache.thrift.TException;
import sr.gen.thrift.Calculator;
import sr.gen.thrift.CharInt;

import java.util.List;

public class CalculatorHandler implements Calculator.Iface {

	int id;

	public CalculatorHandler(int id) {
		this.id = id;
	}

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalcHandler#" + id + " add(" + n1 + "," + n2 + ")");
		if(n1 > 1000 || n2 > 1000) { 
			try { Thread.sleep(6000); } catch(java.lang.InterruptedException ex) { }
			System.out.println("DONE");
		}
		return n1 + n2;
	}

	@Override
	public int subtract(int num1, int num2) throws TException {
		System.out.println("CalcHandler#" + id + " sub(" + num1 + "," + num2 + ")");
		if(num1 > 1000 || num2 > 1000) {
			try { Thread.sleep(6000); } catch(java.lang.InterruptedException ex) { }
			System.out.println("DONE");
		}
		return num1 - num2;
	}
	@Override
	public String fun(List<CharInt> pairs) throws TException {
		System.out.println("CalcHandler#" + id + " fun(" + pairs + ")");
		StringBuilder output = new StringBuilder();
		for (CharInt pair : pairs) {
			String ch = pair.getChar();
			int num = pair.getNum();
			output.append(String.valueOf(ch).repeat(Math.max(0, num)));
		}
		System.out.println("DONE");
		return output.toString();
	}

}

