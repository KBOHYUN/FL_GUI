package project6;


public class Test {

	public static void main(String[] args) {
		
		FriendManager fm=FriendManager.getInstance();
		fm.load(); //파일 읽어오기
		ShowFriendList sfl=new ShowFriendList(fm.showInfo()); //파일에서 읽어온 친구 정보를 GUI화면으로 실행
	}

}
