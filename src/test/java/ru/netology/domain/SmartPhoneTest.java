package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    @Test
    public void shouldFindSmartPhoneByName() {
        SmartPhone smartPhone = new SmartPhone(5,"White", 2000, "Nokia");
        boolean expected = true;
        boolean actual = smartPhone.matches("White");
        assertEquals(expected, actual);
    }

    @Test
    public void  shouldFindSmartPhoneByProducer() {
        SmartPhone smartPhone = new SmartPhone(6,"Silver", 3000, "Samsung");
        boolean expected = true;
        boolean actual = smartPhone.matches("Samsung");
        assertEquals(expected, actual);
    }

    @Test
    public void      shouldNotFindSmartPhone() {
        SmartPhone smartPhone = new SmartPhone(7,"Gold", 400, "Honor");
        boolean expected = false;
        boolean actual = smartPhone.matches("Sony");
        assertEquals(expected, actual);
    }
}