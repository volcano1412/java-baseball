package model;

public class BaseballDto {
	String statusFlag;		//게임상태	0:처음, 1:진행중, 2:완료, 3:종료 4:정답입력오류 5:다시하기입력오류
	String numberData;		//입력받은 숫자
	String textData;		//출력할 메세지

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getNumberData() {
		return numberData;
	}

	public void setNumberData(String numberData) {
		this.numberData = numberData;
	}

	public String getTextData() {
		return textData;
	}

	public void setTextData(String textData) {
		this.textData = textData;
	}

	public BaseballDto(){};

	public BaseballDto(String statusFlag, String numberData, String textData) {
		this.statusFlag = statusFlag;
		this.numberData = numberData;
		this.textData = textData;
	}
}
