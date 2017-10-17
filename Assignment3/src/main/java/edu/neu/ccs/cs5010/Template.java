package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Template is a class contains template text which can be modified.
 * It contains toEmail method to modify template using replacement
 * information.
 */
public class Template implements ITemplate{
  private static final String ENCODING = "UTF-8";
  private List<String> text;

  /**
   * Constructor of Template.
   * @param path template file path.
   */
  public Template(String path) {
    IOUtil ioUtil = new IOUtil(path, ENCODING);
    text = ioUtil.getInput();
  }

  /**
   * {@inheritDoc}
   */
  public List<String> toEmail(Evaluator evaluator) {
    List<String> result = new ArrayList<>();
    final Pattern pattern = Pattern.compile("\\[\\[(.*?)]]", Pattern.DOTALL);
    for (int i = 0; i < text.size(); i++) {
      StringBuffer sb = new StringBuffer();
      Matcher matcher = pattern.matcher(text.get(i));
      while (matcher.find()) {
        String placeholder = matcher.group(1);
        String replacement = evaluator.getValue(placeholder);
        matcher.appendReplacement(sb, replacement);
      }
      matcher.appendTail(sb);
      result.add(sb.toString());
    }
    return result;
  }
}
