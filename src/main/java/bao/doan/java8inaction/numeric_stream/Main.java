package bao.doan.java8inaction.numeric_stream;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    @Data
    @Builder
    static class Person {
        String name;
        Integer age;
    }
    public static void main(String[] args) {

        //1. from int to IntStream to avoid boxing
        System.out.println(Arrays.asList(Person.builder().age(10).name("bao").build(),
                Person.builder().age(11).name("chinh").build())
                .stream().mapToInt(Person::getAge).sum());
        IntStream intStream =Arrays.asList(Person.builder().age(10).name("bao").build(),
                Person.builder().age(11).name("chinh").build()).stream().mapToInt(Person::getAge);
        Stream<Integer> integerStream = intStream.boxed();
    }
}
