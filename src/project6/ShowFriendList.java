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
	
	FriendManager fm=FriendManager.getInstance();
	
	private ArrayList<Friend> friend=new ArrayList<Friend>();
	
	private JPanel infoP; //정보가 들어갈 전체 패널 생성
	private JPanel infoLabelP; //상단의 목록 패널
	
	//체크박스 생성
	private JCheckBox[] box=new JCheckBox[15];
	private ButtonGroup group=new ButtonGroup();
	//체크박스 이름 초기화 -> 수가 많아졌을 때의 해결방안 찾기
	private String[] names= {"1","2","3","4","5","6",
			"7","8","9","10","11","12","13","14","15"
	};
	
	//TextField의 내용을 담을 array
	private String[] nameT=new String[15];
	private String[] groupT=new String[15];
	private String[] phoneT=new String[15];
	private String[] emailT=new String[15];
	
	//TextField 생성
	private JTextField nameTf[]=new JTextField[15];
	private JTextField groupTf[]=new JTextField[15];
	private JTextField phoneTf[]=new JTextField[15];
	private JTextField emailTf[]=new JTextField[15];
	
	//Button 생성
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
		
		//상단 목록 패널 생성
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
		
		//한 줄마다 친구 정보 추가
		for(int i=0;i<friend.size();i++) {
			JPanel infoContentP=new JPanel();
			infoContentP.setLayout(new GridLayout(1,6));
			
			//체크박스 생성
			box[i]=new JCheckBox(names[i]);
			group.add(box[i]);
			box[i].addItemListener(new SelectItemListener());
			infoContentP.add(box[i]);
			
			//이름 TextField 생성
			nameT[i]=friend.get(i).getName();
			nameTf[i]=new JTextField(10);
			nameTf[i].setText(nameT[i]);
			infoContentP.add(nameTf[i]);
			
			//그룹 TextField 생성
			groupT[i]=friend.get(i).getGroup();
			groupTf[i]=new JTextField(10);
			groupTf[i].setText(groupT[i]);
			infoContentP.add(groupTf[i]);
			
			//전화번호 TextField 생성
			phoneT[i]=friend.get(i).getPhoneNum();
			phoneTf[i]=new JTextField(30);
			phoneTf[i].setText(phoneT[i]);
			infoContentP.add(phoneTf[i]);
			
			//이메일 TextField 생성
			emailT[i]=friend.get(i).getEmailAddress();
			emailTf[i]=new JTextField(30);
			emailTf[i].setText(emailT[i]);
			infoContentP.add(emailTf[i]);
			
			//사진 Label 생성 -> 수정 불가능
			infoContentP.add(new JLabel(friend.get(i).getPhoto()));
			infoP.add(infoContentP);
		}
		
		//버튼 패널 생성
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
		if(e.getSource()==addB) //Add 버튼 클릭시
			addAction();
		else if(e.getSource()==deleteB) //Delete 버튼 클릭시
			deleteAction();
		else if(e.getSource()==modifyB) //Modify 버튼 클릭시
			modifyAction();
		else if(e.getSource()==saveB) //Save File 버튼 클릭시
			saveAction();
	}
	
	private void addAction() {
		new FriendAdd(); //FriendAdd 클래스 실행
	}
	
	private void deleteAction() {
		fm.delete(); //FriendManager에 있는 delete 메소드 실행
		ShowFriendList sfl=new ShowFriendList(fm.showInfo()); //다시 ShowFrienList클래스 실행하여 화면 update -> 다시 실행하지 않아도 화면 update할 수 있는 방법 찾기
	}
	
	private void modifyAction() {
		int modifyNum=fm.searchReturn();
		//TextField에 있는 값 불러와 friend ArrayList에 저장
		friend.get(modifyNum).setName(nameTf[modifyNum].getText());
		friend.get(modifyNum).setGroup(groupTf[modifyNum].getText());
		friend.get(modifyNum).setPhoneNum(phoneTf[modifyNum].getText());
		friend.get(modifyNum).setEmailAddress(emailTf[modifyNum].getText());
		
		fm.modify(friend.get(modifyNum)); //FriendManager에 있는 modify 메소드 실행
		}

	private void saveAction() {
		fm.save(); //FriendManager에 있는 save 메소드 실행
	}
	
	//CheckBox 선택시
	class SelectItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) { //item이 선택되었을 떼
				for(int i=0;i<friendNum;i++) {
					if(e.getItem()==box[i]) {
						fm.search(i); //선택된 CheckBox가 있는 라인의 번호를 FriendManager에 있는 search 메소드로 전달
						break;
					}
				}
			}
		}		
	}
	
}
