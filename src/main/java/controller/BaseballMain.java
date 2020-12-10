package controller;

import java.util.Set;

import domain.BallSet;
import domain.Baseball;
import view.ViewUI;
import domain.GameResult;

public class BaseballMain {
	private static Baseball baseball =  new Baseball();
	private static ViewUI viewUI = new ViewUI();

	public static void main(String[] args) {
		GameResult result = new GameResult();
		BallSet comNumbers = null;

		while (true) {
			//comNumbers가 null이면 컴퓨터번호생성
			comNumbers = baseball.comNumChk(comNumbers);

			//결과프린트
			viewUI.baseballPrint(result);

			//결과 3strike : 재시작? 종료?
			restartChk(result);

			//유저입력 값
			String input = getBaseballValidation();

			BallSet userNumbers = baseball.getBaseballSet(input);

			//비교
			result = baseball.gameResult(comNumbers, userNumbers);

			//스트라이크 3이면 comNum 초기화
			comNumbers = baseball.initComNum(comNumbers, result.getStrikeCount());

		}
	}

	public static void restartChk(GameResult result) {
		if (result.getStrikeCount() == 3) {
			baseball.gameExit();
			viewUI.baseballPrint(new GameResult());
		}
	}

	//유저 숫자 입력 Validation
	private static String getBaseballValidation() {
		String input;
		try {
			String inputValue = viewUI.userInput();
			input = baseball.getBaseballValidation(inputValue);
		} catch (IllegalArgumentException illegalArgumentException) {
			viewUI.baseballPrint(null);
			input = getBaseballValidation();
		}
		return input;
	}

	//재시작여부 입력 Validation
	public static String restartInput() {
		String inputValue;
		try {
			inputValue = viewUI.userInput();
			baseball.restartValidation(inputValue);
		} catch (IllegalArgumentException illegalArgumentException) {
			viewUI.baseballPrint(null);
			inputValue = restartInput();
		}
		return inputValue;
	}
}
