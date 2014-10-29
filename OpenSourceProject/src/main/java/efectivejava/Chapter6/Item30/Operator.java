package efectivejava.Chapter6.Item30;

public enum Operator {
	ADD("+") {
		@Override
		public int apply(int a, int b) {
			return a + b;
		}
	},
	MINS("-") {
		@Override
		public int apply(int a, int b) {
			return a - b;
		}
	};

	String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	public abstract int apply(int a, int b);

	public static void main(String[] args) {
		int a = 11, b = 2;
		Operator o = Operator.ADD;
		int result = o.apply(a, b);
		System.out.println(result);
	}
}
