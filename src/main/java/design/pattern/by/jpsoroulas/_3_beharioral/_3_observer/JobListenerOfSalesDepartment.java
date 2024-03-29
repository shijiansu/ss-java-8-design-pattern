package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobListenerOfSalesDepartment implements JobListener {

  @Override
  public void onNewJobAvailable(JobInfo job) {
    log.info("New job notification received by Sales department");
  }

}
