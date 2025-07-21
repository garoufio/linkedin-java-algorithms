package arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.OptionalInt;

import static org.junit.Assert.*;

public class MainTest {
  
  private final int[] intItems = { 1, 2, 3, 4, 5, 6 };
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item found in array using linear search")
  public void testLinearSearchFound() {
    assertTrue(Main.linearSearch(intItems, 4));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item not found in array using linear search")
  public void testLinearSearchNotFound() {
    assertFalse(Main.linearSearch(intItems, 8));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item found in array using linear search Java API")
  public void testLinearSearchFoundWithJavaStreams() {
    OptionalInt optionalInt = Main.linearSearchWithStreams(intItems, 4);
    assertTrue(optionalInt.isPresent());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item not found in array using linear search Java API")
  public void testLinearSearchNotFoundWithJavaStreams() {
    OptionalInt optionalInt = Main.linearSearchWithStreams(intItems, 8);
    assertFalse(optionalInt.isPresent());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item found in array using binary search")
  public void testBinarySearchFound() {
    assertTrue(Main.binarySearch(intItems, 4));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item not found in array using binary search")
  public void testBinarySearchNotFound() {
    assertFalse(Main.binarySearch(intItems, 8));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item found in array using Java API binary search")
  public void testJavaAPIBinarySearchFound() {
    assertTrue(Main.binarySearchJavaAPI(intItems, 4));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Item not found in array using Java API binary search")
  public void testJavaAPIBinarySearchNotFound() {
    assertFalse(Main.binarySearchJavaAPI(intItems, 8));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Reverse the contents of the array")
  public void testReverseArray() {
    int[] reversed =  Main.reverse(intItems);
    assertArrayEquals(reversed, new int[] { 6, 5, 4, 3, 2, 1 });
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Extract only even numbers from the arrays")
  public void testFilterArraysWithEvenNumbers() {
    int[] events = Main.findEvenNumbers(intItems, new int[]{10, 11, 12, 13, 14, 15, 16});
    assertArrayEquals(events, new int[]{2, 4, 6, 10, 12, 14, 16});
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Extract only even numbers from the arrays")
  public void testFilterArraysWithEvenNumbersWithStreams() {
    int[] events = Main.findEvenNumbers(intItems, new int[]{10, 11, 12, 13, 14, 15, 16});
    assertArrayEquals(events, new int[]{2, 4, 6, 10, 12, 14, 16});
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Rotate array by shifting to the left")
  public void testRotateArray() {
    int[] rotated = Main.rotate(intItems);
    assertArrayEquals(rotated, new int[]{ 2, 3, 4, 5, 6, 1 });
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
