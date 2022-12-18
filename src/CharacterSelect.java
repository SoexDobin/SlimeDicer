import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CharacterSelect extends JFrame{
	Font font =  new Font("���� ���", Font.BOLD, 15);
	Color white = new Color(255,255,255);
	CharacterSelect(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		JPanel imageBox1 = new JPanel() {
			ImageIcon chaImage = new ImageIcon("img/Direme.png");
			public void paint(Graphics g) {
				if (chaImage.getImage() == null) {return;}
				g.drawImage(chaImage.getImage(), 0, 0, null);
			}
		};
		JPanel imageBox2 = new JPanel() {
			ImageIcon chaImage = new ImageIcon("img/Dibusyeo.png");
			public void paint(Graphics g) {
				if (chaImage.getImage() == null) {return;}
				g.drawImage(chaImage.getImage(), 0, 0, null);
	      	}
		};
		
		imageBox1.setSize(200, 200);
		imageBox1.setLocation(150, 150);
		imageBox2.setSize(200, 200);
		imageBox2.setLocation(450, 150);
		
		JPanel FirstCh = new JPanel(new GridLayout(2,1,0,10));
		FirstCh.setBounds(150, 350, 200, 100);
		FirstCh.setBackground(Color.ORANGE);
		JPanel SecondCh = new JPanel(new GridLayout(2,1,0,10));
		SecondCh.setBounds(450, 350, 200, 100);
		SecondCh.setBackground(Color.orange);
		
		Label chooseCharacter = new Label("���̼��� ������ �ּ���!", Label.CENTER);
		chooseCharacter.setBackground(Color.orange);
		chooseCharacter.setBounds(0, 50, 800, 50);
		chooseCharacter.setFont(font);
		
		JButton firstManual = new JButton("�ٸ��� ����");
		firstManual.setBackground(new Color(153, 229, 80));
		firstManual.setForeground(white);
		JButton secondManual = new JButton("�ٺμ� ����");
		secondManual.setBackground(new Color(241, 71, 71));
		secondManual.setForeground(white);
		JButton selectCha1 = new JButton("�ٸ��� ����");
		JButton selectCha2 = new JButton("�ٺμ� ����");
		firstManual.setFont(font);
		secondManual.setFont(font);
		selectCha1.setFont(font);
		selectCha2.setFont(font);
		
		firstManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manual1("�ٸ��� �� ������?");
			}
		});
		secondManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Manual2("�ٺμ� �� ������?");
			}
		}); 
		selectCha1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SlimeDicer("������ ���̼�");
			}
		}); 
		selectCha2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseCharacter.setText("�̱��� ĳ���� �Դϴ�! �ٸ� ĳ���͸� ������ �ּ���!");
			}
		}); 
		add(imageBox1);
		add(imageBox2);
		
		add(chooseCharacter);
		add(FirstCh);
		add(SecondCh);
		
		FirstCh.add(firstManual);
		FirstCh.add(selectCha1);
		SecondCh.add(secondManual);
		SecondCh.add(selectCha2);
		
		new Menubar(this);
		getContentPane().setBackground(new Color(160, 194, 255));
		
		setVisible(true);
	}
}
