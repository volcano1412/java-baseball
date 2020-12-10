package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {
	Baseball baseball = new Baseball();
	BallSet comNum = new BallSet();

	@BeforeEach
	void setInputValue() {
		comNum = new BallSet(Arrays.asList(1, 2, 3));

	}

	@Test
	@DisplayName("번호생성")
	public void numberCreateTest() {

		assertThat(baseball.numberCreate().getBalls()).contains(3);
	}

	@DisplayName("입력 값 splite")
	@ParameterizedTest
	@ValueSource(strings = {"4 5 6"})
	void inputSpliteTest(String input) {

		BallSet inputNum = baseball.getBaseball(input);
		assertThat(inputNum.getBalls())
			.contains(4)
			.hasSize(inputNum.getBalls().size() + 1);

	}

	@ParameterizedTest
	@ValueSource(strings = {"4 5 6"})
	@DisplayName("볼 결과 테스트 : nothing")
	void ballCountNTest(String input) {

		BallSet userNum = baseball.getBaseball(input);

		assertThat(baseball.ballChk(comNum, userNum)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"4 5 2"})
	@DisplayName("볼 결과 테스트 : 1b")
	void ballCountBTest(String input) {

		BallSet userNum = baseball.getBaseball(input);

		assertThat(baseball.ballChk(comNum, userNum)).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(strings = {"3 5 2"})
	@DisplayName("스트라이크 결과 테스트 : nothing")
	void strikeCountNTest(String input) {
		BallSet userNum = baseball.getBaseball(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 5 2", "6 8 3"})
	@DisplayName("스트라이크 결과 테스트 : 1s")
	void strikeCountSTest(String input) {
		BallSet userNum = baseball.getBaseball(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 2 3"})
	@DisplayName("스트라이크 결과 테스트 : 3s")
	void strikeCountTSTest(String input) {
		BallSet userNum = baseball.getBaseball(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(0);
	}


	@DisplayName("validation처리")
	@ParameterizedTest
	@ValueSource(strings = {"1 2 234"})
	void validationChkTest(String input) {

		assertThatIllegalArgumentException().isThrownBy(() -> {
				baseball.getBaseball(input);
			}).withMessageMatching("예외발생");
	}

	@DisplayName("restart validation처리")
	@ParameterizedTest
	@ValueSource(strings = {"3"})
	void restartValidationTest(String input) {

		assertThatIllegalArgumentException().isThrownBy(() -> {
			String num = baseball.restartValidation(input);
		}).withMessageMatching("1또는 2 입력이 아님");
	}


}