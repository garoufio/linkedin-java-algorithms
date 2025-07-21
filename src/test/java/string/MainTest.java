package string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MainTest {
  
  public final String str1 = "UPPERCASE";
  public final String str2 = "lowercase";
  public final String str3 = "MixeD";
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("String contains only uppercase letters")
  public void testIsUppercase() {
    assertAll(
        () -> assertTrue(Main.isUppercase(str1)),
        () -> assertFalse(Main.isUppercase(str2)),
        () -> assertFalse(Main.isUppercase(str3))
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("String contains only lowercase letters")
  public void testIsLowercase() {
    assertAll(
        () -> assertTrue(Main.isLowercase(str2)),
        () -> assertFalse(Main.isLowercase(str1)),
        () -> assertFalse(Main.isLowercase(str3))
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Is a complex password")
  public void testIsComplexPasswordWithSuccess() {
    String password = "P@ssword123!@#";
    assertTrue(Main.isPasswordComplex(password));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Is not a complex password - fail in digits")
  public void testIsComplexPasswordFailInDigits() {
    String password = "P@sswordPassPass";
    assertFalse(Main.isPasswordComplex(password));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Is not a complex password - fail in uppercase  letters")
  public void testIsComplexPasswordFailInUppercaseLetters() {
    String password = "p@ssword12345678";
    assertFalse(Main.isPasswordComplex(password));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Is not a complex password - fail in lowercase letters")
  public void testIsComplexPasswordFailInLowercaseLetters() {
    String password = "P@SSWORD12345678";
    assertFalse(Main.isPasswordComplex(password));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void testIsComplexPasswordFailInLength() {
    String password = "Pass123";
    assertFalse(Main.isPasswordComplex(password));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Normalized string")
  public void testNormalizeString() {
    String str = "    Hello, World    ";
    String normalized = Main.normalizeString(str);
    System.out.println(normalized);
    assertTrue(normalized.equals("hello world"));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Reverse string successfully")
  public void testReverseStringWithSuccess() {
    String str = "Hello World";
    String reversed = Main.reverseString(str);
    assertTrue(reversed.equals("dlroW olleH"));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
