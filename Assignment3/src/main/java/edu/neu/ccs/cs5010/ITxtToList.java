package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ITxtToList is to convert text in txt file into String list
 */
public interface ITxtToList {
  /**
   * Returns the String list contains the text in txt file.
   * @return String list contains the text in txt file.
   */
  List<String> getList();
}
