import java.io.*;
import java.util.*;

public class InvoiceGenerator{

    ManufacturerInformation manufacturer;
    CustomerInformation customer;
    final File invoiceFolder=new File("C:/Invoice");
    final File allInvoices=new File("C:/Invoice/invoices");
    final String fileName="C:/Invoice/TESTER.txt";
    WriteFile data=new WriteFile(fileName,true);
   

    ArrayList<String> infoArray=new ArrayList<String>();
    int searchIndex=0;


    public InvoiceGenerator(){}
    public InvoiceGenerator(ManufacturerInformation manufacturer,CustomerInformation customer){
        this.manufacturer=manufacturer;
        this.customer=customer;
    }
    
    public void createInvoiceFolder() throws IOException{
    	invoiceFolder.mkdir();
    	allInvoices.mkdir();
    	data.newFile();
    }
    public void removeFromFile(String removed) throws IOException{
        if(searchOrderNumber(removed)==true){
            data.clearFile();
            infoArray.remove(searchIndex);
            for(int i=0;i<=infoArray.size()-1;i++){
                data.writeToFile(infoArray.get(i));
            }
        }
    }
    
    public void removeAllFromFile() throws IOException{
    	data.clearFile();
    	infoArray=new ArrayList<String>();
    }

    public void addToFile()throws IOException{
        data.writeToFile(toString());
        fileUpdated();
    }
   
    public void fileUpdated() throws IOException{
        Scanner sc=new Scanner(new BufferedReader(new FileReader(fileName)));
        while(sc.hasNextLine()){
                infoArray.add(sc.nextLine());
        }
        sc.close();
    }
    
    public String[][] invoiceArray()throws IOException{
        String[][] tableArray=new String[infoArray.size()][13];
        for(int x=0;x<=infoArray.size()-1;x++){
            String[] tempStrArr=((String) infoArray.toArray()[x]).split("\\| ");
            for(int y=0;y<=tempStrArr.length-1;y++){
                tableArray[x][y]=tempStrArr[y];
            }
        }
        return tableArray;
    }

    public boolean searchOrderNumber(String orderNum) throws IOException{
        boolean flag=false;
        String[][] currentArray=invoiceArray();
        for(int i=0;i<=currentArray.length-1;i++){
            if(currentArray[i][0].equals(orderNum)){
                searchIndex=i;
                flag=true;
                break;
            }
        }
        return flag;
    }
    
    

    public void addInvoiceElement(ManufacturerInformation manu,CustomerInformation cust){
        this.manufacturer=manu;
        this.customer=cust;
    }
    //TODO:generate text file
    public void generateInvoice(String orderNum){
    	try{
			if(searchOrderNumber(orderNum)==true){
                String invoiceFileName="C:/Invoice/invoices/INVOICE "+orderNum+".txt";
                WriteFile invoiceFile=new WriteFile(invoiceFileName,true);
                String[][]invArray=invoiceArray();
                invoiceFile.clearFile();
                invoiceFile.writeToFile("NAME"+"\t"+"\t"+"\t"+invArray[searchIndex][8]);
                invoiceFile.writeToFile("ADDRESS"+"\t"+"\t"+"\t"+invArray[searchIndex][9]);
                invoiceFile.writeToFile("PHONE NUMBER"+"\t"+"\t"+invArray[searchIndex][10]);
                invoiceFile.writeToFile("EMAIL"+"\t"+"\t"+"\t"+invArray[searchIndex][11]);
                invoiceFile.writeToFile("");
                invoiceFile.writeToFile("ORDER NUMBER"+"\t"+"\t"+invArray[searchIndex][0]);
                invoiceFile.writeToFile("PRODUCT"+"\t"+"\t"+"\t"+invArray[searchIndex][1]);
                invoiceFile.writeToFile("PRODUCT NUMBER"+"\t"+"\t"+invArray[searchIndex][2]);
                invoiceFile.writeToFile("QUANTITY"+"\t"+"\t"+invArray[searchIndex][3]);
                invoiceFile.writeToFile("UNIT PRICE"+"\t"+"\t"+invArray[searchIndex][4]);
                invoiceFile.writeToFile("SUBTOTAL"+"\t"+"\t"+invArray[searchIndex][5]);
                invoiceFile.writeToFile("SALES TAX"+"\t"+"\t"+invArray[searchIndex][6]);
                invoiceFile.writeToFile("TOTAL PRICE"+"\t"+"\t"+invArray[searchIndex][7]);
                if(invArray[searchIndex][12]==null){
                    invoiceFile.writeToFile("");
                    invoiceFile.writeToFile("NOTES"+"\t"+"\t"+"\tn/a");
                }                   
			}
        }
    	catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
    }

    public void generateAllInvoices(){
        String[][] invArray;
		try{
			invArray = invoiceArray();
			for(int orderNum=0;orderNum<=invArray.length-1;orderNum++){
	            generateInvoice(invArray[orderNum][0]);
	        }
		} 
		catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    @Override public String toString(){return String.format("%s| %s",this.manufacturer.toString(),this.customer.toString());}
}