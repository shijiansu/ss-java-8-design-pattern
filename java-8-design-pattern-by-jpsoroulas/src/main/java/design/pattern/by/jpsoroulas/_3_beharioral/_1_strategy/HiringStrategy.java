package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;

@FunctionalInterface
public interface HiringStrategy {

  boolean hire(Candidate candidate);
}
