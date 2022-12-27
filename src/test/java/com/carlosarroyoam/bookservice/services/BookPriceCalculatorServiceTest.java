package com.carlosarroyoam.bookservice.services;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.carlosarroyoam.bookservice.entities.Book;

@ExtendWith(MockitoExtension.class)
class BookPriceCalculatorServiceTest {
    @InjectMocks
    BookPriceCalculatorService bookPriceCalculatorService;

    @Test
    @DisplayName("Tests the calculation of the price of a book")
    void calculatePrice() {
        // having
        Book book = new Book("Homo Deus", "Yuval Noah", 12.99d, LocalDate.of(2018, 12, 1), true);

        // then
        double price = bookPriceCalculatorService.calculatePrice(book);

        // expects
        double expectedPrice = book.getPrice() + 10;

        // assert
        Assertions.assertThat(price).isEqualTo(expectedPrice);
    }
}
