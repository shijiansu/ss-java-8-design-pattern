package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import static org.testng.Assert.assertEquals;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Employer;
import java.util.Collection;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HiringStrategyTest extends AbstractTest {

  private Employer employer;
  private List<Candidate> candidates;

  @BeforeClass
  void init() {
    candidates = HiringStrategyTestDataGenerator.buildCandidates(100);
  }

  @BeforeTest
  void before() {
    employer = new Employer();
  }

  @Test
  public void no_hiring_strategy() {
    employer.setHiringStrategy(null);     /* The employer is not authorized to hire */
    List<Candidate> candidates = HiringStrategyTestDataGenerator.buildCandidates(100);
    long hired = candidates.stream() // Find the number of hired candidates
        .filter(employer::hire) // always false, no one hired
        .count();

    assertEquals(hired, 0, "The employer has no authorization for hiring");
  }

  @Test
  public void no_lambda_degree_hiring_strategy() {
    DegreeField field = DegreeField.ENGINEERING;
    // expected
    long expected = candidates.stream()
        .map(Candidate::getDegrees)
        .flatMap(Collection::stream)
        .map(Degree::getField)
        .filter(field::equals)
        .count();
    // actual
    employer.setHiringStrategy(new HiringStrategyOfDegree(field));
    long actual = candidates.stream().filter(employer::hire).count();

    assertEquals(actual, expected, "Unexpected number of hired people");
  }

  @Test
  public void lambda_degree_hiring_strategy() {
    DegreeField field = DegreeField.ENGINEERING;
    // expected
    long expected = candidates.stream()
        .map(Candidate::getDegrees)
        .flatMap(Collection::stream)
        .map(Degree::getField)
        .filter(field::equals)
        .count();
    // actual
    employer.setHiringStrategy(c -> HiringStrategyAlgorithms.degree(c, field));
    long actual = candidates.stream().filter(employer::hire).count();

    assertEquals(actual, expected, "Unexpected number of hired people");
  }

  @Test
  public void no_lambda_grade_hiring_strategy() {
    final int threshold = 8;
    // expected
    long expectedHired = candidates.stream()
        .map(Candidate::getDegrees)
        .flatMap(Collection::stream)
        .mapToInt(Degree::getGrade)
        .filter(grade -> grade >= threshold)
        .count();
    // actual
    employer.setHiringStrategy(new HiringStrategyOfGrade(threshold));
    long actualHired = candidates.stream().filter(employer::hire).count();

    assertEquals(actualHired, expectedHired, "Unexpected number of hired people");
  }

  @Test
  public void lambda_grade_hiring_strategy() {
    final int threshold = 8;
    // expected
    long expectedHired = candidates.stream()
        .map(Candidate::getDegrees)
        .flatMap(Collection::stream)
        .mapToInt(Degree::getGrade)
        .filter(grade -> grade >= threshold)
        .count();
    // actual
    employer.setHiringStrategy(c -> HiringStrategyAlgorithms.grade(c, threshold));
    long actualHired = candidates.stream().filter(employer::hire).count();

    assertEquals(actualHired, expectedHired, "Unexpected number of hired people");
  }

}
