import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Draw extends JFrame{
	Draw(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		JPanel drawBack = new JPanel() {
			public void paint(Graphics g) {
				ImageIcon diceImage = new ImageIcon("img/background.jpg");
				if (diceImage.getImage() == null) {return;}
				g.drawImage(diceImage.getImage(), 0, 0, null);
			}
		};
		drawBack.setBounds(0,0, 800, 600);
		JButton out_btn = new JButton("���� ����");
		JButton restart_btn = new JButton("�ٽ� ����");
		JButton selectCha_btn = new JButton("ĳ���� ���� â");
		JButton[] btn_list = {out_btn, restart_btn, selectCha_btn};
		for(int i = 0; i < 3; i++) {
			btn_list[i].setSize(200, 75);
			btn_list[i].setFont(new Font("���� ���", Font.BOLD, 20));
		}
		out_btn.setLocation(300, 140);
		restart_btn.setLocation(300, 240);
		selectCha_btn.setLocation(300, 340);
		
		out_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		restart_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SlimeDicer("������ ���̼�");
			}
		});
		selectCha_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CharacterSelect("���̼� ����");
			}
		});
		
		add(out_btn);
		add(restart_btn);
		add(selectCha_btn);
		add(drawBack);
		setVisible(true);
		new Menubar(this);
	}
}
