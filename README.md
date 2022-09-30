# KosmoMidProject-Cafe
kosmo - midterm project (Cafe kiosk)

---
**MainTest.java**

JTabbedPane을 사용하여 탭(<Panel_names>)그룹을 만들었습니다.<br />  
(pEast)는 오른쪽에 있는 고정 패널입니다. 이 고정패널 안에는 직원호출, 주문내역, 장바구니 추가 및 취소 버튼이 들어있어 각 <Panel_names>에서 호출 됩니다. EdibleVo 의 객체들을 <EdibleVo> list에 저장합니다.


**Panel_Main.java**

라면, 분식, 간식, 음료 버튼들을 만들고 GridLayout을 사용해 2x2 모양으로 페이지를 만들었습니다. 이 버튼들을 누르면 각 <Panel_names>탭으로 이동합니다.

---
**EdibleVo.java**

음식들을 저장할 오브젝트를 만들었습니다.<br />  
Panel_Main.java의 list 에 장바구니 추가 버튼이 눌린 객체들을 저장합니다.

---
**Panel_Drink.java**

**Panel_Food.java**

**Panel_Noodle.java**

**Panel_Snack.java**

<Panel_names.java> 의 예시를 위해 Panel_Drink 의 메소드 이름과 함수들로 설명하겠습니다. <br /> 

_레이아웃(addLayout):_ <br />  
 왼쪽 패널(pWest)에 메뉴버튼들을 3x2 모양으로 만들고, 아래 패널(pSouth)에 모두 취소, 모두 결제 버튼을 만들었습니다.<br />
 <br /> 
 
_이벤트 발생시(eventProc):_ <br />  
 *bnd*: <Panel_names>에 있는 메뉴 버튼들이 눌렸을때 MainTest.java의 (장바구니를 위한 text area 함수: ta) ta에 더합니다. <br />
 *addbt*: 장바구니에 띄운 후 <장바구니 추가> 버튼이 눌리면 MainTest.java의 <EdibleVo> list 에 추가합니다. <br />
 *addbt2*: <장바구니 취소> 버튼은 ta에 있는 주문을 장바구니에서 없애줍니다. <br />
 *bpay*: <결제>를 누르면 총 금액과 "결제하시겠습니까" 창이 뜨고 모든 값들이 초기화 됩니다.<br />
 *bcan*: <모두 취소>를 누르면 모든 값들이 초기화 됩니다.<br />
 *sosbt*: 직원 호출버튼은 (직원 호출을 위한 text field함수: tf)tf에 있는 주문사항을 띄웁니다.<br />
    
