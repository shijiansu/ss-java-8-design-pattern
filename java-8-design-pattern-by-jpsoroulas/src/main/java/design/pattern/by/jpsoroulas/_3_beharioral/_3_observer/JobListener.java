package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;

@FunctionalInterface
public interface JobListener {

  void onNewJobAvailable(JobInfo info);
}
