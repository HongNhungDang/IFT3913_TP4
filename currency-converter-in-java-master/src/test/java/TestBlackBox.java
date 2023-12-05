package test.java;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlackBox {
    static ArrayList<Currency> currencies;

    @BeforeAll
    static void initAll() {
        currencies = Currency.init();
    }

    public static Stream<Arguments> testMainWindow() {
        List<String> c1 = Arrays.asList("USD", "JPY");
        List<String> c2 = Arrays.asList("USD", "JPY");
        double[] amount = {-50, -0.01, 0, 5000, 1000000, 1000000.01,  1000500};

        List<Arguments> product = new ArrayList<>();

        for (String i : c1) {
            for (String j : c2) {
                for (double k : amount) {
                    List<Object> tuple = Arrays.asList(i, j, k);
                    product.add(Arguments.of(tuple));
                }
            }
        }
        return product.stream();
    }

    @ParameterizedTest
    @MethodSource
    void testMainWindow(List<Object> parameters) {
        assertDoesNotThrow(() -> MainWindow.convert((String) parameters.get(0),
                (String) parameters.get(1), currencies, (Double) parameters.get(2)));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-50, -0.01, 0, 5000, 1000000, 1000000.01,  1000500})
    void testConvert(double amount) {
        assertEquals(currencyConverter.Currency.convert(amount, 1.5),
                Math.round(amount * 150)/100d);
    }

    @AfterAll
    static void end() {
        System.out.println("Finished");
    }

}
