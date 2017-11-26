package com.example;
import java.util.stream.Stream;

/**
 *  main()方法
 * @author seon
 *2017年11月24日16:14:40
 */
public class Fib {
  public static void main(String[] args) {
    Stream<Long> longStream = Stream.generate(new FibonacciSupplier());
    System.out.println("Fib.main(台阶问题：)");
    longStream.limit(10).forEach(System.out::println);
  }
}
