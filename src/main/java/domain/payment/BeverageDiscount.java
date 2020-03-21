package domain.payment;

import domain.Order;

public class BeverageDiscount implements DiscountPolicy {
	@Override
	public int calculate(Order order) {
		if (order.getChickenCount() >= 3) {
			return (int)(order.getBeveragesPrice() * 0.5);
		}
		return 1;
	}
}
