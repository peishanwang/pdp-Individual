package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * Interface of MessagePairGenerator.
 *
 * @see MessagePairGenerator
 */
public interface IMessagePairGenerator {
  /**
   * Returns a list of all message pairs.
   * @return a list of all message pairs.
   */
  List<IMessagePair> getAllMessagePairs();
}
