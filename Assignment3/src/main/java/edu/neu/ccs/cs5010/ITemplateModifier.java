package edu.neu.ccs.cs5010;

import java.util.HashMap;
import java.util.List;

/**
 * ITemplateModifier is to replace the placeholders in a template with replacement
 * information.
 */
public interface ITemplateModifier {
  /**
   * @param replaceInformation the information which is to replace placeholder
   * @return a list of String which store the Email after modification.
   */
  List<String> modifyTemplate(HashMap<String, String> replaceInformation);
}
