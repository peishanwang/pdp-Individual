package edu.neu.ccs.cs5010;

import java.util.HashMap;
import java.util.List;

/**
 * KeyValueEvaluator is a kind of Evaluator storing information using
 * key-value pairs.
 */
public class KeyValueEvaluator implements Evaluator{
  HashMap<String, String> map;

  /**
   * Constructor of KeyValueEvaluator with String pair.
   * @param key String key of the pair
   * @param value String value of the pair
   */
  public KeyValueEvaluator(String key, String value) {
    map = new HashMap<>();
    map.put(key, value);
  }

  /**
   * Constructor of KeyValueEvaluator with String list pair.
   * @param keys String list key of the pair
   * @param values String list value of the pair
   */
  public KeyValueEvaluator(List<String> keys, List<String> values) {
    map = new HashMap<>();
    if (keys.size() != values.size()) {
      throw new IllegalArgumentException("Number of keys must be the same as number of values");
    } else {
      for (int i = 0; i < keys.size(); i++) {
        map.put(keys.get(i), values.get(i));
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getValue(String placeholder) {
    if (map.containsKey(placeholder)) {
      return map.get(placeholder);
    } else {
      throw new PlaceholderInfoNotFoundException("Can not find placeholder [[" + placeholder
          + "]]'s information");
    }
  }

}
