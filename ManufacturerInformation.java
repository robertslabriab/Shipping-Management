public class ManufacturerInformation{
    
    private int orderNumber;
    private String product;
    private int productNumber;
    private int quantity;
    private double unitPrice;
    private final double SALES_TAX=0.043;

    public ManufacturerInformation(int orderNumber,String product,
    int productNumber,int quantity,double unitPrice){
        this.orderNumber=orderNumber;
        this.product=product;
        this.productNumber=productNumber;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
        String[] manfacturerInformationArray=new String[]{String.valueOf(this.orderNumber),this.product,
                            String.valueOf(this.productNumber),String.valueOf(this.quantity),String.valueOf(this.unitPrice),
                            String.valueOf(subTotal()),String.valueOf(SALES_TAX),String.valueOf(totalPrice())};
    }

    public int getOrderNumber(){return this.orderNumber;}
    public String getProduct(){return this.product;}
    public int getProductNumber(){return this.productNumber;}
    public int getQuantity(){return this.quantity;}
    public double getUnitPrice(){return this.unitPrice;}
    public double getSalesTax(){return SALES_TAX;}

    public void setOrderNumber(int newOrderNumber){this.orderNumber=newOrderNumber;}
    public void setProduct(String newProduct){this.product=newProduct;}
    public void setProductNumber(int newProductNumber){this.productNumber=newProductNumber;}
    public void setQuantity(int newQuantity){this.quantity=newQuantity;}
    public void setUnitPrice(double newUnitPrice){this.unitPrice=newUnitPrice;}

    public double subTotal(){
        return Math.round(this.quantity*this.unitPrice*100.0)/100.0;
    }

    public double totalPrice(){
        double beforeTax=this.quantity*this.unitPrice;
        double afterTax=beforeTax+(beforeTax*SALES_TAX);
        double rounded=(double)Math.round(afterTax*100.0)/100.0;
        return rounded;
    }

    @Override public String toString(){
        return String.format("%s %s %s %s %s %s %s %s",this.orderNumber,this.product,this.productNumber,
                                this.quantity,this.unitPrice,subTotal(),SALES_TAX,totalPrice());
    }


}