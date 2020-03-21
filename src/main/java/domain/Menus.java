package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menus {
	private static final List<Menu> menus = new ArrayList<>();

	static {
		menus.add(new Menu(1, "후라이드", MenuType.CHICKEN, 16000));
		menus.add(new Menu(2, "양념", MenuType.CHICKEN, 17000));
		menus.add(new Menu(3, "간장", MenuType.CHICKEN, 17000));
		menus.add(new Menu(4, "뿌링클", MenuType.CHICKEN, 18000));
		menus.add(new Menu(5, "볼케이노", MenuType.CHICKEN, 18500));
		menus.add(new Menu(6, "호식이두마리", MenuType.CHICKEN, 21000));
		menus.add(new Menu(7, "디디치킨", MenuType.CHICKEN, 20000));
		menus.add(new Menu(8, "카일치킨", MenuType.CHICKEN, 19500));
		menus.add(new Menu(9, "콜라", MenuType.BEVERAGE, 2000));
		menus.add(new Menu(10, "사이다", MenuType.BEVERAGE, 2000));
		menus.add(new Menu(11, "기네스", MenuType.BEVERAGE, 8000));
	}

	public static List<Menu> getMenus() {
		return Collections.unmodifiableList(menus);
	}
}
