package edu.neu.ccs.cs5010;


import java.util.ArrayList;
import java.util.List;

/**
 * InputHandler is used to handle the input from command line.
 */
public class InputHandler implements IInputHandler{
  List<String> paths;
  /**
   * Constructor of InputHandler.
   * @param args input arguments
   */
  public InputHandler(String[] args) {
    paths = new ArrayList<>();
    handleArguments(args);
  }

  /**
   * Handle arguments.
   * @param args input arguments.
   */
  private void handleArguments(String[] args) {
    if (Integer.parseInt(args[0]) != args.length - 1) {
      throw new IllegalArgumentException("Number of files is not appointed one.");
    }
    for (int i = 1; i < args.length; i++) {
      paths.add(args[i]);
    }
  }

  @Override
  public List<String> getPaths() {
    return paths;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    if (!(object instanceof InputHandler)) {
      return false;
    }
    InputHandler other = (InputHandler) object;
    return this.paths.equals(other.paths);
  }

  @Override
  public int hashCode() {
    int result = 17;
    for (String path : paths) {
      result = 31 * result + path.hashCode();
    }
    return result;
  }
}
