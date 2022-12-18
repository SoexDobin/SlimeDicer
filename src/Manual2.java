import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Manual2 extends Frame {
	Manual2(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					dispose(); }});
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel titleL = new JLabel("화끈한 다부셔", JLabel.CENTER);
		titleL.setBounds(0, 75, 400, 50);
		titleL.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>다부셔는 화가 많은 슬라임 입니다!<br>특수한 다이스를 사용하여 눈 앞의 누구든 달려들 것 입니다!<br>화나면 어떻게 될지 모릅니다!</body></html>");
		subL.setBounds(50, 100, 300, 200);
		subL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		titleL.setBackground(new Color(241, 71, 71));		
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(232, 255, 224));
		
		setVisible(true);
	}
}
