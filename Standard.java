public class Standard extends Rooms{
    private static int Standard_Room_Number=1001;
    private static final int Standard_Total_Person = 2;
    private static final double Standard_Room_Price = 149.99;

    public Standard(){
        super(Standard_Room_Number, Standard_Total_Person, Standard_Room_Price);
        Standard_Room_Number++;
        roomType = RoomType.STANDARD;
    }
}
