package edu.neu.ccs.cs5010;

/**
 * CaseAdapter is used to adapt string's case.
 */
public class CaseAdapter implements ICaseAdapter{

  @Override
  public String adaptCase(String str) {
    char[] chars = str.trim().toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (i == 0 || chars[i - 1] == ' ') {
        if (Character.isLowerCase(chars[i])) {
          chars[i] = Character.toUpperCase(chars[i]);
        }
      } else {
        if (Character.isUpperCase(chars[i])) {
          chars[i] = Character.toLowerCase(chars[i]);
        }
      }
    }
    return new String(chars);
  }
}
