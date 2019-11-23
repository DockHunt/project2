import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakePurchaseUI {

    public JFrame view;

    public JButton btnAdd = new JButton("Make Purchase");

    public JTextField txtPurchaseID = new JTextField(20);
    public JTextField txtCustomerID = new JTextField(20);
    public JTextField txtProductID = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);
    public JTextField txtCost = new JTextField(20);
    public JTextField txtTax = new JTextField(20);
    public JTextField txtTotal = new JTextField(20);
    public JTextField txtDate = new JTextField(20);

    public MakePurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Make a Purchase");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("PurchaseID "));
        line1.add(txtPurchaseID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("CustomerID "));
        line2.add(txtCustomerID);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("ProductID "));
        line3.add(txtProductID);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Price "));
        line4.add(txtPrice);
        view.getContentPane().add(line4);

        JPanel line5 = new JPanel(new FlowLayout());
        line5.add(new JLabel("Quantity "));
        line5.add(txtQuantity);
        view.getContentPane().add(line5);

        JPanel line6 = new JPanel(new FlowLayout());
        line6.add(new JLabel("Cost "));
        line6.add(txtCost);
        view.getContentPane().add(line6);

        JPanel line7 = new JPanel(new FlowLayout());
        line7.add(new JLabel("Tax "));
        line7.add(txtTax);
        view.getContentPane().add(line7);

        JPanel line8 = new JPanel(new FlowLayout());
        line8.add(new JLabel("Total "));
        line8.add(txtTotal);
        view.getContentPane().add(line8);

        JPanel line9 = new JPanel(new FlowLayout());
        line9.add(new JLabel("Date "));
        line9.add(txtDate);
        view.getContentPane().add(line9);

        btnAdd.addActionListener(new MakePurchaseButtonListener());
    }

    public void run() { view.setVisible(true); }

    class MakePurchaseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // DO NOTHING (for now)
        }

    }

}
