package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class Login {

	private JFrame frmLoginPage;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBackground(Color.ORANGE);
		frmLoginPage.getContentPane().setBackground(Color.ORANGE);
		frmLoginPage.setBounds(100, 100, 850, 650);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = txtUsername.getText();
				String password = txtPassword.getText();	
					
				String adminUsername = "admin";				
				String adminPassword = "password";
				
				String customerUsername = "pankitthakkar";
				String customerPassword = "pankitthakkar";
				
				if ((username.contains(adminUsername)) && (password.contains(adminPassword))) {
					txtUsername.setText(null);
					txtPassword.setText(null);
					
					JOptionPane.showMessageDialog(null, "Admin Login Successful");
					frmLoginPage.dispose();

				}
				
				else if ((username.contains(customerUsername)) && (password.contains(customerPassword))) {
					txtUsername.setText(null);
					txtPassword.setText(null);
					
					JOptionPane.showMessageDialog(null, "Welcome " +customerUsername);
					frmLoginPage.dispose();

				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error", JOptionPane.ERROR_MESSAGE);
					txtUsername.setText(null);
					txtPassword.setText(null);
				}
			}
		});
		loginButton.setBounds(349, 442, 89, 31);
		frmLoginPage.getContentPane().add(loginButton);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(407, 311, 160, 25);
		frmLoginPage.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.PLAIN, 25));
		username.setBounds(267, 306, 119, 31);
		frmLoginPage.getContentPane().add(username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 25));
		password.setLabelFor(password);
		password.setBounds(267, 348, 120, 31);
		frmLoginPage.getContentPane().add(password);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(407, 352, 160, 25);
		frmLoginPage.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("Twisted Toppings");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(204, 11, 441, 59);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginPage.dispose();
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitButton.setBounds(721, 47, 103, 31);
		frmLoginPage.getContentPane().add(exitButton);
	}
}
