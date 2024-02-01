package Theater_Ticket_Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TicketBooking {
    static int availableElite = 1;
    static int availablePremium = 1;
    static int availableNormal = 1;
    static int totalSeats=availableElite + availablePremium + availableNormal;

    static List<Integer> bookedTicketList = new ArrayList<>();
    static List<Integer> ElitePosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> PremiumPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> NormalPosition = new ArrayList<>(Arrays.asList(1));

    static HashMap<Integer,Audience> audi=new HashMap<>();

    public void bookTicket(Audience aud,int SeatInfo,String allotedSeat){
        aud.number=SeatInfo;
        aud.alloted=allotedSeat;

        audi.put(aud.audSeatNo,aud);
        bookedTicketList.add(aud.audSeatNo);
        System.out.println(".................Booked Successfully");
    }
    public void cancelTicket(int id){
        Audience aud=audi.get(id);
        audi.remove(Integer.valueOf(id));

        bookedTicketList.remove(Integer.valueOf(id));
        System.out.println("............Ticket is cancelled successfully");
    }
    public void printAllSeatsinfo(){
        if(audi.size()==0){
            System.out.println("No seats are booked..");
            return;
        }
        for(Audience aud : audi.values()){
            System.out.println("........................");
            System.out.print(aud.id + ". ");
            System.out.println(" Name : "+ aud.name);
            System.out.println("\tAge : " + aud.age);
            System.out.println("\tSeat preference : " + aud.number + aud.alloted);
            System.out.println("........................");
        }
    }

    public void printAvailableSeats(){
        System.out.println(".........................");
        System.out.println("Available Elite seats : "+ availableElite);
        System.out.println("Available Premium seats : "+ availablePremium);
        System.out.println("Available Normal seats : "+ availableNormal);
        System.out.println("Total seats available : "+ totalSeats);
        System.out.println(".........................");
    }
}

