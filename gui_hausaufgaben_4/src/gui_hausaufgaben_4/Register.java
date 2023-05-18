package gui_hausaufgaben_4;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame {
	
	private JButton btnRegister;
	private JLabel lblId, lblPassword;
	private JTextField id, password;
	private JPanel pnlCenter, pnlBottom;
	
	public Register() {
		super("Register");
		setLayout(null);// bileşenlerin nerede yer alacağını ben belirleyeceğim.
		
		lblId = new JLabel("Username");
		id = new JTextField();
		lblPassword = new JLabel("Password");
		password = new JTextField();
		btnRegister = new JButton("Register");
		
		lblId.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);

		
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(1,2,10,10));// satır sütün sayısı ve sonraki 2 parametre aradaki dikey ve yataydaki boşluklar
		pnlCenter.add(lblId);
		pnlCenter.add(id);
		pnlCenter.add(lblPassword);
		pnlCenter.add(password);
		
		pnlBottom = new JPanel();
		pnlBottom.add(btnRegister);
		
		pnlCenter.setBounds(40,80,300,30);//x,y,genişlik,yükselik
		pnlBottom.setBounds(125,150,150,40);
		
		add(pnlCenter);
		add(pnlBottom);
		setVisible(true);
		setSize(400,350);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Register();

	}

}
