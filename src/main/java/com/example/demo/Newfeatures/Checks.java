package com.example.demo.Newfeatures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Checks {
    public static void main(String[] args) {
        List<Product> prods=new ArrayList<>();
        prods.add(new Product(1,"A",200,"desc"));
        prods.add(new Product(2,"B",100,"desc"));
        prods.add(new Product(3,"C",300,"desc"));

        List<Product> collect = prods.stream().sorted((o1, o2) -> Double.compare(o1.getPrice(),o2.getPrice())).collect(Collectors.toList());
        System.out.println("mini = "+collect.get(0).getName() + " max = "+collect.get(collect.size()-1).getName());

        OptionalDouble reduce = prods.stream().mapToDouble(element -> element.getPrice()).reduce((left, right) -> left + right);
        reduce.ifPresent(System.out::println);
        //(product, product2) -> { product.setPrice(product.getPrice()+product2.getPrice());return product;}).ifPresent(product -> System.out.println(product.getPrice()));

//        List<List<String>> listOfLists = Arrays.asList(
//                Arrays.asList("a", "b", "c"),
//                Arrays.asList("d", "e", "f"),
//                Arrays.asList("g", "h", "e", "i")
//        );
//
//        // Create a set to hold intermediate results
//        Set<String> intermediateResults = new HashSet<>();
//
//        // Stream pipeline demonstrating various intermediate operations
//        List<String> result = listOfLists.stream()
//                .flatMap(List::stream)               // Flatten the list of lists into a single stream
//                .filter(s -> s.length()==1)      // Filter elements starting with "S"
//                .map(String::toUpperCase)            // Transform each element to uppercase
//                .distinct()                          // Remove duplicate elements
//                .sorted()                            // Sort elements
//                .peek(s -> intermediateResults.add(s)) // Perform an action (add to set) on each element
//                .collect(Collectors.toList());       // Collect the final result into a list
//
//        // Print the intermediate results
//        Optional<String> firstName =result.stream().findFirst();
//        firstName.ifPresent(s -> System.out.println(s));
//        System.out.println("Intermediate Results:");
//        intermediateResults.forEach(System.out::println);
//
//        // Print the final result
//        System.out.println("Final Result:");
//        result.forEach(System.out::println);

    }
}
