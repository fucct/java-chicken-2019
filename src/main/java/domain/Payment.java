package domain;

public class Payment {
	private final Order order;
	private final DiscountPolicy discountPolicy;

	public Payment(Order order, DiscountPolicy discountPolicy) {
		this.order = order;
		this.discountPolicy = discountPolicy;
	}

	public int calculate() {
		int rawSum = order.calculatePrice();
		return rawSum - discountPolicy.calculate(order);
	}
}
