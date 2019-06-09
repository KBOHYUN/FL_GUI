package project6;

import java.util.ArrayList;


//전체 클래스에서 필요한 메소드를 한 번에 관리하는 인터페이스
//FriendManager 클래스에 있는 ArrayList<Friend>하나에 모든 데이터 처리를 할 수 있다

public interface FriendManage {
	
	public void load(); //파일 읽어오기
	
	public ArrayList<Friend> add(Friend f); //FriendAdd 클래스에서 Add 버튼 클릭시
	
	public boolean nameCheck(Friend f); //Add 버튼을 눌렀을 때, 저장할 친구의 이름이 중복되는지 확인
	
	public void search(int num); // ShowFriendList에서 CheckBox 클릭시, 선택된 라인의 정수값 저장
	
	public int searchReturn(); //search에서 저장된 정수값 return
	
	public void modify(Friend f); //ShowFriendList 클래스에서 Modify 버튼 클릭시
	
	public void delete(); //ShowFriendList 클래스에서 Delete 버튼 클릭시

	public void save(); //ShowFriendList 클래스에서 Save File 버튼 클릭시
	
	public ArrayList<Friend> showInfo(); //저장된 Friend의 ArrayList return
}
