package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TestWhiteBox {

    private MainWindow mainWindow;
    private ArrayList<Currency> currencies;

    @BeforeEach
    public void setUp() {
        mainWindow = new MainWindow();
        currencies = Currency.init();
    }

    @Test
    public void testConvertEuroToUSDollar() {//Test T35
        double expected = 2146.00;
        double result = MainWindow.convert("Euro", "US Dollar", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from Euro to US Dollar did not return the expected result");
    }

    @Test
    public void testConvertCanadianDollarToEuro() {//Test T36
        double expected = 0.0;
        double result = MainWindow.convert("Canadian Dollar", "Euro", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from Canadian Dollar to Euro did not return the expected result");
    }

    @Test
    public void testConvertBritishPoundToCanadianDollar() {//Test T37
        double expected = 0.0;
        double result = MainWindow.convert("British Pound", "Canadian Dollar", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from British Pound to Canadian Dollar did not return the expected result");
    }

    @Test
    public void testConvertUSDollarToEuro() {//Test T38
        double expected = 1860.00;
        double result = MainWindow.convert("US Dollar", "Euro", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from US Dollar to Euro did not return the expected result");
    }

    @Test
    public void testConvertUSDollarToSwissFranc() {//Test T39
        double expected = 2020.00;
        double result = MainWindow.convert("US Dollar", "Swiss Franc", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from US Dollar to Swiss Franc did not return the expected result");
    }

    @Test
    public void testConvertUSDollarToChineseYuanRenminbi() {//Test T40
        double expected = 12720.00;
        double result = MainWindow.convert("US Dollar", "Chinese Yuan Renminbi", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from US Dollar to Chinese Yuan Renminbi did not return the expected result");
    }
    @Test
    public void testConvertUSDollarToJapaneseYen() {//Test T41
        double expected = 247080.00;
        double result = MainWindow.convert("US Dollar", "Japanese Yen", currencies, 2000.0);
        assertEquals(expected, result, "Conversion from US Dollar to Japanese Yen did not return the expected result");
    }

    @AfterAll
    static void end() {
        System.out.println("Finished All TestWhiteBox");
    }
}