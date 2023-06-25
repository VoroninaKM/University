package sample;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void getList() throws Exception {
        int f = 10;
        int g = 16;
        List<Integer> array = new ArrayList<>();
        for (int i = f; i <= g; i++) {
            if ( i % 2 == 0 && i > 0  && i / 10 >= 1 && i / 10 <= 9 )
            {
                array.add(i);
            }
        }
        int [] result = new int [] {10, 12, 14, 16};
        Assert.assertEquals(array.toString(), Arrays.toString(result));
    }

}


