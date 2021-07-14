package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;

public class HiringStrategyOfDegree implements HiringStrategy {

  private DegreeField degreeField;

  public HiringStrategyOfDegree() {
    this(DegreeField.ENGINEERING);
  }

  public HiringStrategyOfDegree(DegreeField degreeField) {
    this.degreeField = degreeField;
  }

  @Override
  public boolean hire(Candidate candidate) {
    return candidate.getDegrees().stream().anyMatch(d -> degreeField == d.getField()); // implementation
  }

}
