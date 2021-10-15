public class Premium extends Rooms{
    private static int Premium_Room_Number=2001;
    private static final int Premium_Total_Person = 4;
    private static final double Premium_Room_Price = 399.99;

    public Premium(){
        super(Premium_Room_Number, Premium_Total_Person, Premium_Room_Price);
        Premium_Room_Number++;
        roomType = RoomType.PREMIUM;
    }

}
