package queue_stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
  
  public static void main(String[] args) {
    int[][] result = nextGreaterElement(new int[]{ 16, 7, 2, 15 });
    System.out.println(Arrays.deepToString(result));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** checks whether a string is a double number or not */
  private static boolean isNumber(String token) {
    try {
      Double.parseDouble(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** checks whether the string is an arithmetic operator or not */
  private static boolean isOperator(String token) {
    return "+-*/".contains(token);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private static double performOperation(String operator, double operand1, double operand2) {
    return switch (operator) {
      case "+" -> operand1 + operand2;
      case "-" -> operand1 - operand2;
      case "*" -> operand1 * operand2;
      case "/" -> {
        if (operand2 == 0) {
          throw new ArithmeticException("Cannot divide by zero");
        }
        else {
         yield operand1 / operand2;
        }
      }
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Evaluate reverse Polish notation (RPN) */
  public static double evaluateRPN(String expression) {
    if (expression == null || expression.length() == 0) {
      System.out.println("Invalid expression");
      return 0;
    }
    
    String[] tokens = expression.split(" ");
    Stack<Double>  stack = new Stack<>();
    for  (String token : tokens) {
      if (isNumber(token)) {
        stack.push(Double.parseDouble(token));
      }
      else if (isOperator(token)) {
        if (!stack.isEmpty()) {
          // LIFO
          double op2 = stack.pop();
          if (stack.isEmpty()) {
            System.out.println("Invalid number of operands: " + expression);
            return 0;
          }
          double op1 = stack.pop();
          stack.push(performOperation(token, op1, op2));
        }
      }
    }
    return stack.isEmpty() ? 0 : stack.pop();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[] generateBinaryNumbers(int number) {
    if (number <= 0) {
      return null;
    }
    
    int[] binaryNumbers = new int[number];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    for (int i = 0; i < number; i++) {
      binaryNumbers[i] = queue.remove();
      
      queue.add(binaryNumbers[i] * 10);
      queue.add(binaryNumbers[i] * 10 + 1);
    }
    return binaryNumbers;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static boolean hasMatchingParenthesis(String expression) {
    if (expression == null || expression.length() == 0) return false;
    
    if (!(expression.contains("(") && expression.contains(")"))) return false;
    
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      
      if (c == '(') {
        stack.push(c);
      }
      else if (c == ')') {
        if (!stack.isEmpty()) stack.pop();
        else return false;
      }
    }
    return stack.isEmpty();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static int[][] nextGreaterElement(int[] numbers) {
    if (numbers == null || numbers.length == 0) return null;
    
    Stack<Integer> stack = new Stack<>();
    int[][] result = new int[numbers.length][2];
    
    int row = 0;
    stack.push(numbers[0]);
    for (int i = 1; i < numbers.length; i++) {
      int next = numbers[i];
      if (!stack.isEmpty()) {
        int popped = stack.pop();
        while (popped < next) {
          result[row][0] = popped;
          result[row][1] = next;
          row++;
          if (stack.isEmpty()) {
            break;
          }
          popped = stack.pop();
        }
        
        if (popped > next) {
          stack.push(popped);
        }
      }
      stack.push(next);
    }
    
    while (!stack.isEmpty()) {
      //System.out.println(stack.pop() + " --> " + -1);
      result[row][0] = stack.pop();
      result[row][1] = -1;
      row++;
    }
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
