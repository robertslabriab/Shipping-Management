import java.io.*;
import java.util.*;

public class InvoiceGenerator{

    ManufacturerInformation manufacturer;
    CustomerInformation customer;
    final String fileName="C:/cs211/ProjectGUI/TESTER.txt";
    WriteFile data=new WriteFile(fileName,true);
    ArrayList<String> infoArray=new ArrayList<String>();
    int searchIndex=0;


    public InvoiceGenerator(){}
    public InvoiceGenerator(ManufacturerInformation manufacturer,CustomerInformation customer){
        this.manufacturer=manufacturer;
        this.customer=customer;
    }

    public void addToFile()throws IOException{
        data.writeToFile(toString());
    }

    public String[][] fileReader() throws IOException{
        Scanner sc=new Scanner(new BufferedReader(new FileReader(fileName)));
        while(sc.hasNextLine()){
                infoArray.add(sc.nextLine());
        }
        sc.close();
        //infoArray.toArray();
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
        String[][] currentArray=fileReader();
        for(int i=0;i<=currentArray.length-1;i++){
            if(currentArray[i][0].contentEquals(orderNum)){
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
    public void generateInvoice(){}

    
    @Override public String toString(){return String.format("%s| %s",this.manufacturer.toString(),this.customer.toString());}  
}
