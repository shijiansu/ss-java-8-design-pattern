package design.pattern.by.jpsoroulas.streams;

import static design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator.buildDegreeByField;
import static design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator.buildDegreesByField;
import static org.testng.Assert.assertEquals;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class GroupTest extends AbstractTest {

  @Test
  public void simple_group() {
    List<Degree> degrees = new ArrayList<>();
    degrees.addAll(buildDegreesByField(DegreeField.ENGINEERING, 10));
    degrees.addAll(buildDegreesByField(DegreeField.CHEMISTRY, 15));
    degrees.addAll(buildDegreesByField(DegreeField.PHYSICS, 20));

    Map<DegreeField, List<Degree>> grouped = degrees.stream() // Convert list to stream
        .collect(Collectors.groupingBy(Degree::getField)); // Group by Degree field

    log.info("simpleGroup()");
    grouped.forEach((k, v) -> v
        .forEach(d -> log.info("DegreeField = {}; total = {}; Degree => {}", k, v.size(), d)));

    // Check the groups size
    assertEquals(grouped.get(DegreeField.ENGINEERING).size(), 10);
    assertEquals(grouped.get(DegreeField.CHEMISTRY).size(), 15);
    assertEquals(grouped.get(DegreeField.PHYSICS).size(), 20);
  }

  @Test
  public void transform_and_group() {
    Map<DegreeField, List<Degree>> grouped = IntStream.range(0, 5)
        .mapToObj( // For each int produce an array with two degrees
            i -> new Degree[]{
                buildDegreeByField(DegreeField.ENGINEERING),
                buildDegreeByField(DegreeField.CHEMISTRY)
            })
        .flatMap(Arrays::stream) // Flatten the array
        .collect(Collectors.groupingBy(Degree::getField)); // Group by degree field

    log.info("transformAndGroup()");
    grouped.forEach((k, v) -> v
        .forEach(d -> log.info("DegreeField = {}; total = {}; Degree => {}", k, v.size(), d)));

    // Check the groups size
    assertEquals(grouped.get(DegreeField.ENGINEERING).size(), 5);
    assertEquals(grouped.get(DegreeField.CHEMISTRY).size(), 5);
  }
}
