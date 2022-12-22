package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

//import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.TimerTask;
import java.util.Locale;
import java.util.Timer;
import javax.swing.JLayeredPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.SystemColor;
import java.text.NumberFormat;
import javax.swing.JCheckBox;

public class JavaBoneClicker {
	
	static Timer timer = new Timer();
	static Thread thread1 = new Thread();
	
	public class Delay extends Thread {
		
		@Override
		public void run() {
				try {
					Thread.sleep(2000);
						btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
						btnReset.setText("Reset");
						btnResetClicked = false;
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
	//images
	ImageIcon backdrop = new ImageIcon(getClass().getClassLoader().getResource("StripedBackgroundLight.png"));
	ImageIcon bone = new ImageIcon(getClass().getClassLoader().getResource("BoneTransparent.png"));
	ImageIcon tier1 = new ImageIcon(getClass().getClassLoader().getResource("BoneT1Transparent.png"));
	ImageIcon tier2 = new ImageIcon(getClass().getClassLoader().getResource("BoneT2Transparent.png"));
	ImageIcon tier3 = new ImageIcon(getClass().getClassLoader().getResource("BoneT3Transparent.png"));
	ImageIcon tier4 = new ImageIcon(getClass().getClassLoader().getResource("BoneT4Transparent.png"));
	ImageIcon tier5 = new ImageIcon(getClass().getClassLoader().getResource("BoneT5Transparent.png"));
	ImageIcon tier6 = new ImageIcon(getClass().getClassLoader().getResource("BoneT6Transparent.png"));
	
	//math variables and large values
	static MathContext round4 = new MathContext(4, RoundingMode.FLOOR);
	static BigDecimal k = BigDecimal.valueOf(Math.pow(10, 3));
	static BigDecimal m = BigDecimal.valueOf(Math.pow(10, 6));
	static BigDecimal b = BigDecimal.valueOf(Math.pow(10, 9));
	static BigDecimal t = BigDecimal.valueOf(Math.pow(10, 12));
	static BigDecimal q = BigDecimal.valueOf(Math.pow(10, 15));
	static BigDecimal qi = BigDecimal.valueOf(Math.pow(10, 18));
	static BigDecimal s = BigDecimal.valueOf(Math.pow(10, 21));
	static BigDecimal se = BigDecimal.valueOf(Math.pow(10, 24));
	static BigDecimal oct = BigDecimal.valueOf(Math.pow(10, 27));
	static BigDecimal n = BigDecimal.valueOf(Math.pow(10, 30));
	static BigDecimal dec = BigDecimal.valueOf(Math.pow(10, 33));
	static BigDecimal aa = BigDecimal.valueOf(Math.pow(10, 36));
	static BigDecimal bb = BigDecimal.valueOf(Math.pow(10, 39));
	static BigDecimal cc = BigDecimal.valueOf(Math.pow(10, 42));
	
	static NumberFormat nf = NumberFormat.getInstance();
	static BigDecimal formattedBones;
	
	//initial declarations
	static JButton btnBuy1;
	static JButton btnBuy2;
	static JButton btnBuy3;
	static JButton btnBuy4;
	static JButton btnBuy5;
	
	static JButton btnUpgradeUnit1;
	static JButton btnUpgradeUnit2;
	static JButton btnUpgradeUnit3;
	static JButton btnUpgradeUnit4;
	static JButton btnUpgradeUnit5;
	
	private JLabel lblShop;
	static JButton btnUpgradeBone;
	static JButton btnReset;
	static JButton btnLabelStatsClose;
	static JPanel panelStats;
	JLabel lblClicksStat;
	JLabel lblBonesSpentStat;
	static JLabel lblBonesProducedStat;
	JLabel btnAddBones;
	
	private JFrame frame;
	static JLabel lblBones;
	static JLabel lblBPS;
	static JLabel lblStats;

	static JPanel panelReset;
	JPanel panelHolyMilk;
	static JLabel lblHolyMilkAmount;
	static JLabel lblHolyMilkText1;
	static JLabel lblHolyMilkText2;
	
	//Item upgrade costs
	static BigDecimal defaultUnit1UpgradeCost = BigDecimal.valueOf(100);
	static BigDecimal defaultUnit2UpgradeCost = BigDecimal.valueOf(1000);
	static BigDecimal defaultUnit3UpgradeCost = BigDecimal.valueOf(10000);
	static BigDecimal defaultUnit4UpgradeCost = BigDecimal.valueOf(100000);
	static BigDecimal defaultUnit5UpgradeCost = BigDecimal.valueOf(1000000);
	
	static BigDecimal currentUnit1UpgradeCost = defaultUnit1UpgradeCost;
	static BigDecimal currentUnit2UpgradeCost = defaultUnit2UpgradeCost;
	static BigDecimal currentUnit3UpgradeCost = defaultUnit3UpgradeCost;
	static BigDecimal currentUnit4UpgradeCost = defaultUnit4UpgradeCost;
	static BigDecimal currentUnit5UpgradeCost = defaultUnit5UpgradeCost;
	
	 //Item levels
	static int unit1Level = 0;
	static int unit2Level = 0;
	static int unit3Level = 0;
	static int unit4Level = 0;
	static int unit5Level = 0;
	
	//Unit multipliers
	static BigDecimal unit1Multiplier = BigDecimal.valueOf(1);
	static BigDecimal unit2Multiplier = BigDecimal.valueOf(1);
	static BigDecimal unit3Multiplier = BigDecimal.valueOf(1);
	static BigDecimal unit4Multiplier = BigDecimal.valueOf(1);
	static BigDecimal unit5Multiplier = BigDecimal.valueOf(1);
	
	//Item costs
	
	static BigDecimal defaultUnit1Cost = BigDecimal.valueOf(10);
	static BigDecimal defaultUnit2Cost = BigDecimal.valueOf(70);
	static BigDecimal defaultUnit3Cost = BigDecimal.valueOf(800);
	static BigDecimal defaultUnit4Cost = BigDecimal.valueOf(5000);
	static BigDecimal defaultUnit5Cost = BigDecimal.valueOf(50000);
	
	static BigDecimal currentUnit1Cost = defaultUnit1Cost;
	static BigDecimal currentUnit2Cost = defaultUnit2Cost;
	static BigDecimal currentUnit3Cost = defaultUnit3Cost;
	static BigDecimal currentUnit4Cost = defaultUnit4Cost;
	static BigDecimal currentUnit5Cost = defaultUnit5Cost;
	
	//Item Bones/sec
	static BigDecimal unit1BPS = BigDecimal.valueOf(0.5);
	static BigDecimal unit2BPS = BigDecimal.valueOf(3);
	static BigDecimal unit3BPS = BigDecimal.valueOf(12);
	static BigDecimal unit4BPS = BigDecimal.valueOf(40);
	static BigDecimal unit5BPS = BigDecimal.valueOf(150);
	
	 //Tier costs
	static BigDecimal tier1Cost = BigDecimal.valueOf(200);
	static BigDecimal tier2Cost = BigDecimal.valueOf(2000);
	static BigDecimal tier3Cost = BigDecimal.valueOf(10000);
	static BigDecimal tier4Cost = BigDecimal.valueOf(100000);
	static BigDecimal tier5Cost = BigDecimal.valueOf(1000000);
	static BigDecimal tier6Cost = BigDecimal.valueOf(10000000);
	
	//bones/click for tiers
	static BigDecimal tier0Increment = BigDecimal.valueOf(1);
	static BigDecimal tier1Increment = BigDecimal.valueOf(2);
	static BigDecimal tier2Increment = BigDecimal.valueOf(5);
	static BigDecimal tier3Increment = BigDecimal.valueOf(10);
	static BigDecimal tier4Increment = BigDecimal.valueOf(20);
	static BigDecimal tier5Increment = BigDecimal.valueOf(50);
	static BigDecimal tier6Increment = BigDecimal.valueOf(100);
	
	//initial data ----------------------------------------------
	static BigDecimal bones = BigDecimal.valueOf(0);
	
	static BigDecimal currentIncrement = BigDecimal.valueOf(1);
	
	//holy milk-related values
	static BigDecimal possibleHolyMilkPints = BigDecimal.valueOf(0);
	static BigDecimal actualHolyMilkPints = BigDecimal.valueOf(0);
	static BigDecimal bonesPerPint = BigDecimal.valueOf(1000000000);
	static final double bonusPerPint = 0.02;
	
	//stat data
	static BigDecimal totalBonus = BigDecimal.valueOf(0);
	static BigDecimal totalSpent = BigDecimal.valueOf(0);
	static BigDecimal totalProduced = BigDecimal.valueOf(0);
	int totalClicks = 0;
	int totalResets = 0;
	static int currentTier = 0;
	static BigDecimal currentTierCost = tier1Cost;
	static int ticks = 0;
	
	//booleans
		boolean timerOn = false;
		boolean statsOn = false;
		boolean holyMilkOn = false;
		boolean btnResetClicked = false;
	//------------------------------------------------------------
	
	//number of units 
	static int unit1Units = 0;
	static int unit2Units = 0;
	static int unit3Units = 0;
	static int unit4Units = 0;
	static int unit5Units = 0;
	
	static BigDecimal perSec = ( 
			     (BigDecimal.valueOf(unit1Units).multiply(unit1BPS).multiply(unit1Multiplier)) 
			.add (BigDecimal.valueOf(unit2Units).multiply(unit2BPS).multiply(unit2Multiplier)) 
			.add (BigDecimal.valueOf(unit3Units).multiply(unit3BPS).multiply(unit3Multiplier)) 
			.add (BigDecimal.valueOf(unit4Units).multiply(unit4BPS).multiply(unit4Multiplier)) 
			.add (BigDecimal.valueOf(unit5Units).multiply(unit5BPS).multiply(unit5Multiplier))
			);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//lblBones.setText("You have " + formatNumber(bones, false) + "Bones");
		
		System.out.println("bones: " + bones);
		createFormat();
		startTimer();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaBoneClicker window = new JavaBoneClicker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public JavaBoneClicker() {
		initialize();
		initializeFormats();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	
	/*public void updateTimer() {
		
		if(timerOn == false) {
			timerOn = true;
		}
		else if(timerOn == true) {
			timer.stop();
		}
		
		double speed = 1/perSec*1000;
		timerSpeed = (int) Math.round(speed);
		
		System.out.println("Unrounded timer speed: " + speed + " " + timerSpeed);
		
		startTimer();
		System.out.println("x");
		timer.start();
		System.out.println("y");
		
	}
	
	public void startTimer() {
		
		timer = new Timer(timerSpeed, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bones++;
				lblbones.setText("You have " + bones + " bones.");
				
				
			}
		});
	}
	*/
	public static void initializeFormats() {
		
		lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
		
		btnBuy1.setText("<html>Buy Milk (" + unit1Units + ")<br>" + formatNumber(currentUnit1Cost, false) + " Bones");
		btnBuy2.setText("<html>Buy Calcium (" + unit2Units + ")<br>" + formatNumber(currentUnit2Cost, false) + " Bones");
		btnBuy3.setText("<html>Buy Skeleton (" + unit3Units + ")<br>" + formatNumber(currentUnit3Cost, false) + " Bones");
		btnBuy4.setText("<html>Buy Graveyard (" + unit4Units + ")<br>" + formatNumber(currentUnit4Cost, false) + " Bones");
		btnBuy5.setText("<html>Buy Heck (" + unit5Units + ")<br>" + formatNumber(currentUnit5Cost, false) + " Bones");
		
		btnUpgradeUnit1.setText("<html>Upgrade<br> (lvl " + unit1Level + ")<br> " + formatNumber(currentUnit1UpgradeCost, false) + " Bones");
		btnUpgradeUnit2.setText("<html>Upgrade<br> (lvl " + unit2Level + ")<br> " + formatNumber(currentUnit2UpgradeCost, false) + " Bones");
		btnUpgradeUnit3.setText("<html>Upgrade<br> (lvl " + unit3Level + ")<br> " + formatNumber(currentUnit3UpgradeCost, false) + " Bones");
		btnUpgradeUnit4.setText("<html>Upgrade<br> (lvl " + unit4Level + ")<br> " + formatNumber(currentUnit4UpgradeCost, false) + " Bones");
		btnUpgradeUnit5.setText("<html>Upgrade<br> (lvl " + unit5Level + ")<br> " + formatNumber(currentUnit5UpgradeCost, false) + " Bones");
		
		btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier1Cost, false) + " Bones");
		
	}
	public static void createFormat() {
		//nf.getCompactNumberInstance(Locale.CANADA, NumberFormat.Style.SHORT);
		nf.setMaximumFractionDigits(0);
	}
	
	public static String formatNumber(BigDecimal num, boolean isBPS) {
		
		String formatted = "";
		if (isBPS == true & num.compareTo(k) < 0) {
			//System.out.println("x");
			//System.out.println(num);
				formatted = ""+num.setScale(1, RoundingMode.DOWN)+"";
		}
		else if (num.compareTo(BigDecimal.ZERO) >= 0 & num.compareTo(k) < 0) {
				formatted = ""+num.setScale(0, RoundingMode.DOWN)+"";
		}
		else if (num.compareTo(k) >= 0 & num.compareTo(m) < 0) {
			num = num.divide(k);
			num = num.round(round4);
			formatted = num.toPlainString() + "K";		
		}	
		else if (num.compareTo(m) >= 0 & num.compareTo(b) < 0) {
			num = num.divide(m);
			num = num.round(round4);
			formatted = num.toPlainString() + "M";
		}
		else if (num.compareTo(b) >= 0 & num.compareTo(t) < 0) {
			num = num.divide(b);
			num = num.round(round4);
			formatted = num.toPlainString() + "B";
		}
		else if (num.compareTo(t) >= 0 & num.compareTo(q) < 0) {
			num = num.divide(t);
			num = num.round(round4);
			formatted = num.toPlainString() + "T";
		}
		else if (num.compareTo(q) >= 0 & num.compareTo(qi) < 0) {
			num = num.divide(q);
			num = num.round(round4);
			formatted = num.toPlainString() + "Q";
		}
		else if (num.compareTo(qi) >= 0 & num.compareTo(s) < 0) {
			num = num.divide(qi);
			num = num.round(round4);
			formatted = num.toPlainString() + "Qi";
		}
		else if (num.compareTo(s) >= 0 & num.compareTo(se) < 0) {
			num = num.divide(s);
			num = num.round(round4);
			formatted = num.toPlainString() + "S";
		}
		else if (num.compareTo(se) >= 0 & num.compareTo(oct) < 0) {
			num = num.divide(se);
			num = num.round(round4);
			formatted = num.toPlainString() + "Se";
		}
		else if (num.compareTo(oct) >= 0 & num.compareTo(n) < 0) {
			num = num.divide(oct);
			num = num.round(round4);
			formatted = num.toPlainString() + "Oct";
		}
		else if (num.compareTo(n) >= 0 & num.compareTo(dec) < 0) {
			num = num.divide(n);
			num = num.round(round4);
			formatted = num.toPlainString() + "N";
		}
		else if (num.compareTo(dec) >= 0 & num.compareTo(aa) < 0) {
			num = num.divide(dec);
			num = num.round(round4);
			formatted = num.toPlainString() + "Dec";
		}
		else if (num.compareTo(aa) >= 0 & num.compareTo(bb) < 0) {
			num = num.divide(aa);
			num = num.round(round4);
			formatted = num.toPlainString() + "Aa";
		}
		else if (num.compareTo(bb) >= 0 & num.compareTo(cc) < 0) {
			num = num.divide(bb);
			num = num.round(round4);
			formatted = num.toPlainString() + "Bb";
		}
		return formatted;
	}
	
	public static void updateBPS() {
		perSec = (
					 (BigDecimal.valueOf(unit1Units).multiply(unit1BPS).multiply(unit1Multiplier)) 
				.add (BigDecimal.valueOf(unit2Units).multiply(unit2BPS).multiply(unit2Multiplier)) 
				.add (BigDecimal.valueOf(unit3Units).multiply(unit3BPS).multiply(unit3Multiplier)) 
				.add (BigDecimal.valueOf(unit4Units).multiply(unit4BPS).multiply(unit4Multiplier)) 
				.add (BigDecimal.valueOf(unit5Units).multiply(unit5BPS).multiply(unit5Multiplier))
				);
	}
	
	public static BigDecimal increaseUnitCost(BigDecimal newCost) {
		newCost = (newCost.add(newCost.divide(BigDecimal.valueOf(10))));
		System.out.println("new cost unrounded: " + newCost);
		newCost = newCost.setScale(0, RoundingMode.DOWN);
		System.out.println("new cost rounded: " + newCost);
		return newCost;
	}
	
	public static BigDecimal increaseUpgradeCost(BigDecimal currentUnit1UpgradeCost2) {
		BigDecimal newCost = (currentUnit1UpgradeCost2.multiply(BigDecimal.valueOf(10)));
		return newCost;
	}
	
	public void increaseBonesSpent(BigDecimal currentUnit1Cost) {
		totalSpent = totalSpent.add(currentUnit1Cost);
		lblBonesSpentStat.setText("Total Bones spent: " + formatNumber(totalSpent, false));
	}
	
	public static void increaseBonesProduced(BigDecimal increase) {
		totalProduced = totalProduced.add(increase);
		lblBonesProducedStat.setText("You've produced " + formatNumber(totalProduced.setScale(0, RoundingMode.DOWN), false));
	}

	public static void updateHolyMilk() {
		possibleHolyMilkPints = bones.divide(bonesPerPint).setScale(0, RoundingMode.DOWN);
		  lblHolyMilkText1.setText("Reset to gain " + formatNumber(possibleHolyMilkPints, false) + " more pints");
		  lblHolyMilkText2.setText("(You will gain a +" + formatNumber(possibleHolyMilkPints.multiply(BigDecimal.valueOf(2)), false) + "% bonus)");
		//System.out.println("Possible Pints: " + possibleHolyMilkPints);
		//System.out.println("Actual Pints: " + actualHolyMilkPints);
	}
	
	public static void startTimer() {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() { 
				bones = bones.add( 
						(perSec.add
						 (perSec.multiply(totalBonus)) )
						.divide(BigDecimal.valueOf(10)) 
						);
			increaseBonesProduced(perSec.divide(BigDecimal.valueOf(10)));
				lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
				updateHolyMilk();
				updateBoneClicker();
				updateBtn1();
				updateBtnUpgrade1();
				updateBtn2();
				updateBtnUpgrade2();
				updateBtn3();
				updateBtnUpgrade3();
				updateBtn4();
				updateBtnUpgrade4();
				updateBtn5();
				updateBtnUpgrade5();
				ticks++;
			}
		}, 1000, 100);
	}
	
	//Set buttons to enabled or disabled based on current amount of bones
	
	public static void updateBtn(JButton btn) {
		if (bones.compareTo(currentUnit1Cost) >= 0) {
			btnBuy1.setEnabled(true);
		}
		else {
			btnBuy1.setEnabled(false);
		}
	}
	public static void updateBoneClicker() {
		if (bones.compareTo(currentTierCost) >= 0) {	
			btnUpgradeBone.setEnabled(true);
			}
		else if (currentTier == 6) {
			btnUpgradeBone.setEnabled(false);
		}
		else {
			btnUpgradeBone.setEnabled(false);
		}
	}
	public static void updateBtn1() {
		if (bones.compareTo(currentUnit1Cost) >= 0) {
			btnBuy1.setEnabled(true);
		}
		else {
			btnBuy1.setEnabled(false);
		}
	}
	
	public static void updateBtnUpgrade1() {
		if (bones.compareTo(currentUnit1UpgradeCost) >= 0) {
			btnUpgradeUnit1.setEnabled(true);
		}
		else {
			btnUpgradeUnit1.setEnabled(false);
		}
	}
	
	public static void updateBtn2() {
		if (bones.compareTo(currentUnit2Cost) >= 0) {
			btnBuy2.setEnabled(true);
		}
		else {
			btnBuy2.setEnabled(false);
		}
	}
	
	public static void updateBtnUpgrade2() {
		if (bones.compareTo(currentUnit2UpgradeCost) >= 0) {
			btnUpgradeUnit2.setEnabled(true);
		}
		else {
			btnUpgradeUnit2.setEnabled(false);
		}
	}
	
	public static void updateBtn3() {
		if (bones.compareTo(currentUnit3Cost) >= 0) {
			btnBuy3.setEnabled(true);
		}
		else {
			btnBuy3.setEnabled(false);
		}
	}
	
	public static void updateBtnUpgrade3() {
		if (bones.compareTo(currentUnit3UpgradeCost) >= 0) {
			btnUpgradeUnit3.setEnabled(true);
		}
		else {
			btnUpgradeUnit3.setEnabled(false);
		}
	}
	
	public static void updateBtn4() {
		if (bones.compareTo(currentUnit4Cost) >= 0) {
			btnBuy4.setEnabled(true);
		}
		else {
			btnBuy4.setEnabled(false);
		}
	}
	
	public static void updateBtnUpgrade4() {
		if (bones.compareTo(currentUnit4UpgradeCost) >= 0) {
			btnUpgradeUnit4.setEnabled(true);
		}
		else {
			btnUpgradeUnit4.setEnabled(false);
		}
	}
	
	public static void updateBtn5() {
		if (bones.compareTo(currentUnit5Cost) >= 0) {
			btnBuy5.setEnabled(true);
		}
		else {
			btnBuy5.setEnabled(false);
		}
	}
	
	public static void updateBtnUpgrade5() {
		if (bones.compareTo(currentUnit5UpgradeCost) >= 0) {
			btnUpgradeUnit5.setEnabled(true);
		}
		else {
			btnUpgradeUnit5.setEnabled(false);
		}
	}
	
	private void initialize() {
		
		System.out.println("initializing");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1174, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		btnLabelStatsClose = new JButton("x");
		btnLabelStatsClose.setFocusPainted(false);
		btnLabelStatsClose.setBackground(Color.WHITE);
		btnLabelStatsClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLabelStatsClose.setBounds(258, 0, 42, 42);
		btnLabelStatsClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelStats.setVisible(false);
				statsOn = false;
			}
		});
		
		panelStats = new JPanel();
		panelStats.setVisible(false);
		panelStats.setForeground(new Color(210, 105, 30));
		panelStats.setBounds(31, 177, 300, 255);
		frame.getContentPane().add(panelStats);
		panelStats.setBackground(Color.WHITE);
		panelStats.setLayout(null);
		panelStats.add(btnLabelStatsClose);
		
		
		
		lblClicksStat = new JLabel("You've clicked 0 times");
		lblClicksStat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblClicksStat.setBounds(20, 95, 259, 26);
		panelStats.add(lblClicksStat);
		
		lblBonesSpentStat = new JLabel("Total Bones spent: 0");
		lblBonesSpentStat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblBonesSpentStat.setBounds(20, 120, 259, 32);
		panelStats.add(lblBonesSpentStat);
		
		lblBonesProducedStat = new JLabel("Total Bones produced: 0");
		lblBonesProducedStat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblBonesProducedStat.setBounds(20, 151, 259, 26);
		panelStats.add(lblBonesProducedStat);
		
		lblStats = new JLabel("Stats");
		lblStats.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
		lblStats.setBounds(106, 25, 85, 42);
		panelStats.add(lblStats);
		
		JLabel lblTotalResetsStat = new JLabel("Total resets: 0");
		lblTotalResetsStat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblTotalResetsStat.setBounds(20, 179, 206, 25);
		panelStats.add(lblTotalResetsStat);
				
				/* btnAddBones.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bones = bones.add( 
										(currentIncrement) .add (currentIncrement.multiply(totalBonus) ) 
										).setScale(0, RoundingMode.DOWN);
						
						updateHolyMilk();
						
						
						totalClicks++;
						lblClicksStat.setText("You've clicked " + totalClicks + " times");
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
					}
				});*/
		
		JPanel shopPanel = new JPanel();
		shopPanel.setBackground(new Color(255, 240, 245));
		shopPanel.setBounds(795, 0, 363, 681);
		frame.getContentPane().add(shopPanel);
		shopPanel.setLayout(null);
		shopPanel.setBackground(new Color(255,229,204,100));
		
		
		btnBuy1 = new JButton("<html>Buy Milk (0)<br>" + currentUnit1Cost + " Bones");
		btnBuy1.setBounds(23, 134, 184, 73);
		shopPanel.add(btnBuy1);
		btnBuy1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		btnBuy1.setBackground(Color.WHITE);
		btnBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit1Cost.setScale(0, RoundingMode.DOWN)) >= 0) {
					
					//update stats
					increaseBonesSpent(currentUnit1Cost);
					
					//update lblBones 
					bones = bones.subtract(currentUnit1Cost);
					lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
					
					//update lbl
					unit1Units++;
					currentUnit1Cost = increaseUnitCost(currentUnit1Cost);
					btnBuy1.setText("<html>Buy Milk (" + unit1Units + ")<br>" + formatNumber(currentUnit1Cost, false) + " Bones");
					
					//update bps
					System.out.println("x");
					updateBPS();
					lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
				}
				else if ((bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit1Cost.setScale(0, RoundingMode.DOWN))) < 0) {
					System.out.println("You need at least " + nf.format(currentUnit1Cost) + " Bones for that.");
				}
			}
		});
		

		btnBuy1.setFocusPainted(false);
		
		btnUpgradeUnit1 = new JButton("<html>Upgrade<br> (lvl " + unit1Level + ")<br> " + currentUnit1UpgradeCost + " Bones");
		btnUpgradeUnit1.setBounds(208, 134, 134, 73);
		shopPanel.add(btnUpgradeUnit1);
		btnUpgradeUnit1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		btnUpgradeUnit1.setBackground(Color.WHITE);
		btnUpgradeUnit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit1UpgradeCost.setScale(0, RoundingMode.DOWN)) >= 0) {
					
					//update stats
					increaseBonesSpent(currentUnit1UpgradeCost);
				
					bones = bones.subtract(currentUnit1UpgradeCost);
					lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
					unit1Level++;
					currentUnit1UpgradeCost = increaseUpgradeCost(currentUnit1UpgradeCost);
					btnUpgradeUnit1.setText("<html>Upgrade<br> (lvl " + unit1Level + ")<br> " + formatNumber(currentUnit1UpgradeCost, false) + " Bones");
					
					unit1Multiplier = unit1Multiplier.multiply(BigDecimal.valueOf(2));
					updateBPS();
					
					lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
				}
			}
		});
		btnUpgradeUnit1.setFocusPainted(false);
		
			
			btnBuy2 = new JButton("<html>Buy Calcium (0)<br>&emsp;" + currentUnit2Cost + " Bones");
			btnBuy2.setBounds(23, 224, 184, 73);
			shopPanel.add(btnBuy2);
			btnBuy2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnBuy2.setBackground(Color.WHITE);
			btnBuy2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit2Cost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit2Cost);
						
						//update lblBones 
						bones = bones.subtract(currentUnit2Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						
						//update lbl
						unit2Units++;
						currentUnit2Cost = increaseUnitCost(currentUnit2Cost);
						btnBuy2.setText("<html>Buy Calcium (" + unit2Units + ")<br>" + formatNumber(currentUnit2Cost, false) + " Bones");
						
						//update bps
						updateBPS();
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
					else if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit2Cost.setScale(0, RoundingMode.DOWN)) < 0) {
						System.out.println("You need at least " + nf.format(currentUnit2Cost) + " Bones for that.");
					}
				}
			});
			
			
			
			btnBuy2.setFocusPainted(false);
			
			btnUpgradeUnit2 = new JButton("<html>Upgrade<br> (lvl 0)<br> " + currentUnit2UpgradeCost + " Bones");
			btnUpgradeUnit2.setBounds(208, 224, 134, 73);
			shopPanel.add(btnUpgradeUnit2);
			btnUpgradeUnit2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnUpgradeUnit2.setBackground(Color.WHITE);
			btnUpgradeUnit2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit2UpgradeCost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit2UpgradeCost);
					
						bones = bones.subtract(currentUnit2UpgradeCost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						unit2Level++;
						currentUnit2UpgradeCost = increaseUpgradeCost(currentUnit2UpgradeCost);
						System.out.println(currentUnit2UpgradeCost);
						btnUpgradeUnit2.setText("<html>Upgrade<br> (lvl " + unit2Level + ")<br> " + formatNumber(currentUnit2UpgradeCost, false) + " Bones");
						System.out.println(currentUnit2UpgradeCost);
						unit2Multiplier = unit2Multiplier.multiply(BigDecimal.valueOf(2));
						updateBPS();
						
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}	
				}
			});
			btnUpgradeUnit2.setFocusPainted(false);
			
			
			btnBuy3 = new JButton("<html>Buy Skeleton (0)<br>&emsp;" + currentUnit3Cost + " Bones");
			btnBuy3.setBounds(23, 314, 184, 73);
			shopPanel.add(btnBuy3);
			btnBuy3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnBuy3.setBackground(Color.WHITE);
			btnBuy3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit3Cost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit3Cost);
						
						//update lblBones 
						bones = bones.subtract(currentUnit3Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						
						//update lbl
						unit3Units++;
						currentUnit3Cost = increaseUnitCost(currentUnit3Cost);
						btnBuy3.setText("<html>Buy Skeleton (" + unit3Units + ")<br>" + formatNumber(currentUnit3Cost, false) + " Bones");
						
						//update bps
						updateBPS();
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
					else if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit3Cost.setScale(0, RoundingMode.DOWN)) < 0) {
						System.out.println("You need at least " + nf.format(currentUnit3Cost) + " Bones for that.");
					}
				}
			});
			
			
			
			btnBuy3.setFocusPainted(false);
			
			btnUpgradeUnit3 = new JButton("<html>Upgrade<br> (lvl 0)<br> " + currentUnit3UpgradeCost + " Bones");
			btnUpgradeUnit3.setBounds(208, 314, 134, 73);
			shopPanel.add(btnUpgradeUnit3);
			btnUpgradeUnit3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnUpgradeUnit3.setBackground(Color.WHITE);
			btnUpgradeUnit3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit3UpgradeCost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit3UpgradeCost);
					
						bones = bones.subtract(currentUnit3UpgradeCost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						unit3Level++;
						currentUnit3UpgradeCost = increaseUpgradeCost(currentUnit3UpgradeCost);
						btnUpgradeUnit3.setText("<html>Upgrade<br> (lvl " + unit3Level + ")<br> " + formatNumber(currentUnit3UpgradeCost, false) + " Bones");
						
						unit3Multiplier = unit3Multiplier.multiply(BigDecimal.valueOf(2));
						updateBPS();
						
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
				}
			});
			btnUpgradeUnit3.setFocusPainted(false);
			
			
			btnBuy4 = new JButton("<html>Buy Graveyard (0)<br>&emsp;" + currentUnit4Cost + " Bones");
			btnBuy4.setBounds(23, 404, 184, 73);
			shopPanel.add(btnBuy4);
			btnBuy4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnBuy4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit4Cost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit4Cost);
						
						//update lblBones 
						bones = bones.subtract(currentUnit4Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						
						//update lbl
						unit4Units++;
						currentUnit4Cost = increaseUnitCost(currentUnit4Cost);
						btnBuy4.setText("<html>Buy Graveyard (" + unit4Units + ")<br>" + formatNumber(currentUnit4Cost, false) + " Bones");
						
						//update bps
						updateBPS();
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
					else if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit4Cost.setScale(0, RoundingMode.DOWN)) < 0) {
						System.out.println("You need at least " + nf.format(currentUnit4Cost) + " Bones for that.");
					}
				}
			});
			
			
			
			btnBuy4.setFocusPainted(false);
			btnBuy4.setBackground(Color.WHITE);
			
			btnUpgradeUnit4 = new JButton("<html>Upgrade<br> (lvl 0)<br> " + currentUnit4UpgradeCost + " Bones");
			btnUpgradeUnit4.setBounds(208, 404, 134, 73);
			shopPanel.add(btnUpgradeUnit4);
			btnUpgradeUnit4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnUpgradeUnit4.setBackground(Color.WHITE);
			btnUpgradeUnit4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit4UpgradeCost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit4UpgradeCost);
					
						bones = bones.subtract(currentUnit4UpgradeCost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						unit4Level++;
						currentUnit4UpgradeCost = increaseUpgradeCost(currentUnit4UpgradeCost);
						btnUpgradeUnit4.setText("<html>Upgrade<br> (lvl " + unit4Level + ")<br> " + formatNumber(currentUnit4UpgradeCost, false) + " Bones");
						
						unit4Multiplier = unit4Multiplier.multiply(BigDecimal.valueOf(2));
						updateBPS();
						
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
				}
			});
			btnUpgradeUnit4.setFocusPainted(false);
			
			
			btnBuy5 = new JButton("<html>Buy Heck (0)<br>" + currentUnit5Cost + " Bones");
			btnBuy5.setBounds(23, 494, 184, 73);
			shopPanel.add(btnBuy5);
			btnBuy5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnBuy5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit5Cost.setScale(0, RoundingMode.DOWN)) >= 0) {
						
						//update stats
						increaseBonesSpent(currentUnit5Cost);
						
						//update lblBones 
						bones = bones.subtract(currentUnit5Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						
						//update lbl
						unit5Units++;
						currentUnit5Cost = increaseUnitCost(currentUnit5Cost);
						btnBuy5.setText("<html>Buy Heck (" + unit5Units + ")<br>" + formatNumber(currentUnit5Cost, false) + " Bones");
						
						//update bps
						updateBPS();
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
					else if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit5Cost.setScale(0, RoundingMode.DOWN)) < 0) {
						System.out.println("You need at least " + nf.format(currentUnit5Cost) + " Bones for that.");
					}
				}
			});
			
			
			
			btnBuy5.setFocusPainted(false);
			btnBuy5.setBackground(Color.WHITE);
			
			btnUpgradeUnit5 = new JButton("<html>Upgrade<br> (lvl 0)<br> " + currentUnit5UpgradeCost + " Bones");
			btnUpgradeUnit5.setBounds(208, 494, 134, 73);
			shopPanel.add(btnUpgradeUnit5);
			btnUpgradeUnit5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
			btnUpgradeUnit5.setBackground(Color.WHITE);
			btnUpgradeUnit5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(currentUnit5UpgradeCost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						
						//update stats
						increaseBonesSpent(currentUnit5UpgradeCost);
					
						bones = bones.subtract(currentUnit5UpgradeCost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						unit5Level++;
						currentUnit5UpgradeCost = increaseUpgradeCost(currentUnit5UpgradeCost);
						btnUpgradeUnit5.setText("<html>Upgrade<br> (lvl " + unit5Level + ")<br> " + formatNumber(currentUnit5UpgradeCost, false) + " Bones");
						
						unit5Multiplier = unit5Multiplier.multiply(BigDecimal.valueOf(2));
						updateBPS();
						
						lblBPS.setText(formatNumber(perSec, true) + " bones/sec");
					}
				}
			});
			btnUpgradeUnit5.setFocusPainted(false);
			
			lblShop = new JLabel("Shop");
			lblShop.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 40));
			lblShop.setBounds(133, 50, 121, 46);
			shopPanel.add(lblShop);
		
				btnAddBones = new JLabel();
				btnAddBones.setBounds(393, 193, 300, 279);
				frame.getContentPane().add(btnAddBones);
				btnAddBones.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
							bones = bones.add( 
											(currentIncrement) .add (currentIncrement.multiply(totalBonus) ) 
											).setScale(0, RoundingMode.DOWN);
			
							updateHolyMilk();
							
							totalClicks++;
							lblClicksStat.setText("You've clicked " + totalClicks + " times");
							lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						}
					
				});
				
				//btnAddBones.setFocusPainted(false);
				//bufferedImage.btnAddBones.setBackground(new Color(0,0,0,0));
				btnAddBones.setBorder(null);
				btnAddBones.setIcon(bone);
		
		
		
		panelHolyMilk = new JPanel();
		panelHolyMilk.setVisible(false);
		panelHolyMilk.setBackground(Color.WHITE);
		panelHolyMilk.setBounds(294, 510, 470, 137);
		frame.getContentPane().add(panelHolyMilk);
		panelHolyMilk.setLayout(null);
		
	
		
		lblHolyMilkAmount = new JLabel("<html>You currently have 0 pints of Holy Milk<br>"
				+ "(+0.0%)");
		lblHolyMilkAmount.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblHolyMilkAmount.setBounds(26, 11, 362, 52);
		panelHolyMilk.add(lblHolyMilkAmount);
		
		JButton btnHolyMilkClose = new JButton("x");
		btnHolyMilkClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHolyMilk.setVisible(false);
				holyMilkOn = false;
			}
		});
		btnHolyMilkClose.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		btnHolyMilkClose.setFocusPainted(false);
		btnHolyMilkClose.setBackground(Color.WHITE);
		btnHolyMilkClose.setBounds(428, 0, 42, 42);
		panelHolyMilk.add(btnHolyMilkClose);
		
		lblHolyMilkText1 = new JLabel("Reset to gain 0 more pints");
		lblHolyMilkText1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblHolyMilkText1.setBounds(182, 70, 239, 27);
		panelHolyMilk.add(lblHolyMilkText1);
		
		lblHolyMilkText2 = new JLabel("(You will gain a +0% bonus)");
		lblHolyMilkText2.setFont(new Font("Microsoft Sans Serif", Font.ITALIC, 15));
		lblHolyMilkText2.setBounds(189, 101, 210, 19);
		panelHolyMilk.add(lblHolyMilkText2);
		
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		btnReset.setFocusPainted(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (actualHolyMilkPints.compareTo(BigDecimal.valueOf(100)) > 0 ) {
					bones = BigDecimal.ZERO;
					lblBones.setText("You have " + bones + " Bones");
					perSec = BigDecimal.ZERO;
					lblBPS.setText(perSec + " Bones/sec");
					btnAddBones.setIcon(bone);
					
					currentIncrement = tier0Increment;
					currentTier = 0;
					unit1Units = 0;
					unit2Units = 0;
					unit3Units = 0;
					unit4Units = 0;
					unit5Units = 0;
					unit1Level = 0;
					unit2Level = 0;
					unit3Level = 0;
					unit4Level = 0;
					unit5Level = 0;
					
					currentUnit1UpgradeCost = defaultUnit1UpgradeCost;
					currentUnit2UpgradeCost = defaultUnit2UpgradeCost;
					currentUnit3UpgradeCost = defaultUnit3UpgradeCost;
					currentUnit4UpgradeCost = defaultUnit4UpgradeCost;
					currentUnit5UpgradeCost = defaultUnit5UpgradeCost;
					btnUpgradeUnit1.setText("<html>Upgrade<br> (lvl " + unit1Level + ")<br> " + currentUnit1UpgradeCost + " Bones");
					btnUpgradeUnit2.setText("<html>Upgrade<br> (lvl " + unit2Level + ")<br> " + currentUnit2UpgradeCost + " Bones");
					btnUpgradeUnit3.setText("<html>Upgrade<br> (lvl " + unit3Level + ")<br> " + currentUnit3UpgradeCost + " Bones");
					btnUpgradeUnit4.setText("<html>Upgrade<br> (lvl " + unit4Level + ")<br> " + currentUnit4UpgradeCost + " Bones");
					btnUpgradeUnit5.setText("<html>Upgrade<br> (lvl " + unit5Level + ")<br> " + currentUnit5UpgradeCost + " Bones");
					currentUnit1Cost = defaultUnit1Cost;
					currentUnit2Cost = defaultUnit2Cost;
					currentUnit3Cost = defaultUnit3Cost;
					currentUnit4Cost = defaultUnit4Cost;
					currentUnit5Cost = defaultUnit5Cost;
					btnBuy1.setText("<html>Buy Milk (" + unit1Units + ")<br>" + currentUnit1Cost + " Bones");
					btnBuy2.setText("<html>Buy Milk (" + unit2Units + ")<br>" + currentUnit2Cost + " Bones");
					btnBuy3.setText("<html>Buy Milk (" + unit3Units + ")<br>" + currentUnit3Cost + " Bones");
					btnBuy4.setText("<html>Buy Milk (" + unit4Units + ")<br>" + currentUnit4Cost + " Bones");
					btnBuy5.setText("<html>Buy Milk (" + unit5Units + ")<br>" + currentUnit5Cost + " Bones");
					unit1Multiplier = BigDecimal.valueOf(1);
					unit2Multiplier = BigDecimal.valueOf(1);
					unit3Multiplier = BigDecimal.valueOf(1);
					unit4Multiplier = BigDecimal.valueOf(1);
					unit5Multiplier = BigDecimal.valueOf(1);
					
					updateBPS();
					initializeFormats();
					
					actualHolyMilkPints = actualHolyMilkPints.add(possibleHolyMilkPints);
					System.out.println("Possible Pints: " + possibleHolyMilkPints);
					System.out.println("Actual Pints: " + actualHolyMilkPints);
					possibleHolyMilkPints = BigDecimal.ZERO;
					totalBonus = actualHolyMilkPints.multiply(BigDecimal.valueOf(bonusPerPint));
					System.out.println("Pints: " + actualHolyMilkPints + " Bonus: " + totalBonus.multiply(BigDecimal.valueOf(100)) + "%");
					
					lblHolyMilkAmount.setText("<html>You currently have " + formatNumber(actualHolyMilkPints, false) + " pints of Holy Milk<br>"
							+ "(" + "+" + formatNumber(totalBonus.multiply(BigDecimal.valueOf(100)), false) + "%" + ")");
					lblHolyMilkText1.setText("Reset to gain 0 more pints");
					lblHolyMilkText2.setText("(You will gain a +0% bonus)");
					
					totalResets++;
					
					lblTotalResetsStat.setText("Total resets: " + totalResets);
				}
				else if (btnResetClicked != true){
					btnResetClicked = true;
					btnReset.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
					btnReset.setText("<html>You need at least 100 pints!");
					
						Delay delay1 = new Delay();
						delay1.start();
					
				}
			
			}
		});
		btnReset.setBackground(new Color(255, 228, 181));
		btnReset.setBounds(10, 74, 159, 52);
		panelHolyMilk.add(btnReset);
		
		JPanel decorPanel1 = new JPanel();
		decorPanel1.setLayout(null);
		decorPanel1.setBackground(new Color(255, 240, 245, 100));
		decorPanel1.setBounds(0, 0, 256, 681);
		frame.getContentPane().add(decorPanel1);
		
		
		
		JButton btnStats = new JButton("Stats");
		btnStats.setBounds(35, 578, 190, 67);
		decorPanel1.add(btnStats);
		btnStats.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnStats.setFocusPainted(false);
		btnStats.setBackground(Color.WHITE);
		
		
		
		JButton btnHolyMilk = new JButton("Reset for bonus");
		btnHolyMilk.setBounds(35, 495, 190, 67);
		decorPanel1.add(btnHolyMilk);
		btnHolyMilk.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnHolyMilk.setBackground(Color.WHITE);
		btnHolyMilk.setFocusPainted(false);
		
		//Upgrades
		
		btnUpgradeBone = new JButton("<html>Upgrade Bone<br>" + tier1Cost + " Bones");
		btnUpgradeBone.setBounds(35, 34, 190, 73);
		decorPanel1.add(btnUpgradeBone);
		btnUpgradeBone.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnUpgradeBone.setBackground(Color.WHITE);
		btnUpgradeBone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(currentTier) {
				case 0:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier1Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier1Cost);
						btnAddBones.setIcon(tier1);
						bones = bones.subtract(tier1Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier2Cost, false) + " Bones");
						currentTier = 1;
						currentIncrement = tier1Increment;
						currentTierCost = tier2Cost;
						}
						break;
				case 1:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier2Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier2Cost);
						btnAddBones.setIcon(tier2);
						bones = bones.subtract(tier2Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier3Cost, false) + " Bones");
						currentTier = 2;
						currentIncrement = tier2Increment;
						currentTierCost = tier3Cost;
						}
						break;
				case 2:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier3Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier3Cost);
						btnAddBones.setIcon(tier3);
						bones = bones.subtract(tier3Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier4Cost, false) + " Bones");
						currentTier = 3;
						currentIncrement = tier3Increment;
						currentTierCost = tier4Cost;
						}
						break;
				case 3:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier4Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier4Cost);
						btnAddBones.setIcon(tier4);
						bones = bones.subtract(tier4Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier5Cost, false) + " Bones");
						currentTier = 4;
						currentIncrement = tier4Increment;
						currentTierCost = tier5Cost;
						}
						break;
				case 4:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier5Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier5Cost);
						btnAddBones.setIcon(tier5);
						bones = bones.subtract(tier5Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("<html>Upgrade Bone<br>" + formatNumber(tier6Cost, false) + " Bones");
						currentTier = 5;
						currentIncrement = tier5Increment;
						currentTierCost = tier6Cost;
						}
						break;
				case 5:
					if (bones.setScale(0, RoundingMode.DOWN).compareTo(tier6Cost.setScale(0, RoundingMode.DOWN)) >= 0 ) {
						increaseBonesSpent(tier6Cost);
						btnAddBones.setIcon(tier6);
						bones = bones.subtract(tier6Cost);
						lblBones.setText("You have " + formatNumber(bones, false) + " Bones");
						btnUpgradeBone.setText("Max Level");
						currentTier = 6;
						currentIncrement = tier6Increment;
						}
						break;
				}
			}
		});
		
		
		
		btnUpgradeBone.setFocusPainted(false);
		btnHolyMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (holyMilkOn == false) {
					panelHolyMilk.setVisible(true);
					holyMilkOn = true;
				}
				else if (holyMilkOn == true) {
					panelHolyMilk.setVisible(false);
					holyMilkOn = false;
				}
			}
		});
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (statsOn == false) {
					panelStats.setVisible(true);
					statsOn = true;
				}
				else if (statsOn == true) {
					panelStats.setVisible(false);
					statsOn = false;
				}
			}
		});
		
		lblBPS = new JLabel("0 Bones/sec");
		lblBPS.setBounds(440, 81, 290, 41);
		frame.getContentPane().add(lblBPS);
		lblBPS.setForeground(Color.BLACK);
		lblBPS.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
		
		
		
		
		lblBones = new JLabel("You have 0 Bones");
		lblBones.setBounds(370, 33, 415, 57);
		frame.getContentPane().add(lblBones);
		lblBones.setForeground(Color.BLACK);
		lblBones.setBackground(Color.WHITE);
		lblBones.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 35));
		
		
		JLabel lblBackdrop = new JLabel();
		lblBackdrop.setBounds(-57, -18, 1280, 720);
		frame.getContentPane().add(lblBackdrop);
		lblBackdrop.setIcon(backdrop);
		lblBackdrop.setLayout(null);
		
	}
}


