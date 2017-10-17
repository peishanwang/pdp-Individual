package edu.neu.ccs.cs5010;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * EvaluatorContainer contains several Evaluators. It contains all the information
 * which can be provided to the template.
 */
public class EvaluatorContainer implements IEvaluatorContainer{
  Deque<Evaluator> evaluators;

  /**
   * Constructor of EvaluatorContainer.
   */
  public EvaluatorContainer() {
    evaluators = new ArrayDeque<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void push(Evaluator eva) {
    evaluators.push(eva);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void pop() {
    evaluators.pop();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getValue(String placeholder) {
    Iterator<Evaluator> ite = evaluators.iterator();
    String replacement = "";
    int countExceptions = 0;
    while (ite.hasNext()) {
      try {
        replacement = ite.next().getValue(placeholder);
      } catch (PlaceholderInfoNotFoundException e) {
        countExceptions++;
      }
    }
    int size = evaluators.size();
    if (countExceptions == size - 1) {
      return replacement;
    } else if (countExceptions == size) {
      throw new PlaceholderInfoNotFoundException("Can not find placeholder [[" +
          placeholder + "]]'s information");
    } else {
      throw new PlaceholderInfoNotFoundException("More than one value for one placeholder: " +
          placeholder);
    }
  }

}
