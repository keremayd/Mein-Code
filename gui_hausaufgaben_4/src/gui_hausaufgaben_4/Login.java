package gui_hausaufgaben_4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui_hausaufgaben_4.*;


public class Login extends JFrame implements ActionListener{

	private JLabel lblIcon,lblId,lblPass;
	private JTextField id;
	private JPasswordField pass;
	private JButton btnLogin;
	private ImageIcon iconObj;
	
	private JPanel pnlCenter,pnlTop,pnlBottom;
	
	
	public Login() {
		super("Bank Login");
		setLayout(null);// bileşenlerin nerede yer alacağını ben belirleyeceğim.
		
	
		
		lblIcon= new JLabel();
		lblId= new JLabel("Username");
		lblId.setForeground(Color.PINK);
		lblPass = new JLabel("Şifre");
		lblPass.setForeground(Color.PINK);
		
		id= new JTextField();
		pass= new JPasswordField();
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBackground(Color.PINK);
		btnLogin.setForeground(Color.WHITE);
		
		pnlCenter= new JPanel();
		pnlCenter.setLayout(new GridLayout(2,2,10,10));// satır sütün sayısı ve sonraki 2 parametre aradaki dikey ve yataydaki boşluklar
		
		//Iconu resize yaptığımız bölüm
		iconObj= new ImageIcon(getClass().getResource("photos/2.png"));
		Image img = iconObj.getImage();
		Image imgScale = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lblIcon.setIcon(scaledIcon);// iconu label ile eşleştirdik

	/*	Component []r= {lblId,txtId,lblPass,pass};
		
		for (int i = 0; i < r.length; i++) {
			pnl.add(r[i]);
		}*/
		
		pnlCenter.add(lblId);
		pnlCenter.add(lblPass);
		pnlCenter.add(id);
		pnlCenter.add(lblPass);
		pnlCenter.add(pass);
		
		pnlCenter.setBounds(90,80,200,75);//x,y,genişlik,yükselik
		
		pnlTop= new JPanel();
		pnlTop.add(lblIcon);
		
		pnlTop.setBounds(170,0,65,65);
		
		pnlBottom= new JPanel();
		pnlBottom.add(btnLogin);
		pnlBottom.setLayout(new GridLayout(1,1));
		pnlBottom.setBounds(125,170,150,30);
		
		add(pnlTop);
		add(pnlCenter);
		add(pnlBottom);
		
		setVisible(true);
		setSize(400,270);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {

		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id.getText().equals("123")&& pass.getText().equals("123")) {
			setVisible(false);
			new Transactions();
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Giriş Hatalı","Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
