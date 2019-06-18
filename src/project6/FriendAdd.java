package project6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FriendAdd extends JFrame{
	FriendManager fm=FriendManager.getInstance();
	
	Dimension dim=new Dimension(900,100);

	private JFrame frame=new JFrame("�߰��� ģ�� ����");
	
	//��Ʈ ����
	Font labelFont =new Font("BahnschriftSemiBold",Font.BOLD,13);
	
	//Done ��ư ����
	private JButton doneB=new JButton("Done");
	
	private JPanel panel=new JPanel();
	private JPanel labelPanel=new JPanel();
	private JPanel textPanel=new JPanel();
	
	//�Է��� TextField ����
	private JTextField txName;
	private JTextField txGroup;
	private JTextField txPhone;
	private JTextField txEmail;
	private JTextField txPhoto;
	
	//TextField���� �Է��� ������ ������ String
	private String name;
	private String group;
	private String email;
	private String phone;
	private String photo;

	@SuppressWarnings("static-access")
	FriendAdd(){
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		panel.setLayout(new GridLayout(2,1));
		
		//����� ��� ���� panel
		labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.X_AXIS));
		labelPanel.setLayout(new GridLayout(1,5));
		JLabel namel=new JLabel("Name");
		namel.setFont(labelFont);
		namel.setHorizontalAlignment(namel.CENTER);
		labelPanel.add(namel);
		JLabel groupl=new JLabel("Group");
		groupl.setFont(labelFont);
		groupl.setHorizontalAlignment(groupl.CENTER);
		labelPanel.add(groupl);
		JLabel phonel=new JLabel("Phone");
		phonel.setFont(labelFont);
		phonel.setHorizontalAlignment(phonel.CENTER);
		labelPanel.add(phonel);
		JLabel emaill=new JLabel("Email");
		emaill.setFont(labelFont);
		emaill.setHorizontalAlignment(emaill.CENTER);
		labelPanel.add(emaill);
		JLabel photol=new JLabel("Photo");
		photol.setFont(labelFont);
		photol.setHorizontalAlignment(photol.CENTER);
		labelPanel.add(photol);
		panel.add(labelPanel);
		
		//TextField�� �� panel
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
		textPanel.setLayout(new GridLayout(1,5));
		
		txName=new JTextField(100);
		textPanel.add(txName);
		
		txGroup=new JTextField(100);
		textPanel.add(txGroup);
		
		txPhone=new JTextField(100);
		textPanel.add(txPhone);
		
		txEmail=new JTextField(100);
		textPanel.add(txEmail);
		
		txPhoto=new JTextField(100);
		textPanel.add(txPhoto);
		
		panel.add(textPanel);
		
		doneB.setFont(labelFont);
		doneB.addActionListener(new doneAction());
		
		frame.setLocation(130, 300);
		frame.setPreferredSize(dim);
		frame.add(panel,BorderLayout.CENTER);
		frame.add(doneB, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		
		}

	//Done ��ư Ŭ����
	class doneAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//TextField�� �Է��� ���� ����
			name=txName.getText().trim();
			group=txGroup.getText().trim();
			phone=txPhone.getText().trim();
			email=txEmail.getText().trim();
			photo=txPhoto.getText().trim();
			
			//�Էµ� ������ �����̸� ���� �޼���
			if(name.equals("")||group.equals("")||phone.equals("")||email.equals("")||photo.equals("")) {
				System.out.println("Input every Information!");
				addWindowListener(new Exit());
			}
			else {
				//�Էµ� ������ ������ ���ο� Friend ��ü ����
				Friend checkFriend=new Friend(name, group, phone, email, photo);
				
				//���� �̸��̳� ģ����  �������� ������ ArrayList�� �߰�
				if(fm.sameFriendCheck(checkFriend)==true && fm.nameCheck(checkFriend)==true) {
					fm.add(checkFriend);
					new ShowFriendList(fm.showInfo());
				}
				else {
					if(fm.sameFriendCheck(checkFriend)==false) {
						System.out.println("same friend exist!");
						frame.dispose();
					}
					if(fm.nameCheck(checkFriend)==false) {
						System.out.println("same name exist!");
						fm.add(checkFriend);
						new ShowFriendList(fm.showInfo());
						}
					}
			}
			//Done ��ư Ŭ���� FriendAdd ����	
			frame.dispose();
			}
				
		}
	
	//FriendAdd�� Frameâ�� ������ ��ü ���ᰡ ���� �ʵ���
	class Exit extends WindowAdapter{
		public void WindowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}
}

