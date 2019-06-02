package project6;

public class Test {

	public static void main(String[] args) {
		
		//File file=new File("./friendlist-norm.data");
		//FriendListFile flf=new FriendListFile();
		//FriendList fl=new FriendList();

		
		//fl=flf.readFileToList(file.getName());
		
		//ShowFriendList sfl=new ShowFriendList(fl);
		
		FriendManager fm=FriendManager.getInstance();
		ShowFriendList sfl=new ShowFriendList(fm.load());
	}

}
