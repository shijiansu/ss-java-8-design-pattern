package design.pattern.by.jpsoroulas.streams;

import static java.util.Comparator.comparing;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ComparatorTest extends AbstractTest {

  @Test
  public void simple_sort() {
    List<Candidate> candidates = HiringStrategyTestDataGenerator.buildCandidates(5);
    candidates.sort(Comparator.comparing(Candidate::getName));
    Assert.assertTrue(HiringStrategyTestDataGenerator
        .isSorted(candidates, (a, b) -> a.getName().compareTo(b.getName()) < 0));
  }

  @Test
  public void multiSort() {
    List<Candidate> candidates = HiringStrategyTestDataGenerator
        .buildCandidatesByName("Javaman", 5);
    candidates.sort(comparing(Candidate::getName).thenComparingInt(Candidate::getAge));
    HiringStrategyTestDataGenerator.printList(candidates);
    Assert.assertTrue(HiringStrategyTestDataGenerator
        .isSorted(candidates, (a, b) -> a.getAge() - b.getAge() < 0));
  }
}
