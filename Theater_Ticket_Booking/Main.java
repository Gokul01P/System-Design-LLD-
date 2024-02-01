package Theater_Ticket_Booking;
import java.util.Scanner;
public class Main {
    public static void bookTicket(Audience aud){
        TicketBooking booking=new TicketBooking();
        if(TicketBooking.totalSeats==0){
            System.out.println("Sorry!...No tickets available");
            return;
        }
        if((aud.SeatPreference.equals("E") && TicketBooking.availableElite>=0) ||
                (aud.SeatPreference.equals("P") && TicketBooking.availablePremium >= 0) ||
                (aud.SeatPreference.equals("N") && TicketBooking.availableNormal >= 0)){
            System.out.println("Prefered seat available...");
            //Elite Seats
            if(aud.SeatPreference.equals("E")){
                if(TicketBooking.availableElite>0){
                    System.out.println("Elite seat is given...");
                    booking.bookTicket(aud, (TicketBooking.ElitePosition.get(0)), "E");
                    TicketBooking.ElitePosition.remove(0);
                    TicketBooking.availableElite--;
                    TicketBooking.totalSeats--;
                }else{
                    System.out.println("Sorry !...Elite seat are filled");
                }
            }
            //Premium Seats
            if(aud.SeatPreference.equals("P")){
                if(TicketBooking.availablePremium>0){
                    System.out.println("Premium seat is given...");
                    booking.bookTicket(aud,(TicketBooking.PremiumPosition.get(0)),"P");
                    TicketBooking.PremiumPosition.remove(0);
                    TicketBooking.availablePremium--;
                    TicketBooking.totalSeats--;
                }else{
                    System.out.println("Sorry !...Premium seat are filled");
                }
            }
            if(aud.SeatPreference.equals("N")){
                if(TicketBooking.availableNormal>0){
                    System.out.println("Normal seat is given...");
                    booking.bookTicket(aud,(TicketBooking.NormalPosition.get(0)),"P");
                    TicketBooking.NormalPosition.remove(0);
                    TicketBooking.availableNormal--;
                    TicketBooking.totalSeats--;
                }else{
                    System.out.println("Sorry !...Premium seat are filled");
                }
            }
        }
    }
    public static void cancelTicket(int id){
        TicketBooking booking=new TicketBooking();
        if(!booking.audi.containsKey(id)){
            System.out.println("Name was unknown");
        }else{
            booking.cancelTicket(id);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        boolean loop=true;

        while(loop){
            System.out.println("1.Book Ticket \n2.Cancel Ticket \n3.Available Tickets \n4.Booked Tickets \n5.Exit");
            int choice=in.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("Enter your name,age,Seat preference(E,P,N)");
                    String name=in.next();
                    int age= in.nextInt();
                    String SeatPreference=in.next();

                    Audience aud=new Audience(name,age,SeatPreference);
                    bookTicket(aud);
                }
                break;
                case 2:{
                    System.out.println("Enter the name id to cancel: ");
                    int id=in.nextInt();
                    cancelTicket(id);
                }
                break;
                case 3:{
                    TicketBooking booking=new TicketBooking();
                    booking.printAvailableSeats();
                }
                break;
                case 4:{
                    TicketBooking booking=new TicketBooking();
                    booking.printAllSeatsinfo();
                }
                break;
                case 5:{
                    loop=false;
                }
                break;
                default:
                    break;
            }
        }
    }
}
