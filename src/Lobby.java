import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Lobby extends JFrame {
	Font font =  new Font("맑은 고딕", Font.BOLD, 15);
	Toolkit tk = Toolkit.getDefaultToolkit();
	ImageIcon background = new ImageIcon("img/background.jpg");
	JPanel imageLayer = new JPanel(){ 	
		public void paint(Graphics g) {
			background.getImage();
			if (background.getImage() == null) {return;}
			g.drawImage(background.getImage(), 0, 0, null);
	    }
	};
	Lobby(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		imageLayer.setLayout(null);
		imageLayer.setSize(800,600);
		
		JButton start = new JButton("게임 시작");
		JButton close = new JButton("나가기");
		start.setBounds(350, 350, 100, 50);
		close.setBounds(350, 450, 100, 50);
		start.setFont(font);
		close.setFont(font);
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);}});
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CharacterSelect("다이서 선택");				
				setVisible(false);}});

		add(start);
		add(close);
		new Menubar(this);
		add(imageLayer);
		setVisible(true);
	}
}
