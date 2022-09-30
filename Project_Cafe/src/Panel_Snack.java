import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class Panel_Snack extends JPanel{

	MainTest parent;

	JButton b[] = new JButton[6]; //주문 가능 수량
	JButton delbt,calbt; 	//모두 취소버튼, 결제버튼

	//Panel_Sanck 생성
	public Panel_Snack(MainTest mainTest) {

		parent = mainTest;
		parent.tf = new JTextField();
		parent.ta = new JTextArea();

		parent.tf.setPreferredSize(new Dimension(250,200)); //텍스트필드 크기설정


		// 메뉴 관련버튼 (이미지 경로), 이미지와 툴팁내용 배열로 선언
		String []img = {"src\\imgs\\s1.PNG","src\\imgs\\s2.PNG","src\\imgs\\s3.PNG",
				"src\\imgs\\s4.PNG","src\\imgs\\s5.PNG","src\\imgs\\s6.PNG"};	//이미지 경로
		String[] tooltip = { "죠리뽕: 3000원", "칸츄리콘: 2500원", "치토스: 3000원", "썬칩: 3000원", "카스타드: 4000원", "허니버터칩: 3500원" };	// 툴팁내용
		for(int i =0; i < img.length; i++) { //배열선언, 배열길이는 이미지배열 갯수
			b[i] = new JButton(new ImageIcon(img[i])); // 이미지배열
			b[i].setToolTipText(tooltip[i]);	//툴팁 내용
			b[i].setBackground(new Color(255, 255, 255)); //버튼 배경 흰색설정
		}
		//주문 관련 버튼 추가
		delbt= new JButton("모두 취소");
		calbt = new JButton("결제");
		parent.addbt = new JButton("장바구니 추가");
		parent.addbt2 = new JButton("장바구니 취소");
		parent.sosbt = new JButton("직원호출");

		addLayout();
		eventProc();

	}	//end of Panel_Snack()

	void addLayout() {

		setLayout(new BorderLayout()); //전체레이아웃 Border로 선언
		// ------------------------왼쪽패널에 주문할 버튼들 3행2열로 선언

		JPanel pWest = new JPanel(); //West방향 패널 설정
			pWest.setLayout(new GridLayout(3,2,10,10));	//West패널을 3행2열, 10,10의 간격지정 
			pWest.setPreferredSize(new java.awt.Dimension(500, 600)); // 패널의 크기지정
		
			for(JButton b: b) 
			pWest.add(b);

		add(pWest, BorderLayout.WEST);	//West에 지정

		// ----------------------------------
		JPanel pSouth = new JPanel();	//South패널 생성
		pSouth.setLayout(new GridLayout(1, 2));	//south 패널을 1행2열로 설정
		pSouth.setPreferredSize(new java.awt.Dimension(10, 50));	//패널의 크기지정
		pSouth.add(delbt);
		pSouth.add(calbt);

		add(pSouth, BorderLayout.SOUTH);

	}// end of addLayout()

	void eventProc() {
		//-----------------------------각각의 버튼이 눌렸을때 장바구니에 담기
		String[] a = { "죠리뽕 3000", "칸츄리콘 2500", "치토스 2500", 
				"썬칩 3000", "카스타드 4000", "허니버터칩 3500" };	 	// 값 배열에 지정
		for (int i = 0; i < b.length; i++) {
			int su = i;
			b[i].addActionListener(new ActionListener() {		//각 버튼을 눌렀을떄의 액션지정을 배열을통해 for구문으로 
				@Override
				public void actionPerformed(ActionEvent e) {
					if (parent.ta.getText().equals(""))	
						parent.ta.append(a[su]);	// 장바구니 메뉴누른거 이어주기
					else
						parent.ta.setText(a[su]);	

				}// actionPerformed()
			});// addActionListener()
		} // for
		//장바구니추가 이벤트
		parent.addbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputData(); //리스트에 넣는 메서드
			}// actionPerformed
		});// addActionListenerAddbt
		//장바구니 누른걸 눌러서 취소하는 이벤트
		parent.addbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();	//취소 메서드
			}// actionPerformed
		});// addActionListenerAddbt2
		//결제 이벤트
		calbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int reply = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?","결제창", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					pay();
					parent.ta.setText(String.valueOf(parent.ta.getText().equals("")));
				} else {
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
				}// 결제창 구문 Y/N

			}// actionPerformed
		});// addActionListenerbpay
		//모두 취소하는 버튼
		delbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAll(); // 모두지우는 메서드
			}// actionPerformed
		});// addActionListenerbcan
		//직원호출 SOS버튼
		parent.sosbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s= parent.tf.getText();	//부모의 장바구니내용을가져와서 String s에저장
				JOptionPane.showMessageDialog(null,"용무 "+ s +"로 종업원 호출하였습니다. 기다리세요."); //직원호출 메세지창
				parent.tf.setText(""); // 클리어
			}// end of actionPerformed
		});// end of addActionListenersosbt

	}//eventProc
		//inputs into toJang
	
	//addbt (장바구니에 텍스트에어리어 tq에 있는 값 담는 메서드)
	void inputData() {	//inputdata 메서드
		String a = parent.ta.getText();	// a에 장바구니 get
		String[] b = a.split(" ");	//b배열에 a로 받아온 내용을 문자열 자르기split
		EdibleVo v = new EdibleVo(b[0],Integer.valueOf(b[1])); // EdibleVo v에 b내용을 형변환하여 
		parent.list.add(v);	// 부모의 list에 더하기
		parent.ta.setText("");	// 장바구니 클리어
		parent.taJang.append(v.toString());	//toString을 써서 문자열 더해서 출력
	}//input data()

	// delete form toJang(장바구니취소 메서드)
	void deleteData() {	//deletData 메서드
		String a = parent.ta.getText();	//위의 방식과 동일
		if(a.equals("")) {	// 공백일경우
			JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");	//메세지 출력
			return;
		}//if
		String[] b = a.split(" ");

		for (EdibleVo vo : parent.list)	//Enhanced for문 이용(generics 위에서 써야함)
			if (b[0].equals(vo.getName())) {
				parent.list.remove(vo);	// list해당내용 지움
				break;
			}//if

		parent.ta.setText("");	//초기화
		parent.taJang.setText("");	//초기화
		for (EdibleVo vo : parent.list)
			parent.taJang.append(vo.toString());	//장보기텍스트에어리어 toString으로 출력
	}//deletedata()

	//결제창을 띄우고 다 지우는 기능의 메서드
	void pay() {	//paymethod

		int total = 0;
		for(EdibleVo v : parent.list) {	// total 에 값을 계속 더하는 반복문
			total += v.getCost();	
		}//for
		JOptionPane.showMessageDialog(null, "내실 총 금액은 "+ total+" 원입니다.");	// 총액출력구문

		cancelAll();	// 모든 정보 초기화
	}//pay

	//모든 정보를 다지우는 메서드
	void cancelAll() {	
		parent.taJang.setText("");	//초기화
		parent.ta.setText("");	//초기화
		parent.list = new ArrayList<EdibleVo>(); 
	}//cancelAll
<<<<<<< HEAD
}//end of Panel_Sanck
=======
}//end of Panel_Sanck
>>>>>>> branch 'main' of https://github.com/jsy4/KosmoMidProject-Cafe.git
