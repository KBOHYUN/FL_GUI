package project6;

import java.util.ArrayList;

public class FriendList {
	
	private ArrayList<Friend> friend=new ArrayList<Friend>();
	
	int num=0;
	int i,j;
	
	FriendList(){
		
	}
	
	//FriednListFileŬ�������� file�� �� ���� �޾Ƽ�  �׸񺰷� ������ Friend Ŭ������ �Ѱ��ִ� �޼ҵ�
	void friendInfo(String line) { 
		String[] splitLine=line.split(":", 5);
		if(splitLine.length==5&&line!=null) {
			Friend f=new Friend();
			//������ ������ ���� ���� ���� �� ����
			f=new Friend(splitLine[0].trim(),splitLine[1].trim(),splitLine[2].trim(),splitLine[3].trim(),splitLine[4].trim());
			friend.add(f);
			num++;
		}
		else {
			checkInputLine(line);
			return;
		}
	}
	
	void friendInfo2(String name, String group, String phone, String email, String photo) {
		Friend f=new Friend();
		f=new Friend(name, group, phone, email, photo);
		friend.add(f);
		num++;
	}
	
	//input line�� �ִ� ģ�� ���� ���� ��Ȯ���� ������ �����޼���
	void checkInputLine(String s) {
		System.out.println("Irregular input line!  ; Skip the input line : "+s);
		return;
	}
	
	
	//���� Friend Number return
	public int numFriends() {
		return num;
	}
	
	//�̸� ��ġ�� ��� Ȯ��
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
		//��ġ�� �̸��� �ִ��� Ȯ�� �� Friend ���� �Ѱ��ֱ�
		if(!nameCheck(i)) { 
			System.out.println("Name Conflict!");
		}

		return friend.get(i);
	}
	
	public ArrayList<Friend> getFriendArray(){
	
		return friend;
	}
	
	public void setFriendArray(ArrayList<Friend> friend) {
		this.friend=friend;
	}
}