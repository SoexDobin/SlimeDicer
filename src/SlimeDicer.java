import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SlimeDicer extends JFrame {
	ImageIcon diceImage;
	int update;
	int tempUpdate1 = 1;
	int tempUpdate2 = 2;
	int tempUpdate3 = 3;
	int[] tempUpdate = {tempUpdate1, tempUpdate2, tempUpdate3};
	Graphics g;
	Toolkit tk = Toolkit.getDefaultToolkit(); 
	
	int totalPoint;
	JLabel Dialog;
	
	int playerHp = 50;
	int attackPoint = 0;
	int defensePoint = 0;
	
	int enemyHp = 50;
	int enemydmg = (int)(Math.random()*10);
	int enemyshield = (int)(Math.random()*10);
	SlimeDicer(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(new Color(160, 194, 255));
		
		JPanel dice1 = new JPanel() {
			public void paint(Graphics g) {
				ImageIcon diceImage = new ImageIcon("String.format(\"img/Dice%d.png\", tempUpdate[0])");
				if (diceImage.getImage() == null) {return;}
				g.drawImage(diceImage.getImage(), 0, 0, null);}};
		JPanel dice2 = new JPanel() {
			public void paint(Graphics g) {
				ImageIcon diceImage = new ImageIcon("String.format(\"img/Dice%d.png\", tempUpdate[0])");
				if (diceImage.getImage() == null) {return;}
				g.drawImage(diceImage.getImage(), 0, 0, null);}};
		JPanel dice3 = new JPanel() {
			public void paint(Graphics g) {
				ImageIcon diceImage = new ImageIcon("String.format(\"img/Dice%d.png\", tempUpdate[0])");
				if (diceImage.getImage() == null) {return;}
				g.drawImage(diceImage.getImage(), 0, 0, null);}};
		JPanel[] dicepack = {dice1, dice2, dice3};
		dice1.setBounds(250, 75, 100, 100);
		dice2.setBounds(350, 75, 100, 100);
		dice3.setBounds(450, 75, 100, 100);
		dice1.setBackground(Color.white);
		dice2.setBackground(Color.white);
		dice3.setBackground(Color.white);
		
		// 클라이언트 콘솔
		JLabel dialog = new JLabel("다이스를 돌려 게임을 시작하세요!", JLabel.CENTER);
		dialog.setBounds(0, 440, 800, 100);
		dialog.setBackground(Color.orange);
		dialog.setOpaque(true);
		dialog.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		// 플레이어
		JPanel player = new JPanel() {
			ImageIcon playerImage = new ImageIcon("img/InDireme.png");
			public void paint(Graphics g) {
				if (playerImage.getImage() == null) {return;}
				g.drawImage(playerImage.getImage(), 0, 0, null);
	      	}
		};
		player.setBounds(200, 300, 100, 100);
		// 적
		JPanel enemy = new JPanel() {
			ImageIcon enemyImage = new ImageIcon("img/InEnemy.png");
			public void paint(Graphics g) {
				if (enemyImage.getImage() == null) {return;}
				g.drawImage(enemyImage.getImage(), 0, 0, null);
	      	}
		};
		enemy.setBounds(500, 300, 100, 100);
		// 다음 턴 버튼
		JButton nextTurn = new JButton("턴 넘기기");
		nextTurn.setBounds(340, 360, 120, 50);
		// 주사위 굴리기 버튼
		JButton rollDice = new JButton("주사위 굴리기");
		rollDice.setBounds(340, 285, 120, 50);
		nextTurn.setEnabled(false);
		
		// 플레이어 제어 패널
		JPanel playerUi = new JPanel(); 
		playerUi.setBounds(0, 215, 200, 250);
		playerUi.setBackground(new Color(0, 0, 0, 0));
		JLabel pHp = new JLabel(String.format("체력 %d", playerHp), JLabel.CENTER);
		JLabel pDmg = new JLabel(String.format("데미지 %d", attackPoint), JLabel.CENTER);
		JLabel pDef = new JLabel(String.format("방어력 %d", defensePoint), JLabel.CENTER);
		JLabel[] playerArg = {pDmg, pDef};
		pHp.setPreferredSize(new Dimension(200, 50));
		pHp.setBackground(Color.GRAY);
		pHp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pHp.setOpaque(true);
		for(int pindex = 0; pindex < 2; pindex++) {
			playerArg[pindex].setOpaque(true);
			playerArg[pindex].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			playerArg[pindex].setPreferredSize(new Dimension(80, 50));
			playerArg[pindex].setBackground(Color.GRAY);
		}
		// 플레이어 제어 버튼
		JButton dmgup_btn = new JButton("+");
		JButton dmgdown_btn = new JButton("-");
		JButton shieldup_btn = new JButton("+");
		JButton shielddown_btn = new JButton("-");
		JButton[] btnPack = {dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn};
		for(int btn_index = 0; btn_index < 4; btn_index++) {
			btnPack[btn_index].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btnPack[btn_index].setPreferredSize(new Dimension(45, 45));
		}
		playerUi.add(pHp);
		playerUi.add(dmgdown_btn);playerUi.add(pDmg);playerUi.add(dmgup_btn);
		playerUi.add(shielddown_btn);playerUi.add(pDef);playerUi.add(shieldup_btn);
		Init_btn(dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn);
		// 적 데이터 출력 패널
		JPanel enemyUi = new JPanel();
		enemyUi.setBounds(600, 220, 150, 170);
		enemyUi.setBackground(new Color(0, 0, 0, 0));
		JLabel eHp = new JLabel(String.format("체력 %d", enemyHp), JLabel.CENTER);
		JLabel eDmg = new JLabel(String.format("데미지 %d", enemydmg), JLabel.CENTER);
		JLabel eDef = new JLabel(String.format("방어력 %d", enemyshield), JLabel.CENTER);
		JLabel[] enemyArg = {eHp, eDmg, eDef};
		for(int eindex = 0; eindex < 3; eindex++) {
			enemyArg[eindex].setOpaque(true);
			enemyArg[eindex].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			enemyArg[eindex].setPreferredSize(new Dimension(100, 50));
			enemyArg[eindex].setBackground(Color.GRAY);
		}
		eHp.setPreferredSize(new Dimension(300, 50));
		enemyUi.add(eHp);
		enemyUi.add(eDmg);
		enemyUi.add(eDef);
		
		dmgup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attackPoint++;
				totalMinus();
				setDmgText(pDmg, dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn, dialog);
			}
		});
		dmgdown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attackPoint--;
				totalPlus();
				setDmgText(pDmg, dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn, dialog);
			}
		});
		shieldup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defensePoint++;
				totalMinus();
				setDefText(pDef, dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn, dialog);
			}
		});
		shielddown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defensePoint--;
				totalPlus();
				setDefText(pDef, dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn, dialog);
			}
		});
		nextTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rollDice.setEnabled(true);
				nextTurn.setEnabled(false);
				Battle(pHp, eHp);
				
				totalPoint = 0;
				attackPoint = 0;
				defensePoint = 0;
				pDmg.setText(String.format("데미지 %d", attackPoint));
				pDef.setText(String.format("방어력 %d", defensePoint));
				dialog.setText(String.format("남은 다이스 눈 개수 %d개", totalPoint));
				Init_btn(dmgup_btn, dmgdown_btn, shieldup_btn, shielddown_btn);
				
				enemydmg = (int)(Math.random()*18);
				enemyshield = (int)(Math.random()*15);
				eDmg.setText(String.format("데미지 %d", enemydmg));
				eDef.setText(String.format("방어력 %d", enemyshield));
				
				if(playerHp<=0 && enemyHp<=0) {new Draw("무 승 부 !");dispose();}
				else if(enemyHp<=0) { new Win("승 리 !"); dispose();}
				else if(playerHp<=0) {new Lose("패 배 !"); dispose();}
			}
		});
		rollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i< 3; i++) {
					rollDice.setEnabled(false);
					nextTurn.setEnabled(true);
					update = (int)(Math.random()*6)+1;
					tempUpdate[i] = update;
					diceImage = new ImageIcon(String.format("img/Dice%d.png", tempUpdate[i]));
					g = dicepack[i].getGraphics();
					g.drawImage(diceImage.getImage(), 0, 0, null);
					totalPoint += update;
				}
				dmgup_btn.setEnabled(true);
				shieldup_btn.setEnabled(true);
				dmgdown_btn.setEnabled(false);
				shielddown_btn.setEnabled(false);
				dialog.setText(String.format("남은 다이스 눈 개수 %d개", totalPoint));
			}
		});
		
		JPanel drawBack = new JPanel() {
			public void paint(Graphics g) {
				ImageIcon diceImage = new ImageIcon("img/InGameBack.png");
				if (diceImage.getImage() == null) {return;}
				g.drawImage(diceImage.getImage(), 0, 0, null);
			}
		};
		drawBack.setBounds(0,0,800,600);
		add(dice1);
		add(dice2);
		add(dice3);
		
		add(enemy);
		add(player);
		
		add(rollDice);
		add(nextTurn);
		
		add(dialog);
		
		add(playerUi);
		add(enemyUi);

		add(drawBack);
		
		setVisible(true);
		new Menubar(this);
	}
	public void setDmgText(JLabel pDmg, JButton dmgup_btn, JButton dmgdown_btn, JButton shieldup_btn, JButton shielddown_btn, JLabel dialog) {
		isUseAllP(dmgup_btn, shieldup_btn);
		isZeroP(dmgdown_btn, shielddown_btn);
		pDmg.setText(String.format("데미지 %d", attackPoint));
		dialog.setText(String.format("남은 다이스 눈 개수 %d개", totalPoint));
	}
	public void setDefText(JLabel pDef, JButton dmgup_btn, JButton dmgdown_btn, JButton shieldup_btn, JButton shielddown_btn, JLabel dialog) {
		isUseAllP(dmgup_btn, shieldup_btn);
		isZeroP(dmgdown_btn, shielddown_btn);
		pDef.setText(String.format("방어력 %d", defensePoint));
		dialog.setText(String.format("남은 다이스 눈 개수 %d개", totalPoint));
	}
	public void totalPlus() {totalPoint++;}
	public void totalMinus() {totalPoint--;}
	public void isUseAllP(JButton dmgup_btn, JButton shieldup_btn) {
		if(totalPoint==0) {
			dmgup_btn.setEnabled(false);
			shieldup_btn.setEnabled(false);
		}
		else if(totalPoint>0) {
			dmgup_btn.setEnabled(true);
			shieldup_btn.setEnabled(true);
		}
	}
	public void isZeroP(JButton dmgdown_btn, JButton shielddown_btn) {
		if (attackPoint<=0) {
			dmgdown_btn.setEnabled(false);
		} else if(attackPoint>0) {
			dmgdown_btn.setEnabled(true);
		}
		if (defensePoint<=0) {
			shielddown_btn.setEnabled(false);
		} else if(defensePoint>0) {
			shielddown_btn.setEnabled(true);
		}
	}
	public void Init_btn(JButton dmgup_btn, JButton dmgdown_btn, JButton shieldup_btn, JButton shielddown_btn) {
		dmgup_btn.setEnabled(false);
		shieldup_btn.setEnabled(false);
		dmgdown_btn.setEnabled(false);
		shielddown_btn.setEnabled(false);
	}
	public void Battle(JLabel pHp, JLabel eHp) {
		if (playerHp > 0) {
			if(defensePoint>=enemydmg) {
				playerHp=playerHp;
			}else if(defensePoint<enemydmg) {
				playerHp = (playerHp-enemydmg)+defensePoint;
			}
			if(enemyshield>=attackPoint) {
				enemyHp=enemyHp;
			}else if(enemyshield<attackPoint) {
				enemyHp -= attackPoint-enemyshield;
			}
			pHp.setText(String.format("체력 %d", playerHp));
			eHp.setText(String.format("체력 %d", enemyHp));
		}
	}
}

