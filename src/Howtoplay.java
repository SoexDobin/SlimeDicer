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
		
		JLabel titleL = new JLabel("�÷��� ���", JLabel.CENTER);
		titleL.setBounds(0, 50, 400, 50);
		titleL.setFont(new Font("���� ���", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>1. �߾� ������ ��ư���� 3���� ���̽��� ���� �ݴϴ�!<br><br>"
				+ "2. ���� ���ݷ°� ���¿� ���� �־��� �ֻ��� ���� �й��ϼ���. <br><br>"
				+ "3. �й踦 ��ġ�� �� �ѱ�� ��ư�� ���� �������ּ���.<br><br>"
				+ "4. ��� ü���� 0�� ����� �¸��մϴ�! </body></html>");
		subL.setBounds(50, 75, 300, 300);
		subL.setFont(new Font("���� ���", Font.BOLD, 15));
		
		titleL.setBackground(new Color(153, 229, 80));
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(224, 243, 248));
		
		setVisible(true);
	}
}
