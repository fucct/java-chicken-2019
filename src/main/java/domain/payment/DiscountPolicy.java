package domain.payment;

import domain.Order;

public interface DiscountPolicy {
	int calculate(Order order);
}
