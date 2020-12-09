package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	@ValueSource(strings = {"4 6 2"})
	void inputSpliteTest(String input) {

		BallSet inputNum = baseball.getBaseballNumber(input);
		assertThat(inputNum.getBalls())
			.contains(4)
			.hasSize(inputNum.getBalls().size() + 1);

	}

	@ParameterizedTest
	@ValueSource(strings = {"4 5 6"})
	@DisplayName("볼 결과 테스트 : nothing")
	void ballCountNTest(String input) {

		BallSet userNum = baseball.getBaseballNumber(input);

		assertThat(baseball.ballChk(comNum, userNum)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"4 5 2"})
	@DisplayName("볼 결과 테스트 : 1b")
	void ballCountBTest(String input) {

		BallSet userNum = baseball.getBaseballNumber(input);

		assertThat(baseball.ballChk(comNum, userNum)).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(strings = {"3 5 2"})
	@DisplayName("스트라이크 결과 테스트 : nothing")
	void strikeCountNTest(String input) {
		BallSet userNum = baseball.getBaseballNumber(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 5 2", "6 8 3"})
	@DisplayName("스트라이크 결과 테스트 : 1s")
	void strikeCountSTest(String input) {
		BallSet userNum = baseball.getBaseballNumber(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1 2 3"})
	@DisplayName("스트라이크 결과 테스트 : 3s")
	void strikeCountTSTest(String input) {
		BallSet userNum = baseball.getBaseballNumber(input);

		assertThat(baseball.strikeCheck(comNum, userNum)).isEqualTo(0);
	}

	@DisplayName("숫자체크")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "r", "0", "10"})
	void setContains(String input) {
		Boolean chk = baseball.isNum(input);
		assertThat(chk).isTrue();
	}

	@ParameterizedTest
	@DisplayName("게임결과판단")
	@CsvSource(value = {"1:1"}, delimiter = ':')
	void gameResult(String ball, String strike) {
		int ballValue = Integer.parseInt(ball);
		int strikeValue = Integer.parseInt(strike);
		//	assertThat(Logic.gameResult(ballValue,strikeValue).getTextData()).isEqualTo("1 볼 1 스트라이");
	}
}