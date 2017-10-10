package edu.neu.ccs.cs5010;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TemplateModifier is to replace the placeholders in a template with replacement
 * information.
 */
public class TemplateModifier implements ITemplateModifier{
  private List<String> template;

  /**
   * Constructor of TemplateModifier
   * @param template a template containing placeholders to be replaced
   */
  public TemplateModifier(List<String> template) {
    this.template = template;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> modifyTemplate (HashMap<String, String> replaceInformation) {
    List<String> result = new ArrayList<>();
    final Pattern pattern = Pattern.compile("\\[\\[(.*?)]]", Pattern.DOTALL);
    for (int i = 0; i < template.size(); i++) {
      StringBuffer sb = new StringBuffer();
      Matcher matcher = pattern.matcher(template.get(i));
      while (matcher.find()) {
        String key = matcher.group(1);
        String replacement = replaceInformation.get(key);
        if(replacement == null){
          throw new IllegalArgumentException(
              "Template contains unmapped key: "
                  + key);
        }
        matcher.appendReplacement(sb, replacement);
      }
      matcher.appendTail(sb);
      result.add(sb.toString());
    }
    return result;
  }
}
