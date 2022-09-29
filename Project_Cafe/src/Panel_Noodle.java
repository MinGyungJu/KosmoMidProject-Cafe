import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Panel_Noodle extends JPanel {

   MainTest parent;
   JFrame f;
   
   JTextField tf;
   JTextArea ta,taJang;
   JButton bnd[] = new JButton[6];
   JButton delbt,calbt,addbt,addbt2,sosbt;
   ArrayList<EdibleVo> list = new ArrayList<EdibleVo>();

   JLabel banner1 = new JLabel("요청 쓴후에 호출, 장바구니에는 하나씩만");
   JLabel banner2 = new JLabel();
   JLabel banner3 = new JLabel();
   JLabel banner4 = new JLabel();
   JLabel banner5 = new JLabel();

   public Panel_Noodle(MainTest mainTest) {
      
      parent = mainTest;

      f = new JFrame();
      tf = new JTextField();
      ta = new JTextArea();
      taJang = new JTextArea();
      
      tf.setPreferredSize(new Dimension(250,200));
      taJang.setPreferredSize(new Dimension(250,200));
      
      
      addbt = new JButton("장바구니 담기");
      addbt2 = new JButton("장바구니 취소");
      sosbt = new JButton("직원호출");
      delbt= new JButton("모두 취소");
      calbt = new JButton("              결제              ");
      
      // 메뉴 관련버튼 (이미지 경로)
//      bnd1 = new JButton( new ImageIcon("src\\imgs\\n1.PNG"));
//      bnd2 = new JButton( new ImageIcon("src\\imgs\\n2.PNG"));
//      bnd3 = new JButton( new ImageIcon("src\\imgs\\n3.PNG"));
//      bnd4 = new JButton( new ImageIcon("src\\imgs\\n4.PNG"));
//      bnd5 = new JButton( new ImageIcon("src\\imgs\\n5.PNG"));
//      bnd6 = new JButton( new ImageIcon("src\\imgs\\n6.PNG"));
      String []img = {"src\\imgs\\n1.PNG","src\\imgs\\n2.PNG","src\\imgs\\n3.PNG",
				"src\\imgs\\n4.PNG","src\\imgs\\n5.PNG","src\\imgs\\n6.PNG"};
		String[] tooltip = { "너구리: 3500원", "신라면: 3500원","오징어짬뽕: 3500원", "튀김우동: 3500원", "진라면: 3000원","짜파게티 : 3500원" };
		for(int i =0; i < img.length; i++) {
			bnd[i] = new JButton(new ImageIcon(img[i]));
			bnd[i].setToolTipText(tooltip[i]);
		}

      // 주문 관련 버튼
   
      addLayout();
      eventProc();

   } // Panel_Noodle()

   void addLayout() {
//      BorderLayout layout = new BorderLayout();
//      setLayout(layout); 
//      remove(layout.getLayoutComponent(BorderLayout.CENTER));
      setLayout(new BorderLayout());
      JPanel pWest = new JPanel();
      
      pWest.setLayout(new GridLayout(3, 2, 10, 10));
      pWest.setPreferredSize(new java.awt.Dimension(500, 600));
      for(JButton b: bnd) pWest.add(b);

      add(pWest, BorderLayout.WEST);

      JPanel pNorth = new JPanel();
      pNorth.setLayout(new GridLayout(1, 2));
      pNorth.add(tf);
      add(pNorth, BorderLayout.NORTH);
      // ----------------------------------------------
      JPanel pEast = new JPanel();
      pEast.setLayout(new GridLayout(2, 1));
      pEast.setPreferredSize(new java.awt.Dimension(300, 450));

      JPanel pEast1 = new JPanel();
      pEast1.add(tf); // 요청 사항 입력 후, 직원 호출을 눌러주세요
      pEast1.add(sosbt); // 직원 호출
      JPanel pEast2 = new JPanel();
      pEast2.add(banner1); // 이벤트 배너 삽입
      pEast2.add(ta); // 주문내역 출력
      pEast2.add(addbt); // 장바구니 담기
      
      pEast2.add(addbt2); // 장바구니 담기
      pEast2.add(taJang); // 주문내역 출력
      pEast.add(pEast1);
      pEast.add(pEast2);

      add(pEast, BorderLayout.EAST);
      // ----------------------------------------------
      JPanel pSouth = new JPanel();

      pSouth.setLayout(new GridLayout(1, 2));
      pSouth.setPreferredSize(new java.awt.Dimension(10, 50));
      pSouth.add(delbt);
      pSouth.add(calbt);
      add(pSouth, BorderLayout.SOUTH);

   } // addLayout()

   void eventProc() {
      bnd[0].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 if (ta.getText().equals(""))
					ta.append("커피 3500");
				else 
					ta.setText("커피 3500");
         }// actionPerformed
      });// addActionListener
      bnd[1].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta.append("신라면 3500");
         }// actionPerformed
      });// addActionListener
      bnd[2].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta.append("오징어짬뽕 3500");
         }// actionPerformed
      });// addActionListener
      bnd[3].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta.append("튀김우동 3000");
         }// actionPerformed
      });// addActionListener
      bnd[4].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta.append("진라면 3000");
         }// actionPerformed
      });// addActionListener
      bnd[5].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta.append("짜파게티 3500");
         }// actionPerformed
      });// addActionListener
      addbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            inputData();
         }// actionPerformed
      });// addActionListenerAddbt
      addbt2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            deleteData();
         }// actionPerformed
      });// addActionListenerAddbt2
      calbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            pay();
         }// actionPerformed
      });// addActionListenerbpay
      delbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cancelAll();
         }// actionPerformed
      });// addActionListenerbcan
      sosbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String s= tf.getText();
            JOptionPane.showMessageDialog(null,"용무 "+ s +"로 종업원 호출하였습니다. 기다리세요.");
            tf.setText("");
         }// actionPerformed
      });// addActionListenersosbt
      
   }//eventProc
   void inputData() {
      String a = ta.getText();
      String[] b = a.split(" ");
      EdibleVo v = new EdibleVo(b[0],Integer.valueOf(b[1]));
      list.add(v);
      ta.setText("");
      taJang.append(v.toString());
   }//input data
   
   void deleteData() {
      String a = ta.getText();
      if(a.equals("")) {
         JOptionPane.showMessageDialog(null, "취소할 주문이 없습니다.");
         return;
      }//if
      String[] b = a.split(" ");

      for (EdibleVo vo : list)
         if (b[0].equals(vo.getName())) {
            list.remove(vo);
            break;
         }//if

      ta.setText("");
      taJang.setText("");
      for (EdibleVo vo : list)
         taJang.append(vo.toString());
   }
   
   void pay() {
      int total = 0;
      for(EdibleVo v : list) {
         total += v.getCost();
      }//for
      JOptionPane.showMessageDialog(null, "내실 총 금액은 "+ total+" 원입니다.");
      cancelAll();
   }//pay
   
   void cancelAll() {
      taJang.setText("");
      ta.setText("");
      list = new ArrayList<EdibleVo>();
   }//cancelAll
}