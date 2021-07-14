package design.pattern.by.jpsoroulas._3_beharioral._2_template;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class EvaluationProcessTest extends AbstractTest {

  private List<Candidate> candidates;

  @BeforeClass
  void init() {
    candidates = HiringStrategyTestDataGenerator.buildCandidates(50);
  }

  @Test
  protected void sorted_score() {
    IEvaluationProcess process = new EvaluationProcessOfEngineer();

    List<Pair<String, Integer>> scores = candidates.stream()
        .map(c -> Pair.of(c.getName(), process.evaluate(c)))
        .sorted(reverseOrder(comparing(Pair::getRight)))
        .peek(s -> log.info("score: " + s))
        .collect(Collectors.toList());

    scores.stream()
        .reduce((current, next) -> {
          assertTrue(scoreValue(next).compareTo(scoreValue(current)) <= 0,
              "Unexpected scores order");
          return next;
        });
  }

  @Test
  protected void score_for_candidates() {
    IEvaluationProcess process = new EvaluationProcessOfEngineer();
    ToIntFunction<Candidate> specialEvaluation = EvaluationProcessAlgorithms::engineer;

    List<Pair<String, Integer>> scores = candidates.stream()
        .map(c -> Pair.of(c.getName(), process.evaluate(c)))
        .collect(Collectors.toList());

    Map<String, Candidate> cm = candidates.stream()
        .collect(Collectors.toMap(Candidate::getName, Function.identity()));

    scores.forEach(score -> {
      Candidate candidate = cm.get(candidateName(score));
      Integer expected = EvaluationProcessAlgorithms.common(candidate) + specialEvaluation.applyAsInt(candidate);
      assertEquals(scoreValue(score), expected, "Unexpected score");
    });
  }

  @Test
  public void non_lambda_evaluate_engineer() {
    IEvaluationProcess process = new EvaluationProcessOfEngineer();
    ToIntFunction<Candidate> specialEvaluation = EvaluationProcessAlgorithms::engineer;

    candidates.forEach(candidate -> {
      int expected = EvaluationProcessAlgorithms.common(candidate) + specialEvaluation.applyAsInt(candidate);
      assertEquals(process.evaluate(candidate), expected, "Unexpected score");
    });
  }

  @Test
  public void non_lambda_evaluate_manager() {
    IEvaluationProcess process = new EvaluationProcessOfManager();
    ToIntFunction<Candidate> specialEvaluation = EvaluationProcessAlgorithms::management;

    candidates.forEach(candidate -> {
      int expected = EvaluationProcessAlgorithms.common(candidate) + specialEvaluation.applyAsInt(candidate);
      assertEquals(process.evaluate(candidate), expected, "Unexpected score");
    });
  }

  @Test
  public void lambda_evaluate_engineer() {
    IEvaluationProcess process = new EvaluationProcessOfEngineer();
    ToIntFunction<Candidate> specialEvaluation = EvaluationProcessAlgorithms::engineer;

    candidates.forEach(candidate -> {
      int expected = EvaluationProcessAlgorithms.common(candidate) + specialEvaluation.applyAsInt(candidate);
      assertEquals(process.evaluate(candidate), expected, "Unexpected score");
    });
  }

  @Test
  public void lambda_evaluate_manager() {
    IEvaluationProcess process = new EvaluationProcessOfManager();
    ToIntFunction<Candidate> specialEvaluation = EvaluationProcessAlgorithms::management;

    candidates.forEach(candidate -> {
      int expected = EvaluationProcessAlgorithms.common(candidate) + specialEvaluation.applyAsInt(candidate);
      assertEquals(process.evaluate(candidate), expected, "Unexpected score");
    });
  }

  private String candidateName(Pair<String, Integer> score) {
    return score.getLeft();
  }

  private Integer scoreValue(Pair<String, Integer> score) {
    return score.getRight();
  }
}

