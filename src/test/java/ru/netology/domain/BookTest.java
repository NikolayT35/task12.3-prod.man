package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void shouldFindBookByName() {
        Book book = new Book(2,"Green", 200, "Smart");
        boolean expected = true;
        boolean actual = book.matches("Green");
        assertEquals(expected, actual);
    }

    @Test
    public void  shouldFindBookByAuthor() {
        Book book = new Book(3,"Red", 300, "Shy");
        boolean expected = true;
        boolean actual = book.matches("Shy");
        assertEquals(expected, actual);
    }

    @Test
    public void      shouldNotFindBook() {
        Book book = new Book(4,"Black", 400, "Smart");
        boolean expected = false;
        boolean actual = book.matches("Strong");
        assertEquals(expected, actual);
    }
}