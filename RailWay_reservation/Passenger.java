package RailWay_reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    String name;
    int age;
    String train;
    String berth;
    String allotment;

    public Passenger(String name, int age, String train, String berth) {
        this.name = name;
        this.age = age;
        this.train = train;
        this.berth = berth;
        this.allotment = "";
    }
}

class Coach {
    int sleeper;
    int AC;

    public Coach() {
        this.sleeper = 40;
        this.AC = 30;
    }
}

class Train {
    int id;
    Coach coach;
    int L;
    int M;
    int U;

    public Train(int id, Coach coach) {
        this.id = id;
        this.coach = coach;
        this.L = 1;
        this.M = 2;
        this.U = 3;
    }

    public void bookTicket(Passenger p) {
       // p.id = this.id;
        if (p.berth.equals("L") && this.L < this.coach.sleeper) {
            System.out.println("Preference is available");
            p.allotment = this.L + "-L";
            this.L += 3;
        } else if (p.berth.equals("U") && this.U < this.coach.sleeper) {
            System.out.println("Preference is available");
            p.allotment = this.U + "-U";
            this.U += 3;
        } else if (p.berth.equals("M") && this.M < this.coach.sleeper) {
            System.out.println("Preference is available");
            p.allotment = this.M + "-M";
            this.M += 3;
        } else {
            if (this.L < this.coach.sleeper) {
                p.allotment = this.L + "-L";
                this.L += 3;
            } else if (this.M < this.coach.sleeper) {
                p.allotment = this.M + "-M";
                this.M += 3;
            } else if (this.U < this.coach.sleeper) {
                p.allotment = this.U + "-U";
                this.U += 3;
            }
        }
        this.id += 1;
    }

    public void availability() {
        System.out.println("Sleeper: " + this.coach.sleeper);
        System.out.println("AC: " + this.coach.AC);
    }

    public void cancellation(int pid) {

//        for (Passenger p : booked) {
//            if (pid == p.id) {
//                String[] allot = p.allotment.split("-");
//                if (allot[allot.length - 1].equals("L")) {
//                    this.L -= 3;
//                } else if (allot[allot.length - 1].equals("M")) {
//                    this.M -= 3;
//                } else if (allot[allot.length - 1].equals("U")) {
//                    this.U -= 3;
//                }
//                booked.remove(p);
//                break;
//            }
//        }
    }
}

class Main {
    static List<Passenger> booked = new ArrayList<>();

    public static void display(List<Passenger> booked) {
        for (Passenger p : booked) {
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Berth: " + p.berth);
            System.out.println("Train Name: " + p.train);
            //System.out.println("Passenger Id: " + p.id);
            System.out.println("Allotment: " + p.allotment);
            System.out.println("_".repeat(31));
        }
    }

    public static void main(String[] args) {
        boolean loop = true;
        Coach E_C = new Coach();
        E_C.sleeper = 30;
        Train Express = new Train(201, E_C);
        Coach F_C = new Coach();
        F_C.sleeper = 20;
        Train Fast = new Train(101, F_C);
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("1.Book\n2.Available Ticket\n3.Booked List\n4.Cancel\n5.Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter your Name: ");
                String name = scanner.next();
                System.out.print("Enter your Age: ");
                int age = scanner.nextInt();
                System.out.print("Enter your train preference: ");
                String train = scanner.next();
                System.out.print("Enter your Berth_Preference: ");
                String berth = scanner.next();
                Passenger passenger = new Passenger(name, age, train, berth);
                if (train.contains("Express")) {
                    Express.bookTicket(passenger);
                    booked.add(passenger);
                    E_C.sleeper -= 1;
                } else if (train.contains("Fast")) {
                    Fast.bookTicket(passenger);
                    booked.add(passenger);
                    F_C.sleeper -= 1;
                }
            } else if (choice == 2) {
                System.out.println("Express Availability:");
                Express.availability();
                System.out.println("Fast Availability:");
                Fast.availability();
            } else if (choice == 3) {
                display(booked);
            } else if (choice == 4) {
                System.out.print("Enter Your Id: ");
                int user = scanner.nextInt();
                if (user > 100 && user < 200) {
                    Fast.cancellation(user);
                } else {
                    Express.cancellation(user);
                }
            } else if (choice == 5) {
                loop = false;
            }
        }
    }
}


