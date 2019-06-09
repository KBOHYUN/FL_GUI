package project6;

import java.util.ArrayList;

public class FriendManager {
	private ArrayList<Friend> friends;

	private FriendListFile flf=new FriendListFile();
	private FriendList fl=new FriendList();
	
	private int searchNum;
	
	private static FriendManager instance;
	
	//파일에서 읽어오기, 추가, 수정, 삭제, 파일에 저장하기를 실행할 ArrayList<Friend> 생성
	private FriendManager() {
		friends=new ArrayList<Friend>();
	}
	
	public static FriendManager getInstance() {
		if(instance==null)
			instance=new FriendManager();
		
		return instance;
	}
	
	public void load() {
		fl=flf.readFileToList();
		friends=fl.getFriendArray();
	}
	
	//친구 정보 ArrayList에 저장
	public void add(Friend p) {
		friends.add(p);
	}
	
	//FriendAdd에서 추가할 친구의 이름이 중복되는지 검사
	public boolean nameCheck(Friend f) {
		int checknum=friends.size();
		int i=0;
			for(i=0;i<checknum;i++) {
				if(f.getName().equals(friends.get(i).getName())) { 
					return false;
				}
			}
		return true;
	}
	
	public void search(int num) {
		this.searchNum=num;
	}
	
	public int searchReturn() {
		return searchNum;
	}
	
	public void modify(Friend f) {
		//TextField에서 수정된 Friend정보를 ArrayList에 update
		Friend p=new Friend();
		p=friends.get(searchNum);
		p.setName(f.Name);
		p.setGroup(f.getGroup());
		p.setPhoneNum(f.getPhoneNum());
		p.setEmailAddress(f.getEmailAddress());
		p.setPhoto(f.getPhoto());
		friends.set(searchNum, p);
		return;
	}
	
	public void delete() {
		//CheckBox에서 선택된 라인의 친구 정보 삭제
		friends.remove(searchNum);
		return;
	}
	
	public ArrayList<Friend> showInfo(){
		return friends;
	}
	
	public void save() {
		flf.writeListToFile(friends);
		
	}
}
