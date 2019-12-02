import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.IOException;
public class MainMenu{
    
    FlowLayout frameLayout=new FlowLayout();
    JFrame menuFrame=new JFrame("Shipping Management");
    ManufacturerInformation mInfo=new ManufacturerInformation();
    CustomerInformation cInfo=new CustomerInformation();
    InvoiceGenerator invoice=new InvoiceGenerator();

    public MainMenu(){
    		try {
				invoice.createInvoiceFolder();
				invoice.fileUpdated();
			} 
    		catch(IOException e1){
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }

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
                try{informationTableDisplay();} 
                catch(IOException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
                try{
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
					else{
			            mInfo=new ManufacturerInformation(orderNumber.getText(),product.getText()
			                        ,productNumber.getText(),quantity.getText(),unitPrice.getText());
			            try{
							inputCustomerInformationDisplay();
	                    }
	                    catch(IOException e1){
							// TODO Auto-generated catch block
							e1.printStackTrace();
			            }
			            inputShippingFrame.dispose();      
			        }
                }
                catch(HeadlessException e2){
					// TODO Auto-generated catch block
					e2.printStackTrace();
                }
                catch(IOException e2){
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
        JLabel phoneNumberL=new JLabel("Phone Number");
        inputCustomerFrame.add(phoneNumberL);
        //FIXME: figure textField or Formatted?
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
        phoneNumber.addKeyListener(new KeyAdapter(){
        	public void keyPressed(KeyEvent key){
        		if(key.getKeyChar()>='0'&&key.getKeyChar()<='9'){
        			phoneNumber.setEditable(true);
        		}
        		else if(key.getKeyChar()=='\b'){phoneNumber.setEditable(true);}
                else if(phoneNumber.getText().length()>10){phoneNumber.setEditable(false);}
                else{phoneNumber.setEditable(false);}
        	}
        });
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
                else if(!(phoneNumber.getText().length()==10)){
                	if(phoneNumber.getText().length()>10){JOptionPane.showMessageDialog(null,"Invalid phone number (too long)");}
                	else{JOptionPane.showMessageDialog(null,"Invalid phone number (too short)");}
                }
                else if(name.getText().isEmpty()==false&&
                		address.getText().isEmpty()==false&&
                		phoneNumber.getText().isEmpty()==false&&
                		email.getText().isEmpty()==false&&
                		phoneNumber.getText().length()==10){
                	cInfo=new CustomerInformation(name.getText(),address.getText(),
                            phoneNumber.getText(),email.getText(),notes.getText());
                	invoice=new InvoiceGenerator(mInfo,cInfo);
                	//TRY BLOCK IOEXCEPTION
                    try{
    					invoice.addToFile();
                    }
                    catch(IOException e1){
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tableFrame.setSize(dim);
        tableFrame.setLocation(dim.width/2-tableFrame.getSize().width/2, dim.height/2-tableFrame.getSize().height/2);
        String[]colName={"Order Number","Product","Product No.","Qty","Unit Price",
                            "Subtotal","Tax","Total","Name","Address","Phone No.",
                            "Email","Notes"};
        Object[][]rowData=invoice.invoiceArray(); 
        JLabel shippingInfoL=new JLabel("Shipping Information");
        tableFrame.add(shippingInfoL);
        //FIXME: is the DefaultTableModel needed? 
        DefaultTableModel model=new DefaultTableModel(rowData,colName);
        final JTable table=new JTable(model);
        //FIXME: are these needed?
        //table.setPreferredScrollableViewportSize(new Dimension(1300,600));
        //table.setFillsViewportHeight(true);
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1300,600));
        tableFrame.add(scrollPane,BorderLayout.CENTER);
        JButton menuButton=new JButton("Main Menu");
        tableFrame.add(menuButton);
        JLabel searchL=new JLabel("Search");
        tableFrame.add(searchL);
        JTextField searchField=new JTextField(20);
        tableFrame.add(searchField);
        JButton genInvoiceButton=new JButton("Create Invoice");
        tableFrame.add(genInvoiceButton);
        JButton genAllInvoiceButton=new JButton("Create All Invoices");
        tableFrame.add(genAllInvoiceButton);
        JButton removeButton=new JButton("Remove");
        tableFrame.add(removeButton);
        JButton removeAllButton=new JButton("Remove All");
        tableFrame.add(removeAllButton);
        tableFrame.setVisible(true);
        //searcher
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
        genInvoiceButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
            		if(invoice.searchOrderNumber(searchField.getText())==true){
						invoice.generateInvoice(searchField.getText());
            		}
					searchField.setText("");
				}
            	catch(IOException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        genAllInvoiceButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				invoice.generateAllInvoices();
            }
        });
        removeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try{
            		if(invoice.searchOrderNumber(searchField.getText())==true){
						invoice.removeFromFile(searchField.getText());
						model.removeRow(invoice.searchIndex);
            		}
					searchField.setText("");
				}
            	catch(IOException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } 
        });
        removeAllButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            	try{
						invoice.removeAllFromFile();
						model.setNumRows(0);
            		}
            	catch(IOException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
        });
    }
}