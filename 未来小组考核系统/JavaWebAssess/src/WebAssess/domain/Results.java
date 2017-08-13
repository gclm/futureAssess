package WebAssess.domain;

public class Results {

	private String username;
	private String NO1;
	private String NO2;
	private String NO3;
	private String NO4;
	private String NO5;
	private String NO6;
	private String NO7;

	public Results() {
	}

	public Results(String username, String NO1, String NO2, String NO3, String NO4, String NO5, String NO6,
			String NO7) {
		this.username = username;
		this.NO1 = NO1;
		this.NO2 = NO2;
		this.NO3 = NO3;
		this.NO4 = NO4;
		this.NO5 = NO5;
		this.NO6 = NO6;
		this.NO7 = NO7;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNO1() {
		return NO1;
	}

	public void setNO1(String nO1) {
		NO1 = nO1;
	}

	public String getNO2() {
		return NO2;
	}

	public void setNO2(String nO2) {
		NO2 = nO2;
	}

	public String getNO3() {
		return NO3;
	}

	public void setNO3(String nO3) {
		NO3 = nO3;
	}

	public String getNO4() {
		return NO4;
	}

	public void setNO4(String nO4) {
		NO4 = nO4;
	}

	public String getNO5() {
		return NO5;
	}

	public void setNO5(String nO5) {
		NO5 = nO5;
	}

	public String getNO6() {
		return NO6;
	}

	public void setNO6(String nO6) {
		NO6 = nO6;
	}

	public String getNO7() {
		return NO7;
	}

	public void setNO7(String nO7) {
		NO7 = nO7;
	}
}
