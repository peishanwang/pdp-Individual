package edu.neu.ccs.cs5010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParserTest {
  private CSVParser csvp;

  @Before
  public void before() {
    List<String> input = new ArrayList<>();
    input.add("\"haha1\", \"haha2\", \"haha3\"");
    input.add("\"haha4\", \"haha5\", \"haha6\"");
    csvp = new CSVParser(input);
  }

  @Test
  public void testGetInfo() {
    List<List<String>> output = new ArrayList<>();
    List<String> temp1 = new ArrayList<>(), temp2 = new ArrayList<>();
    temp1.addAll(Arrays.asList("haha1", "haha2", "haha3"));
    temp2.addAll(Arrays.asList("haha4", "haha5", "haha6"));
    output.add(temp1);
    output.add(temp2);
    Assert.assertEquals(output, csvp.getCSVInfo());
  }


}
