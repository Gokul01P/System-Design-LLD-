package Theater_Ticket_Booking;
public class Audience {
    static int id=1;
    String name;
    int age;
    String SeatPreference;
    int audSeatNo;
    String alloted;
    int number;
    public Audience(String name,int age,String SeatPreference){
        this.name=name;
        this.age=age;
        this.SeatPreference=SeatPreference;
        this.audSeatNo=id++;
        alloted="";
        number=-1;
    }
}
