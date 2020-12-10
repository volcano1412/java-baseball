package controller;

import java.util.Set;

import domain.BallSet;
import domain.Baseball;
import view.ViewUI;
import domain.GameResult;

public class BaseballMain {

	public static void main(String[] args) {
		Baseball baseball =  new Baseball();
		ViewUI viewUI = new ViewUI();
		GameResult result = new GameResult();
		BallSet comNumbers = null;

		while (true) {
			//comNumbers가 null이면 컴퓨터번호생성
			comNumbers = baseball.comNumChk(comNumbers);

			//결과프린트
			viewUI.baseballPrint(result);

			//재시작? 종료?


			//입력 값
			BallSet userNumbers = getBaseballValidation();

			//비교
			result = baseball.gameResult(comNumbers, userNumbers);

			//스트라이크 3이면 comNum 초기화
			comNumbers = baseball.initComNum(comNumbers, result.getStrikeCount());

		}
	}

	private static BallSet getBaseballValidation() {
		Baseball baseball =  new Baseball();
		ViewUI viewUI = new ViewUI();
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

}
