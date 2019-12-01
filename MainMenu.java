import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class MainMenu{
    
    FlowLayout frameLayout=new FlowLayout();
    JFrame menuFrame=new JFrame("Shipping Management");
    ManufacturerInformation mInfo=new ManufacturerInformation();
    CustomerInformation cInfo=new CustomerInformation();
    InvoiceGenerator invoice=new InvoiceGenerator();

	
    public MainMenu(){}

    public void mainMenuDisplay(){
        //mainMenuDisplay:frame+frame elements
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
        //mainMenuDisplay:element actions
        inputInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuFrame.dispose();
                inputShippingInformationDisplay();
            }
        });
        oldInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menuFrame.dispose();
                informationDisplay();
            }
        });
    }

    public void informationDisplay(){
        //informationDisplay:frame+frame elements
        JFrame infoFrame=new JFrame("Shipping Management");
        infoFrame.setLayout(frameLayout);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        infoFrame.setLocation(dim.width/2-infoFrame.getSize().width/2, dim.height/2-infoFrame.getSize().height/2);
        JButton table=new JButton("Table");
        infoFrame.add(table);
        //JButton search=new JButton("Search");
        //infoFrame.add(search);
        JButton remove=new JButton("Remove");
        infoFrame.add(remove);
        JButton menuButton=new JButton("Main Menu");
        infoFrame.add(menuButton);
        infoFrame.setVisible(true);
        //informationDisplay:element actions
        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                mainMenuDisplay();
            }
        });
        table.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                try {
					informationTableDisplay();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        /*
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                //searchDisplay();
            }
        });
        */
        remove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                infoFrame.dispose();
                removeDisplay();
            }
        });
    }

    public void inputShippingInformationDisplay(){
        //inputShippingInformationDisplay:frame+frame elements
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
        JButton backButton=new JButton("Back");
        inputShippingFrame.add(backButton);
        JButton menuButton=new JButton("Main Menu");
        inputShippingFrame.add(menuButton);
        inputShippingFrame.setVisible(true);
        

        //inputShippingInformationDisplay:element actions
        orderNumber.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent key){
        		if(key.getKeyChar()>='0'&&key.getKeyChar()<='9'){
        			orderNumber.setEditable(true);
        		}
        		else if(key.getKeyChar()==' '||key.getKeyChar()=='\b'){orderNumber.setEditable(true);}
        		else{orderNumber.setEditable(false);}
        	}
        });
        
        productNumber.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent key){
        		if(key.getKeyChar()>='0'&&key.getKeyChar()<='9'){
        			productNumber.setEditable(true);
        		}
        		else if(key.getKeyChar()==' '||key.getKeyChar()=='\b'){productNumber.setEditable(true);}
        		else{productNumber.setEditable(false);}
        	}
        });
        
        quantity.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent key){
        		if(key.getKeyChar()>='0'&&key.getKeyChar()<='9'){
        			quantity.setEditable(true);
        		}
        		else if(key.getKeyChar()==' '||key.getKeyChar()=='\b'){quantity.setEditable(true);}
        		else{quantity.setEditable(false);}
        	}
        });
        
        unitPrice.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key){
        		if(key.getKeyChar()>='0'&&key.getKeyChar()<='9'){
        			unitPrice.setEditable(true);
        		}
        		else if(key.getKeyChar()==' '||key.getKeyChar()=='\b'){
        			unitPrice.setEditable(true);
        		}
        		else if (key.getKeyChar()=='.'){
        			if(unitPrice.getText().contains(".")){unitPrice.setEditable(false);}
        			else{unitPrice.setEditable(true);}
        		}
        		else{unitPrice.setEditable(false);}
        	}
        });
        
        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputShippingFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
					if(invoice.searchOrderNumber(orderNumber.getText())==true){
					    JOptionPane.showMessageDialog(null,"Order number already in use.");
					    orderNumber.setText("");
					}
					else if(orderNumber.getText().isEmpty()||
							product.getText().isEmpty()||
							productNumber.getText().isEmpty()||
							quantity.getText().isEmpty()||
							unitPrice.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"1 or more fields are empty");
					}
				} catch (HeadlessException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                
                //TRY BLOCK IOEXCEPTION
                if(orderNumber.getText().equals("")==false){
		            mInfo=new ManufacturerInformation(orderNumber.getText(),product.getText()
		                        ,productNumber.getText(),quantity.getText(),unitPrice.getText());
		            try {
						inputCustomerInformationDisplay();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
		            }
		            inputShippingFrame.dispose();
		                
		            }
            	}
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                orderNumber.setText("");
                product.setText("");
                productNumber.setText("");
                quantity.setText("");
                unitPrice.setText("");
            }
        });
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputShippingFrame.dispose();
                mainMenuDisplay();
            }
        });
    }

    public void inputCustomerInformationDisplay()throws IOException{
        //inputCustomerInformationDisplay:frame+frame elements
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
        //FIXME: phoneNumber: restrict so that only numbers go in    
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
        JButton backButton=new JButton("Back");
        inputCustomerFrame.add(backButton);
        JButton menuButton=new JButton("Main Menu");
        inputCustomerFrame.add(menuButton);

        inputCustomerFrame.setVisible(true);
        //inputCustomerInformationDisplay:element actions
        menuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputCustomerFrame.dispose();
                mainMenuDisplay();
            }
        });
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(notes.getText()==""){
                    notes.setText(" ");
                }
                if(name.getText().isEmpty()||
                		address.getText().isEmpty()||
                		phoneNumber.getText().isEmpty()||
                		email.getText().isEmpty()){
                	JOptionPane.showMessageDialog(null,"1 or more fields are empty");	
                }
                else if(name.getText().isEmpty()==false&&
                		address.getText().isEmpty()==false&&
                		phoneNumber.getText().isEmpty()==false&&
                		email.getText().isEmpty()==false){
                	cInfo=new CustomerInformation(name.getText(),address.getText(),
                            phoneNumber.getText(),email.getText(),notes.getText());
                	invoice=new InvoiceGenerator(mInfo,cInfo);
                	//TRY BLOCK IOEXCEPTION
                    try {
    					invoice.addToFile();
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                    inputCustomerFrame.dispose();
                    mainMenuDisplay();
                	
                }
                
                
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                name.setText("");
                address.setText("");
                phoneNumber.setText("");
                email.setText("");
                notes.setText("");
            }
        });
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputCustomerFrame.dispose();
                inputShippingInformationDisplay();
            }
        });
    }

    public void informationTableDisplay() throws IOException{
        //informationTableDisplay:frame+frame elements
        JFrame tableFrame=new JFrame("Shipping Management");
        tableFrame.setLayout(frameLayout);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tableFrame.setLocation(dim.width/2-tableFrame.getSize().width/2, dim.height/2-tableFrame.getSize().height/2);

        //FIXME: set up table
        
        String[]colName={"Order Number","Product","Product No.","Qty","Unit Price",
                            "Subtotal","Tax","Total","Name","Address","Phone No.",
                            "Email","Notes"};
        Object[][]rowData=invoice.fileReader(); 

        JLabel shippingInfoL=new JLabel("Shipping Information");
        tableFrame.add(shippingInfoL);
        DefaultTableModel model=new DefaultTableModel(rowData,colName);
        final JTable table=new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(1300,600));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1300,600));
        tableFrame.add(scrollPane,BorderLayout.CENTER);
        
        JButton menuButton=new JButton("Main Menu");
        tableFrame.add(menuButton);
        JButton cancelButton=new JButton("Back");
        tableFrame.add(cancelButton);
        JLabel searchL=new JLabel("Search");
        tableFrame.add(searchL);
        JTextField searchField=new JTextField(20);
        tableFrame.add(searchField);
        tableFrame.setVisible(true);

        
        TableRowSorter<TableModel> rowSorter=new TableRowSorter<>(table.getModel());
       	table.setRowSorter(rowSorter);
       	searchField.getDocument().addDocumentListener(new DocumentListener(){

			@Override public void changedUpdate(DocumentEvent arg0) {
                throw new UnsupportedOperationException();
            }
            
			@Override public void insertUpdate(DocumentEvent arg0) {
				String text=searchField.getText();
				if(text.trim().length()==0){rowSorter.setRowFilter(null);}
       			else{rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));}
			}

			@Override public void removeUpdate(DocumentEvent arg0) {
                String text=searchField.getText();
				if(text.trim().length()==0){
                    rowSorter.setRowFilter(null);
                }
                else{rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));}	
			}
       		
       	});
        //informationTableDisplay:element actions
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
    /*
    public void searchDisplay(){
        //searchDisplay:frame+frame elements
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
        //searchDisplay:element actions
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
	*/
    public void removeDisplay(){
        //removeDisplay:frame+frame elements
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
        //removeDisplay:frame+frame elements
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

    public void invoiceDisplay(){
        JFrame invoiceFrame=new JFrame("Shipping Management");
        invoiceFrame.setLayout(frameLayout);
        invoiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        invoiceFrame.setSize(500,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        invoiceFrame.setLocation(dim.width/2-invoiceFrame.getSize().width/2, dim.height/2-invoiceFrame.getSize().height/2);
        JLabel invoiceL=new JLabel("Invoice: Customer Name");
        invoiceFrame.add(invoiceL);
        //------
        JTextField invoiceField=new JTextField(invoice.toString());
        invoiceFrame.add(invoiceField);
        invoiceFrame.setVisible(true);
    }
}