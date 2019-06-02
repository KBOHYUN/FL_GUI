package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendListFile {
	private ArrayList<Friend> friendFile=new ArrayList<Friend>();
	FriendList fList=new FriendList();
	Scanner input;
	
	FriendListFile(){
		
	}
	
	public FriendList readFileToList(String fileName) {
		File file=new File(fileName);
		
		try {
			input=new Scanner(file);
			
			while(input.hasNextLine()) {
				String line=input.nextLine();
				if(line!=null) {
					if(!line.startsWith("//")) {
						fList.friendInfo(line);
					}
				}
			}
			
			input.close();
		}catch(FileNotFoundException fe) {
			System.out.println("Unknown File!");
		}
		
		friendFile=fList.getFriendArray();
		
		return fList;
	}
	
	/*public void save(String filename) {
		File file=new File(filename);
		
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(file));
			for(int i=0;i<fList.numFriends();i++) {
				oos.writeObject(friendFile.get(i));
				oos.flush();
			}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}finally {
			try {
				oos.close();
			}catch(IOException ee) {
				System.out.println(ee);
			}
		}
	}*/
}

