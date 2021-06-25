package string_calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalTest {

  Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void _빈문자열() {
    assertThat(calculator.input("       ")).isEqualTo(0);
    assertThat(calculator.input(null)).isEqualTo(0);
  }

  @Test
  void _숫자하나() {
    assertThat(calculator.input("2")).isEqualTo(2);
  }

  @Test
  void _콤마_하나() {
    assertThat(calculator.input("1,2")).isEqualTo(3);
  }

  @Test
  void _콤마_두개() {
    assertThat(calculator.input("1,2,3")).isEqualTo(6);
  }

  @Test
  void _클론() {
    assertThat(calculator.input("1,2:3")).isEqualTo(6);
  }

  @Test
  void _커스텀() {
    assertThat(calculator.input("//;\n1;2;3")).isEqualTo(6);
  }

  @Test
  void _음수() {
    assertThatThrownBy(() -> calculator.input("-1,2,3"))
        .isInstanceOf(RuntimeException.class);
  }
}
