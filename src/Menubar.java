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
		JMenu controller = new JMenu("��Ʈ�ѷ�");
		JMenuItem control_home = new JMenuItem("�κ� ȭ��");
		control_home.setAccelerator(KeyStroke.getKeyStroke('H', Event.CTRL_MASK));
		JMenuItem control_out = new JMenuItem("���� ����");
		control_out.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK));
		JMenu help = new JMenu("����");
		JMenuItem howToPlay = new JMenuItem("���� ���");
		howToPlay.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK));
		JMenuItem whoMade = new JMenuItem("ũ����");
		whoMade.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
		
		control_home.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Lobby("������ ���̼�");
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
				new Howtoplay("�÷��� ���");
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
