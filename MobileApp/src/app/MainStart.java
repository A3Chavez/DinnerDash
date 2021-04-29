package app;
//////////////////////////////////////////
//Run MainStart.java to include the login/
////Login: admin                         /
////password: dinnerdash                 /
////Or guest option                      /
//////////////////////////////////////////



//import Ordering.*;


//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
//import javax.swing.SwingConstants;
//import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
//import java.awt.SystemColor;
//import javax.swing.LayoutStyle.ComponentPlacement;

public class MainStart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStart frame = new MainStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public MainStart() {
		setTitle("DinnerDash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Admin Login
				//File login = new File("login");
				LogIn guiFrame = new LogIn();
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Guest Login");
		btnNewButton_1_1.addActionListener(new ActionListener()  {//Guest Login
			public void actionPerformed(ActionEvent e) {
				File inputFile = new File("menu");
				try {
					Driver guiFrame = new Driver(inputFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
		});
		
		JTextArea txtrDinnerDash = new JTextArea();
		txtrDinnerDash.setEditable(false);
		txtrDinnerDash.setFont(new Font("Lucida Fax", Font.BOLD, 25));
		txtrDinnerDash.setText("Dinner Dash");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(181)
					.addComponent(txtrDinnerDash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(328, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(txtrDinnerDash, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_1_1)
					.addGap(107))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
