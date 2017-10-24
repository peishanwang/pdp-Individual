package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * IIPutHandler is the interface of InputHandler. It can get useful information
 * from the input arguments.
 *
 * @see InputHandler
 */
public interface IInputHandler {
  /**
   * Returns the paths of csv file.
   * @return the paths of csv file.
   */
  List<String> getPaths();
}
