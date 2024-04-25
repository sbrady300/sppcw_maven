package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDeductionsTest {

    @Test
    void testMaximumDeductions() {
        // Arrange
        Income income = new Income(100000, 10000); // Work income: £100,000, Savings income: £10,000
        Deductions deductions = new Deductions();
        deductions.addDeduction("Mortgage Interest", 7000); // Deduction: Mortgage Interest £7,000
        deductions.addDeduction("Medical Expenses", 5000); // Deduction: Medical Expenses £5,000

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 24200; // Expected tax: £24,200
        assertEquals(expectedTax, actualTax, "Maximum deductions calculation failed");
    }
}
