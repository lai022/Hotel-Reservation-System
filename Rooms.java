public class Rooms{
    private int roomNumber=1;
    private final int totalPerson;
    private final double roomPrice;
    protected RoomType roomType;

    public Rooms(){
        roomNumber++;
        totalPerson = 0;
        roomPrice = 0;
    }

    public Rooms(int roomNumber, int totalPerson, double roomPrice){
        this.roomNumber = roomNumber++;
        this.totalPerson = totalPerson;
        this.roomPrice = roomPrice;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public int getTotalPerson(){
        return totalPerson;
    }

    public double getRoomPrice(){
        return roomPrice;
    }

}