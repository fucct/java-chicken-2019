package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenusTest {
	@Test
	@DisplayName("생성된 전체 메뉴는 변경이 불가능하다.")
	void unmodifiableTest() {
		List<Menu> menus = Menus.getMenus();
		assertThatThrownBy(() -> menus.remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("생성된 전체 메뉴는 추가가 불가능하다.")
	void unmodifiableAddTest() {
		List<Menu> menus = Menus.getMenus();
		assertThatThrownBy(() -> menus.add(new Menu(12, "new Chicken", MenuType.CHICKEN, 10000)))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("11가지의 메뉴가 생성된다.")
	void sizeTest() {
		List<Menu> menus = Menus.getMenus();
		assertThat(menus).hasSize(11);
	}
}