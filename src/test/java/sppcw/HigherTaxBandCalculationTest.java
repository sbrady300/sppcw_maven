package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HigherTaxBandCalculationTest {

    @Test
    void testHigherTaxBandCalculation() {
        // Arrange
        Income income = new Income(75000, 10000); // Work income: £75,000, Savings income: £10,000
        Deductions deductions = new Deductions(); // No deductions

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 19000; // Expected tax: £19,000
        assertEquals(expectedTax, actualTax, "Higher tax band calculation failed");
    }
}

