package efectivejava.Chapter6.Item30;

// Enum type with constant-specific class bodies and data - Page 153

import java.util.*;

public enum Operation {
	PLUS("+") {
		@Override
		double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		@Override
		double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type - Page 154
	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
	static { // Initialize map from constant name to enum constant
		for (Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns Operation for string, or null if string is invalid
	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	// Test program to perform all operations on given operands
	public static void main(String[] args) {
		//		double x = Double.parseDouble(args[0]);
		//		double y = Double.parseDouble(args[1]);

		double x = Double.parseDouble("12.00");
		double y = Double.parseDouble("22.0");
		for (Operation op : Operation.values())
			System.out.printf("%f %s %f = %f%n",
					x, op, y, op.apply(x, y));
	}
}
