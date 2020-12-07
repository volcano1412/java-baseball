package view;

import java.util.Scanner;

import model.BaseballDto;

public class ViewUI {
	Scanner sc = new Scanner(System.in);

	public BaseballDto baseballPrint(BaseballDto dto) {
		BaseballDto inputDto = new BaseballDto();

		//처음
		if (dto.getStatusFlag() == "0") {
			System.out.println(dto.getTextData());

			inputDto.setStatusFlag("1");
			inputDto.setNumberData(sc.next());
		}
		//결과 - 틀림
		if (dto.getStatusFlag() == "1") {
			System.out.println(dto.getTextData());

			inputDto.setStatusFlag("1");
			inputDto.setNumberData(sc.next());
		}

		//결과 - 정답
		if (dto.getStatusFlag() == "2") {
			System.out.println(dto.getTextData());

			inputDto.setStatusFlag("2");
			inputDto.setNumberData(sc.next());
		}

		//입력오류 - 정답
		if (dto.getStatusFlag() == "4") {
			System.out.println(dto.getTextData());

			inputDto.setStatusFlag("1");
			inputDto.setNumberData(sc.next());
		}

		//입력오류 - 다시하기
		if (dto.getStatusFlag() == "5") {
			System.out.println(dto.getTextData());

			inputDto.setStatusFlag("2");
			inputDto.setNumberData(sc.next());
		}

		return inputDto;
	}


}
