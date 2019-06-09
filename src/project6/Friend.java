package project6;

public class Friend {
	String Name;
	private String Group;
	private String PhoneNum;
	private String EmailAddress;
	private String Photo;
	
	Friend(){
		
	}
	
	//Friend의 각각의 정보가 들어왔을때의 Constructor
	Friend(String Name, String Group, String PhoneNum, String EmailAddress,String Photo){
		this.Name=Name;
		this.Group=Group;
		this.PhoneNum=PhoneNum;
		this.EmailAddress=EmailAddress;
		this.Photo=Photo;
	}
	
	//Group정보가 정수로 이루어져있는지 확인하는 메소드
	private boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	//Friend 정보를 출력하는 메소드
	void print() {
		//이메일 주소에 @가 들어있는지 확인
		if(!EmailAddress.contains("@")) {
			System.out.println("Illegal email address ; Skip the input line : "+Name+" : "+Group+" : "+PhoneNum+" : "+EmailAddress+" : "+Photo);
			return;
		}
		
		//Group Number가 정수인지 확인
		if(!isStringDouble(Group)) { 
			System.out.println("Illegal value -- "+Group+" ; Skip the input line : "+Name+" : "+Group+" : "+PhoneNum+" : "+EmailAddress+" : "+Photo);
			return;
		}
		
		else {
			System.out.println(Name+" : "+Group+" : "+PhoneNum+" : "+EmailAddress+" : "+Photo);
		}
		return;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public String getGroup() {
		return Group;
	}
	
	public void setGroup(String Group) {
		this.Group=Group;
	}
	
	public String getPhoneNum() {
		return PhoneNum;
	}
	
	public void setPhoneNum(String PhoneNum) {
		this.PhoneNum=PhoneNum;
	}
	
	public String getEmailAddress() {
		return EmailAddress;
	}
	
	public void setEmailAddress(String EmailAddress) {
		this.EmailAddress=EmailAddress;
	}
	
	public String getPhoto() {
		return Photo;
	}
	
	public void setPhoto(String Photo) {
		this.Photo=Photo;
	}
}
