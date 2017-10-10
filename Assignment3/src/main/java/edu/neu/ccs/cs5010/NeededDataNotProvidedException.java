package edu.neu.ccs.cs5010;

public class NeededDataNotProvidedException extends RuntimeException{
  public NeededDataNotProvidedException() {
    super();
  }
  public NeededDataNotProvidedException(String s) {
    super(s);
    System.out.println("Usage:\n" +
        "--csv-file need to contains at least following four parts:\n" +
        "first_name\n" + "last_name\n" + "rewards\n" + "email\n");
  }
}
