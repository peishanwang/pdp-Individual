package edu.neu.ccs.cs5010;

import java.util.List;

/**
 * Interface of ClientGenerator containing method to get all clients.
 *
 * @see ClientGenerator
 */
public interface IClientGenerator {
  /**
   * Returns all clients in a list.
   * @return all clients in a list.
   */
  List<IClient> getAllClients();
}
