package shop.data;

import java.sql.Timestamp;

public class ShopRepleDto {
	private int idx;
	private int num;
	private int star;
	private String message;
	private Timestamp writeday;
	
	public ShopRepleDto() {
		// TODO Auto-generated constructor stub
	}

	public ShopRepleDto(int num, int star, String message) {
		super();
		this.num = num;
		this.star = star;
		this.message = message;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
}
