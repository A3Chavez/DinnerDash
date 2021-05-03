package app;
/////////////////////////////////
////////////////////////////////
////Login: admin
////password: dinnerdash
////////////////////////////////
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {
	   JPanel panel;
	   JLabel user_label, password_label, message;
	   JTextField userName_text;
	   JPasswordField password_text;
	   JButton submit, cancel;
	   public LogIn() {
	      // User name Label
	      user_label = new JLabel();
	      user_label.setText("User Name :");
	      userName_text = new JTextField();
	      // Password Label
	      password_label = new JLabel();
	      password_label.setText("Password :");
	      password_text = new JPasswordField();
	      // Submit
	      submit = new JButton("SUBMIT");
	      panel = new JPanel(new GridLayout(3, 1));
	      panel.add(user_label);
	      panel.add(userName_text);
	      panel.add(password_label);
	      panel.add(password_text);
	      message = new JLabel();
	      panel.add(message);
	      panel.add(submit);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // Adding the listeners to components..
	      submit.addActionListener(this);
	      getContentPane().add(panel, BorderLayout.CENTER);
	      setTitle("Welcome to Dinner Dash!");
	      setSize(450,308);
	      setVisible(true);
	   }
	     
	   @Override
	   public void actionPerformed(ActionEvent ae) {
		  boolean profileExists = false;
	      String userName = userName_text.getText();
	      String password = "";
	      char[] array = new char[30];
	      Scanner fileReader = null;	      
	      
	      try {
	    	  fileReader = new Scanner(new File("profiles.txt"));
	      } catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	      }
	      
	      array = password_text.getPassword();
	      
	      for(int i=0; i<array.length; i++)
	    	  password = password + array[i];
	      
	      password = password.trim();
	      
	      while(fileReader.hasNextLine()) {
	    	  String fileUserName = fileReader.next();
              String filePassword = fileReader.next();
                  
              if(fileUserName.equals(userName) && filePassword.equals(password))
                   profileExists = true;     
              
              if(profileExists)
                  break;
	  	  }
	      fileReader.close();
	  		
	      if(!profileExists) {
              JOptionPane.showMessageDialog(null,"Error! Profile not found. Adding profile", "Adding profile", JOptionPane.ERROR_MESSAGE);
              addProfile(userName, password); 
              
              try {
                  File inputFile = new File("menu");
                    Driver guiFrame = new Driver(inputFile);
            
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
            
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error", JOptionPane.ERROR_MESSAGE);
              }
          } else {
              try {
                   File inputFile = new File("menu");
                   Driver guiFrame = new Driver(inputFile);
             
                 } catch (FileNotFoundException e1) {
                     JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
             
                 } catch(Exception e1) {
                     JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error", JOptionPane.ERROR_MESSAGE);
               }
          }
	   }
	   
	   public void addProfile(String userName, String password) {
           try {
                FileWriter writer = new FileWriter("profiles.txt", true);
                
                writer.write("\n"+userName + " " + password);
                
                writer.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
	}