package project6;

public class Friend {
	String Name;
	private String Group;
	private String PhoneNum;
	private String EmailAddress;
	private String Photo;
	
	Friend(){
		
	}
	
	//Friend�� ������ ������ ���������� Constructor
	Friend(String Name, String Group, String PhoneNum, String EmailAddress,String Photo){
		this.Name=Name;
		this.Group=Group;
		this.PhoneNum=PhoneNum;
		this.EmailAddress=EmailAddress;
		this.Photo=Photo;
	}
	
	//Group������ ������ �̷�����ִ��� Ȯ���ϴ� �޼ҵ�
	private boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	//Friend ������ ����ϴ� �޼ҵ�
	void print() {
		//�̸��� �ּҿ� @�� ����ִ��� Ȯ��
		if(!EmailAddress.contains("@")) {
			System.out.println("Illegal email address ; Skip the input line : "+Name+" : "+Group+" : "+PhoneNum+" : "+EmailAddress+" : "+Photo);
			return;
		}
		
		//Group Number�� �������� Ȯ��
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
