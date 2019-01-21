package com;

import com.company.FourArray;
import org.junit.*;

public class FourArrayTests{
    int arr1[] = new int[]{1,2,3,4,5,6,7,8,9};
    int arr2[] = new int[]{1,2,3,3,5,6,7,8,9};
    int arr3[] = new int[]{1,2,3,4,5,6,7,4,9};

    int[] outArr ={5, 6, 7, 8, 9};
    int[] outArr1 = {4, 8, 9};
    int[] outArr2 = {9};

    private FourArray fa;
    @Before
    private void init(){
        fa = new FourArray();
    }
    @Test
    private void forurArrayTest1() {
        Assert.assertEquals(fa.repacking(outArr), arr1);
    }
    @Test
    private void forurArrayTest2() {
        Assert.assertEquals(fa.repacking(outArr), arr1);
    }
    @Test(expected = RuntimeException.class)
    private void forurArrayTest3() {
        Assert.assertEquals(fa.repacking(outArr), arr1);
    }
}
