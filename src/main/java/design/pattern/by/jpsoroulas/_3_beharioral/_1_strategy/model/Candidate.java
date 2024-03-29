package design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
public class Candidate {

  private String name;
  private int age;
  private Gender gender;
  private List<Degree> degrees;
  // The candidate may not give a contact info
  private ContactInfo contactInfo;

  private Candidate(CandidateBuilder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.gender = builder.gender;
    this.degrees = builder.degrees;
    this.contactInfo = builder.contactInfo;
  }

  public enum Gender {
    MALE, FEMALE
  }

  public static class CandidateBuilder {

    private String name;

    private int age;

    private Gender gender;

    private List<Degree> degrees = new ArrayList<>();

    private ContactInfo contactInfo;

    public CandidateBuilder withName(String name) {
      this.name = name;
      return this;
    }

    public CandidateBuilder withAge(Integer age) {
      this.age = age;
      return this;
    }

    public CandidateBuilder withGender(Gender gender) {
      this.gender = gender;
      return this;
    }

    public CandidateBuilder withDegree(Degree degree) {
      this.degrees.add(degree);
      return this;
    }

    public CandidateBuilder withDegrees(List<Degree> degrees) {
      this.degrees.addAll(degrees);
      return this;
    }

    public CandidateBuilder withContactInfo(ContactInfo contactInfo) {
      this.contactInfo = contactInfo;
      return this;
    }

    public Candidate build() {
      Validate.notEmpty(name, "Undefined candidate name!");
      Validate.notNull(gender, "Undefined candidate gender!");
      return new Candidate(this);
    }
  }
}
