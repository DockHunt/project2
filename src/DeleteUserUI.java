import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUserUI {

    public JFrame view;

    public JButton btnDel = new JButton("Delete User");

    public JTextField txtUsername = new JTextField(20);

    public DeleteUserUI() {
        this.view = new JFrame();

        view.setTitle("Delete a User");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnDel);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Username "));
        line1.add(txtUsername);
        view.getContentPane().add(line1);

        btnDel.addActionListener(new DelUserButtonListener());

    }

    public void run() { view.setVisible(true); }

    class DelUserButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // DO NOTHING (for now)
        }

    }
}
