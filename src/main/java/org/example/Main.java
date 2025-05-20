package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);

        festivalStatisticsThread.start();
        int participantsForFestival = rand.nextInt(500)+100;
        for(int i=0; i<participantsForFestival; i++) {
            TicketType ticketType = Arrays.asList(TicketType.values()).get(rand.nextInt(TicketType.values().length));
            FestivalAttendeThread festivalAttendeThread = new FestivalAttendeThread(ticketType, festivalGate);

            try{
                festivalAttendeThread.sleep(1000);
            } catch(InterruptedException e) {
                e.getMessage();
            }
            festivalAttendeThread.start();
        }
    }
}
