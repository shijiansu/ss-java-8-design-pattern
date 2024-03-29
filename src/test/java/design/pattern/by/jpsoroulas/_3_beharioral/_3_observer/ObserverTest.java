package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;
import design.pattern.by.jpsoroulas._3_beharioral._1_strategy.HiringStrategyTestDataGenerator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ObserverTest extends AbstractTest {

  @Test
  public void non_lambda_send_notifications() {
    JobNotificationSystem ns = new JobNotificationSystemOfCompany();
    ns.addListener(new JobListenerOfEngineeringDepartment());
    ns.addListener(new JobListenerOfLogisticsDepartment());
    ns.addListener(new JobListenerOfSalesDepartment());
    List<JobInfo> jobsInfo = HiringStrategyTestDataGenerator.buildJobs(10);
    jobsInfo.forEach(ns::notify);
  }

  @Test
  public void lambda_send_notifications() {
    JobNotificationSystem ns = new JobNotificationSystemOfCompany();
    ns.addListener(JobNotificationAlgorithms::engineering);
    ns.addListener(JobNotificationAlgorithms::logistics);
    ns.addListener(JobNotificationAlgorithms::sales);
    List<JobInfo> jobsInfo = HiringStrategyTestDataGenerator.buildJobs(10);
    jobsInfo.forEach(ns::notify);
  }

}
