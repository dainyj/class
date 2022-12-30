package proFront;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 프레임 1개, 버튼1개, 라벨 5개, 텍스트필드 4개
// 정보 입력하고 bsignUp 버튼 클릭 시 DB에 저장되도록 연동, DB에 MEMBER TABLE 필요

public class SignUp extends WindowAdapter implements ActionListener {
	private JFrame f2, fout;
	private JButton bsignUp, bout, bout2;
	private JLabel lid, lpwd, lpn, lem, ltitle, lid2;
	private TextField tfid, tfpwd, tfpn, tfem, tfid2;
	
	PMemberDAO dao = new PMemberDAO();

//	다른 클래스에서 프레임 불러오기에 사용하려고 // 사용되는 부분 정리 후 삭제 예정.
//	public JFrame getF2() {
//		return f2;
//	}

	public SignUp() {

//		Frame setting 1개
		f2 = new JFrame("회원가입");
		f2.setLayout(null);
//		f2.setLayout(new FlowLayout());
		f2.setSize(400, 400);
		f2.setLocation(300, 300);
		f2.addWindowListener(this);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fout = new JFrame("탈퇴하기");
		fout.setLayout(null);
//		fout.setLayout(new FlowLayout());
		fout.setSize(150, 150);
		fout.setLocation(300, 300);
		fout.addWindowListener(this);

//		Button setting 1개
		bsignUp = new JButton("가입하기");  //O
		bsignUp.setSize(85, 30);
		bsignUp.setLocation(150, 280);
		bsignUp.addActionListener(this);
		bsignUp.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 12));

		bout = new JButton("탈퇴하기");  //O
		bout.setSize(85, 30);
		bout.setLocation(260, 280);
		bout.addActionListener(this);
		bout.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 12));

		bout2 = new JButton("탈퇴");	
		bout2.setSize(80, 30);
		bout2.setLocation(30, 60);
		bout2.addActionListener(this);
		bout2.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 12));

//		Label setting 5개
		ltitle = new JLabel("가입 정보 입력", JLabel.CENTER);  //O
		ltitle.setSize(150, 30);
		ltitle.setLocation(80, 30);
		ltitle.setFont(new Font("kopubworld", Font.BOLD, 20)); // 폰트
		
		lid = new JLabel("ID", JLabel.CENTER);
		lid.setSize(100, 20);
		lid.setLocation(60, 80);
		lid.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 15));
		
		lpwd = new JLabel("PASSWORD", JLabel.CENTER);
		lpwd.setSize(100, 20);
		lpwd.setLocation(60, 130);
		lpwd.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 15));
		
		lpn = new JLabel("Phone Number", JLabel.CENTER);
		lpn.setSize(100, 20);
		lpn.setLocation(60, 180);
		lpn.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 15));
		
		lem = new JLabel("E-mail", JLabel.CENTER);
		lem.setSize(100, 20);
		lem.setLocation(60, 230);
		lem.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 15));

		lid2 = new JLabel("ID", JLabel.RIGHT); // 탈퇴프레임
		lid2.setSize(30, 20);
		lid2.setLocation(8, 30);
		lid2.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 15));
		
//		TextField 4개
		tfid = new TextField();
		tfid.setSize(100, 20);
		tfid.setLocation(180, 80);
	
		tfpwd = new TextField();
		tfpwd.setSize(100, 20);
		tfpwd.setLocation(180, 130);
		
		tfpn = new TextField();
		tfpn.setSize(100, 20);
		tfpn.setLocation(180, 180);
		
		tfem = new TextField();
		tfem.setSize(100, 20);
		tfem.setLocation(180, 230);
		
		tfid2 = new TextField(); // 탈퇴프레임
		tfid2.setSize(70, 20);
		tfid2.setLocation(50, 30);
	}

	public void startFrame() {
		f2.add(ltitle);
		f2.add(lid);
		f2.add(tfid);
		f2.add(lpwd);
		f2.add(tfpwd);
		f2.add(lpn);
		f2.add(tfpn);
		f2.add(lem);
		f2.add(tfem);
		f2.add(bsignUp);
		f2.add(bout);

		f2.setVisible(true);

	}
	
	public void outFrame() {
		fout.add(lid2);
		fout.add(tfid2);
		fout.add(bout2);
		fout.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		SignUp su= new SignUp();

		if (e.getActionCommand().equals("가입하기")) { // 버튼 클릭시 회원정보 DB테이블에 저장
			f2.setVisible(false);
			dao.insert(tfid.getText(), tfpwd.getText(), tfpn.getText(), tfem.getText());
			Login.main(null);
			
//			가입 실패시 창뜨게 해야하는데 아직 안해둠.. 나중에 하자 나중에 
			
		}
		if (e.getActionCommand().equals("탈퇴하기")) { // 우선 ID만 입력해서 탈퇴가능, 나중에 비밀번호도 같이 입력해서 하도록 바꾸기 
			f2.setVisible(false);
			su.outFrame();
		}

		if (e.getActionCommand().equals("탈퇴")) { 
			dao.delete(tfid2.getText());
			fout.setVisible(false);	
//			Login log  = new Login();
			
			Login.main(null);
		}
	}

	public static void main(String[] args) {
		SignUp su = new SignUp();
		su.startFrame();

	}
}
