package gui_hausaufgaben_4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	private String path = "C:\\Users\\kerem.aydın\\git\\repository\\gui_hausaufgaben_4\\src\\gui_hausaufgaben_4\\users";
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
		btnRegister.addActionListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id.getText().equals("") != true && password.getText().equals("") != true) {
			File file = new File(path);
			try {
				FileReader fReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fReader);
				String line = "";
				while((line = bReader.readLine()) != null) { //file komple boşsa hiç çalışmıyor buna çözüm lazım
					String[] user = line.split("\t");
					if(id.getText().equals(user[0]) == false) {
						FileWriter fWriter = new FileWriter(file,true);
						BufferedWriter bWriter = new BufferedWriter(fWriter);
						bWriter.write(id.getText()+"\t"+password.getText()+"\t"+0+"\n");
						bWriter.close();
						break;
					}
				}
				bReader.close();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

}
