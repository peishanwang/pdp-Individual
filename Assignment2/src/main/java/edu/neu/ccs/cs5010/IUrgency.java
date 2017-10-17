package edu.neu.ccs.cs5010;

public interface IUrgency {
  boolean moreUrgentThan(Urgency other);
  boolean asUrgentAs(Urgency other);
  boolean lessUrgentThan(Urgency other);
  int getValue();
}
