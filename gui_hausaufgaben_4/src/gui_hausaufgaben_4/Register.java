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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	private static String path = "C:\\Users\\kerem.aydın\\git\\repository\\gui_hausaufgaben_4\\src\\gui_hausaufgaben_4\\users";
	private JButton btnRegister;
	private JLabel lblId, lblPassword;
	private static JTextField id;
	private JTextField password;
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

	public static void main(String[] args) throws IOException {
		new Register();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id.getText().equals("") != true && password.getText().equals("") != true) {
			File file = new File(path);
			try {
				if(checkUser() == true) {
					FileWriter fWriter = new FileWriter(file,true);
					BufferedWriter bWriter = new BufferedWriter(fWriter);
					bWriter.write(id.getText()+"\t"+password.getText()+"\t"+0+"\t"+false+"\n");
					bWriter.close();
				} else {
					JOptionPane.showMessageDialog(null, "Username defined!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static boolean checkUser() throws IOException {
		File file = new File(path);
		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);
		long lineCount;
		Stream<String> stream = Files.lines(Paths.get(path));
		lineCount = stream.count();
		while(lineCount>0) {
			String[] user = bReader.readLine().split("\t");
			if(id.getText().equals(user[0]) == true) {
				System.out.println("Username defined");
				return false;
			}
			lineCount--;
		}
		return true;
	}

}
