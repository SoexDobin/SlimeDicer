import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Howtoplay extends Frame{
	Howtoplay(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					dispose(); }});
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel titleL = new JLabel("플레이 방법", JLabel.CENTER);
		titleL.setBounds(0, 50, 400, 50);
		titleL.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>1. 중앙 돌리기 버튼으로 3개의 다이스를 돌려 줍니다!<br><br>"
				+ "2. 적의 공격력과 방어력에 따라 주어진 주사위 눈을 분배하세요. <br><br>"
				+ "3. 분배를 마치면 턴 넘기기 버튼을 눌러 진행해주세요.<br><br>"
				+ "4. 상대 체력을 0을 만들면 승리합니다! </body></html>");
		subL.setBounds(50, 75, 300, 300);
		subL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		titleL.setBackground(new Color(153, 229, 80));
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(224, 243, 248));
		
		setVisible(true);
	}
}
