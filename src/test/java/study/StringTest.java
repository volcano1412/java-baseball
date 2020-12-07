package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import model.StudyModel;

public class StringTest {

	@Test
	public void split() {
		//given
		String numberValue = "1,2";
		//when
		String[] numArr = numberValue.split(",");
		//then
		//assertThat(numArr).contains(new String[] {"1","3"});
		assertThat(numArr).containsExactly(new String[] {"1"});

	}

	@Test
	public void removeBracket() {
		//given
		String numberValue = "(1,2)";
		//when
		String value =  numberValue.substring(1,4);
		//then

		//assertThat(numArr).contains(new String[] {"1"});
		assertThat(value).contains("1,3");

	}

	@Test
	void a_few_simple_assertions() {
		assertThat("The Lord of the Rings").isNotNull()
			.startsWith("The")
			.contains("Lord")
			.endsWith("Rings");
	}

	@Test
	@DisplayName("charAt 메소드 활용 : 특정위치 문자")
	void charAtMethod (){
		//given
		String numberValue = "abc";
		//when
		String value =  numberValue.substring(1,4);
		//then

	}

	@Test
	public void list() {
		//given
		List<String> numberValue = new ArrayList<>(Arrays.asList(new String[] {"1", "2", "3"}));

		//when

		//then
		//assertThat(numberValue).containsExactly("1");
		assertThat(numberValue).containsExactly("2");

	}

	@Test
	public void containMap() {
		//given
		Map<String, Object> studyModelTestMap = new HashMap<>();
		List<StudyModel> personList = new ArrayList<>();
		personList.add(new StudyModel("20", "jin0", "jin0"));
		personList.add(new StudyModel("21", "jin1", "jin1"));
		personList.add(new StudyModel("22", "jin2", "jin2"));
		studyModelTestMap.put("list",personList);
		studyModelTestMap.put("cnt",personList.size());
		//when

		//then,.
		//assertThat(studyModelTestMap).containsKey("cnt");
		//assertThat(studyModelTestMap).containsValue(personList.get(1));
		//assertThat(studyModelTestMap).containsValue(new StudyModel("25", "jin0", "jin0"));
		//assertThat(studyModelTestMap.get("list")).
	}


	@Test
	public void charAt() {
		/*"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
		테스트를 구현한다.
		String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
		StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
			JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.*/
		//given
		String param = "abc";

		//when
		int index = param.length() + 1;

		//then
		/*assertThatThrownBy(() -> {
			param.charAt(index);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("Index: " + index + ", Size: " + param.length());
		*/
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				param.charAt(index);
			}).withMessageMatching("Index: " + index + ", Size: " + param.length());
	}

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
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

		numbers.add(10);
		numbers.add(54);
		numbers.add(20);
		// 10, 54, 20
		// 10, 20, 54

		Set<Integer> numbers2 = new HashSet<>();
		numbers2.add(4);
		numbers2.add(5);
		numbers2.add(2);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void csvTest(String input, boolean booleanValue) {

		assertThat(numbers.contains(input)).isEqualTo(booleanValue);
	}
}
