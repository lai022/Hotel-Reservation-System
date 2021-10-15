import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static Scanner input = new Scanner (System.in);

    public static void main (String[] arg) throws ParseException{
        Customer cust = new Customer();
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        Payment payments = new Payment();
        Date newDate = new Date();

        int i=0;
        int s=0;

        //Name
        cust.setName(inputName());

        //IC number
        cust.setIC(inputIcNo());

        //Phone number
        cust.setPhone(inputPhoneNo());

        //Email
        cust.setEmail(inputEmail());

        /*Home Page*/
        int menuChoice;
        do{
            printMenu(cust.getName());
            menuChoice = input.nextInt();

            switch(menuChoice){
                case 1:
                printRooms();
                Rooms room = inputRooms();
                int noOfPeron = inputNoOfPerson(room);

                String strDate = "";
                System.out.print("◍The date you will check-in (dd/MM/yyyy):");
                strDate = input.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

                while(newDate.after(date)){
                    System.out.println("!!!The date is not valid!!!");
                    System.out.print("◍The date you will check-in (dd/MM/yyyy):");
                    strDate = input.nextLine();
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
                }

                int days = inputDays();
                Reservation reservation = new Reservation(days, noOfPeron, room, date, cust);
                reservations.add(reservation);
                System.out.println(reservation);
                System.out.println("\t\t\tThe new reservation have been made");
                break;

                case 2:
                if(reservations.size()==0){
                    System.out.println("No Reservation Record found!!!");
                    break;
                }

                for(int c=0;c<reservations.size();c++){
                    System.out.println("\n\n\nReservation " + (1 + c));
                    System.out.println("------------");
                    System.out.println(reservations.get(c));

                }

                input.nextLine();
                String confirm = "";
                System.out.print("Do you want to edit the reservation? (N/n = no / Other = yes):");
                confirm = input.nextLine();
                if(Objects.equals(confirm,"N") || (Objects.equals(confirm,"n"))){
                    break;
                }

                System.out.print("Which Reservation you want to edit?\n");
                s = input.nextInt();
                while(s<=0 || s >reservations.size()){
                    System.out.println("!!!Invalid Input!!!");
                    System.out.print("Which Reservation you want to edit?\n");
                    s = input.nextInt();
                }

                --s;
                printRooms();

                Rooms roomEdit = inputRooms();

                int noOfPersonEdit = inputNoOfPerson(roomEdit);

                String strDate2 = "";
                System.out.print("◍The date you will check-in (dd/MM/yyyy):");
                strDate2 = input.nextLine();
                Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strDate2);

                while (newDate.after(date2)) {
                    System.out.println("!!!The date is not valid!!!");
                    System.out.print("◍The date you will check-in (dd/MM/yyyy):");
                    strDate = input.nextLine();
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate2);
                }

                int daysEdit = inputDays();

                Reservation reservationEdit = new Reservation(daysEdit, noOfPersonEdit, roomEdit, date2,cust);

                reservations.set(s, reservationEdit);

                System.out.println(reservationEdit);

                System.out.println("\t\t\t\tThe reservation have been edited");
                break;

                case 3:
                if(reservations.size()==0){
                    System.out.println("No Reservation Record found!!!");
                    break;
                }

                for (int c = 0; c < reservations.size(); c++) {
                    System.out.println("\n\n\nReservation " + (1 + c));
                    System.out.println(reservations.get(c));
                }

                input.nextLine();
                String confirm2 = "";
                System.out.print("Do you want to pay the reservation? (N/n = no / Other = yes):");
                confirm2 = input.nextLine();
                if (Objects.equals(confirm2, "N") || Objects.equals(confirm2, "n")) {
                    break;
                }

                System.out.print("Which Reservation you want to pay?\n");
                i = input.nextInt();
                while (i <= 0 || i > reservations.size()) {
                    System.out.println("!!!Invalid Input!!!");
                    System.out.print("Which Reservation you want to pay?\n");
                    i = input.nextInt();
                }
                --i;

                int paymentOption;
                do{
                    System.out.println("What payment method you want to use?");
                    System.out.println("1.Cash");
                    System.out.println("2.Card(Credit Card/Debit Card)");
                    System.out.print("Please Enter your selection: ");
                    paymentOption = input.nextInt();
                    input.nextLine();

                    switch(paymentOption){
                        case 1:
                        double subPrice = reservations.get(i).getCalTotalPrice();
                        double amountPay;
                        System.out.print("Please enter the amount you pay:");
                        amountPay = input.nextDouble();
                        while(amountPay < subPrice){
                            System.out.println("!!!Amount not enough!!!");
                            System.out.print("Please enter the amount you pay:");
                            amountPay = input.nextDouble();
                        }

                        payments = new Cash (reservations.get(i), amountPay);
                        break;

                        case 2:
                        System.out.print("◍Please enter the card number(0000-0000-0000-0000):");
                        String cardNo = input.nextLine();
                        while (!cardNo.matches("^\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{4}$")) {
                            System.out.println("!!!Invalid card number!!!\n");
                            System.out.print("◍Please enter the card number(0000-0000-0000-0000): ");
                            cardNo = input.nextLine();
                        }

                        System.out.print("Please enter the CVV:");
                        String cardCVV = input.nextLine();
                        while (!cardCVV.matches("^\\d{3}")) {
                            System.out.println("!!!Invalid CVV number!!!\n");
                            System.out.print("◍Please enter the CVV:: ");
                            cardCVV = input.nextLine();
                        }

                        String expDate = "";
                        System.out.print("Please enter the Exp.Date (MM/yy):");
                        expDate = input.nextLine();
                        Date date3 = new SimpleDateFormat("MM/yy").parse(expDate);

                        while (newDate.after(date3)) {
                            System.out.println("!!!The Exp.Date is not valid!!!");
                            System.out.print("Please enter the Exp.Date (MM/yy):");
                            expDate = input.nextLine();
                            date3 = new SimpleDateFormat("MM/yy").parse(expDate);
                        }

                        payments = new Card(reservations.get(i), cardNo, cardCVV, expDate);

                        default:
                        System.out.println("You only can select 1-2 only!!!");
                    }

                }while(paymentOption < 1 || paymentOption > 2);

                System.out.println(payments);
                System.out.println("\t\t\t\tYou have paid the payment");
                //remove a paid reservation
                reservations.remove(i);
                break;

                case 4:
                System.out.println("Thank you for using our system :D\n");


            }

        }while(menuChoice != 4);


    }


    public static String inputName(){
        System.out.print("\n◍Please enter your name: ");
        String theName = input.nextLine();

        while(!theName.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?")){
            System.out.print("Invalid name   ∑(° △ °|||)︴ \n\n◍Please enter your name again: ");
            theName = input.nextLine();
        }

        return theName;

    }

    public static String inputIcNo(){
        System.out.print("◍Please enter your IC number(000000-00-0000): ");
        String theIcNo = input.nextLine();

        while(!theIcNo.matches("^\\d{6}\\-\\d{2}\\-\\d{4}$")){
            System.out.println("Invalid IC number.");
            System.out.print("◍Please enter your IC number(000000-00-0000): ");
            theIcNo = input.nextLine();
        }

        return theIcNo;
    }

    public static String inputPhoneNo(){
        System.out.print("◍Please enter your phone number(012-3456789): ");
        String thePhone = input.nextLine();

        while(!thePhone.matches("\\d{3}-\\d{7,9}")){
            System.out.println("Invalid phone number");
            System.out.print("◍Please enter your phone number(012-3456789): ");
            thePhone = input.nextLine();
        }

        return thePhone;
    }

    public static String inputEmail(){
        System.out.print("◍Please enter your email: ");
        String theEmail = input.nextLine();

        while(!theEmail.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
            System.out.println("Invalid email.");
            System.out.print("◍Please enter your email: ");
            theEmail = input.nextLine();
        }

        return theEmail;
    }

    public static void printMenu(String name){
        System.out.println("\n  ✿✿HI, " + name.toUpperCase() + "✿✿ \n");
        System.out.println("+-----------------------+");
        System.out.println("|       Home Page       |");
        System.out.println("+-----------------------+");
        System.out.println("|  1. Reservation       |");
        System.out.println("|  2. Edit Reservation  |");
        System.out.println("|  3. Payment           |");
        System.out.println("|  4. Exit              |");
        System.out.println("+-----------------------+");
        System.out.print("Please select your option: ");

    }

    public static void printRooms(){
        System.out.println("+---------------------------------------------+");
        System.out.println("|                 Rooms Menu                  |");
        System.out.println("+---------------------------------------------+");
        System.out.println("|  1. Standard (Max 2p)   Price: RM149.99     |");
        System.out.println("|  2. Premium  (Max 4p)   Price: RM399.99     |");
        System.out.println("|  3. Deluxe   (Max 8p)   Price: RM899.99     |");
        System.out.println("+---------------------------------------------+");
    }

    public static Rooms inputRooms(){
        Rooms room =new Rooms();

        int roomOption;

        do{
            System.out.print("◍Please select the room (1-3) :");
            roomOption = input.nextInt();

            switch(roomOption){
                case 1:
                room = new Standard();
                break;

                case 2:
                room = new Premium();
                break;

                case 3:
                room = new Deluxe();
                break;

                default:
                System.out.println("You can only select 1-3 only!!!");

            }

        }while(roomOption<1 || roomOption > 3);

        return room;
    }

    public static int inputNoOfPerson(Rooms room){
        int numberOfPerson =0;
        System.out.print("◍How many person you have?: ");
        numberOfPerson = input.nextInt();

        while(numberOfPerson<1||numberOfPerson > room.getTotalPerson()){
            System.out.println("!!!INVALID INPUT!!!");
            System.out.print("◍How many person you have?: ");
            numberOfPerson = input.nextInt();

        }
        input.nextLine();
        return numberOfPerson;
    }

    public static int inputDays(){
        int days;
        System.out.print("◍How many days you want to stay?: ");
        days = input.nextInt();

        while(days<1){
            System.out.println("!!!Invalid Input!!!");
            System.out.print("◍How many days you want to stay?: ");
            days = input.nextInt();
        }

        return days;
    }
}
