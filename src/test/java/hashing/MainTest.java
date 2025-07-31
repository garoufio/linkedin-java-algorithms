package hashing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
  
  @Test
  @DisplayName("Test missing elements")
  public void testMissingElements() {
    int[] array1 = new int[] { 1, 2, 3, 4, 6 };
    int[] array2 = new int[] { 4, 2, 7 };
    List<Integer> expected = List.of(new Integer[] { 1, 3, 6 });
    List<Integer> actual = Main.getMissingElements(array1, array2);
    
    assertEquals(expected, actual);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test frequency of each element")
  public void testGetFreqOfEachElement() {
    int[] array1 = new int[] { 1, 2, 3, 4, 6, 6, 6, 1, 4, 4, 4, 4, 8, 5, 8, 1 };
    List<Integer> expected = List.of(new Integer[] { 3, 1, 1, 5, 1, 3, 2 });
    
    Map<Integer, Integer> map = Main.getFreqOfEachElement(array1);
    List<Integer> actual = new ArrayList<>(map.values());
    assertAll(
        () -> assertTrue(actual.size() == expected.size()),
        () -> assertEquals(expected, actual)
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test hasCycle using set with success")
  public void testHasCycleWithSet() {
    ListNode head = new ListNode(1);
    ListNode node1 = new ListNode(2);
    head.setNext(node1);
    ListNode node2 = new ListNode(3);
    node1.setNext(node2);
    
    assertTrue(Main.hasCycleWithSet(head));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
