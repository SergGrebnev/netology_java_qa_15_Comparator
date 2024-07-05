package ru.netology.ticket;

public interface Comparator<T> extends java.util.Comparator<T> {
    int compare(T t1, T t2);

}
