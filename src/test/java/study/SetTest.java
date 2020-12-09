package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
	}

	@Test
	void setSeq() {
		Iterator iter = numbers.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	@Test
	public void setTest() {
		assertThat(numbers.size())
			.isEqualTo(numbers.size() + 1);

	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setContains(int input) {
		//assertTrue(input > 2);
		assertThat(numbers.contains(input)).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:false", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void csvTest(String input, boolean booleanValue) {

		assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(booleanValue);
	}

	@Test
	void groupAssertions() {
		int[] numbers = {0, 1, 2, 3, 4};
		assertAll(
			() -> assertEquals(numbers[0], 1),
			() -> assertEquals(numbers[3], 3),
			() -> assertEquals(numbers[4], 1)
		);
	}
	int count = 0;
	int strikeCount = 0;

	@Test
	void compareValue() {
		List<String> numbers1 = new ArrayList<>();
		List<String> numbers2 = new ArrayList<>();

		numbers1.add("1");
		numbers1.add("2");
		numbers1.add("3");

		numbers2.add("3");
		numbers2.add("4");
		numbers2.add("1");

		for (String num : numbers2) {

			compareCountTest(numbers1,num);
		}
		assertThat(count).isEqualTo(3);
	}

	void compareCountTest(List<String> numbers, String num) {
		if (numbers.contains(num)) {
			count++;
		}
	}
}
