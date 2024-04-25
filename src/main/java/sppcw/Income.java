package sppcw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sppcw.Rate;

@Getter
@Setter
@AllArgsConstructor
public class Income {

    private double workIncome;
    private double savingsIncome;
    private Rate taxBand;

    private static final double BASIC_RATE_LIMIT = 50000;

    private static final double HIGHER_RATE_LIMIT = 150000;

    public double getWorkIncome() {
        return workIncome;
    }

    public double getSavingsIncome() {
        return savingsIncome;
    }

    public Income(double workIncome, double savingsIncome) {
        this.workIncome = workIncome;
        this.savingsIncome = savingsIncome; // Use 'this' keyword to refer to the class field
    }


    public Rate taxBand(){
        if((workIncome + savingsIncome) <= BASIC_RATE_LIMIT)
            return Rate.BASIC;
        else if((workIncome + savingsIncome)<= HIGHER_RATE_LIMIT)
            return Rate.HIGHER;
        else
            return Rate.ADDITIONAL;
    }


}
