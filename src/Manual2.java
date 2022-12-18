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
		
		JLabel titleL = new JLabel("ȭ���� �ٺμ�", JLabel.CENTER);
		titleL.setBounds(0, 75, 400, 50);
		titleL.setFont(new Font("���� ���", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>�ٺμŴ� ȭ�� ���� ������ �Դϴ�!<br>Ư���� ���̽��� ����Ͽ� �� ���� ������ �޷��� �� �Դϴ�!<br>ȭ���� ��� ���� �𸨴ϴ�!</body></html>");
		subL.setBounds(50, 100, 300, 200);
		subL.setFont(new Font("���� ���", Font.BOLD, 15));
		
		titleL.setBackground(new Color(241, 71, 71));		
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(232, 255, 224));
		
		setVisible(true);
	}
}
