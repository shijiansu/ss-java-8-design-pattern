package design.pattern.by.jpsoroulas._3_beharioral._3_observer.model;

import lombok.Data;

@Data
public class JobInfo {

  private JobCategory jobCategory;
  private String description;

  public JobInfo(JobCategory jobCategory, String description) {
    this.jobCategory = jobCategory;
    this.description = description;
  }

  public enum JobCategory {
    ENGINEERING, SALES, LOGISTICS
  }

}
