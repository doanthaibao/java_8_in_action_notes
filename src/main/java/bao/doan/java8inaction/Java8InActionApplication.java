package bao.doan.java8inaction;

import bao.doan.java8inaction.model.Trader;
import bao.doan.java8inaction.model.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class Java8InActionApplication {

    public static void main(String[] args) {
//		SpringApplication.run(Java8InActionApplication.class, args);

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        //1. Find all transactions in the year 2011 and sort them by value (small to high).

        transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        //reversed
        //thenCompare
//        transactions.stream().filter(t -> t.getYear() == 2011)
//                .sorted(Comparator.comparing(Transaction::getValue).reversed()).forEach(System.out::println);
        //2. What are all the unique cities where the traders work?
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        //3. Find all traders from Cambridge and sort them by name.

        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader())
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

    }

}
