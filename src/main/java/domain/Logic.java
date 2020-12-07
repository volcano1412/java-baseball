package domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import model.BaseballDto;

public class Logic {
	Set<Integer> numbers = new LinkedHashSet<Integer>();
	Set<Integer> inputNum = new LinkedHashSet<Integer>();

	public BaseballDto statusSort(BaseballDto input) {
		BaseballDto output = new BaseballDto();

		if (input.getStatusFlag() == "0") {
			numberCreate();
		}


		return output;
	}

	//번호 생성
	public void numberCreate() {
		while (numbers.size() < 3) {
			int num = (int)((Math.random() * 100) % 8 + 1);
			numbers.add(num);
		}
	}

	//문자열 splite
	public void inputSplite(String input) {

		input = input.replaceAll(" ", "");

		for(int i = 0; i < input.length(); i++) {
			inputNum.add(Integer.parseInt(String.valueOf(input.charAt(i))));
		}
	}
}
