package domain;

import java.util.Arrays;

public enum PaymentType {
	CARD(1, 1),
	CASH(2, 0.95);

	private final int paymentType;
	private final double discountRate;

	PaymentType(int paymentType, double discountRate) {
		this.paymentType = paymentType;
		this.discountRate = discountRate;
	}

	public static PaymentType of(int sex) {
		return Arrays.stream(values()).filter(type -> type.paymentType == sex)
			.findAny()
			.orElseThrow(IllegalArgumentException::new);
	}

	public int calculate(int money) {
		return (int)(this.discountRate * money);
	}
}
