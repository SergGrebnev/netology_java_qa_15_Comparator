package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    private Ticket ticket1 = new Ticket("Новосибирск", "Москва", 36000, 1010, 1440);
    private Ticket ticket2 = new Ticket("Новосибирск", "Казань", 20000, 1235, 1610);
    private Ticket ticket3 = new Ticket("Новосибирск", "Барнаул", 6000, 1810, 1850);
    private Ticket ticket4 = new Ticket("Новосибирск", "Сочи", 28000, 1110, 1510);
    private Ticket ticket5 = new Ticket("Новосибирск", "Сочи", 36000, 1240, 1630);

    private AviaSouls tickets = new AviaSouls();
    private TicketTimeComparator comparator = new TicketTimeComparator();


    @BeforeEach
    public void setup() {
        tickets.add(ticket1);
        tickets.add(ticket4);
        tickets.add(ticket3);
        tickets.add(ticket5);
        tickets.add(ticket2);
        tickets.add(ticket4);
    }

    @Test //Найдено и отсортировано по цене более 1 билета
    public void searchTicketMore() {

        Ticket[] expected = {ticket4, ticket4, ticket5};
        Ticket[] actual = tickets.search("Новосибирск", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Найден 1 билет
    public void searchTicketOne() {

        Ticket[] expected = {ticket2};
        Ticket[] actual = tickets.search("Новосибирск", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Билеты не найдены
    public void searchTicketNone() {

        Ticket[] expected = {};
        Ticket[] actual = tickets.search("Новосибирск", "Томск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //цена билета меньше
    public void ticketPriceLess() {
        Assertions.assertEquals(-1, ticket2.compareTo(ticket1));
    }

    @Test //цена билета больше
    public void ticketPriceMore() {
        Assertions.assertEquals(1, ticket4.compareTo(ticket3));
    }

    @Test //цены билетов равны
    public void ticketPricesEqual() {
        Assertions.assertEquals(0, ticket1.compareTo(ticket5));
    }

    @Test //время полёта 1 меньше чем 2
    public void tickedTimeLess() {

        int expected = -1;
        int actual = comparator.compare(ticket3, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test //время полёта 1 больше чем 2
    public void tickedTimeMore() {

        int expected = 1;
        int actual = comparator.compare(ticket2, ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test //время полёта 1 равно 2
    public void tickedTimeEqual() {

        int expected = 0;
        int actual = comparator.compare(ticket2, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test //Найдено и отсортировано по времени полёта более 1 билета
    public void searchAndSortTicketMore() {

        Ticket[] expected = {ticket5, ticket4, ticket4};
        Ticket[] actual = tickets.searchAndSortBy("Новосибирск", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Найден и отсортирован по времени полёта 1 билет
    public void searchAndSortTicketOne() {

        Ticket[] expected = {ticket1};
        Ticket[] actual = tickets.searchAndSortBy("Новосибирск", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Не найден и отсортирован по времени полёта ни один билет
    public void searchAndSortTicketNone() {

        Ticket[] expected = {};
        Ticket[] actual = tickets.searchAndSortBy("Новосибирск", "Омск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
