package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;

public class HiringStrategyOfGrade implements HiringStrategy {

  private int threshold;

  public HiringStrategyOfGrade() {
    this(8);
  }

  public HiringStrategyOfGrade(int threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean hire(Candidate candidate) {
    return candidate.getDegrees().stream()
        .anyMatch(d -> threshold <= d.getGrade()); // implementation
  }

}
