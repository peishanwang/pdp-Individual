package edu.neu.ccs.cs5010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TxtToList is to convert text in txt file into String list
 */
public class TxtToList implements ITxtToList{
  private String path;
  private List<String> list;

  /**
   * Constructor of TxtToList
   * @param path String path of txt file to be converted
   */
  public TxtToList(String path) {
    this.path = path;
    list = new ArrayList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getList() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      String line;
      while ((line = br.readLine()) != null) {
        list.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
}
