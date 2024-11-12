package Listeners;

import Utilities.LogsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestResultListenerClass implements ITestListener {
    public void onTestStart(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " started");
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " passed");
    }
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " skipped");
    }

    private static final Logger logger = LoggerFactory.getLogger(ITestResultListenerClass.class);

}
