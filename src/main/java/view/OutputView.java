package view;

import java.util.List;

import domain.Menu;
import domain.Table;
import domain.TableRepository;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	public static void showTables() {
		List<Table> tables = TableRepository.getTables();
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void showFunctions() {
		System.out.println("##메인화면\n 1 - 주문등록 \n 2 - 결제하기 \n 프로그램 종료");
	}

	public static void printMenus(List<Menu> menus) {
		menus.forEach(System.out::println);
		System.out.println();
	}

	public static void printSuccess() {
		System.out.println("\n 등록이 완료되었습니다. 맛있게 드시길");
	}
}
