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
		
		JLabel titleL = new JLabel("���Ƿο� �ٸ���", JLabel.CENTER);
		titleL.setBounds(0, 50, 400, 50);
		titleL.setFont(new Font("���� ���", Font.BOLD, 20));

		JLabel subL = new JLabel("<html><body>�ٷ�̴� ���ǰ��� ��ġ�� ������ �Դϴ�!<br>3���� �ֻ����� ������ �ٴϸ� ȣ���� ���� �� �ִ�<br>��븦 ã�� ������ �ϰ� �ֽ��ϴ�!<br>�ε� �׸� ���� ������ ������ ��ġ��<br>�����ּ���!</body></html>");
		subL.setBounds(50, 100, 300, 200);
		subL.setFont(new Font("���� ���", Font.BOLD, 15));
		
		titleL.setBackground(new Color(153, 229, 80));
		titleL.setOpaque(true);
		
		add(titleL);
		add(subL);
		
		setBackground(new Color(232, 255, 224));
		
		setVisible(true);
	}
}
