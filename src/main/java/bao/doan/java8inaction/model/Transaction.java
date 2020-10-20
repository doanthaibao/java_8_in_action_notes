package bao.doan.java8inaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Transaction {

    private Trader trader;

    private int year;

    private int value;

    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}
