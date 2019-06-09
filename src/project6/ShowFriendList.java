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
	
	private JPanel infoP; //������ �� ��ü �г� ����
	private JPanel infoLabelP; //����� ��� �г�
	
	//üũ�ڽ� ����
	private JCheckBox[] box=new JCheckBox[15];
	private ButtonGroup group=new ButtonGroup();
	//üũ�ڽ� �̸� �ʱ�ȭ -> ���� �������� ���� �ذ��� ã��
	private String[] names= {"1","2","3","4","5","6",
			"7","8","9","10","11","12","13","14","15"
	};
	
	//TextField�� ������ ���� array
	private String[] nameT=new String[15];
	private String[] groupT=new String[15];
	private String[] phoneT=new String[15];
	private String[] emailT=new String[15];
	
	//TextField ����
	private JTextField nameTf[]=new JTextField[15];
	private JTextField groupTf[]=new JTextField[15];
	private JTextField phoneTf[]=new JTextField[15];
	private JTextField emailTf[]=new JTextField[15];
	
	//Button ����
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
		JFrame frame=new JFrame("ģ�� ���");
	
		infoP=new JPanel();
		infoP.setLayout(new BoxLayout(infoP, BoxLayout.Y_AXIS));
		infoP.setLayout(new GridLayout(15,1));
		
		//��� ��� �г� ����
		infoLabelP=new JPanel();
		infoLabelP.setLayout((new BoxLayout(infoLabelP, BoxLayout.X_AXIS)));
		infoLabelP.setLayout(new GridLayout(1,6));
		infoLabelP.add(new JLabel(" "));
		infoLabelP.add(new JLabel("�̸�"));
		infoLabelP.add(new JLabel("�׷�"));
		infoLabelP.add(new JLabel("��ȭ��ȣ"));
		infoLabelP.add(new JLabel("Email"));
		infoLabelP.add(new JLabel("����"));
		infoP.add(infoLabelP);
		
		//�� �ٸ��� ģ�� ���� �߰�
		for(int i=0;i<friend.size();i++) {
			JPanel infoContentP=new JPanel();
			infoContentP.setLayout(new GridLayout(1,6));
			
			//üũ�ڽ� ����
			box[i]=new JCheckBox(names[i]);
			group.add(box[i]);
			box[i].addItemListener(new SelectItemListener());
			infoContentP.add(box[i]);
			
			//�̸� TextField ����
			nameT[i]=friend.get(i).getName();
			nameTf[i]=new JTextField(10);
			nameTf[i].setText(nameT[i]);
			infoContentP.add(nameTf[i]);
			
			//�׷� TextField ����
			groupT[i]=friend.get(i).getGroup();
			groupTf[i]=new JTextField(10);
			groupTf[i].setText(groupT[i]);
			infoContentP.add(groupTf[i]);
			
			//��ȭ��ȣ TextField ����
			phoneT[i]=friend.get(i).getPhoneNum();
			phoneTf[i]=new JTextField(30);
			phoneTf[i].setText(phoneT[i]);
			infoContentP.add(phoneTf[i]);
			
			//�̸��� TextField ����
			emailT[i]=friend.get(i).getEmailAddress();
			emailTf[i]=new JTextField(30);
			emailTf[i].setText(emailT[i]);
			infoContentP.add(emailTf[i]);
			
			//���� Label ���� -> ���� �Ұ���
			infoContentP.add(new JLabel(friend.get(i).getPhoto()));
			infoP.add(infoContentP);
		}
		
		//��ư �г� ����
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
		if(e.getSource()==addB) //Add ��ư Ŭ����
			addAction();
		else if(e.getSource()==deleteB) //Delete ��ư Ŭ����
			deleteAction();
		else if(e.getSource()==modifyB) //Modify ��ư Ŭ����
			modifyAction();
		else if(e.getSource()==saveB) //Save File ��ư Ŭ����
			saveAction();
	}
	
	private void addAction() {
		new FriendAdd(); //FriendAdd Ŭ���� ����
	}
	
	private void deleteAction() {
		fm.delete(); //FriendManager�� �ִ� delete �޼ҵ� ����
		ShowFriendList sfl=new ShowFriendList(fm.showInfo()); //�ٽ� ShowFrienListŬ���� �����Ͽ� ȭ�� update -> �ٽ� �������� �ʾƵ� ȭ�� update�� �� �ִ� ��� ã��
	}
	
	private void modifyAction() {
		int modifyNum=fm.searchReturn();
		//TextField�� �ִ� �� �ҷ��� friend ArrayList�� ����
		friend.get(modifyNum).setName(nameTf[modifyNum].getText());
		friend.get(modifyNum).setGroup(groupTf[modifyNum].getText());
		friend.get(modifyNum).setPhoneNum(phoneTf[modifyNum].getText());
		friend.get(modifyNum).setEmailAddress(emailTf[modifyNum].getText());
		
		fm.modify(friend.get(modifyNum)); //FriendManager�� �ִ� modify �޼ҵ� ����
		}

	private void saveAction() {
		fm.save(); //FriendManager�� �ִ� save �޼ҵ� ����
	}
	
	//CheckBox ���ý�
	class SelectItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.SELECTED) { //item�� ���õǾ��� ��
				for(int i=0;i<friendNum;i++) {
					if(e.getItem()==box[i]) {
						fm.search(i); //���õ� CheckBox�� �ִ� ������ ��ȣ�� FriendManager�� �ִ� search �޼ҵ�� ����
						break;
					}
				}
			}
		}		
	}
	
}
