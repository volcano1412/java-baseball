package domain;

import static org.assertj.core.api.Assertions.*;

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
	int ballCount;
	int strikeCount;

	@BeforeEach
	void setInputValue() {
		ballCount = 0;
		strikeCount = 0;
	}

	@Test
	@DisplayName("번호생성")
	public void numberCreateTest() {

		assertThat(baseball.numberCreate()).contains(3);
	}

	@DisplayName("입력 값 splite")
	@ParameterizedTest
	@ValueSource(strings = {"4 6 2"})
	void inputSpliteTest(String input) {

		Set<Integer> inputNum = baseball.getBaseballNumber(input);
		assertThat(inputNum)
			.contains(4)
			.hasSize(inputNum.size() + 1);

	}





	@Test
	@DisplayName("정답체크 : 스트라이크")
	void strikeCheckTest() {

		assertThat(strikeCount).isEqualTo("2");
	}

	void compareStrikeTest(int a, int b) {
		if (a == b) {
			strikeCount++;
		}
	}



	@ParameterizedTest
	@DisplayName("게임결과판단")
	@CsvSource(value = {"1:1"}, delimiter = ':')
	void gameResult(String ball, String strike) {
		int ballValue = Integer.parseInt(ball);
		int strikeValue = Integer.parseInt(strike);
	//	assertThat(Logic.gameResult(ballValue,strikeValue).getTextData()).isEqualTo("1 볼 1 스트라이");
	}


	//-------------------------------------------------------------

	@Test
	@DisplayName("볼 결과 테스트 : nothing")
	void ballCountNTest() {

		//assertThat(ballcnt).isEqualTo("0");
	}

	@Test
	@DisplayName("볼 결과 테스트 : ball")
	void ballCountBTest() {
		//assertThat(ballcnt).isEqualTo("1");
	}

	@Test
	@DisplayName("스트라이크 결과 테스트 : ")
	void strikeCountTest() {
		//int strikeCnt = baseball.strikeCheck(numbers,inputNumbers);
		//assertThat(strikeCnt).isEqualTo("1");
	}

	@DisplayName("숫자체크 ")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "r", "0", "10"})
	void setContains(String input) {
		Boolean chk = baseball.isNum(input);
		assertThat(chk).isTrue();
	}

}