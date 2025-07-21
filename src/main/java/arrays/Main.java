package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class Main {
  
  public static void main(String[] args) {
  
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean linearSearch(int[] items, int item) {
    if (items == null || items.length == 0) return false;
    
    for (int i : items) {
      if (i == item) return true;
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static OptionalInt linearSearchWithStreams(int[] items, int item) {
    if (items == null || items.length == 0) return OptionalInt.empty();
    
    return Arrays.stream(items).filter(i -> i == item).findFirst();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean binarySearch(int[] items, int item) {
    if (items == null || items.length == 0) return false;
    
    int low = 0;
    int high = items.length - 1;
    int mid;
    while (low <= high) {
      mid = (high + low) / 2;
      if (items[mid] == item) {
        return true;
      }
      else if (items[mid] < item) {
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return false;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean binarySearchJavaAPI(int[] items, int item) {
    if (items == null || items.length == 0) return false;
    
    return Arrays.binarySearch(items, item) >= 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static void addEvenToList(List<Integer> list, int[] items) {
    if (items == null || items.length == 0) return;
    
    for (int i : items) {
      if (i % 2 == 0) list.add(i);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findEvenNumbers(int[] items1, int[] items2) {
    if (items1 == null && items2 == null) return items1;
    if (items1.length == 0 || items2.length == 0) return items1;
   
    List<Integer> list = new ArrayList<>();
    addEvenToList(list, items1);
    addEvenToList(list, items2);
    
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] findEvenNumbersWithStreams(int[] items1, int[] items2) {
    if (items1 == null && items2 == null) return items1;
    if (items1.length == 0 || items2.length == 0) return items1;
    
    IntPredicate intPredicate = i -> i % 2 == 0;
    return Stream.of(items1, items2).flatMapToInt(Arrays::stream).filter(intPredicate).toArray();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] reverse(int[] items) {
    if (items == null || items.length == 0) return items;
    
    int[] ar = new int[items.length];
    
    for (int i = 0; i < items.length; i++) {
      ar[i] = items[items.length - i - 1];
    }
    return ar;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  // Return a new array with the input array's contents rotated to the left by one
  public static int[] rotate(int[] items) {
    if (items == null || items.length <= 1) return items;
    
    int first = items[0];
    int[] ar = new int[items.length];
    for (int i = 1; i < items.length; i++) {
      ar[i - 1] = items[i];
    }
    ar[items.length - 1] = first;
    
    return ar;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
