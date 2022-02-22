package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LightsShowTest {

    private LightsShow lightsShow = new LightsShow();

    @Test
    public void test() throws IOException {
        int result = lightsShow.startShow("src/test/resources/data.txt");
        Assert.assertEquals(998004, result);
    }
}
