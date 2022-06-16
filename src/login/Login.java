package login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public JFrame frmLoginPage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login window = new Login();
                window.frmLoginPage.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLoginPage = new JFrame();
        frmLoginPage.setTitle("Twisted Toppings");
        frmLoginPage.setBackground(Color.ORANGE);
        frmLoginPage.getContentPane().setBackground(Color.ORANGE);
        frmLoginPage.setBounds(100, 100, 850, 650);
        frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginPage.getContentPane().setLayout(null);
        frmLoginPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmLoginPage.setUndecorated(false);
        frmLoginPage.setVisible(true);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginButton.addActionListener(e -> {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/twisted_toppings", "pankitthakkar", "");
                String sql = "SELECT * FROM login_credentials WHERE username=? and password=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Welcome " + username);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Database cannot be connected!", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        loginButton.setBounds(707, 500, 89, 31);
        frmLoginPage.getContentPane().add(loginButton);

        txtUsername = new JTextField();
        txtUsername.setBounds(745, 310, 160, 25);
        frmLoginPage.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        JLabel username = new JLabel("Username:");
        username.setFont(new Font("Tahoma", Font.PLAIN, 25));
        username.setBounds(625, 306, 120, 31);
        frmLoginPage.getContentPane().add(username);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Tahoma", Font.PLAIN, 25));
        password.setLabelFor(password);
        password.setBounds(625, 348, 120, 31);
        frmLoginPage.getContentPane().add(password);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(745, 352, 160, 25);
        frmLoginPage.getContentPane().add(txtPassword);

        JLabel lblNewLabel = new JLabel("Twisted Toppings");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel.setBounds(565, 25, 441, 59);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        frmLoginPage.getContentPane().add(lblNewLabel);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> frmLoginPage.dispose());
        exitButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        exitButton.setBounds(1321, 47, 103, 31);
        frmLoginPage.getContentPane().add(exitButton);
    }
}
