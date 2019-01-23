package test.com.company;

import com.company.FourArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FourArrayTest {
    private static FourArray fa;

    int arr1[] = new int[]{1,2,3,4,5,6,7,8,9};
    int arr2[] = new int[]{1,2,3,3,5,6,7,8,9};
    int arr3[] = new int[]{1,2,3,4,5,6,7,4,9};

    int[] outArr1 ={5, 6, 7, 8, 9};
    int[] outArr2 = {4, 8, 9};
    int[] outArr3 = {9};

    @BeforeClass
    public static void init() {
        System.out.println("init calc");
        fa = new FourArray();
    }
    @Test
    public void testR1() {
//        Assert.assertArrayEquals("Метод 1",fa.repacking(arr1), outArr1);
        Assert.assertArrayEquals(outArr1, fa.repacking(arr1));
    }

    @Test(expected = RuntimeException.class)
    public void testR2() {
//        fa.repacking(arr2);
        Assert.assertArrayEquals(outArr2, fa.repacking(arr2));
    }

    @Test
    public void testR3() {
//        Assert.assertEquals("Метод 3",fa.repacking(arr3), outArr3);
        Assert.assertArrayEquals(outArr3, fa.repacking(arr3));
    }

}