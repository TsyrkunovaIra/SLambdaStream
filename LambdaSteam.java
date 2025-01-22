package com.home.project.homeWork2;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaSteam {
    @FunctionalInterface
    public interface Converted<T, N>{
        N convert(T t);
        static <T> boolean inNotNull(T t){
            return t != null;
        }
        default void writeToConsole(T t){
            System.out.println("Текущий объект - " + t.toString());
        }
        boolean equals(Object obj);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("bob", 5, 3);
        Converted<Dog, Reccon> converted = x -> new Reccon(x.name, x.age, x.weight);
        Reccon reccon = converted.convert(dog);
        System.out.println("Raccoon has parameters: name - " + reccon.name + reccon.age + reccon.weight);

        Predicate<Integer> isEvenNumber = x -> x % 2==0;
        System.out.println(isEvenNumber.test(4));
        System.out.println(isEvenNumber.test(3));

        Consumer<String> greetings = x -> System.out.println("hello" + x + "!!!");
        greetings.accept(" elena");

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("jfh");
        nameList.add("jdfgdfg");
        nameList.add("dfdb");
        nameList.add("dfv");
        nameList.add("bffd");

        Supplier<String> randomName = () -> {
            int value = (int)(Math.random() * nameList.size());
            return nameList.get(value);
        };
        System.out.println(randomName.get());

        Function<String, Integer> valueConverter = x -> Integer.valueOf(x);
        System.out.println(valueConverter.apply("678"));

        UnaryOperator<Integer> squareValue = x -> x * x;
        System.out.println(squareValue.apply(9));

        List<Integer> evenNumers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(x -> x % 2 ==0)
                .collect(Collectors.toList());
        System.out.println(evenNumers);

        List<String> peopleGreetings = Stream.of("Efdf", "dfgdffg", "sdvv")
                .peek(x -> System.out.println("hello " + x + "!!!"))
                .collect(Collectors.toList());
        System.out.println(peopleGreetings);

        Stream.generate(() ->{
            int value = (int) (Math.random() * nameList.size());
            return  nameList.get(value);

        }).limit(5).forEach(System.out::println);

        List<Integer> values = Stream.of("32", "43", "74", "54","3")
                .map(x -> Integer.valueOf(x)).collect(Collectors.toList());

        Stream.iterate(9, x -> x * x)
                .limit(4)
                .forEach(System.out::println);

        ArrayList<String> lks = new ArrayList<>();

        Collections.addAll(lks,"gfjbkjd", "knghknjt");




    }}