package domain;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

import view.ViewUI;
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


	public BallSet getBaseballNumber(String input) {
		BallSet inputNum = new BallSet();
		input = input.replaceAll(" ", "");
		for(int i = 0; i < input.length(); i++) {
			String num = String.valueOf(input.charAt(i));
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

	public BallSet getBaseballValidation(String input) {
		String valInput = input;
		Boolean valChk = false;
		while(true) {
			try {
				if(valInput.length() == 5) {
					throw new IllegalArgumentException("예외발생");
				}
				BallSet ballNum = getBaseballNumber(valInput);
				if (ballNum.getBalls().size() != 3) {
					throw new IllegalArgumentException("예외발생");
				}
				Iterator<Integer> iter = ballNum.getBalls().iterator();
				while (iter.hasNext()) {
					valChk = isNum(iter.next().toString());
					if (valChk == true) {
						throw new IllegalArgumentException("예외발생");
					}
				}
				return ballNum;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				ViewUI viewUI = new ViewUI();
				viewUI.baseballPrint(null);
				valInput = viewUI.userInput();
			}
		}
	}

	public Boolean isNum(String input) {
		String pattern = "^[1-9]$";
		boolean i = !Pattern.matches(pattern, input);
		return i;
	}

}
