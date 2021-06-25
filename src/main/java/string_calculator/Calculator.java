package string_calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  public int input(String str) {
    if (str == null || str.trim().isEmpty()) {
      return 0;
    }
    String[] tokens = splitToken(str);
    exception(tokens);
    return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
  }


  private void exception(String[] tokens) {
    if (Arrays.stream(tokens).anyMatch(i -> Integer.parseInt(i) < 0)) {
      throw new RuntimeException();
    }
  }

  private String[] splitToken(String str) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }
    return str.split("[,:]");
  }

}
