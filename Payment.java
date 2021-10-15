import java.util.Date;

public class Payment {
    private final Reservation reservationDetail;
    private int paymentID;
    private static int paymentIdPlus = 21201;
    protected PaymentType paymentType;
    private Date paymentTime;

    public Payment(){
        paymentID = paymentIdPlus;
        reservationDetail = new Reservation();
        paymentTime = new Date();
    }

    public Payment(Reservation reservationDetail){
        this.reservationDetail = reservationDetail;
        paymentID = paymentIdPlus;
        paymentIdPlus++;
        paymentTime = new Date();
    }

    public Reservation getReservation(){ return reservationDetail;}

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
