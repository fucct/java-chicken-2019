package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {

	@Test
	@DisplayName("수량이 99개를 초과한 경우 예외발생")
	void countTest() {
		assertThatThrownBy(() -> new Order(Menus.findMenuById("1"), 100))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("정상적으로 주문 가격을 계산하는지")
	void calculateOrderPrice() {
		assertThat(new Order(Menus.findMenuById("1"), 10).calculateOrderPrice()).isEqualTo(160000);
	}
}
