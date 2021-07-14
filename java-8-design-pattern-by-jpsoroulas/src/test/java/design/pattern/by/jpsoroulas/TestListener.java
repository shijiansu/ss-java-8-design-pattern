package design.pattern.by.jpsoroulas;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.perf4j.StopWatch;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {

  private StopWatch stopWatch = new StopWatch();

  @Override
  public void onTestStart(ITestResult result) {
    result.getMethod().getMethodName();
    String mthName = result.getMethod().getMethodName();
    stopWatch.start();
    log.info("------------------------------------------------------");
    log.info("Test: {} START on {}", mthName, new Date(stopWatch.getStartTime()));
    log.info("------------------------------------------------------");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    stopWatch.stop();
    String mthName = result.getMethod().getMethodName();
    log.info("------------------------------------------------------");
    log.info("Test: {} FINISH, EXECUTION TIME {} sec ", mthName,
        stopWatch.getElapsedTime() / 1000.);
    log.info("------------------------------------------------------");
  }

  @Override
  public void onTestFailure(ITestResult result) {
  }

  @Override
  public void onTestSkipped(ITestResult result) {
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

  @Override
  public void onStart(ITestContext context) {
  }

  @Override
  public void onFinish(ITestContext context) {
  }

}
