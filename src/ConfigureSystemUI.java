import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigureSystemUI {

    public JFrame view;

    public JButton btnConfig = new JButton("Configure System");

    public JTextField txtSetting1 = new JTextField(20);
    public JTextField txtSetting2 = new JTextField(20);
    public JTextField txtSetting3 = new JTextField(20);

    public ConfigureSystemUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Setup System Configuration");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnConfig);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Setting 1 "));
        line1.add(txtSetting1);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Setting 2 "));
        line2.add(txtSetting2);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Setting 3 "));
        line3.add(txtSetting3);
        view.getContentPane().add(line3);

        btnConfig.addActionListener(new ConfigButtonListener());
    }

    public void run() { view.setVisible(true); }

    class ConfigButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // DO NOTHING (for now)
        }

    }

}
