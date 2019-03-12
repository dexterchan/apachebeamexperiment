package io.research.java8.funcClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.BiFunction;
import java.util.function.Function;

@RunWith(JUnit4.class)
public class testfuncMain {

    @Test
    public void testInversion() throws Exception {
        int v=5;
        Integer ret = AwesomeClass.invertTheNumber(v);
        assert( v*(-1) == ret.intValue());
       // System.out.println(ret);
    }

    @Test
    public void testByLambda(){
        int v=5;
        v=v;
        Integer ret=AwesomeClass.compute( (a)->(-1)*a, v );
        assert(ret.intValue()== v*(-1));

    }
    @Test
    public void bifunction(){
        int k=7,s=5;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        Integer ret=add.apply(k,s);
        assert(ret.intValue()==(k+s));

    }

}

class AwesomeClass {
    private static Integer invert(Integer value) {
        return -value;
    }
    public static Integer invertTheNumber(Integer value){
        Integer toInvert = value;
        Function<Integer, Integer> invertFunction = AwesomeClass::invert;
        return compute(invertFunction, toInvert);
    }
    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }

}