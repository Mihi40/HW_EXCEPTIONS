package ru.netology.qa;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("товара с id " + id + " не существует");
    }
}
