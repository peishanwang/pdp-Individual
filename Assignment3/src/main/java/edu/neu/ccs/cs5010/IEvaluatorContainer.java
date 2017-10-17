package edu.neu.ccs.cs5010;

/**
 * IEvaluator extends interface Evaluator. It contains methods push() and pop()
 * to handle Evaluators in the container.
 *
 */
public interface IEvaluatorContainer extends Evaluator {
  /**
   * Push an evaluator into the Evaluator Container.
   * @param evaluator evaluator to be pushed to the Evaluator Container.
   */
  void push(Evaluator evaluator);

  /**
   * Pop the evaluator last pushed into the Evaluator Container out from it.
   */
  void pop();
}
