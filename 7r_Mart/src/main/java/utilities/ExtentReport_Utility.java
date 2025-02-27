package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport_Utility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7r_Mart");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organisation", "Obsqura");
		extentReports.setSystemInfo("Name", "Roshan");
		return extentReports;

	}
}
