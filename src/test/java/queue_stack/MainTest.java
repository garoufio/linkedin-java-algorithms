package queue_stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
  
  @ParameterizedTest
  @DisplayName("Evaluates the RPN successfully for given input values")
  @ValueSource(strings = { "8 4 +", "25 13 -", "4 3 *", "24 2 /", "2 7 * 3 4 + - 25 5 / + ", "3 4 + 2 * 7 / 6 *" })
  public void testEvaluateRPNTrue(String input) {
    assertEquals(Main.evaluateRPN(input), 12, () -> "RPN evaluation failed");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @DisplayName("Evaluates the RPN unsuccessfully for given input values")
  @ValueSource(strings = { "4 4 4 +", "4 +", "5 2 -", "4 2 / 5 7 + *" })
  public void testEvaluateRPNFalse(String input) {
    assertNotEquals(Main.evaluateRPN(input), 12, () -> "RPN evaluation failed");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @DisplayName("Strings with matching parenthesis")
  @ValueSource(strings = { "(text)", "((text))", "(te(xt) word (letter))", "() (text(word))" })
  public void testHasMatchingParenthesisTrue(String input) {
    assertTrue(Main.hasMatchingParenthesis(input));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @ParameterizedTest
  @DisplayName("Strings without matching parenthesis")
  @ValueSource(strings = { "(text))", "text", "(text( words" })
  public void testHasMatchingParenthesisFalse(String input) {
    assertFalse(Main.hasMatchingParenthesis(input), "String " + input + " failed");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Generate 5 binary numbers")
  public void testGenerateBinaryNumbers() {
    int[] binaryNumbers = Main.generateBinaryNumbers(5);
    int[] expectedBinaryNumbers = { 1, 10, 11, 100, 101 };
    assertArrayEquals(expectedBinaryNumbers, binaryNumbers);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Get next greater element")
  public void testNextGreaterElement() {
    int[] expected = new int[] { 15, 15, -1, -1 };
    int[][] actual = Main.nextGreaterElement(new int[]{16, 7, 2, 15});
    
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i][1], () -> "next greater element failed");
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
