package ru.netology.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class IncomeServiceTest {

    @Test
    void shouldCalculateExample1() {
        IncomeService service = new IncomeService();

        // подготавливаем данные:
        int income = 10000;
        int expenses = 3000;
        int threshold = 20000;
        int expected = 3;

        // вызываем целевой метод:
        long actual = service.calculate(income, expenses, threshold);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateExample12() {
        IncomeService service = new IncomeService();

        // подготавливаем данные:
        int income = 100000;
        int expenses = 60000;
        int threshold = 150000;
        int expected = 2;

        // вызываем целевой метод:
        long actual = service.calculate(income, expenses, threshold);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/test.csv")
    void shouldCalculateCSV(int income, int expenses, int threshold, int expected) {
        IncomeService service = new IncomeService();

        long actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals(expected, actual);
    }
}
