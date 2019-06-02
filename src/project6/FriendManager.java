package project6;

import java.util.ArrayList;

public class FriendManager {
	private ArrayList<Friend> friends;
	private FriendListFile flf=new FriendListFile();
	private FriendList fl=new FriendList();
	
	private static FriendManager instance;
	
	private FriendManager() {
		friends=new ArrayList<Friend>();
		
		fl=flf.readFileToList("./friendlist-norm.data");
	}
	
	public ArrayList<Friend> load() {
		friends=fl.getFriendArray();
		return friends;
	}
	
	public static FriendManager getInstance() {
		if(instance==null)
			instance=new FriendManager();
		
		return instance;
	}
	
	public void add(Friend p) {
		friends.add(p);
	}
	
	public Friend search(int num) {
		Friend f=friends.get(num);
		return f;
	}
	
	public ArrayList<Friend> modify(Friend f,int num) {
		Friend p=new Friend();
		p=friends.get(num);
		p.setName(f.Name);
		p.setGroup(f.getGroup());
		p.setPhoneNum(f.getPhoneNum());
		p.setEmailAddress(f.getEmailAddress());
		p.setPhoto(f.getPhoto());
		friends.set(num, p);
		return friends;
	}
	
	public void delete(int num) {
		friends.remove(num);
	}
}
