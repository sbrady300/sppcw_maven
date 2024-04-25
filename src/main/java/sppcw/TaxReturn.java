package sppcw;

import sppcw.Deductions;
import sppcw.Income;
import sppcw.Rate;


public class TaxReturn {
    private Income income;
    private Deductions deductions;

    private static final double PERSONAL_ALLOWANCE = 12000;

    private static final double BASIC_PERSONAL_SAVINGS_ALLOWANCE = 1000;
    private static final double HIGHER_PERSONAL_SAVINGS_ALLOWANCE = 500;

    private static final double BASIC_RATE_LIMIT = 50000;
    private static final double HIGHER_RATE_LIMIT = 150000;

    private static final double BASIC_RATE = 0.20;
    private static final double HIGHER_RATE = 0.40;
    private static final double ADDITIONAL_RATE = 0.45;

    public TaxReturn(Income income, Deductions deductions) {
        this.income = income;
        this.deductions = deductions;
    }

    public double calculateTaxableSavingsIncome() {
        double savingsIncome = income.getSavingsIncome();
        double personalSavingsAllowance;

        if (income.taxBand() == Rate.BASIC) {
            personalSavingsAllowance = BASIC_PERSONAL_SAVINGS_ALLOWANCE;
        } else if (income.taxBand() == Rate.HIGHER) {
            personalSavingsAllowance = HIGHER_PERSONAL_SAVINGS_ALLOWANCE;
        } else {
            return savingsIncome;
        }

        double taxableSavingsIncome = savingsIncome - personalSavingsAllowance;

        // Ensure taxable savings income is not negative
        if (taxableSavingsIncome < 0) {
            taxableSavingsIncome = 0;
        }

        return taxableSavingsIncome;
    }


    public double calculateTax() {
        double taxableIncome = income.getWorkIncome()
                + calculateTaxableSavingsIncome()
                - deductions.totalDeductions()
                - PERSONAL_ALLOWANCE;

        if (taxableIncome <= BASIC_RATE_LIMIT) {
            return taxableIncome * BASIC_RATE;
        } else if (taxableIncome <= HIGHER_RATE_LIMIT) {
            return (10000 + (taxableIncome - BASIC_RATE_LIMIT) * HIGHER_RATE);
        } else {
            return (50000 + (taxableIncome - 150000) * ADDITIONAL_RATE);
        }
    }


}

