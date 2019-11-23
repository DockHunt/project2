import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ManagePurchaseUI {

    public JFrame view;

    public JButton btnLoad = new JButton("Load Purchase");
    public JButton btnSave = new JButton("Save Purchase");

    public JTextField txtPurchaseID = new JTextField(10);
    public JTextField txtCustomerID = new JTextField(10);
    public JTextField txtProductID = new JTextField(10);
    public JTextField txtQuantity = new JTextField(10);

    public JLabel labPrice = new JLabel("Product Price: ");
    public JLabel labDate = new JLabel("Date of Purchase: ");

    public JLabel labCustomerName = new JLabel("Customer Name: ");
    public JLabel labProductName = new JLabel("Product Name: ");

    public JLabel labCost = new JLabel("Cost: $0.00 ");
    public JLabel labTax = new JLabel("Tax: $0.00");
    public JLabel labTotalCost = new JLabel("Total Cost: $0.00");

    ProductModel product;
    PurchaseModel purchase;
    CustomerModel customer;

    public ManagePurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Manage Purchase Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnLoad);
        panelButtons.add(btnSave);
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
        line4.add(new JLabel("Quantity "));
        line4.add(txtQuantity);
        view.getContentPane().add(line4);

        JPanel line = new JPanel(new FlowLayout());
        line.add(labCost);
        line.add(labTax);
        line.add(labTotalCost);
        view.getContentPane().add(line);

        btnLoad.addActionListener(new LoadButtonListerner());
        btnSave.addActionListener(new SaveButtonListener());
        txtProductID.addFocusListener(new ProductIDFocusListener());
        txtCustomerID.addFocusListener(new CustomerIDFocusListener());

    }

    public void run() {
        view.setVisible(true);
    }

    class LoadButtonListerner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            PurchaseModel purchase = new PurchaseModel();
            String id = txtPurchaseID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "PurchaseID cannot be null!");
                return;
            }

            try {
                purchase.mPurchaseID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "PurchaseID is invalid!");
                return;
            }

            // call data access!

            purchase = StoreManager.getInstance().getDataAdapter().loadPurchase(purchase.mPurchaseID);

            if (purchase == null) {
                JOptionPane.showMessageDialog(null, "Purchase DOES NOT exists!");
            } else {
                txtCustomerID.setText(String.valueOf((purchase.mCustomerID)));
                txtProductID.setText(String.valueOf(purchase.mProductID));
                txtQuantity.setText(String.valueOf(purchase.mQuantity));
            }
        }
    }

    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            PurchaseModel purchase = new PurchaseModel();
            String id = txtPurchaseID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "PurchaseID cannot be null!");
                return;
            }

            try {
                purchase.mPurchaseID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "PurchaseID is invalid!");
                return;
            }

            String CustomerID = txtCustomerID.getText();
            if (CustomerID.length() == 0) {
                JOptionPane.showMessageDialog(null, "CustomerID cannot be empty!");
                return;
            }

            customer.mCustomerID = Integer.parseInt(CustomerID);

            String ProductID = txtProductID.getText();
            try {
                purchase.mProductID = Integer.parseInt(ProductID);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String quantity = txtQuantity.getText();
            try {
                purchase.mQuantity = Double.parseDouble(quantity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }


            int res = StoreManager.getInstance().getDataAdapter().savePurchase(purchase);

            if (res == IDataAdapter.PURCHASE_SAVE_FAILED)
                JOptionPane.showMessageDialog(null, "Purchase is NOT saved successfully!");
            else
                JOptionPane.showMessageDialog(null, "Purchase is SAVED successfully!");
        }
    }

    private class ProductIDFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            process();
        }

        private void process() {
            String s = txtProductID.getText();

            if (s.length() == 0) {
                labProductName.setText("Product Name: [not specified!]");
                return;
            }

            System.out.println("ProductID = " + s);

            try {
                purchase.mProductID = Integer.parseInt(s);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Error: Invalid ProductID", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            product = StoreManager.getInstance().getDataAdapter().loadProduct(purchase.mProductID);

            if (product == null) {
                JOptionPane.showMessageDialog(null,
                        "Error: No product with id = " + purchase.mProductID + " in store!", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                labProductName.setText("Product Name: ");

                return;
            }

            labProductName.setText("Product Name: " + product.mName);
            purchase.mPrice = product.mPrice;
            labPrice.setText("Product Price: " + product.mPrice);

        }

    }

    private class CustomerIDFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent focusEvent) {

        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            process();
        }

        private void process() {
            String s = txtCustomerID.getText();

            if (s.length() == 0) {
                labCustomerName.setText("Customer Name: [not specified!]");
                return;
            }

            System.out.println("CustomerID = " + s);

            try {
                purchase.mCustomerID = Integer.parseInt(s);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Error: Invalid CustomerID", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            customer = StoreManager.getInstance().getDataAdapter().loadCustomer(purchase.mCustomerID);

            if (customer == null) {
                JOptionPane.showMessageDialog(null,
                        "Error: No customer with id = " + purchase.mCustomerID + " in store!", "Error Message",
                        JOptionPane.ERROR_MESSAGE);
                labCustomerName.setText("Customer Name: ");

                return;
            }

            labCustomerName.setText("Product Name: " + customer.mName);

        }

    }
}
