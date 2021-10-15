public class Card extends Payment{
    private String cardNo;
    private String cardCVV;
    private String cardExpDate;

    public Card(){
        super();
        paymentType = PaymentType.CARD;
        cardNo = "";
        cardCVV = "";
        cardExpDate = "";
    }

    public Card(Reservation reservation, String cardNo, String cardCVV, String cardExpDate){
        super(reservation);
        paymentType = PaymentType.CARD;
        this.cardNo = cardNo;
        this.cardCVV = cardCVV;
        this.cardExpDate = cardExpDate;
    }

    public String getCash_No() {
        return cardNo;
    }

    public void setCash_No(String cash_No) {
        cardNo = cash_No;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
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
        str +="\tDays of Stay:"+ getReservation().getTotalDays() +"\n";
        str +="\tTotal person:"+ getReservation().getNoOfPerson() +"\n";
        str +=String.format("\tRoom price: RM%.2f\n", getReservation().getRooms().getRoomPrice());
        str += String.format("\tRoom Service Charge (5%%): RM%.2f\n", getReservation().getServiceChange());
        str += String.format("\tRoom SST (3%%): RM%.2f\n", getReservation().getSST());

        str +="\n";
        str +="\tCard info\n";
        str +="\t----------\n";
        str +="\tCard no.: "+ cardNo +"\n";
        str +="\tCard CVV: "+ cardCVV +"\n";
        str +="\tCard Exp.Date: "+ cardExpDate +"\n";
        str +=String.format("\tPaid: RM%.2f\n", getReservation().getCalTotalPrice());
        str +="\t--------------------------------------------------------------------\n";
        str += String.format("\tTotal price: RM %.2f \n", getReservation().getCalTotalPrice());
        str +="\t====================================================================\n";

        return str;
    }
}
