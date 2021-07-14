package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;

public interface HiringStrategyAlgorithms {

  static boolean degree(Candidate candidate, DegreeField field) {
    return candidate.getDegrees().stream()
        .anyMatch(d -> field == d.getField()); // 实现逻辑
  }

  static boolean grade(Candidate candidate, int threshold) {
    return candidate.getDegrees().stream()
        .anyMatch(d -> threshold <= d.getGrade()); // 实现逻辑
  }

}
