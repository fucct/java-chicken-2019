package domain;

public class Order {
	public static final int MAX_MENU_COUNT = 99;

	private final Menu menu;
	private final int menuCount;

	public Order(Menu menu, int menuCount) {
		validateMenuCount(menuCount);
		this.menu = menu;
		this.menuCount = menuCount;
	}

	private void validateMenuCount(int menuCount) {
		if (menuCount > MAX_MENU_COUNT) {
			throw new IllegalArgumentException("한 메뉴는 99개 까지만 주문하실 수 있습니다.");
		}
	}

	public int calculateOrderPrice() {
		return this.menu.getPrice() * menuCount;
	}
}
