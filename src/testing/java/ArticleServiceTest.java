import java.lang.reflect.Method;

import org.springframework.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArticleServiceTest {
	@BeforeClass
    public void beforeClass(){
        //Ideal place to perform some setup which is shared among all tests.
        //E.g. Initializing DB connection, setting environment properties
        System.out.println("@BeforeClass: I run only once, before first test start.");
    }
 
    @AfterClass
    public void afterClass(){
        //Ideal place to perform some cleanup of setup which is shared among all tests.
        System.out.println("@AfterClass: I run only once, after all tests have been done.\n");
    }
 
    @BeforeMethod
    public void beforeEachTestMethod(Method method){//Parameter are optional
        //May perform some initialization/setup before each test.
        //E.g. Initializing User whose properties may be altered by actual @Test
        System.out.println("\n@BeforeMethod: I run before each test method. Test to be executed is : "+method.getName());
    }
     
    @AfterMethod
    public void afterEachTestMethod(Method method){//Parameter are optional
        //May perform cleanup of initialization/setup after each test.
        System.out.println("@AfterMethod: I run after each test method. Test just executed is : "+method.getName()+"\n");
    }

	@Test
	public void test(){
		Assert.isTrue(true, "ERROR WITH TEST METHOD...");
	}
	
	@Test
	public void test1(){
		Assert.isTrue(true, "ERROR WITH TEST METHOD...");
	}
	@Test
	public void test2(){
		Assert.isTrue(true, "ERROR WITH TEST METHOD...");
	}
	@Test
	public void test3(){
		Assert.isTrue(true, "ERROR WITH TEST METHOD...");
	}
}
