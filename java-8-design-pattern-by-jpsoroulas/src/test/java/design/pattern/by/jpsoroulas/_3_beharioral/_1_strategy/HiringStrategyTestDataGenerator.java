package design.pattern.by.jpsoroulas._3_beharioral._1_strategy;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Candidate.Gender;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.ContactInfo;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model.Degree.DegreeField;
import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;
import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo.JobCategory;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;

@Slf4j
public final class HiringStrategyTestDataGenerator {

  // some Suppliers
  private static final Supplier<String> RAND_NAME = () -> randomAlphabetic(15);
  private static final IntSupplier RAND_AGE = () -> nextInt(20, 50);
  private static final Supplier<Gender> RAND_GENDER = () -> Gender.values()[nextInt(0,
      Gender.values().length)];
  private static final IntSupplier RAND_GRADE = () -> nextInt(0, 10);
  private static final Supplier<DegreeField> RAND_DEGREE_FIELD = () -> DegreeField.values()[nextInt(
      0, DegreeField.values().length)];
  private static final Supplier<JobCategory> RAND_JOB_CAT_SUPPL = () -> JobCategory
      .values()[nextInt(0, JobCategory.values().length)];

  private HiringStrategyTestDataGenerator() {
  }

  private static Candidate buildCandidate(Supplier<String> name) {
    return new Candidate.CandidateBuilder()
        .withName(name.get())
        .withAge(RAND_AGE.getAsInt())
        .withGender(RAND_GENDER.get())
        .withDegree(buildDegree())
        .withContactInfo(new ContactInfo(name.get(), genRandomBoolean()))
        .build();
  }

  private static List<Candidate> buildCandidates(Supplier<String> name, int numberOfCandidates) {
    return IntStream
        .range(0, numberOfCandidates)
        .mapToObj(i -> buildCandidate(name))
        // side action to log
        .peek(c -> log.debug("candidate: " + c))
        .collect(Collectors.toList());
  }

  public static List<Candidate> buildCandidates(int numberOfCandidates) {
    return buildCandidates(RAND_NAME, numberOfCandidates);
  }

  public static List<Candidate> buildCandidatesByName(String name, int numberOfCandidates) {
    return buildCandidates(() -> name, numberOfCandidates);
  }

  private static Degree buildDegree() {
    return new Degree.DegreeBuilder()
        .withField(RAND_DEGREE_FIELD.get())
        .withHolderName(RAND_NAME.get())
        .withGrade(RAND_GRADE.getAsInt())
        .build();
  }

  public static Degree buildDegreeByField(DegreeField field) {
    return new Degree.DegreeBuilder()
        .withField(field)
        .withHolderName(RAND_NAME.get())
        .withGrade(RAND_GRADE.getAsInt())
        .build();
  }

  public static List<Degree> buildDegreesByField(DegreeField field, int numberOfDegrees) {
    return IntStream
        .range(0, numberOfDegrees)
        .mapToObj(i -> buildDegreeByField(field))
        .collect(Collectors.toList());
  }

  public static List<JobInfo> buildJobs(int numberOfJobs) {
    return IntStream
        .range(0, numberOfJobs)
        .mapToObj(i -> new JobInfo(RAND_JOB_CAT_SUPPL.get(), RAND_NAME.get()))
        .collect(Collectors.toList());
  }

  public static <T> boolean isSorted(List<T> source, BiFunction<T, T, Boolean> unsc) {
    return StreamEx.of(source).pairMap(unsc).has(true);
  }

  public static void printList(List<?> list) {
    list.forEach((e) -> log.info(e.toString()));
  }

  private static boolean genRandomBoolean() {
    return Math.random() < 0.5;
  }
}
