package string;

public class Main {
  
  public static void main(String[] args) {
    
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Checks if a string contains only uppercase characters  */
  public static boolean isUppercase(String str) {
    return str.chars().allMatch(Character::isUpperCase);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Checks if a string contains only lowercase characters  */
  public static boolean isLowercase(String str) {
    return str.chars().allMatch(Character::isLowerCase);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Checks if a password contains at least an uppercase letter, a lowercase letter, a digit and has a minimum length
   * of 12 characters  */
  public static boolean isPasswordComplex(String password) {
    return password.length() >= 12 &&
        password.chars().anyMatch(Character::isDigit) &&
        password.chars().anyMatch(Character::isLetter) &&
        password.chars().anyMatch(Character::isLowerCase) &&
        password.chars().anyMatch(Character::isUpperCase);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String normalizeString(String str) {
    return str.trim().toLowerCase().replace(",", "");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static String reverseString(String str) {
    if (str == null || str.isEmpty()) return str;
    
//    StringBuilder sb = new StringBuilder();
//    for (int i = str.length() - 1; i >= 0; i--) {
//      sb.append(str.charAt(i));
//    }
//    return sb.toString();
    
    StringBuilder sb = new StringBuilder(str);
    return sb.reverse().toString();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
