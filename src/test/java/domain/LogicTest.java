package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
		Set<Integer> numbers = new LinkedHashSet<Integer>();
		while (numbers.size() < 3) {
			int num = (int)((Math.random() * 100) % 8 + 1);
			numbers.add(num);
		}
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

	Set<Integer> numbers = new LinkedHashSet<Integer>();
	Set<Integer> inputNumbers = new LinkedHashSet<Integer>();
	int ballCount;
	int strikeCount;
	int sameIndexCount;

	@BeforeEach
	void setInputValue() {
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		inputNumbers.add(4);
		inputNumbers.add(3);
		inputNumbers.add(1);
		ballCount = 0;
		strikeCount = 0;
		sameIndexCount = 0;
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

	@Test
	@DisplayName("정답체크 : 볼")
	void ballChkTest() {
		Iterator iter1 = numbers.iterator();
		for (int i = 0; iter1.hasNext(); i++) {
			ballChkTest((int)iter1.next(), inputNumbers, i);
		}

		assertThat(ballCount).isEqualTo(3);
	}

	void ballChkTest(int number1, Set<Integer> number2, int i) {
		Iterator iter2 = inputNumbers.iterator();
		for (int j = 0; iter2.hasNext(); j++) {
			indexCompareTest(number1, (int)iter2.next(), i, j);
		}
	}

	void indexCompareTest(int a, int b, int i, int j) {
		if (i != j) {
			compareballChkTest(a, b);
		}
	}

	void compareballChkTest(int a, int b) {
		if (a == b) {
			ballCount++;
		}
	}


}