import javax.swing.*;
public class ShippingInvoiceInput{
    
    public ShippingInvoiceInput(){}

    public static void InvoiceInputDisplay(){
        JFrame InvoiceFrame = new JFrame("Invoice Information");
        InvoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InvoiceFrame.setSize(300,300);
        String name=JOptionPane.showInputDialog(InvoiceFrame,"Customer Name");
        String address=JOptionPane.showInputDialog(InvoiceFrame,"Customer Address");
        String phoneNum=JOptionPane.showInputDialog(InvoiceFrame,"Customer Phone Number");
        String email=JOptionPane.showInputDialog(InvoiceFrame,"Customer Email");
        String product=JOptionPane.showInputDialog(InvoiceFrame,"Product");
        String productSerialNum=JOptionPane.showInputDialog(InvoiceFrame,"Product Serial Number");
        String quantity=JOptionPane.showInputDialog(InvoiceFrame,"Quantity");
        String unitPrice=JOptionPane.showInputDialog(InvoiceFrame,"Unit Price");
        String comments=JOptionPane.showInputDialog(InvoiceFrame,"Comments/Notes");
        InvoiceFrame.setVisible(true);
    }
}
