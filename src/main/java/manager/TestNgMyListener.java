package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class TestNgMyListener implements ITestListener, ISuiteListener {
    Logger logger = LoggerFactory.getLogger(TestNgMyListener.class);

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        logger.info("onStart(ISuite suite)");
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        logger.info("onFinish(ISuite suite)");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("onTestFailure" +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("nTestFailedWithTimeout" + result.getInstanceName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("onStart"+ context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("onFinish");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("onTestStart");
    }
}
