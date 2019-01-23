package test.com.company;
import com.company.FourArray;
import com.company.OneAndFour;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class OneAndFourTest {
    public static OneAndFour oaf;
    @BeforeClass
    public static void init() {
        System.out.println("init calc");
        oaf = new OneAndFour();
    }
    int arr1[] = new int[]{1,2,3,4,5,6,7,8,9};
    int arr2[] = new int[]{1, 1, 4, 5, 3, 4, 1, 5, 3, 4};
    int arr3[] = new int[]{1,2,3,3,5,6,7,9};
    int arr4[] = new int[]{4,2,3,3,5,6,7,4,9};
    boolean b1 = true;
    boolean b2 = false;

    @Test
    public void testR1() {
        Assert.assertEquals(b1, oaf.check(arr1));
    }
    @Test
    public void testR2() {
        Assert.assertEquals(b1, oaf.check(arr2));
    }
    @Test
    public void testR3() {
        Assert.assertEquals(b2, oaf.check(arr3));
    }
    @Test
    public void testR4() {
        Assert.assertEquals(b2, oaf.check(arr4));
    }




}