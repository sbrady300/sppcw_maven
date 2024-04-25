package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoSavingsIncomeTest {

    @Test
    void testNoSavingsIncome() {
        // Arrange
        Income income = new Income(60000, 0); // Work income: £60,000, Savings income: £0
        Deductions deductions = new Deductions(); // No deductions

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 9600; // Expected tax: £9,600
        assertEquals(expectedTax, actualTax, "No savings income calculation failed");
    }
}

