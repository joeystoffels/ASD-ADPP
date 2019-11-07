package asd.adpp;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseUnitTest {

    @Rule
    public TestName testName = new TestName();

    private final String className = this.getClass().getSimpleName();

    @Before
    public void before(){
        System.out.println("Start of test [" + className + ": " + testName.getMethodName() + "]");
    }

    @After
    public void after() {
        System.out.println("End of test [" + className + ": " + testName.getMethodName() + "]");
    }

}
