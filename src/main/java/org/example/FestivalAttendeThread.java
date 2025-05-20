package org.example;

public class FestivalAttendeThread extends Thread {
    private TicketType ticketType;
    private int nrOfPersons;
    private FestivalGate gate;

    public FestivalAttendeThread(TicketType ticketType, FestivalGate gate){
            this.ticketType = ticketType;
            this.gate = gate;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(ticketType);
            gate.addTicket(ticketType);
        }
    }

    public int getNrOfPersons(){
        return nrOfPersons;
    }
}