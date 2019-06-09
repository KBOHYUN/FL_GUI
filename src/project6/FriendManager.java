package project6;

import java.util.ArrayList;

public class FriendManager {
	private ArrayList<Friend> friends;

	private FriendListFile flf=new FriendListFile();
	private FriendList fl=new FriendList();
	
	private int searchNum;
	
	private static FriendManager instance;
	
	//���Ͽ��� �о����, �߰�, ����, ����, ���Ͽ� �����ϱ⸦ ������ ArrayList<Friend> ����
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
	
	//ģ�� ���� ArrayList�� ����
	public void add(Friend p) {
		friends.add(p);
	}
	
	//FriendAdd���� �߰��� ģ���� �̸��� �ߺ��Ǵ��� �˻�
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
		//TextField���� ������ Friend������ ArrayList�� update
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
		//CheckBox���� ���õ� ������ ģ�� ���� ����
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
