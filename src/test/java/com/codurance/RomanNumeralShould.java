package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumeralShould {

  private RomanNumeral romanNumeral;

  @BeforeEach
  void setUp() {
    romanNumeral = new RomanNumeral();
  }

  @ParameterizedTest
  @CsvSource({
      "1, I",
      "2, II",
      "3, III",
      "4, IV",
      "5, V",
      "9, IX",
      "10, X"
  })
  void return_roman_for_decimal(int input, String output) {

    assertEquals(output, romanNumeral.convert(input));

  }


  @ParameterizedTest
  @CsvSource({
      "I, 1",
      "II, 2",
      "III, 3",
      "IV, 4",
      "V, 5",
      "IX, 9",
      "X, 10"
  })
  void return_roman_for_decimal(String input, int output) {

    assertEquals(output, romanNumeral.toDecimal(input));

  }
}
