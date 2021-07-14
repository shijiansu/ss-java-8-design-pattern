package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;

public interface JobNotificationSystem {

  void addListener(JobListener listener);

  void removeListener(JobListener listener);

  void notify(JobInfo info);

}
