package design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public class Degree {

  private DegreeField field;
  private int grade;
  private String holderName;

  private Degree(DegreeBuilder builder) {
    this.holderName = builder.holderName;
    this.field = builder.field;
    this.grade = builder.grade;
  }

  public enum DegreeField {
    ENGINEERING, CHEMISTRY, PHYSICS, MANAGEMENT
  }

  public static class DegreeBuilder {

    private DegreeField field;

    private int grade;

    private String holderName;

    public DegreeBuilder withField(DegreeField field) {
      this.field = field;
      return this;
    }

    public DegreeBuilder withHolderName(String holderName) {
      this.holderName = holderName;
      return this;
    }

    public DegreeBuilder withGrade(int grade) {
      this.grade = grade;
      return this;
    }

    public Degree build() {
      Validate.notNull(field, "Undefined degree field!");
      Validate.notEmpty(holderName, "Undefined degree holder's name!");
      return new Degree(this);
    }
  }
}
