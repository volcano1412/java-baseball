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
	Set<Integer> numbers = new LinkedHashSet<Integer>();	// computer 수
	Set<Integer> inputNumbers = new LinkedHashSet<Integer>();
	int ballCount;
	int strikeCount;

	@BeforeEach
	void setInputValue() {
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		inputNumbers.add(4);
		inputNumbers.add(5);
		inputNumbers.add(6);
		ballCount = 0;
		strikeCount = 0;
	}

	@Test
	@DisplayName("번호생성")
	public void numberCreate() {
		Set<Integer> numbers = new Baseball().numberCreate();

		assertThat(numbers.size()).isEqualTo(numbers.size() + 1);
	}

	@DisplayName("입력 값 splite")
	@ParameterizedTest
	@ValueSource(strings = {"4 6 2"})
	void inputSpliteTest(String input) {
		Set<Integer> inputNum = new LinkedHashSet<Integer>();

		input = input.replaceAll(" ", "");

		for(int i = 0; i < input.length(); i++) {
			inputNum.add(Integer.parseInt(String.valueOf(input.charAt(i))));
		}

		assertThat(inputNum)
			.contains(4)
			.hasSize(inputNum.size() + 1);

	}





	@Test
	@DisplayName("정답체크 : 스트라이크")
	void strikeCheckTest() {

		Iterator iter1 = numbers.iterator();
		Iterator iter2 = inputNumbers.iterator();
		while (iter1.hasNext()) {
			compareStrikeTest((int)iter1.next(), (int)iter2.next());
		}
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

		int ballcnt = baseball.ballChk(numbers,inputNumbers);
		assertThat(ballcnt).isEqualTo("0");
	}

	@Test
	@DisplayName("볼 결과 테스트 : ball")
	void ballCountBTest() {
		int ballcnt = baseball.ballChk(numbers,inputNumbers);
		assertThat(ballcnt).isEqualTo("1");
	}

	@Test
	@DisplayName("스트라이크 결과 테스트 : ")
	void strikeCountTest() {
		int strikeCnt = baseball.strikeCheck(numbers,inputNumbers);
		assertThat(strikeCnt).isEqualTo("1");
	}

	@DisplayName("숫자체크 ")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "r", "0", "10"})
	void setContains(String input) {
		Boolean chk = baseball.isNum(input);
		assertThat(chk).isTrue();
	}

}