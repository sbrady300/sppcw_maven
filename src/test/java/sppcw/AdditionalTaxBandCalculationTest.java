package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalTaxBandCalculationTest {

    @Test
    void testAdditionalTaxBandCalculation() {
        // Arrange
        Income income = new Income(160000, 20000); // Work income: £160,000, Savings income: £20,000
        Deductions deductions = new Deductions(); // No deductions

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 58100; // Expected tax: £58,100
        assertEquals(expectedTax, actualTax, "Additional tax band calculation failed");
    }
}

