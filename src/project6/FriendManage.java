package project6;

import java.util.ArrayList;

public interface FriendManage {
	
	public void load();
	
	public ArrayList<Friend> add(Friend f);
	
	public Friend search(int num);
	
	public ArrayList<Friend> modify(Friend f,int num);
	
	public void delete(int num);
}
