package core;

import io.qameta.allure.Description;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Listener implements ITestListener {

    @Override public void onTestSuccess(ITestResult result) {
        Method[] declaredMethods = result.getTestClass().getRealClass().getDeclaredMethods();
        result.getMethod().setDescription(Arrays.stream(declaredMethods)
            .filter(m -> m.getName().equalsIgnoreCase(result.getMethod().getMethodName()))
            .findFirst()
            .map(m -> m.getAnnotation(Description.class).value())
            .orElseThrow(() -> new NoSuchMethodError(result.getMethod().getMethodName() + " does not exist")));
        Logger.step(result.getMethod().getDescription() + " [passed]");
    }

    @Override public void onTestFailure(ITestResult result) {
        Logger.step(result.getMethod().getMethodName() + " [failed]");
    }

    @Override public void onTestSkipped(ITestResult result) {
        Logger.step(result.getMethod().getMethodName() + " [skipped]");
    }
}
