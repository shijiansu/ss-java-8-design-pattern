package design.pattern.by.jpsoroulas._3_beharioral._2_template;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import java.util.function.ToIntFunction;

public class EvaluationProcess implements IEvaluationProcess {

  private EvaluationProcess() {
  }

  private ToIntFunction<Candidate> specialEvaluation;

  public static EvaluationProcess build(ToIntFunction<Candidate> specialEvaluation) {
    EvaluationProcess p = new EvaluationProcess();
    p.specialEvaluation = specialEvaluation;
    return p;
  }

  private ToIntFunction<Candidate> getSpecialEvaluation() {
    return specialEvaluation;
  }

  @Override
  public int evaluate(Candidate candidate) {
    return commonStep(candidate) + getSpecialEvaluation().applyAsInt(candidate);
  }

  private int commonStep(Candidate candidate) {
    return EvaluationProcessAlgorithms.common(candidate);
  }

}
