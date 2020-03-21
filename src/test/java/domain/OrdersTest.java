package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
	@Test
	@DisplayName("정상적으로 메뉴추가가 되는지")
	void add() {
		Order order = new Order();
		Menu menuById = Menus.findMenuById("1");
		order.add(menuById, 10);
		assertThat(order.getOrder().get(menuById)).isEqualTo(10);
	}

	@Test
	@DisplayName("99개 이상을 추가하는 경우 예외가 발생하는지")
	void addOverRange() {
		Order order = new Order();
		Menu menuById = Menus.findMenuById("1");
		order.add(menuById, 50);

		assertThatThrownBy(() -> order.add(menuById, 50))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("하나의 메뉴는 99개만 주문할 수 있습니다.");
	}

	@Test
	@DisplayName("가격을 정상적으로 계산하는지")
	void calculateTest() {
		Order order = new Order();
		order.add(Menus.findMenuById("1"), 10);
		order.add(Menus.findMenuById("10"), 10);

		assertThat(order.calculatePrice()).isEqualTo(180000);
	}
}
