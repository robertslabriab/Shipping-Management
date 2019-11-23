import java.awt.*;
import javax.swing.*;
public class MainMenu{
    
    FlowLayout frameLayout=new FlowLayout();
    JFrame menuFrame=new JFrame("Shipping Management");
	
    public MainMenu(){}

    public void defaultDisplay(){
        menuFrame.setLayout(frameLayout);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500,500);
    }

    public void mainMenuDisplay(){
        defaultDisplay();
        JButton inputInfo=new JButton("Add Information");
        menuFrame.add(inputInfo);
        JButton oldInfo=new JButton("Look at Information");
        menuFrame.add(oldInfo);
        menuFrame.setVisible(true);

        
    }

    public void inputInformationDisplay(){
        defaultDisplay();
        JRadioButton manuInfo=new JRadioButton("Manufacturer Information");
        menuFrame.add(manuInfo);
        JRadioButton custInfo=new JRadioButton("Customer Information");
        menuFrame.add(custInfo);
        JButton okButton=new JButton("OK");
        menuFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        menuFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);
        menuFrame.setVisible(true);
    }

    public void informationDisplay(){
        defaultDisplay();
        JButton table=new JButton("Table");
        menuFrame.add(table);
        JButton search=new JButton("Search");
        menuFrame.add(search);
        JButton remove=new JButton("Remove");
        menuFrame.add(remove);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);
        menuFrame.setVisible(true);
    }

    public void inputShippingInformationDisplay(){
        defaultDisplay();

        JLabel orderNumberL=new JLabel("Order Number");
        menuFrame.add(orderNumberL);
        JTextField orderNumber=new JTextField(40);
        menuFrame.add(orderNumber);

        JLabel productL=new JLabel("Product");
        menuFrame.add(productL);
        JTextField product=new JTextField(40);
        menuFrame.add(product);

        JLabel productNumberL=new JLabel("Product Number");
        menuFrame.add(productNumberL);
        JTextField productNumber=new JTextField(40);
        menuFrame.add(productNumber);

        JLabel quantityL=new JLabel("Quantity");
        menuFrame.add(quantityL);
        JTextField quantity=new JTextField(40);
        menuFrame.add(quantity);

        JLabel unitPriceL=new JLabel("Unit Price");
        menuFrame.add(unitPriceL);
        JTextField unitPrice=new JTextField(40);
        menuFrame.add(unitPrice);

        JButton okButton=new JButton("OK");
        menuFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        menuFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);

        menuFrame.setVisible(true);
    }

    public void inputCustomerInformationDisplay(){
        defaultDisplay();

        JLabel nameL=new JLabel("Name");
        menuFrame.add(nameL);
        JTextField name=new JTextField(40);
        menuFrame.add(name);

        JLabel addressL=new JLabel("Address");
        menuFrame.add(addressL);
        JTextField address=new JTextField(40);
        menuFrame.add(address);
        
        JLabel phoneNumberL=new JLabel("Phone Number");
        menuFrame.add(phoneNumberL);
        //JTextField phoneNumber=new JTextField(40);
        JFormattedTextField phoneNumber=new JFormattedTextField();
        phoneNumber.setPreferredSize(new Dimension(445,20));
        menuFrame.add(phoneNumber);
        
        JLabel emailL=new JLabel("Email");
        menuFrame.add(emailL);
        JTextField email=new JTextField(40);
        menuFrame.add(email);

        JLabel notesL=new JLabel("Notes");
        menuFrame.add(notesL);
        JTextArea notes=new JTextArea(4,37);
        menuFrame.add(notes);
        
        JButton okButton=new JButton("OK");
        menuFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        menuFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);
        
        menuFrame.setVisible(true);
    }

    public void informationTableDisplay(){
        defaultDisplay();
        //String[]colName={"Name","Address","Phone Number","Email"};
        JLabel shippingInfoL=new JLabel("Shipping Information");
        menuFrame.add(shippingInfoL);
        final JTable table=new JTable(20,10);
        menuFrame.add(table);

        JButton cancelButton=new JButton("Back");
        menuFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);
        
        menuFrame.setVisible(true);
    }

    public void searchDisplay(){
        defaultDisplay();

        JLabel searchL=new JLabel("Order Number");
        menuFrame.add(searchL);
        JTextField search=new JTextField(40);
        menuFrame.add(search);

        JButton okButton=new JButton("OK");
        menuFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        menuFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        menuFrame.add(menuButton);

        menuFrame.setVisible(true);
    }

}
