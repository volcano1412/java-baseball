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
			//comNumbers가 null이면 생성
			comNumbers = baseball.comNumChk(comNumbers);

			viewUI.baseballPrint(result);				//결과프린트
			String inputValue = viewUI.userInput();		//입력 값

			BallSet userNumbers = baseball.getBaseballValidation(inputValue);


			result = baseball.gameResult(comNumbers, userNumbers);

			//스트라이크 3이면 comNum 초기화
			comNumbers = baseball.initComNum(comNumbers, result.getStrikeCount());

		}
	}
}
