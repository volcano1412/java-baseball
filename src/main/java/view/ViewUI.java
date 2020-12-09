package view;

import java.util.Scanner;

import vo.Constants;
import domain.GameResult;

public class ViewUI {

	private String inputNum = "\n숫자를 입력해 주세요 : \n";
	private String restart = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
					+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
	private String endGame = "\n게임을 종료합니다.";
	private String error= "\n입력 오류입니다 다시 입력해주세요.\n";
	private int ball;
	private int strike;

	private Scanner sc = new Scanner(System.in);

	public void baseballPrint(GameResult result) {
		//예외
		if (result == null) {
			System.out.println(error);
			return;
		}
		ball = result.getBallCount();
		strike = result.getStrikeCount();

		// 3 strike
		if (strike == Constants.MAX_NUMBER_SIZE) {
			System.out.println(restart);
			return;
		}
		// start
		if (strike == 0 && ball == 0) {
			System.out.println(inputNum);
			return;
		}
		// ball만
		if (strike == 0 && ball > 0) {
			System.out.println(ball + "볼" + inputNum);
			return;
		}
		// strike만
		if (strike > 0 && ball == 0) {
			System.out.println(strike + "스트라이크" + inputNum);
			return;
		}
		// strike ball 둘다
		System.out.println(ball + "볼 " + strike + "스트라이크" + inputNum);

	}

	public String userInput() {
		String input = sc.nextLine();
		return input;
	}

}
