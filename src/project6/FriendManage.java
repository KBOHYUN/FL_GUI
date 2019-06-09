package project6;

import java.util.ArrayList;


//��ü Ŭ�������� �ʿ��� �޼ҵ带 �� ���� �����ϴ� �������̽�
//FriendManager Ŭ������ �ִ� ArrayList<Friend>�ϳ��� ��� ������ ó���� �� �� �ִ�

public interface FriendManage {
	
	public void load(); //���� �о����
	
	public ArrayList<Friend> add(Friend f); //FriendAdd Ŭ�������� Add ��ư Ŭ����
	
	public boolean nameCheck(Friend f); //Add ��ư�� ������ ��, ������ ģ���� �̸��� �ߺ��Ǵ��� Ȯ��
	
	public void search(int num); // ShowFriendList���� CheckBox Ŭ����, ���õ� ������ ������ ����
	
	public int searchReturn(); //search���� ����� ������ return
	
	public void modify(Friend f); //ShowFriendList Ŭ�������� Modify ��ư Ŭ����
	
	public void delete(); //ShowFriendList Ŭ�������� Delete ��ư Ŭ����

	public void save(); //ShowFriendList Ŭ�������� Save File ��ư Ŭ����
	
	public ArrayList<Friend> showInfo(); //����� Friend�� ArrayList return
}
