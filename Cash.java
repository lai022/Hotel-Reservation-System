public class Cash extends Payment{
    private double cashAmount;

    public Cash(){
        super();
        paymentType = PaymentType.CASH;
        cashAmount = 0;
    }

    public Cash(Reservation reservation, double CashAmount){
        super(reservation);
        this.cashAmount = CashAmount;
        paymentType = PaymentType.CASH;
    }

    public double getCalTotalChange(){return cashAmount - getReservation().getCalTotalPrice();}

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String toString(){
        String str = "";

        str += "\n\n\t====================================================================\n";
        str += "\t                              Receipt\n";
        str += "\t====================================================================\n";
        str += "\tPayment ID:P" + getPaymentID();
        str += String.format("\t\t  Payment Date: %te %<tB %<tY\n", getPaymentTime());
        str +="\t====================================================================\n";
        str +="\tCustomer info\n";
        str +="\t--------------\n";
        str +="\tCustomer Name: "+ getReservation().getCustomer().getName()+"\n";
        str +="\tIC no. : " +getReservation().getCustomer().getIC()+ "\n";
        str +="\tContact.no :"+ getReservation().getCustomer().getPhone() +"\n";
        str +="\tEmail: "+ getReservation().getCustomer().getEmail()+"\n";
        str +="\n";
        str +="\t--------------------------------------------------------------------\n";
        str +="\n";
        str +="\tReservation info\n";
        str +="\t-----------------\n";
        str +="\tRoom Type: "+ getReservation().getRooms().roomType+"\n";
        str +="\tRoom Number:"+ getReservation().getRooms().getRoomNumber()+"\n";
        str += String.format("\tRoom Service Charge (5%%): RM%.2f\n", getReservation().getServiceChange());
        str += String.format("\tRoom SST (3%%): RM%.2f\n", getReservation().getSST());
        str +="\tDays of Stay:"+ getReservation().getTotalDays() +"\n";
        str +="\tTotal person:"+ getReservation().getNoOfPerson() +"\n";
        str +=String.format("\tRoom price: RM%.2f\n", getReservation().getRooms().getRoomPrice());
        str +="\n";
        str += String.format("\tPaid: RM%.2f\n", cashAmount);
        str += String.format("\tChange: RM%.2f\n", getCalTotalChange());
        str +="\t--------------------------------------------------------------------\n";
        str += String.format("\tTotal price: RM %.2f \n", getReservation().getCalTotalPrice());
        str +="\t====================================================================\n";

        return str;
    }
}
