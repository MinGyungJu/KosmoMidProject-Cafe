import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Noodle extends JPanel {

   MainTest parent;
   
   JButton bnd[] = new JButton[6]; // 주문 가능 수량
   JButton bcan, bpay;	// 모두취소, 결제

   public Panel_Noodle(MainTest mainTest) {

      parent = mainTest;
      parent.tf = new JTextField();	// 한줄의 문자열을 입력받는 창,입력 가능한 문자 개수와 입력 창의 크기는 서로 다름
      parent.ta = new JTextArea();	// 여러 줄의 문자열을 입력받을 수 있는 입력탕을 만든다.

      parent.tf.setPreferredSize(new Dimension(250, 200));		// setPreferredSize(); 이 메소드는 Dimension객체를 인자로 받으면서
      															//   해당 콤포넌트의 기본크기를 결정
      
      //메뉴 관련 (이미지 경로)
      String []img = {"src\\imgs\\n1.PNG","src\\imgs\\n2.PNG","src\\imgs\\n3.PNG",
            "src\\imgs\\n4.PNG","src\\imgs\\n5.PNG","src\\imgs\\n6.PNG"};	// 이미지 소스의 경로
      String[] tooltip = { "너구리: 3500원", "신라면: 3500원","오징어짬뽕: 3500원", "튀김우동: 3500원", "진라면: 3000원","짜파게티 : 3500원" };   //툴팁 내용
      for(int i =0; i < img.length; i++) {
         bnd[i] = new JButton(new ImageIcon(img[i]));		// 버튼에 이미지를 배열 순서대로
         bnd[i].setToolTipText(tooltip[i]);					// 버튼에 툴팁내용 배열 순서대로
         bnd[i].setBackground(new Color(255, 255, 255));	// 버튼의 색상을 흰색으로 설정
      }
   // 주문 관련 버튼
         bcan = new JButton("모두 취소");
         bpay = new JButton("결제");
         parent.addbt = new JButton("장바구니 추가");
         parent.addbt2 = new JButton("장바구니 취소");
         parent.sosbt = new JButton("직원호출");

         addLayout();
         eventProc();
   }  // Panel_Noodle()

   void addLayout() {

      setLayout(new BorderLayout());							// BorderLayout을 이용해서 화면을 구성(동, 서, 남, 북)						
      // ------------------------왼쪽패널에 주문할 버튼들
      JPanel pWest = new JPanel();								// West(왼)에 만들 패널 생성
      pWest.setLayout(new GridLayout(3, 2, 10, 10));			// West(왼)에 3행 2열에 간격 10의 패널 설정
      pWest.setPreferredSize(new java.awt.Dimension(500, 600));	// 기본크기를 결정
      for (JButton b : bnd)
         pWest.add(b);
      add(pWest, BorderLayout.WEST);	// West(왼쪽)에 패널을 더한다. 



      // -------------------------------모두 취소, 결제버튼
      JPanel pSouth = new JPanel();								// South(아래)에 만들 패널 생성
      pSouth.setLayout(new GridLayout(1, 2));					// South(아래)에 1행 2열 매널 설정
      pSouth.setPreferredSize(new java.awt.Dimension(10, 50));	//기본 크기
      pSouth.add(bcan);
      pSouth.add(bpay);
      add(pSouth, BorderLayout.SOUTH); // South(아래)쪽에 패널을 더한다

   } // addLayout()

   void eventProc() {
      //-----------------------------각각의 버튼이 눌렸을때 장바구니에 담기
      String[] a = { "너구리 3500", "신라면 3500", "오징어짬뽕 3500", 
               "튀김우동 3500", "진라면 3000", "짜파게티 3500" };		//값을 배열에 넣어줌.
      for (int i = 0; i < bnd.length; i++) {
			int su = i;
			bnd[i].addActionListener(new ActionListener() {		//각 버튼을 눌렀을떄의 액션지정 배열을 통해 순서대로
				@Override
				public void actionPerformed(ActionEvent e) {
					if (parent.ta.getText().equals(""))			
						parent.ta.append(a[su]);				//장바구니에 구매할 메뉴를 추가해서 붙인다(append).
					else
						parent.ta.setText(a[su]);	

				}// actionPerformed()
			});// addActionListener()
		} // for
		//장바구니추가
		parent.addbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputData(); //리스트에 넣는 메서드
			}// actionPerformed
		});// addActionListenerAddbt
		//장바구니에 추가된 것을 한번더 눌러서 취소
		parent.addbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteData();	//취소 메서드
			}// actionPerformed
		});// addActionListenerAddbt2
		//결제
		 bpay.addActionListener(new ActionListener() {
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
		 bcan.addActionListener(new ActionListener() {
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
   
   //addbt (장바구니에 ta에 있는 값 담기)
   void inputData() {
      String a = parent.ta.getText();	// 부모장바구니를 a에 담는다
      String[] b = a.split(" ");		// b배열에 a로 받아온 내용을 문자열 자르기
      EdibleVo v = new EdibleVo(b[0], Integer.valueOf(b[1]));	// EdibleVo v에 b내용을 형변환하여
      parent.list.add(v);	// 부모 list에 더하기
      parent.ta.setText("");	// 초기화
      parent.taJang.append(v.toString());		// toString을 써서 문자열 더해서 출력
   }// input data()

   // deletes from taJang(장바구니 취소)
   void deleteData() {	// deletData 메서드
      String a = parent.ta.getText();	// 부모장바구니를 a에 담는다
      if (a.equals("")) {	// 공백일 경우
         JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");	//메세지를 출력
         return;
      } // if
      String[] b = a.split(" ");
      
      for (EdibleVo vo : parent.list)	// Enhanced for문 이용(generics 위에서 써야함)
         if (b[0].equals(vo.getName())) {
            parent.list.remove(vo);	// list에 해당 내용 지움
            break; //꼭 필요함
         } // if
      parent.ta.setText("");		// 초기화
      parent.taJang.setText("");	// 초기화
      for (EdibleVo vo : parent.list)	// Enhanced for문
         parent.taJang.append(vo.toString());	// 장보기텍스트에어리어 toString으로 출력
   }// deletedata

   // 결제창을 띄우고 다 지우기
   void pay() {
      int total = 0;
      for (EdibleVo v : parent.list) {	// total 에 값을 계속 더하는 반복문	 
         total += v.getCost();
      } // for
      JOptionPane.showMessageDialog(null, "내실 총 금액은 " + total + " 원입니다.");	//주문한 값의 총액 출력
      cancelAll();		//모든 정보 초기화
   }// pay

   // 모든 정보 지우기
   void cancelAll() {
      parent.taJang.setText("");	//초기화
      parent.ta.setText("");		//초기화
      parent.list = new ArrayList<EdibleVo>();
   }// cancelAll()
}// panel_noodle