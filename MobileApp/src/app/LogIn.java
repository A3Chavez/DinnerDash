/**
*
* Implements a Login feature 
*
*/
package app;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;

import ordering.CreditCard;
import ordering.Delivery;

public class LogIn extends JFrame implements ActionListener {
	   JPanel panel;
	   JLabel user_label, password_label, message;
	   JTextField userName_text;
	   JPasswordField password_text;
	   JButton submit, cancel;
	   boolean loggedIn;
	   
	   /**
	   * LogIn constructor
	   */
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
	      // Adding the listeners to components
	      submit.addActionListener(this);
	      getContentPane().add(panel, BorderLayout.CENTER);
	      setTitle("Welcome to Dinner Dash!");
	      setSize(450,308);
	      
	      setLocationRelativeTo(null);	// Center frame
	      
	      setVisible(true);
	   }
	     
	   @Override
	   public void actionPerformed(ActionEvent ae) {
		  boolean profileExists = false;
		  loggedIn = true;
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
              
              panel.removeAll();
              panel.revalidate();
              panel.repaint();
              
              addProfile(userName, password);

          } else {
              try {
            	   dispose();
            	  
                   File inputFile = new File("menu");
                   Driver guiFrame = new Driver(inputFile, loggedIn);
             
                 } catch (FileNotFoundException e1) {
                     JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
             
                 } catch(Exception e1) {
                     JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error", JOptionPane.ERROR_MESSAGE);
               }
          }
	   }
	   
	   /**
	   * Adds profile to the profiles text file
	   * @param userName
	   * @param password
	   */
	   public void addProfile(String userName, String password) {
           try {
                FileWriter writer = new FileWriter("profiles.txt", true);
                
                writer.write("\n"+userName + " " + password);
                writer.close();
                
                addCreditInfo(userName);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
	   /**
	   * adds credit card information to a text file
	   * @param userName
	   */
	   public void addCreditInfo(String userName) {
	       panel.setLayout(null);
	       setSize(300,150);
	       
	       setLocationRelativeTo(null);	// Center frame
	       
	       setTitle("Credit Info");
	                
	       JLabel userLabel = new JLabel("Name");
	       userLabel.setBounds(10, 20, 80, 25);
	       panel.add(userLabel);
	                
	       JTextField userText = new JTextField();
	       userText.setBounds(100, 20, 165, 25);
	       panel.add(userText);
	        
	       JLabel cardLabel = new JLabel("Card Number");
	       cardLabel.setBounds(10, 50, 80, 25);
	       panel.add(cardLabel);
	        
	       JTextField cardText = new JTextField();
	       cardText.setBounds(100, 50, 165, 25);
	       panel.add(cardText);
	        
	       JButton button = new JButton("Confirm");
	       button.setBounds(10, 80, 80, 25);
	        
	       panel.add(button);
	        
	       JLabel success = new JLabel("");
	       success.setBounds(10, 110, 300, 25);
	       panel.add(success);
	        
	       button.addActionListener(new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent e) {
	        	   boolean flag = false;
	        	   File creditCardFile = new File("creditCardInfo.txt");
	            	
	               while(flag) {
	            	   try {
	            		   CreditCard userCard = new CreditCard(cardText.getText(), userText.getText());
	            		   flag = true;
	            	   } catch (IllegalArgumentException g) {
	            		   success.setText("Invalid Card Number");
	            	   }
	               }
	            	
	            	try {
	                   FileWriter writer = new FileWriter(creditCardFile, true);
	                    
	                   writer.write("\n"+ userName + ";" + userText.getText() + ";" + cardText.getText());
	                   writer.close();
	                   
	                   try {
	                	   dispose();
	                       File inputFile = new File("menu");
	                       Driver guiFrame = new Driver(inputFile, loggedIn);
	                       
	                     } catch (FileNotFoundException e1) {
	                         JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
	                 
	                     } catch(Exception e1) {
	                         JOptionPane.showMessageDialog(null, "Error! Program terminated", " Error", JOptionPane.ERROR_MESSAGE);
	                   }
	                } catch (IOException e2) {
	                   e2.printStackTrace();
	                }
	            }
	        });
	   }
	}
