package project6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ShowFriendList extends JFrame implements ActionListener{
	private int friendNum;
	
	private Friend f= new Friend();
	FriendManager fm=FriendManager.getInstance();
	
	private ArrayList<Friend> friend=new ArrayList<Friend>();
	
	private JPanel infoP;
	private JPanel infoLabelP;
	
	private JCheckBox[] box=new JCheckBox[15];
	private ButtonGroup group=new ButtonGroup();
	
	private String[] names= {"1","2","3","4","5","6","7","8"};
	private JPanel buttonP;
	private JButton addB=new JButton("Add");
	private JButton deleteB=new JButton("Delete");
	private JButton modifyB=new JButton("Modify");
	private JButton saveB=new JButton("Save File");
	
	
	@SuppressWarnings("static-access")
	ShowFriendList(ArrayList<Friend> friend){
		this.friend.addAll(friend);
		
		this.friendNum=friend.size();
		Dimension dim=new Dimension(1000,400);
		JFrame frame=new JFrame("친구 목록");
		
		infoP=new JPanel();
		infoP.setLayout(new BoxLayout(infoP, BoxLayout.Y_AXIS));
		infoP.setLayout(new GridLayout(15,1));
		
		infoLabelP=new JPanel();
		infoLabelP.setLayout((new BoxLayout(infoLabelP, BoxLayout.X_AXIS)));
		infoLabelP.setLayout(new GridLayout(1,6));
		infoLabelP.add(new JLabel(" "));
		infoLabelP.add(new JLabel("이름"));
		infoLabelP.add(new JLabel("그룹"));
		infoLabelP.add(new JLabel("전화번호"));
		infoLabelP.add(new JLabel("Email"));
		infoLabelP.add(new JLabel("사진"));
		infoP.add(infoLabelP);
		
		
		for(int i=0;i<friend.size();i++) {
			
			JPanel infoContentP=new JPanel();
			infoContentP.setLayout(new GridLayout(1,6));
			box[i]=new JCheckBox(names[i]);
			group.add(box[i]);
			box[i].addItemListener(new SelectItemListener());
			infoContentP.add(box[i]);
			
			infoContentP.add(new JLabel(friend.get(i).getName()));
			infoContentP.add(new JTextField(friend.get(i).getGroup()));
			infoContentP.add(new JTextField(friend.get(i).getPhoneNum()));
			infoContentP.add(new JTextField(friend.get(i).getEmailAddress()));
			infoContentP.add(new JLabel(friend.get(i).getPhoto()));
			infoP.add(infoContentP);
		}
		
		
		
		buttonP=new JPanel();
		buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.Y_AXIS));
		buttonP.setLayout(new GridLayout(4,1));
	
		addB.addActionListener(this);
		deleteB.addActionListener(this);
		modifyB.addActionListener(this);
		saveB.addActionListener(this);
		
		buttonP.add(addB);
		buttonP.add(deleteB);
		buttonP.add(modifyB);
		buttonP.add(saveB);
		
		frame.setPreferredSize(dim);
		frame.add(infoP,BorderLayout.CENTER);
		frame.add(buttonP,BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addB)
			addAction();
		else if(e.getSource()==deleteB)
			deleteAction();
		else if(e.getSource()==modifyB)
			modifyAction();
		else if(e.getSource()==saveB)
			saveAction();
	}
	
	private void addAction() {
		FriendAdd fa=new FriendAdd();
	}
	
	private void deleteAction() {
		int i=friend.indexOf(f);
		fm.delete(i);
		ShowFriendList sfl=new ShowFriendList(fm.load());
	}
	private void modifyAction() {
		System.out.println("modify");
	}
	private void saveAction() {
		System.out.println("save");
	}
	
	
	class SelectItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {

			if(e.getStateChange()==ItemEvent.SELECTED) {
				for(int i=0;i<friendNum;i++) {
					if(e.getItem()==box[i]) {
						f=fm.search(i);
						break;
					}
				}
			}
		}		
	}
	
}
