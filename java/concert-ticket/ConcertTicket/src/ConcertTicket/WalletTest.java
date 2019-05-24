package ConcertTicket;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class WalletTest {

    @Test
    public void add() {
        ConcertTicket ticket = new ConcertTicket("Flip and the Boogies",new Date(),99.00);
        Wallet myWallet = new Wallet();
        ConcertTicket concertTicket = myWallet.add(ticket);
        assertEquals(myWallet.tickets[myWallet.getSize() - 1], ticket);
        assertEquals(myWallet.tickets[myWallet.getSize() - 1], concertTicket);
        assertEquals(ticket,concertTicket);
    }

    @Test
    public void resize() {
    }

    @Test
    public void getSize() {
    }
}