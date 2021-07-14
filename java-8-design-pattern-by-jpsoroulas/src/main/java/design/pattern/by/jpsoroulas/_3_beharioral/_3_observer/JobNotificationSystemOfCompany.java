package design.pattern.by.jpsoroulas._3_beharioral._3_observer;

import design.pattern.by.jpsoroulas._3_beharioral._3_observer.model.JobInfo;
import org.apache.commons.lang3.event.EventListenerSupport;

public class JobNotificationSystemOfCompany implements JobNotificationSystem {

  private EventListenerSupport<JobListener> listeners = EventListenerSupport
      .create(JobListener.class);

  @Override
  public void addListener(JobListener listener) {
    listeners.addListener(listener);
  }

  @Override
  public void removeListener(JobListener listener) {
    listeners.removeListener(listener);
  }

  @Override
  public void notify(JobInfo info) {
    listeners.fire().onNewJobAvailable(info);
  }
}
