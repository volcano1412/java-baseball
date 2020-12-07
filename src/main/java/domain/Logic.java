package domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import model.BaseballDto;

public class Logic {
	Set<Integer> numbers = new LinkedHashSet<Integer>();

	public BaseballDto logic(BaseballDto input) {
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
}
