package domain;

import java.util.Iterator;
import java.util.regex.Pattern;

import controller.BaseballMain;
import vo.Constants;

public class Baseball {
	private int ballCount;
	private int strikeCount;


	//번호 생성
	public BallSet numberCreate() {
		BallSet tempSet = new BallSet();
		while (tempSet.getBalls().size() < 3) {
			int num = (int)((Math.random() * 100) % 8 + 1);
			tempSet.getBalls().add(num);
		}

		return tempSet;
	}
	public BallSet comNumChk(BallSet comNumbers) {
		if (comNumbers == null) {
			return numberCreate();
		}
		return comNumbers;
	}


	public BallSet getBaseballNumber(String[] inputArr) {
		BallSet inputNum = new BallSet();
		for(int i = 0; i < inputArr.length; i++) {
			String num = inputArr[i];
			inputNum.getBalls().add(Integer.parseInt(num));
		}
		return inputNum;
	}


	//정답체크 스트라이크
	public int strikeCheck(BallSet numbers, BallSet inputNumbers) {
		strikeCount = 0;
		Iterator iter1 = numbers.getBalls().iterator();
		Iterator iter2 = inputNumbers.getBalls().iterator();
		while (iter1.hasNext()) {
			compareStrike((int)iter1.next(), (int)iter2.next());
		}
		return strikeCount;
	}

	void compareStrike(int a, int b) {
		if (a == b) {
			strikeCount++;
		}
	}

	//정답체크 볼
	public int ballChk(BallSet numbers, BallSet inputNumbers) {
		ballCount = 0;
		Iterator iter1 = numbers.getBalls().iterator();
		for (int i = 0; iter1.hasNext(); i++) {
			ballChk((int)iter1.next(), inputNumbers, i);
		}
		return ballCount;
	}

	void ballChk(int number1, BallSet number2, int i) {
		Iterator iter2 = number2.getBalls().iterator();
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

	public GameResult gameResult(BallSet comNum, BallSet userNum) {
		GameResult result = new GameResult();
		result.setBallCount(ballChk(comNum, userNum));
		result.setStrikeCount(strikeCheck(comNum, userNum));
		return result;
	}

	public BallSet initComNum(BallSet comNumbers, int strikeCount) {
		if (strikeCount == Constants.MAX_NUMBER_SIZE) {
			return null;
		}
		return comNumbers;
	}

	public BallSet getBaseball(String input) throws IllegalArgumentException {

		String[] inputArr = input.split(" ");

		if (inputArr.length != 3) {
			throw new IllegalArgumentException("입력 형태 장애(데이터 사이에 스페이스바 2개 아님)");
		}

		// adasd 2 3
		if (isNumber(inputArr)) {
			throw new IllegalArgumentException("숫자입력이 아님");
		}

		BallSet ballset = getBaseballNumber(inputArr);

		// 1 2 2 // 중복된 수를 입력함
		if (isDulicate(ballset)) {
			throw new IllegalArgumentException("숫자입력이 3개가 아님");
		}
		return ballset;
	}

	private boolean isDulicate(BallSet ballSet) {
		if (ballSet.getBalls().size() == 3) {
			return false;
		}
		return true;
	}

	public boolean isNumber(String[] inputArr) {

		try {
			for (String str : inputArr) {

				Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {

			return true;
		}

		return false;
	}

	public String restartValidation(String input) throws IllegalArgumentException {
		String regex = "^[1-2]$";
		Boolean match = Pattern.matches(regex, input);
		if (!match) {
			throw new IllegalArgumentException("1또는 2 입력이 아님");
		}
		return input;
	}

	public void gameExit() {
		BaseballMain main = new BaseballMain();
		if (main.restartInput().equals("2")) {
			System.exit(0);
		}
	}
}
