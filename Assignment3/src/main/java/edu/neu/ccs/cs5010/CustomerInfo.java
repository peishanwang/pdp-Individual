package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * CustomerInfo is used to store customers' information. It can iterate
 * through all the customers' information.
 */
public class CustomerInfo implements ICustomerInfo{
  private List<String> headers;
  private List<List<String>> data;
  private static final String ENCODING = "UTF-8";
  private Iterator<List<String>> iterator;
  private ICSVParser parser;
  private IOUtil ioUtil;

  /**
   * Constructor of CustomerInfo.
   * @param path path of file which contains customers' raw data.
   */
  public CustomerInfo(String path) {
    ioUtil = new IOUtil(path, ENCODING);
    parser = new CSVParser(ioUtil.getInput());
    List<List<String>> csvInfo = parser.getCSVInfo();
    headers = csvInfo.get(0);
    data = new ArrayList<>();
    for (int i = 1; i < csvInfo.size(); i++) {
      data.add(csvInfo.get(i));
    }
    iterator = data.iterator();
  }

  /**
   * {@inheritDoc}
   */
  public List<String> getHeaders() {
    return headers;
  }

  /**
   * {@inheritDoc}
   */
  public boolean hasNextCustomer() {
    return iterator.hasNext();
  }

  /**
   * {@inheritDoc}
   */
  public List<String> nextCustomer() {
    return iterator.next();
  }

}
