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
			BallSet userNumbers = getBaseballValidation();

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
	private static BallSet getBaseballValidation() {
		BallSet ballSet;
		try {
			String inputValue = viewUI.userInput();
			ballSet = baseball.getBaseball(inputValue);
		} catch (IllegalArgumentException illegalArgumentException) {
			viewUI.baseballPrint(null);
			ballSet = getBaseballValidation();
		}
		return ballSet;
	}

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
