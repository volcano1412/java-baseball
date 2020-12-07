package controller;

import domain.Logic;
import model.BaseballDto;
import view.ViewUI;

public class baseballMain {
	public static void main(String[] args) {

		BaseballDto dto = new BaseballDto();
		ViewUI viewUI = new ViewUI();
		Logic logic = new Logic();

		//첫시작
		dto.setStatusFlag("0");
		dto.setTextData("숫자를입력해주세요 : ");

		while (dto.getStatusFlag() != "3") {
			dto = viewUI.baseballPrint(dto);
			dto = logic.logic(dto);
		}

	}
}
