import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class MainMenu{
    
    FlowLayout frameLayout=new FlowLayout();
    JFrame menuFrame=new JFrame("Shipping Management");
	
    public MainMenu(){}

        

    public void mainMenuDisplay(){
        
        JFrame menuFrame=new JFrame("Shipping Management");
        menuFrame.setLayout(frameLayout);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        menuFrame.setLocation(dim.width/2-menuFrame.getSize().width/2, dim.height/2-menuFrame.getSize().height/2);
        JButton inputInfo=new JButton("Add Information");
        menuFrame.add(inputInfo);
        JButton oldInfo=new JButton("Look at Information");
        menuFrame.add(oldInfo);
        menuFrame.setVisible(true);
        
        inputInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuFrame.dispose();
                inputInformationDisplay();
            }
        });
        oldInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuFrame.dispose();
                informationDisplay();
            }
        });
    }

    public void inputInformationDisplay(){
        
        JFrame inputInfoFrame=new JFrame("Shipping Management");
        inputInfoFrame.setLayout(frameLayout);
        inputInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputInfoFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        inputInfoFrame.setLocation(dim.width/2-inputInfoFrame.getSize().width/2, dim.height/2-inputInfoFrame.getSize().height/2);
        

        JRadioButton manuInfo=new JRadioButton("Manufacturer Information");
        inputInfoFrame.add(manuInfo);
        JRadioButton custInfo=new JRadioButton("Customer Information");
        inputInfoFrame.add(custInfo);
        JButton okButton=new JButton("OK");
        inputInfoFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        inputInfoFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        inputInfoFrame.add(menuButton);
        inputInfoFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputInfoFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputInfoFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputInfoFrame.dispose();
            }
        });
    }

    public void informationDisplay(){
        JFrame infoFrame=new JFrame("Shipping Management");
        infoFrame.setLayout(frameLayout);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        infoFrame.setLocation(dim.width/2-infoFrame.getSize().width/2, dim.height/2-infoFrame.getSize().height/2);
        
        JButton table=new JButton("Table");
        infoFrame.add(table);
        JButton search=new JButton("Search");
        infoFrame.add(search);
        JButton remove=new JButton("Remove");
        infoFrame.add(remove);
        JButton menuButton=new JButton("Main Menu");
        infoFrame.add(menuButton);
        infoFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                mainMenuDisplay();
            }
        });
        table.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                informationTableDisplay();
            }
        });
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                searchDisplay();
            }
        });
        remove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                removeDisplay();
            }
        });
    }

    public void inputShippingInformationDisplay(){
        JFrame inputShippingFrame=new JFrame("Shipping Management");
        inputShippingFrame.setLayout(frameLayout);
        inputShippingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputShippingFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        inputShippingFrame.setLocation(dim.width/2-inputShippingFrame.getSize().width/2, dim.height/2-inputShippingFrame.getSize().height/2);

        JLabel orderNumberL=new JLabel("Order Number");
        inputShippingFrame.add(orderNumberL);
        JTextField orderNumber=new JTextField(40);
        inputShippingFrame.add(orderNumber);

        JLabel productL=new JLabel("Product");
        inputShippingFrame.add(productL);
        JTextField product=new JTextField(40);
        inputShippingFrame.add(product);

        JLabel productNumberL=new JLabel("Product Number");
        inputShippingFrame.add(productNumberL);
        JTextField productNumber=new JTextField(40);
        inputShippingFrame.add(productNumber);

        JLabel quantityL=new JLabel("Quantity");
        inputShippingFrame.add(quantityL);
        JTextField quantity=new JTextField(40);
        inputShippingFrame.add(quantity);

        JLabel unitPriceL=new JLabel("Unit Price");
        inputShippingFrame.add(unitPriceL);
        JTextField unitPrice=new JTextField(40);
        inputShippingFrame.add(unitPrice);

        JButton okButton=new JButton("OK");
        inputShippingFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        inputShippingFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        inputShippingFrame.add(menuButton);

        inputShippingFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputShippingFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputShippingFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputShippingFrame.dispose();
            }
        });
    }

    public void inputCustomerInformationDisplay(){
        JFrame inputCustomerFrame=new JFrame("Shipping Management");
        inputCustomerFrame.setLayout(frameLayout);
        inputCustomerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputCustomerFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        inputCustomerFrame.setLocation(dim.width/2-inputCustomerFrame.getSize().width/2, dim.height/2-inputCustomerFrame.getSize().height/2);

        JLabel nameL=new JLabel("Name");
        inputCustomerFrame.add(nameL);
        JTextField name=new JTextField(40);
        inputCustomerFrame.add(name);

        JLabel addressL=new JLabel("Address");
        inputCustomerFrame.add(addressL);
        JTextField address=new JTextField(40);
        inputCustomerFrame.add(address);
        
        JLabel phoneNumberL=new JLabel("Phone Number");
        inputCustomerFrame.add(phoneNumberL);
        //JTextField phoneNumber=new JTextField(40);
        JFormattedTextField phoneNumber=new JFormattedTextField();
        phoneNumber.setPreferredSize(new Dimension(445,20));
        inputCustomerFrame.add(phoneNumber);
        
        JLabel emailL=new JLabel("Email");
        inputCustomerFrame.add(emailL);
        JTextField email=new JTextField(40);
        inputCustomerFrame.add(email);

        JLabel notesL=new JLabel("Notes");
        inputCustomerFrame.add(notesL);
        JTextArea notes=new JTextArea(4,37);
        inputCustomerFrame.add(notes);
        
        JButton okButton=new JButton("OK");
        inputCustomerFrame.add(okButton);
        JButton cancelButton=new JButton("Cancel");
        inputCustomerFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        inputCustomerFrame.add(menuButton);
        
        inputCustomerFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputCustomerFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputCustomerFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputCustomerFrame.dispose();
            }
        });
    }

    public void informationTableDisplay(){
        JFrame tableFrame=new JFrame("Shipping Management");
        tableFrame.setLayout(frameLayout);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tableFrame.setLocation(dim.width/2-tableFrame.getSize().width/2, dim.height/2-tableFrame.getSize().height/2);

        //String[]colName={"Name","Address","Phone Number","Email"};
        JLabel shippingInfoL=new JLabel("Shipping Information");
        tableFrame.add(shippingInfoL);
        final JTable table=new JTable(20,10);
        tableFrame.add(table);

        JButton cancelButton=new JButton("Back");
        tableFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        tableFrame.add(menuButton);
        
        tableFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tableFrame.dispose();
                mainMenuDisplay();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tableFrame.dispose();
                informationDisplay();
            }
        });
    }

    public void searchDisplay(){
        JFrame searchFrame=new JFrame("Shipping Management");
        searchFrame.setLayout(frameLayout);
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        searchFrame.setLocation(dim.width/2-searchFrame.getSize().width/2, dim.height/2-searchFrame.getSize().height/2);

        JLabel searchL=new JLabel("Search Order Number");
        searchFrame.add(searchL);
        JTextField search=new JTextField(40);
        searchFrame.add(search);

        JButton okButton=new JButton("OK");
        searchFrame.add(okButton);
        JButton cancelButton=new JButton("Back");
        searchFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        searchFrame.add(menuButton);

        searchFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                searchFrame.dispose();
                informationDisplay();
            }
        });
    }

    public void removeDisplay(){
        JFrame removeFrame=new JFrame("Shipping Management");
        removeFrame.setLayout(frameLayout);
        removeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        removeFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        removeFrame.setLocation(dim.width/2-removeFrame.getSize().width/2, dim.height/2-removeFrame.getSize().height/2);

        JLabel removeL=new JLabel("Remove Order Number");
        removeFrame.add(removeL);
        JTextField remove=new JTextField(40);
        removeFrame.add(remove);

        JButton okButton=new JButton("OK");
        removeFrame.add(okButton);
        JButton cancelButton=new JButton("Back");
        removeFrame.add(cancelButton);
        JButton menuButton=new JButton("Main Menu");
        removeFrame.add(menuButton);

        removeFrame.setVisible(true);

        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                removeFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                removeFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                removeFrame.dispose();
                informationDisplay();
            }
        });
    }

    

}