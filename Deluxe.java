public class Deluxe extends Rooms{
    private static int Deluxe_Room_Number=3001;
    private static final int Deluxe_Total_Person = 8;
    private static final double Deluxe_Room_Price = 899.99;

    public Deluxe(){
        super(Deluxe_Room_Number, Deluxe_Total_Person, Deluxe_Room_Price);
        Deluxe_Room_Number++;
        roomType = RoomType.DELUXE;
    }
}