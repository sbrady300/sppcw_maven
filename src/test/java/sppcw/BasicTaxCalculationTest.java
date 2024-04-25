package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTaxCalculationTest {

    @Test
    void testBasicTaxCalculation() {
        // Arrange
        Income income = new Income(40000, 5000); // Work income: £40,000, Savings income: £5,000
        Deductions deductions = new Deductions(); // No deductions

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 6400; // Expected tax: £6,400
        assertEquals(expectedTax, actualTax, "Basic tax calculation failed");
    }
}
