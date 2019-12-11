public class CustomerInformation{
    
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String notes;
    
    public CustomerInformation(){}
    public CustomerInformation(String name,String address,String phoneNumber,
    String email,String notes){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.notes=notes;
    }

    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmail(){return this.email;}
    public String getNotes(){return this.notes;}

    public void setName(String newName){this.name=newName;}
    public void setAddress(String newAddress){this.address=newAddress;}
    public void setPhoneNumber(String newPhoneNumber){this.phoneNumber=newPhoneNumber;}
    public void setEmail(String newEmail){this.email=newEmail;}
    public void setNotes(String newNotes){this.notes=newNotes;}

    @Override public String toString(){
        return String.format("%s| %s| %s| %s| %s",this.name,this.address,this.phoneNumber,
                                this.email,this.notes);
    }
}
