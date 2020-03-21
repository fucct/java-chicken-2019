package domain;

public class Menu {
	private final int id;
	private final String name;
	private final MenuType menuType;
	private final int price;

	public Menu(int id, String name, MenuType menuType, int price) {
		this.id = id;
		this.name = name;
		this.menuType = menuType;
		this.price = price;
	}
}
