package bao.doan.java8inaction.chapter6;

import bao.doan.java8inaction.model.Trader;
import bao.doan.java8inaction.model.Transaction;
import lombok.var;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Chapter 6 : collecting data with stream
 */
public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
        Map<Integer, List<Transaction>> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
        var map2 = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear, Collectors.summingInt(Transaction::getValue)));
        System.out.println(map2);
    }
}
