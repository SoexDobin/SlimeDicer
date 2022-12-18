import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menubar {
	@SuppressWarnings("deprecation")
	Menubar(JFrame f) {
		JMenuBar mb = new JMenuBar();
		JMenu controller = new JMenu("컨트롤러");
		JMenuItem control_home = new JMenuItem("로비 화면");
		control_home.setAccelerator(KeyStroke.getKeyStroke('H', Event.CTRL_MASK));
		JMenuItem control_out = new JMenuItem("게임 종료");
		control_out.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK));
		JMenu help = new JMenu("도움말");
		JMenuItem howToPlay = new JMenuItem("게임 방법");
		howToPlay.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK));
		JMenuItem whoMade = new JMenuItem("크레딧");
		whoMade.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
		
		control_home.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Lobby("슬라임 다이서");
			}});
		control_out.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				System.exit(0);
			}});
		howToPlay.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Howtoplay("플레이 방법");
			}});
		whoMade.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Credit("Who made ?");
			}});
		
		mb.add(controller);
		controller.add(control_home);
		controller.add(control_out);
		mb.add(help);
		help.add(howToPlay);
		help.add(whoMade);

		f.setJMenuBar(mb);
	}
}
