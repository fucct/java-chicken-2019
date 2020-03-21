package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuId {
	private static final Map<Integer, MenuId> menuId = new HashMap<>();
	private final int id;

	static {
		menuId.put(1, new MenuId("1"));
		menuId.put(2, new MenuId("2"));
		menuId.put(3, new MenuId("3"));
		menuId.put(4, new MenuId("4"));
		menuId.put(5, new MenuId("5"));
		menuId.put(6, new MenuId("6"));
		menuId.put(7, new MenuId("7"));
		menuId.put(8, new MenuId("8"));
		menuId.put(9, new MenuId("9"));
		menuId.put(10, new MenuId("10"));
		menuId.put(11, new MenuId("11"));
	}

	private MenuId(String id) {
		this.id = stringToInt(id);
	}

	public static MenuId of(String id) {
		try {
			containKey(id);
			return menuId.get(stringToInt(id));
		} catch (Exception e) {
			throw new IllegalArgumentException(String.format("%s 는 잘못된 아이디입니다.", id));
		}
	}

	private static void containKey(String id) {
		if (menuId.containsKey(menuId.get(stringToInt(id)))) {
			throw new IllegalArgumentException("잘못된 없는 아이디입니다.");
		}
	}

	private static int stringToInt(String id) {
		try {
			int parsedInt = Integer.parseInt(id);
			validate(parsedInt);
			return parsedInt;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format("%s 는 잘못된 값입니다", id));
		}
	}

	private static void validate(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("음수는 아이디로 사용할 수 없습니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuId menuId = (MenuId)o;
		return id == menuId.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
