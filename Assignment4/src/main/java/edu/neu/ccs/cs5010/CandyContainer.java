package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CandyContainer contains a list of candies corresponding to input file information.
 */
public class CandyContainer implements ICandyContainer {
  List<List<String>> csvInfo;

  /**
   * Constructor of candy container.
   * @param path path of file containing candies' information
   * @param encoding encoding type
   */
  public CandyContainer(String path, String encoding) {
    CsvParser parser = new CsvParser(path, encoding);
    csvInfo = parser.getCsvInfo();
  }

  @Override
  public List<ICandy> getCandyList() {
    List<ICandy> result = new ArrayList<>();
    ICaseAdapter adapter = new CaseAdapter();
    ICandyGenerator generator = new CandyGenerator();
    for (int i = 0; i < csvInfo.size(); i++) {
      List<String> line = csvInfo.get(i);
      for (int j = 0; j < line.size(); j++) {
        String currCandy = adapter.adaptCase(line.get(j));
        if (!currCandy.contains("Size")) {
          currCandy = "Size".concat(currCandy);
        }
        Pattern pattern = Pattern.compile("(.*?)(\\s*)Size(\\s*)(.*)");
        Matcher matcher = pattern.matcher(currCandy);
        if (matcher.find()) {
          String size = matcher.group(1).trim();
          String type = matcher.group(4).replaceAll("\\s", "");
          result.add(generator.generateCandy(size, type));
        } else {
          throw new IllegalArgumentException("Can not match!");
        }
      }
    }
    return result;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof CandyContainer)) {
      return false;
    }
    CandyContainer other = (CandyContainer) object;
    return this.csvInfo.equals(other.csvInfo);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (List<String> list : csvInfo) {
      result = 31 * result + list.hashCode();
    }
    return result;
  }

}
