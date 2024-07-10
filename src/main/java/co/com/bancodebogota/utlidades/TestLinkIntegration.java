package co.com.bancodebogota.utlidades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

    public static final String TESTLINK_KEY = "e9432f99b2375e3e0e121c3d329432ab";
    public static final String TESTLINK_URL = "https://testlink.labdigitalbdblifecycle.co/lib/api/xmlrpc/v1/xmlrpc.php";
    public static final String TEST_PROJECT_NAME = "WebComponents";
    public static final String TEST_PLAN_NAME = "AutomatizacionWebComponentes";
    public static final String BUILD_NAME = "Build_Automatizacion";
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLinkIntegration.class);

    private TestLinkIntegration() {
        LOGGER.info("TestLinkIntegration");
        throw new IllegalStateException("Utility class");
    }

    public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException {
        TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
    }
}
