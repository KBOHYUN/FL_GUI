package project6;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendListFile {
	FriendList fList=new FriendList();
	
	FriendListFile(){
		
	}
	
	//���Ͽ��� ������ �о����
	public FriendList readFileToList() {
		
		File file=new File("./friendlist-norm.data");
		Scanner input;
		
		try {
			input=new Scanner(file);
			
			while(input.hasNextLine()) {
				String line=input.nextLine();
				if(line!=null) {
					if(!line.startsWith("//")||friendInfo(line)==true){
						fList.friendInfo(line);
					}
				}
			}
			input.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println("Unknown File!"); //������ ã�� ������ �� �����޼���
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return fList;
	}
	
	//���� Line�� ģ�� ���� 5������ ����� �ԷµǾ��ִ��� Ȯ��
	boolean friendInfo(String line) { 
		String[] splitLine=line.split(":", 5);
		if(splitLine.length==5&&line!=null) {
			return true;
		}
		else {
			return false;
		}
	}
		
	//ArrayList�� ����� ������ ���Ͽ� ����
	public void writeListToFile(ArrayList<Friend> friend) {

		ObjectOutputStream oout=null;
		
		try {
			oout=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("./friendlist-norm.data")));
			
			int num=friend.size();
			
			for(int i=0;i<num;i++) {
				//friend�� �ִ� ģ�� ������ �׸񺰷� String���·� ����
				String sName=friend.get(i).getName();
				String sGroup=friend.get(i).getGroup();
				String sPhone=friend.get(i).getPhoneNum();
				String semail=friend.get(i).getEmailAddress();
				String sphoto=friend.get(i).getPhoto();
				
				//���Ͽ��� ���� ���� �������� �ٲپ� �����ϱ�
				String saveline="\r\n".concat(sName).concat(" : ").concat(sGroup).concat(" : ").concat(sPhone).concat(" : ").concat(semail).concat(" : ").concat(sphoto).concat(" ").concat("\r\n");
				oout.writeObject(saveline);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				oout.close();
			}catch(IOException e) {
				System.out.println("IO Exception!");
			}
		}
		
	}
}

