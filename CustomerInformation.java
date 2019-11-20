public class CustomerInformation{
    
    private String name;
    private String address;
    private int phoneNumber;
    private String email;
    private String notes;
    
    public CustomerInformation(String name,String address,int phoneNumber,
    String email,String notes){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.notes=notes;
        String[] customerInfomationArray=new String[]{this.name,this.address,String.valueOf(this.phoneNumber),
                                        this.email,this.notes};
    }

    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public int getPhoneNumber(){return this.phoneNumber;}
    public String getEmail(){return this.email;}
    public String getNotes(){return this.notes;}

    public void setName(String newName){this.name=newName;}
    public void setAddress(String newAddress){this.address=newAddress;}
    public void setPhoneNumber(int newPhoneNumber){this.phoneNumber=newPhoneNumber;}
    public void setEmail(String newEmail){this.email=newEmail;}
    public void setNotes(String newNotes){this.notes=newNotes;}

    @Override public String toString(){
        return String.format("%s %s %s %s %s",this.name,this.address,this.phoneNumber,
                                this.email,this.notes);
    }
}