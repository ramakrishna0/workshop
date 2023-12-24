package Googletest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailTest {
    @Parameters({"suite-param", "testng"})
    @Test
    public void LoginTest(String suiteParam, String testNG)
    {
        System.out.println("Successfully Logged In");
        System.out.println(suiteParam);
        System.out.println(testNG);
    }

    @Parameters({"testng", "testng2"})
    @Test
    public void LogoutTest(String testNG, String testNG2)
    {
        System.out.println("Successfully Logged Out");
        System.out.println(testNG);
        System.out.println(testNG2);
    }
}
