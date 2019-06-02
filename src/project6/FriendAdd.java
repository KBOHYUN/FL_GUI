package project6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
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
	
	Dimension dim=new Dimension(600,300);
	private JFrame frame=new JFrame("추가할 친구 정보");
	
	private JButton doneB=new JButton("Done");
	private JPanel panel=new JPanel();
	private JPanel labelPanel=new JPanel();
	private JPanel textPanel=new JPanel();
	
	private JTextField txName;
	private JTextField txGroup;
	private JTextField txPhone;
	private JTextField txEmail;
	private JTextField txPhoto;
	
	private String name;
	private String group;
	private String email;
	private String phone;
	private String photo;

	FriendAdd(){
	
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		panel.setLayout(new GridLayout(2,1));
		
		labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.X_AXIS));
		labelPanel.setLayout(new GridLayout(1,5));
		labelPanel.add(new JLabel("이름"));
		labelPanel.add(new JLabel("그룹"));
		labelPanel.add(new JLabel("전화"));
		labelPanel.add(new JLabel("Email"));
		labelPanel.add(new JLabel("사진"));
		panel.add(labelPanel);
		
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
		
		doneB.addActionListener(new doneAction());
		
		frame.add(panel,BorderLayout.CENTER);
		frame.add(doneB, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		
		}
	
	class doneAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			name=txName.getText().trim();
			group=txGroup.getText().trim();
			phone=txPhone.getText().trim();
			email=txEmail.getText().trim();
			photo=txPhoto.getText().trim();
			
			if(name.equals("")||group.equals("")||phone.equals("")||email.equals("")||photo.equals("")) {
				System.out.println("모든 정보를 입력해주세요");
				addWindowListener(new Exit());
			}
			else {
				fm.add(new Friend(name, group, phone, email, photo));
				ShowFriendList sfl=new ShowFriendList(fm.load());				
			}
				
		}
	}
	
	class Exit extends WindowAdapter{
		public void WindowClosing(WindowEvent e) {
			dispose();
			System.exit(0);
		}
	}
}

