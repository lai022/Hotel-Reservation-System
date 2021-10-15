import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Rooms rooms;
    private final Customer customer;
    private final int reservationID;
    private static int reservationIDPlus = 1001;
    private Date dateFrom;;  
    private Date systemDate;
    private int totalDays;
    private double totalPrice;
    private  int noOfPerson;
    private char roomCode;

    public Reservation(){
        rooms = new Rooms();

        customer = new Customer();
        reservationID = reservationIDPlus;
        systemDate = new Date();
        noOfPerson = 0;
        totalPrice = 0;
    }

    public Reservation( int totalDays, int noOfPerson, Rooms rooms, Date dateFrom, Customer customer){
        this.customer = customer;
        reservationID = reservationIDPlus;
        reservationIDPlus++;
        this.totalDays = totalDays;
        this.noOfPerson = noOfPerson;
        this.rooms = rooms;
        totalPrice = getCalTotalPrice();
        this.dateFrom = dateFrom;
        systemDate = new Date();
        if(rooms.roomType == RoomType.STANDARD){
            roomCode = 'A';
        }

        else if(rooms.roomType == RoomType.PREMIUM){
            roomCode = 'B';
        }

        else if(rooms.roomType == RoomType.DELUXE){
            roomCode = 'C';
        }
    }

    public double getCalTotalPrice(){
        return getRooms().getRoomPrice() * getTotalDays() + getServiceChange() + getSST() ;
    }

    public double getServiceChange(){
        return (getRooms().getRoomPrice() * getTotalDays()) * 0.05  ;
    }

    public double getSST(){
        return (getRooms().getRoomPrice() * getTotalDays()) * 0.03 ;
    }

    public int getCountDays(){
        return (int)( dateFrom.getTime() + getTotalDays());
    }

    public int getReservationID(){
        return reservationID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setDateFrom(Date dateFrom){
        this.systemDate = dateFrom;
    }

    public void setNoOfPerson(int noOfPerson){this.noOfPerson = noOfPerson;}

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Customer getCustomer(){ 
        return customer;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String toString(){
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");

        String rev = "";

        rev +="\t====================================================================\n";
        rev +="\t                            Reservation                             \n";
        rev +="\t====================================================================\n";
        rev +="\t   Reservation ID:R"+reservationID;
        rev += String.format("\t\t  Reservation Date: %te %<tB %<tY\n", systemDate);
        rev +="\t====================================================================\n";
        rev +="\tCustomer info\n";
        rev +="\t--------------\n";
        rev +="\tCustomer Name: "+ customer.getName() +"\n";
        rev +="\tIC no.: " +customer.getIC()+ "\n";
        rev +="\tContact.no: "+ customer.getPhone() +"\n";
        rev +="\tEmail: "+ customer.getEmail() +"\n";
        rev +="\n";
        rev +="\t--------------------------------------------------------------------\n";
        rev +="\n";
        rev +="\tReservation info\n";
        rev +="\t-----------------\n";
        rev +="\tRoom Type: "+ rooms.roomType+"\n";
        rev +="\tRoom Number: "+ roomCode + rooms.getRoomNumber()+"\n";
        rev +="\tCheck-in date: "+dateF.format(dateFrom)+"\n";
        rev +="\tDays of Stay: "+ totalDays +"\n";
        rev +="\tTotal person: "+ noOfPerson +"\n";
        rev +="\tRoom price: RM"+ rooms.getRoomPrice() +"\n";
        rev += 	String.format("\tRoom Service Charge (5%%): RM %.2f\n", getServiceChange());
        rev += 	String.format("\tRoom SST (3%%): RM%.2f\n", getSST());
        rev +="\n";
        rev +="\t--------------------------------------------------------------------\n";
        rev +=String.format("\tTotal price: RM%.2f\n", totalPrice);
        rev +="\t====================================================================\n";
        return rev;
    }



}
