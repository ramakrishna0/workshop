import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @BeforeAll // there is also non static BeforeEach
    public static void beforeAll() {
        System.out.println("beforeALl");
    }

    @AfterAll //there is also non static AfterEach
    public static void afterAll() {
        System.out.println("afterAll");
    }

}
