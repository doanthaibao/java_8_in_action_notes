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

        //4.Return a string of all traders’ names sorted alphabetically.

        transactions.stream().map(t -> t.getTrader().getName()).sorted(Comparator.comparing(String::toString)).forEach(System.out::println);

        //5.Are any traders based in Milan?
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Milan"))
                .map(t -> t.getTrader())
                .findAny().ifPresent((x) -> System.out.println(x));
        //6. Print all transactions’ values from the traders living in Cambridge.
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).forEach(System.out::println);

        //7. What’s the highest value of all the transactions?
        transactions.stream().map(t -> t.getValue()).max(Comparator.comparing(Integer::intValue)).ifPresent((x) -> System.out.println(x));

        //8. Find the transaction with the smallest value.
        transactions.stream().map(t -> t.getValue()).min(Comparator.comparing(Integer::intValue)).ifPresent((x) -> System.out.println(x));


    }

}
