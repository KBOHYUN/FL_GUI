package project6;

import java.util.ArrayList;

public class FriendList {
	
	private ArrayList<Friend> friend=new ArrayList<Friend>();
	
	int num=0;
	int i,j;
	
	FriendList(){
		
	}
	
	//FriednListFile클래스에서 file의 한 줄을 받아서  항목별로 나누고 Friend 클래스로 넘겨주는 메소드
	void friendInfo(String line) { 
		String[] splitLine=line.split(":", 5);
		if(splitLine.length==5&&line!=null) {
			Friend f=new Friend();
			//각각의 정보에 대해 공백 제거 후 저장
			f=new Friend(splitLine[0].trim(),splitLine[1].trim(),splitLine[2].trim(),splitLine[3].trim(),splitLine[4].trim());
			friend.add(f);
			num++;
		}
		else {
			checkInputLine(line);
			return;
		}
	}
	
	//input line에 있는 친구 정보 수가 정확하지 않으면 에러메세지
	void checkInputLine(String s) {
		//System.out.println("Irregular input line"+ "! : "+s);
		return;
	}
	
	
	//현재 Friend Number return
	public int numFriends() {
		return num;
	}
	
	//이름 겹치는 경우 확인
	boolean nameCheck(int i) {
		if(i+1<num) {
			for(int j=i+1;j<num;j++) {
				if(friend.get(i).equals(friend.get(j))) { 
					return false;
				}
			}
		}
		return true;
	}
	
	
	public Friend getFriend(int i) {	
		//겹치는 이름이 있는지 확인 
		if(!nameCheck(i)) { 
			System.out.println("Name Conflict!");
		}

		return friend.get(i);
	}
	
	//현재 FriendList클래스에 저장되어있는 friend ArrayList return 메소드
	public ArrayList<Friend> getFriendArray(){
		return friend;
	}
	
	//friend정보를 받아 ArrayList에 저장하는 메소드
	public void setFriendArray(ArrayList<Friend> friend) {
		this.friend=friend;
	}
}
