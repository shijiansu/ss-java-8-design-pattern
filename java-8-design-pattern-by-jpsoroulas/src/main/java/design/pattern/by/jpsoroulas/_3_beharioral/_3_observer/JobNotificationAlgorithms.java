package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;
import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo.JobCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface JobNotificationAlgorithms {

  Logger log = LoggerFactory.getLogger(JobNotificationAlgorithms.class);

  static void engineering(JobInfo job) {

    if (JobCategory.ENGINEERING == job.getJobCategory()) {
      log.info("New job notification received by Engineering department");
    }
  }

  static void logistics(JobInfo job) {
    if (JobCategory.LOGISTICS == job.getJobCategory()) {
      log.info("New job notification received by Logistics department");
    }
  }

  static void sales(JobInfo job) {
    if (JobCategory.LOGISTICS == job.getJobCategory()) {
      log.info("New job notification received by Sales department");
    }
  }

}
