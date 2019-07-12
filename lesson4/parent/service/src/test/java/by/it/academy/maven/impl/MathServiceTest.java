package by.it.academy.maven.impl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MathServiceTest {
    MathService mathService;


    @org.junit.Before
    public void setUp() throws Exception {
        mathService = new MathService();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        mathService = null;
    }

    @org.junit.Test
    public void average() {
        //given
        List<Integer> testdata = List.of(1,2);
        List<Integer> testdata2 = new ArrayList<>();
        testdata2.add(1);
        testdata2.add(null);
        testdata2.add(2);

        //when
        Double average = mathService.average(testdata);
        Double average2 = mathService.average(testdata2);

        //then
        assertEquals(1.5, average,0);
        assertEquals(1.5, average2,0);

    }
}