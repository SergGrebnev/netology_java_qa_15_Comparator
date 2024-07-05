package ru.netology.ticket;

import java.util.Arrays;
import java.util.Comparator;

//менеджер, который умеет хранить и искать билеты
public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current Массив, в который мы хотим добавить элемент
     * @param ticket  Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    /**
     * Метод добавления билета в менеджер
     *
     * @param ticket Добавляемый билет
     */
    public void add(Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        return tickets;
    }

    /**
     * Метод поиска билетов по маршруту и сортировка по цене
     *
     * @param from Откуда вылетаем
     * @param to   Куда прилетаем
     * @return Массив из подходящих билетов
     */
    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result); //вызов метода сортировки
        return result;
    }

    /**
     * Метод поиска билетов по маршруту и сортировка компаратором переданным в параметре
     *
     * @param from       Откуда вылетаем
     * @param to         Куда прилетаем
     * @param comparator параметр для сортировки
     * @return Массив из подходящих билетов
     */
    public Ticket[] searchAndSortBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from)) { // совпадает аэропорт вылета
                if (ticket.getTo().equals(to)) { // совпадает аэропорт прилёта
                    result = addToArray(result, ticket); // добавляем его в массив ответа
                }
            }
        }
        Arrays.sort(result, comparator); //вызов метода сортировки
        return result;

    }

}
