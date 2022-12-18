import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Credit extends Frame {
	Credit(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					dispose(); }});
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel dirL = new JLabel("디렉터 : 201810070_최재욱 ", JLabel.CENTER);
		dirL.setBounds(0, 75, 400, 50);
		dirL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		dirL.setBackground(new Color(239, 62, 91));
		dirL.setOpaque(true);
		
		JLabel progL = new JLabel("프로그래밍 : 201810070_최재욱 ", JLabel.CENTER);
		progL.setBounds(0, 175, 400, 50);
		progL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		progL.setBackground(new Color(75, 37, 109));
		progL.setOpaque(true);
		
		JLabel drawL = new JLabel("아트 : 201810070_최재욱 ", JLabel.CENTER);
		drawL.setBounds(0, 275, 400, 50);
		drawL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		drawL.setBackground(new Color(0, 176, 178));
		drawL.setOpaque(true);
		
		dirL.setForeground(new Color(255,255,255));
		progL.setForeground(new Color(255,255,255));
		drawL.setForeground(new Color(255,255,255));
		

		add(dirL);
		add(progL);
		add(drawL);
		
		setBackground(new Color(224, 243, 248));
		
		setVisible(true);
	}
}
