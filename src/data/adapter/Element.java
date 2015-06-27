package data.adapter;

public class Element {

	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmValue() {
		return mValue;
	}
	public void setmValue(String mValue) {
		this.mValue = mValue;
	}
		
	public Element(String mName,String mValue) {
		super();
		this.mName = mName;
		this.mValue = mValue;
	}
	
	public Element(String mName) {
		super();
		this.mName = mName;
		this.mValue = "12345";
	}
	private String mValue;
	private String mName;
}
