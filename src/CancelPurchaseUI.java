import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelPurchaseUI {

    public JFrame view;

    public JButton btnCancel = new JButton("Cancel Purchase");

    public JTextField txtPurchaseID = new JTextField(20);

    public CancelPurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Cancel a Purchase");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnCancel);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("PurchaseID "));
        line1.add(txtPurchaseID);
        view.getContentPane().add(line1);

        btnCancel.addActionListener(new CancelPurchaseButtonListener());
    }

    public void run() { view.setVisible(true);}

    class CancelPurchaseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // DO NOTHING (for now)
        }

    }
}
