package proMiddle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.Execute;
import db.MyMuseVo;
import db.Query;

public class Mypage extends WindowAdapter implements ActionListener, MouseListener {
	private JFrame f5, fclick;
	private JPanel p;
	private JScrollPane sp;
	private JTable tb;
	private DefaultTableModel model;
	private JButton b;
	private String ID;
	private TextArea comments;

	Query qu = new Query();

	Execute ec = new Execute();

	public Mypage() {

//		Frame setting
		f5 = new JFrame("Mypage");
		f5.setLayout(null);
		f5.setSize(300, 550);
		f5.setLocation(300, 300);
		f5.setResizable(false);

		fclick = new JFrame("자세히");
		fclick.setLayout(null);
		fclick.setSize(500, 200);

		comments = new TextArea();
		comments.setSize(450, 120);
		comments.setLocation(20, 20);

		p = new JPanel();
		p.setSize(250, 450);
		p.setLocation(20, 30);
		p.setLayout(new BorderLayout());
//		p.addMouseListener(this);

//		JTable setting
		String header[] = { "기관명", "도시명" };
		String contents[][] = null;
		model = new DefaultTableModel(contents, header); // 모델 생성

		tb = new JTable(model); // 모델을 사용한 테이블 생성
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tb.setPreferredSize(new Dimension(250, 450));
		tb.addMouseListener(this);

		sp = new JScrollPane(); // 테이블을 스크롤패널에 추가
		sp.setViewportView(tb);
		tb.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동금지
//		tb.getTableHeader().setResizingAllowed(false); // 테이블 사이즈 고정
//		tb.setEnabled(false); // 테이블 수정 금지// 적용하면 자료 이동이 안됨.
		p.add(sp);

		b = new JButton("확인");
		b.setSize(80, 25);
		b.setLocation(100, 480);
		b.addActionListener(this);
		b.setFont(new Font("kopubworld", Font.ROMAN_BASELINE, 13));

	}

	public void list() {// 마이페이지 실행과 동시에 실행될 부분
		ec.connDB();
		String sql = qu.basics(ID); // 먼저 조회쿼리 작성
		System.out.println(sql);
		ArrayList<MyMuseVo> mylist = ec.printBasics(sql);// 쿼리 실행 메서드 호츨 // 배열로 넘겨받음

		String list[] = new String[mylist.size()];
		for (int i = 0; i < mylist.size(); i++) {
			MyMuseVo data = (MyMuseVo) mylist.get(i);
			list[0] = data.getNAME();
			list[1] = data.getCITY();
			System.out.println(list);
			model.addRow(list);
		}
	}

	public void startFrame() {
		f5.add(p);
		f5.add(b);
		f5.setVisible(true);
		model.setNumRows(0); // 초기화 시켜주지 않으면 Table에 계속 쌓인다.
		list();
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void startClick(String result) {
		comments.append(result);
		fclick.add(comments);
		fclick.setVisible(true);
		ec.connDB();
	}

	public void actionPerformed(ActionEvent e) { // DB 출력까지는 됨. 화면에 출력이 안되는 중. 레이아웃 문제였음.
//		Execute ec = new Execute();
		ec.connDB();
		if (e.getActionCommand().equals("확인")) {
			Mypage mp = new Mypage();
			int row = tb.getSelectedRow();
			String get = (String) tb.getValueAt(row, 0);
//			쿼리 작성하고 실행시켜서 출력 하나만 출력하면 됨. 
			String sql = qu.detail(get); // 쿼리 작성
//			System.out.println(sql);
			String result = ec.printRes(sql); // 데이터 출력 성공.
//			System.out.println(result);
			mp.startClick(result);
		}

	}

	public static void main(String[] args) {
		Mypage mp = new Mypage();
		mp.startFrame();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && e.getSource().equals(tb)) {
//			System.out.println(tb.getSelectedRow());
			String muse = (String) tb.getValueAt(tb.getSelectedRow(), 0);
//			System.out.println(muse);
			String sql = qu.deleteDB(ID, muse);
			ec.runQuery(sql);

			model.removeRow(tb.getSelectedRow());

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}