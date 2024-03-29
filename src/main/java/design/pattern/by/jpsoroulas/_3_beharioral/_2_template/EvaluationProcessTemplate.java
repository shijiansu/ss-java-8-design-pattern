package design.pattern.by.jpsoroulas._3_beharioral._2_template;

import static design.pattern.by.jpsoroulas._3_beharioral._2_template.EvaluationProcessAlgorithms.common;
import static design.pattern.by.jpsoroulas._3_beharioral._2_template.EvaluationProcessAlgorithms.engineer;
import static design.pattern.by.jpsoroulas._3_beharioral._2_template.EvaluationProcessAlgorithms.management;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;

public abstract class EvaluationProcessTemplate implements IEvaluationProcess {

  @Override
  public int evaluate(Candidate candidate) {
    return commonStep(candidate) + specialStep(candidate);
  }

  private int commonStep(Candidate candidate) {
    return common(candidate);
  }

  protected abstract int specialStep(Candidate candidate);
}

class EvaluationProcessOfEngineer extends EvaluationProcessTemplate {

  @Override
  protected int specialStep(Candidate candidate) {
    return engineer(candidate);
  }
}

class EvaluationProcessOfManager extends EvaluationProcessTemplate {

  @Override
  protected int specialStep(Candidate candidate) {
    return management(candidate);
  }
}
