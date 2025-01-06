package day0106db;

public class ShopDto {
	private int idx;
	private String sangpum;
	private int su;
	private int danga;
	
	public ShopDto() {
		// TODO Auto-generated constructor stub
	}

	public ShopDto(String sangpum, int su, int danga) {
		super();
		this.sangpum = sangpum;
		this.su = su;
		this.danga = danga;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDanga() {
		return danga;
	}

	public void setDanga(int danga) {
		this.danga = danga;
	}
}
