import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import postbodies.LoginPass;
import Tasks.LoginTask;



public class AuJourinaGUI extends JFrame{
    private JLabel authorizationLabel = new JLabel("Authorization");
    private JLabel loginLabel = new JLabel("Login:");
    private JTextField loginTextField = new JTextField();
    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordTextField = new JPasswordField();
    private JButton authorizationButton = new JButton("Go in!");

    public AuJourinaGUI (){
        super("Jourina");
        this.setBounds(100, 100, 400, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container containerAu = this.getContentPane();
        containerAu.setLayout(new GridLayout(6,1,5,5));
        authorizationButton.addActionListener(new AuthorizationButtonEventListener ());
        containerAu.add(authorizationLabel);
        containerAu.add(loginLabel);
        containerAu.add(loginTextField);
        containerAu.add(passwordLabel);
        containerAu.add(passwordTextField);
        containerAu.add(authorizationButton);
    }

    class AuthorizationButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String login = loginTextField.getText();
            String password = new String(passwordTextField.getPassword());
            //LoginPass postLoginPass = new LoginPass(login, password);
            //LoginTask loginTask = new LoginTask(postLoginPass);
              //  if (loginTask.getValue().statusCode() >= 300)
            if (login.equals("alex") && password.equals("12345678"))
            {
                System.out.println("Yep");
                JourinaEditor jourinaEditor = new JourinaEditor();
                jourinaEditor.mainWindow();

            }
            else
            {
                authorizationLabel.setText("Authorization: Login or password is incorrect!");

            }
        }
    }
}
