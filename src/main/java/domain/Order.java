package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
	public static final int MAX_MENU_COUNT = 99;
	public static final int INIT = 0;

	private final Map<Menu, Integer> order = new HashMap<>();

	public Order() {
		for (Menu menu : MenuRepository.getMenus()) {
			order.put(menu, INIT);
		}
	}

	public void add(Menu menu, int count) {
		validateCount(menu, count);
		order.put(menu, count);
	}

	private void validateCount(Menu menu, int count) {
		if (order.get(menu) + count > MAX_MENU_COUNT)
			throw new IllegalArgumentException("하나의 메뉴는 99개만 주문할 수 있습니다.");
	}

	public Map<Menu, Integer> getOrder() {
		return Collections.unmodifiableMap(order);
	}

	public int calculatePrice() {
		return order.entrySet().stream()
			.mapToInt(items -> items.getKey().getPrice() * items.getValue())
			.sum();
	}
}
