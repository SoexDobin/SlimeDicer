import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Manual1 extends Frame{
	Manual1(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					dispose(); }});
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel titleL = new JLabel("정의로운 다리미", JLabel.CENTER);
		titleL.setBounds(0, 50, 400, 50);
		titleL.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>다루미는 정의감이 넘치는 슬라임 입니다!<br>3개의 주사위를 가지고 다니며 호각을 다툴 수 있는<br>상대를 찾아 여행을 하고 있습니다!<br>부디 그를 도와 무사히 여정을 마치게<br>도와주세요!</body></html>");
		subL.setBounds(50, 100, 300, 200);
		subL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		titleL.setBackground(new Color(153, 229, 80));
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(232, 255, 224));
		
		setVisible(true);
	}
}
