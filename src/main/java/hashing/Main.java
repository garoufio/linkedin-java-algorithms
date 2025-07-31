package hashing;

import java.util.*;

public class Main {
  
  public static void main(String[] args) {
  
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static List<Integer> getMissingElements(int[] array1,  int[] array2) {
    List<Integer> missingElements = new ArrayList<>();
    
    if (array1 == null && array2 == null) {
      return missingElements;
    }
    else if (array1 == null) {
      Arrays.stream(array2).forEach(x -> missingElements.add(x));
      return missingElements;
    }
    else if (array2 == null) {
      Arrays.stream(array1).forEach(x -> missingElements.add(x));
      return missingElements;
    }
    
    Set<Integer> set = new HashSet<>();
    Arrays.stream(array2).forEach(x -> set.add(x));
    Arrays.stream(array1).forEach(x -> {
      if (!set.contains(x)) {
        missingElements.add(x);
      }
    });
    return missingElements;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static Map<Integer, Integer> getFreqOfEachElement(int[] array) {
    Map<Integer, Integer> map = new HashMap<>();
    
    if (array == null) return map;
    
    Arrays.stream(array).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    
    return map;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasCycle(ListNode head) {
    if (head == null) return false;
    
    ListNode next = head.getNext();
    if (next == null) return false;
    
    while (next != null) {
      if (next == head) return true;
      
      next = next.getNext();
    }
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasCycleWithSet(ListNode head) {
    if (head == null) return false;
    
    Set<ListNode> set = new HashSet<>();
    ListNode cur = head.getNext();
    while (cur != null) {
      if (!set.add(cur)) return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
