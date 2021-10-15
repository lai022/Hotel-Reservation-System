public class Customer {
    private String name;
    private String icNumber;
    private String phoneNo;
    private String email;

    public Customer(String name,String icNumber, String phoneNo, String email){
        this.name=name;
        this.icNumber=icNumber;
        this.phoneNo=phoneNo;
        this.email=email;
    }

    //No arg constructor
    public Customer(){
    }

    //getter method/ accessor method
    public String getName(){
        return name;
    }

    public String getIC(){
        return icNumber;
    }

    public String getPhone(){
        return phoneNo;
    }

    public String getEmail(){
        return email;
    }

    //setter method/mutator method
    public void setName(String name){
        this.name=name;
    }

    public void setIC(String icNumber){
        this.icNumber=icNumber;
    }

    public void setPhone(String phoneNo){
        this.phoneNo=phoneNo;
    }

    public void setEmail(String email){
        this.email=email;
    }
}
