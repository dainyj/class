package frame_Menu;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mypage extends WindowAdapter implements ActionListener {
	private Frame f5;
	
	TextArea comments;

//	종료 메서드
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Frame getF5() {
		return f5;
	}

	public Mypage() {
//		Frame setting
		f5 = new Frame("Mypage");
		f5.setLayout(new FlowLayout());
		f5.setSize(400, 400);
		f5.setLocation(300, 300);
		f5.addWindowListener(this);
		
		comments = new TextArea("하고 싶은 말을 적으세요!", 10, 50);
		
		
	}

	public void startFrame() {
		f5.add(comments);
//		f5.add(bm1);
//		f5.add(bm2);
//		f5.add(bm3);
//		f5.add(ls);
//		f5.add(tfs);
//		f5.add(bs);
//		f5.add(lmp);
//		f5.add(bmp);
		f5.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		Mypage mp = new Mypage();
		mp.startFrame();
	}

}
