package com.cinnacinnabuns;

import com.cinnacinnabuns.variables.Endpoint;
import com.cinnacinnabuns.variables.Collexion;
import com.cinnacinnabuns.variables.Complex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {

    Integer testEndpoint = 2;
    List<Integer> testCollexion = new ArrayList<>(Arrays.asList(3, 4));
    StringBuilder testComplex = new StringBuilder("Hello");

    @Test
    void fromObject() {

        Variable expectedEndpoint = Variable.fromObject(null, testEndpoint, "testEndpoint");
        Variable expectedCollexion = Variable.fromObject(null, testCollexion, "testCollexion");
        Variable expectedComplex = Variable.fromObject(null, testComplex, "testComplex");

        assertTrue(expectedEndpoint instanceof Endpoint);
        assertTrue(expectedCollexion instanceof Collexion);
        assertTrue(expectedComplex instanceof Complex);
    }

    @Test
    void constructReasonablyComplexObject() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                Variable reasonablyComplexVariable = Variable.fromObject(
                        null, new testClass(), "reasonablyComplexVariable");
                reasonablyComplexVariable.print(0);
            }
        });
    }

    public static class testClass {

        //  NOTE: Note the access levels!
        public int testInt = 2;
        protected String testString = "Hello";
        List<Character> testList = new ArrayList<>(Arrays.asList('H', 'i'));
        private TestMemberClass testMemberClass = new TestMemberClass();
    }

    public static class TestMemberClass {
        public boolean testBool = true;
        private Map<Integer, String> testMap = Map.of(
                10, "Chocolate",
                20, "Pancakes");
    }
}