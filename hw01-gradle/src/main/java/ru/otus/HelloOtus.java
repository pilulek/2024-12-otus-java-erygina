package ru.otus;

import com.google.common.base.Joiner;

public class HelloOtus {
  public static void main(String[] args) {
    String[] fruits = {"apple", "banana", "cherry"};
    String result = Joiner.on(", ").join(fruits);
    System.out.println(result); // apple, banana, cherry
  }
}