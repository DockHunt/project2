import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI {

    public UserModel user = null;

    public JFrame view;

    public JButton btnConfigureSystem = new JButton("Setup System Config");
    public JButton btnAddUser = new JButton("Add a User");
    public JButton btnDelUser = new JButton("Delete a User");

    public AdminUI(UserModel user) {

        this.user = user;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Administrator View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnConfigureSystem);
        panelButtons.add(btnAddUser);
        panelButtons.add(btnDelUser);

        view.getContentPane().add(panelButtons);

        btnConfigureSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ConfigureSystemUI ui = new ConfigureSystemUI();
                ui.run();
            }
        });

        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddUserUI ui = new AddUserUI();
                ui.run();
            }
        });

        btnDelUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteUserUI ui = new DeleteUserUI();
                ui.run();
            }
        });

    }

}
