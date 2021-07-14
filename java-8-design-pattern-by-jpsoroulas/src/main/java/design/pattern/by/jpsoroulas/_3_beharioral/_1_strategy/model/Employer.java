package design.pattern.by.jpsoroulas._3_beharioral._1_strategy.model;

import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategy;
import java.util.Optional;
import lombok.Data;

@Data
public class Employer {

  private HiringStrategy hiringStrategy;

  public boolean hire(Candidate candidate) {
    return Optional.ofNullable(hiringStrategy)
        .map(hs -> hs.hire(candidate))
        .orElse(Boolean.FALSE);
  }
}
