public class ManufacturerInformation{
    
    private String orderNumber;
    private String product;
    private String productNumber;
    private String quantity;
    private String unitPrice;
    private final double SALES_TAX=0.043;

    public ManufacturerInformation(){}
    public ManufacturerInformation(String orderNumber,String product,
    String productNumber,String quantity,String unitPrice){
        this.orderNumber=orderNumber;
        this.product=product;
        this.productNumber=productNumber;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
        String[] manfacturerInformationArray=new String[]{this.orderNumber,this.product,
                            this.productNumber,this.quantity,this.unitPrice,
                            String.valueOf(subTotal()),String.valueOf(SALES_TAX),String.valueOf(totalPrice())};
    }

    public String getOrderNumber(){return this.orderNumber;}
    public String getProduct(){return this.product;}
    public String getProductNumber(){return this.productNumber;}
    public String getQuantity(){return this.quantity;}
    public String getUnitPrice(){return this.unitPrice;}
    public double getSalesTax(){return SALES_TAX;}

    public void setOrderNumber(String newOrderNumber){this.orderNumber=newOrderNumber;}
    public void setProduct(String newProduct){this.product=newProduct;}
    public void setProductNumber(String newProductNumber){this.productNumber=newProductNumber;}
    public void setQuantity(String newQuantity){this.quantity=newQuantity;}
    public void setUnitPrice(String newUnitPrice){this.unitPrice=newUnitPrice;}

    public double subTotal(){
        return Math.round(Integer.valueOf(this.quantity)*Double.valueOf(this.unitPrice)*100.0)/100.0;
    }

    public double totalPrice(){
        double beforeTax=Integer.valueOf(this.quantity)*Double.valueOf(this.unitPrice);
        double afterTax=beforeTax+(beforeTax*SALES_TAX);
        double rounded=(double)Math.round(afterTax*100.0)/100.0;
        return rounded;
    }

    @Override public String toString(){
        return String.format("%s| %s| %s| %s| %s| %s| %s| %s",this.orderNumber,this.product,this.productNumber,
                                this.quantity,this.unitPrice,subTotal(),SALES_TAX,totalPrice());
    }
}