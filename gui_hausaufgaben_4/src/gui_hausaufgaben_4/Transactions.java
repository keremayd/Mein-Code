package gui_hausaufgaben_4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Transactions extends JFrame implements ActionListener {

	private JButton[] buttons;
	private JPanel pnlBottom,pnlTop;
	private String[] names= {"Withdraw","Transaction","Transfer","Balance","Deposit","Quit"};
	private JLabel lblIcon;
	private ImageIcon iconObj2;
	private Icon[] iconObj = { new ImageIcon(getClass().getResource("photos/wphoto.png")),
			new ImageIcon(getClass().getResource("photos/tphoto.png")),
			new ImageIcon(getClass().getResource("photos/trphoto.png")),
			new ImageIcon(getClass().getResource("photos/bphoto.png")),
			new ImageIcon(getClass().getResource("photos/dphoto.png")),
			new ImageIcon(getClass().getResource("photos/ephoto.png")),
			new ImageIcon(getClass().getResource("photos/ss.png"))
	
	};
	
	public Transactions() {
		super("Transactions");
		setLayout(null);
		
		buttons= new JButton[names.length];
		pnlBottom = new JPanel();
		pnlBottom.setLayout(new GridLayout(2,3,5,5));
		
		pnlTop= new JPanel();
		
		for (int i = 0; i < buttons.length; i++) {
			
			buttons[i]= new JButton(names[i]);
			buttons[i].setIcon(iconObj[i]); 
			//buttons[i].setBackground(Color.PINK);
			//buttons[i].setForeground(Color.WHITE);
			pnlBottom.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		
		lblIcon= new JLabel();
		lblIcon.setIcon(iconObj[iconObj.length-1]);

		pnlTop.add(lblIcon);
		pnlTop.setBounds(155,30,90,90);
		pnlBottom.setBounds(10, 150, 370, 100);	
		
		add(pnlTop);
		add(pnlBottom);
		
		
		setVisible(true);
		setSize(400,350);
		setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {
		new Transactions();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton event = (JButton)e.getSource();

		if(e.getSource()  == buttons[0]) {
			System.out.println(event);	
		} else if (e.getSource() == buttons[1]) {
			System.out.println(event);
		}
		
	}
	
	
	
}
