package project6;


public class Test {

	public static void main(String[] args) {
		
		FriendManager fm=FriendManager.getInstance();
		fm.load(); //���� �о����
		ShowFriendList sfl=new ShowFriendList(fm.showInfo()); //���Ͽ��� �о�� ģ�� ������ GUIȭ������ ����
	}

}
