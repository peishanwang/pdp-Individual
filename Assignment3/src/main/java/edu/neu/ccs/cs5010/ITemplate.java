package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * ITemplate is the interface of Template. It can generate new Email using
 * template and evaluator which can replace placeholder in template.
 *
 * @see Template
 */
public interface ITemplate {
  /**
   * Replace the placeholders in template using evaluator to generate new email.
   * @param evaluator used to replace the placeholder
   * @return new Email text
   */
  List<String> toEmail(Evaluator evaluator);
}
