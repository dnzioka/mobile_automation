package dominic.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReports() {
        String fileName = System.getProperty("user.dir") + "/Reports/Testreport.html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);

        // config for the report
        sparkReporter.config().setDocumentTitle("Mobile Auotmation Test Report");
        sparkReporter.config().setReportName("Android App Automation Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Title", "QA Engineer");
        extent.setSystemInfo("Name", "Dominic Malile");

        return extent;
    }
}
