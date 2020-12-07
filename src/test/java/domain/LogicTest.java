package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LogicTest {

	@Test
	@DisplayName("번호생성")
	public void numberCreate() {
		Set<Integer> numbers = new HashSet<Integer>();
		for(;numbers.size() < 3;) {
			int num = (int)((Math.random() * 100) % 8 + 1);
			numbers.add(num);
		}
		assertThat(numbers.size())
			.isEqualTo(numbers.size() + 1);
	}


	@DisplayName("입력 값 splite")
	@ParameterizedTest
	@ValueSource(strings = {"4 6 2"})
	void inputSplite(String input) {
		String[] arrayInput = input.split(" ");
		int[] arrIntInput = new int[3];

		for(int i = 0; i < arrayInput.length; i++) {
			arrIntInput[i] = Integer.parseInt(arrayInput[i]);
		}

		assertThat(arrIntInput)
			.contains(4)
			.hasSize(arrIntInput.length + 1);

	}

	private int[] inputValue;		//화면에서 받은 값
	private int[] resultValue;		//정답 값


	@BeforeEach
	void setInputValue() {
		inputValue = new int[] {1, 2, 3};
		resultValue = new int[] {4, 5, 3};
	}
	int strikes = 0;
	int correctNumber = 0;

	@Test
	@DisplayName("정답체크 : 스트라이크")
	void strikeCheck() {
		for (int i = 0; i <= 2; i++) {
			if (inputValue[i] == resultValue[i]) {
				strikes++;
			}
		}
		assertThat(strikes).isEqualTo(2);
	}

	int count = 0;
	int strikeCount = 0;

	@Test
	@DisplayName("정답체크")
	void strikeChkTest() {
		List<String> numbers1 = new ArrayList<>();
		List<String> numbers2 = new ArrayList<>();

		numbers1.add("1");
		numbers1.add("2");
		numbers1.add("3");

		numbers2.add("5");
		numbers2.add("2");
		numbers2.add("7");

		for (int i = 0; i < 3; i++) {
			compareStrikeCountTest(numbers1.get(i),numbers2.get(i));
		}

		assertThat(strikeCount).isEqualTo(3);
	}

	void compareStrikeCountTest(String number1, String number2) {
		if (number1.equals(number2)) {
			strikeCount++;
		}
	}

	@Test
	@DisplayName("결과 출력")
	void resultPrintTest() {
		count = 2;			//맞춘 개수 결과
		strikeCount = 1;	//맞춘 스트라이크 결과
		int ballCount = count - strikeCount;
		String result = "";
		if (ballCount > 0) {

		}
	}
}