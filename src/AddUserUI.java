import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserUI {

    public JFrame view;

    public JButton btnAdd = new JButton("Add User");

    public JTextField txtUsername = new JTextField(20);
    public JTextField txtPassword = new JTextField(20);
    public JTextField txtFullname = new JTextField(20);
    public JTextField txtUserType = new JTextField(20);
    public JTextField txtCustomerID = new JTextField(20);

    public AddUserUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Add a New User");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Username "));
        line1.add(txtUsername);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Password "));
        line2.add(txtPassword);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Fullname "));
        line3.add(txtFullname);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("UserType "));
        line4.add(txtUserType);
        view.getContentPane().add(line4);

        JPanel line5 = new JPanel(new FlowLayout());
        line5.add(new JLabel("CustomerID "));
        line5.add(txtCustomerID);
        view.getContentPane().add(line5);

        btnAdd.addActionListener(new AddUserButtonListener());

    }

    public void run() { view.setVisible(true); }

    class AddUserButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // DO NOTHING (for now)
        }

    }

}
