package sppcw;

import org.junit.jupiter.api.Test;
import sppcw.Income;
import sppcw.TaxReturn;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeductionsAppliedTest {

    @Test
    void testDeductionsApplied() {
        // Arrange
        Income income = new Income(50000, 2000); // Work income: £50,000, Savings income: £2,000
        Deductions deductions = new Deductions();
        deductions.addDeduction("Pension", 2000); // Deduction: Pension £2,000
        deductions.addDeduction("Charity Donation", 500); // Deduction: Charity Donation £500

        TaxReturn taxReturn = new TaxReturn(income, deductions);

        // Act
        double actualTax = taxReturn.calculateTax();

        // Assert
        double expectedTax = 7400; // Expected tax: £7,400
        assertEquals(expectedTax, actualTax, "Deductions applied calculation failed");
    }
}

