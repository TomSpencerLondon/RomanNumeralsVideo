package com.codurance;

import java.util.Map;

public class RomanNumeral {

  public String convert(int input) {
    StringBuilder result = new StringBuilder();

    for (Roman roman : Roman.values()) {
      while (input >= roman.decimal){
        result.append(roman.toString());
        input -= roman.decimal;
      }
    }

    return result.toString();
  }

  public int toDecimal(String input) {
    Map<Character, Integer> numerals = Map.of(
        'X', 10,
        'V', 5,
        'I', 1
    );

    int result = numerals.get(input.charAt(input.length() - 1));

    for (int i = input.length() - 2; i >= 0; i--){
      if (numerals.get(input.charAt(i)) < numerals.get(input.charAt(i + 1))){
        result -= numerals.get(input.charAt(i));
      }else {
        result += numerals.get(input.charAt(i));
      }
    }

    return result;
  }

  enum Roman {
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private final int decimal;

    Roman(int decimal) {
      this.decimal = decimal;
    }
  }
}
