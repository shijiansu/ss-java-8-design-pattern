package design.pattern.by.jpsoroulas._3_beharioral._2_template;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;

public interface EvaluationProcessAlgorithms {

  static int common(Candidate c) {
    return c.getAge() > 30 ? 3 : 12;
  }

  static int engineer(Candidate c) {
    return c.getDegrees().stream()
        .mapToInt(d -> DegreeField.MANAGEMENT.equals(d.getField()) ? 15 : 50)
        .sum();
  }

  static int management(Candidate c) {
    return c.getDegrees().stream()
        .filter(d -> DegreeField.MANAGEMENT.equals(d.getField()))
        .findAny()
        .map(d -> 27)
        .orElse(0);
  }
}
