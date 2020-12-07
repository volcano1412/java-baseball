package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class logicTest {

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

	@Test
	@DisplayName("정답체크 : 맞춘 총 개수")
	void compareCheck() {

	}
}