package edu.neu.ccs.cs5010;

public class Urgency implements Comparable<Urgency>, IUrgency {
  int level;

  public Urgency(int level) {
    this.level = level;
  }

  @Override
  public int compareTo(Urgency other) {
    if (other == null) {
      throw new NullPointerException();
    }
    return this.level - other.level;
  }

  @Override
  public boolean moreUrgentThan(Urgency other) {
    return this.compareTo(other) < 0;
  }

  @Override
  public boolean asUrgentAs(Urgency other) {
    return this.compareTo(other) == 0;
  }

  @Override
  public boolean lessUrgentThan(Urgency other) {
    return this.compareTo(other) > 0;
  }

  @Override
  public int getValue() {
    return level;
  }

}
