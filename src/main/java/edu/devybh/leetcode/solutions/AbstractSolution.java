package edu.devybh.leetcode.solutions;

import edu.devybh.leetcode.Util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractSolution {


    /**
     * TestCase 관련
     */


    public abstract AbstractSolution setTestCases();

    private ArrayList<TestCase> testCases = new ArrayList<>();

    public ArrayList<TestCase> getTestCases() {
        return testCases;
    }

    protected TestCase newTestCase() {
        TestCase testCase = new TestCase();
        testCases.add(testCase);
        return testCase;
    }

    public static class TestCase {

        ArrayList<Object> input = new ArrayList<>();
        public Object output;

        public TestCase setInput(Object o) {
            input.add(o);
            return this;
        }

        public Object[] getInput() {
            return input.toArray();
        }

        public void setOutput(Object o) {
            output = o;
        }
    }


    /**
     * reflection 관련
     */


    public Method getMethod() {
        String methodName = getMethodName();
        Method[] methods = getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    private String getMethodName() {
        String methodName = getClass().getName();
        methodName = methodName.substring(methodName.lastIndexOf('.') + 1);
        methodName = methodName.substring(methodName.lastIndexOf('_') + 1);
        methodName = methodName.substring(0, 1).toLowerCase() + methodName.substring(1);
        return methodName;
    }


    /**
     * Compare 관련
     */


    private String getReturnTypeName() {
        return getMethod().getReturnType().getTypeName();
    }

    public boolean compare(Object o1, Object o2) {
        if (o1.getClass().isArray()) { // when array
            ArrayList<Object> list1 = new ArrayList<>();
            for (int i = 0; i < Array.getLength(o1); i++) {
                list1.add(Array.get(o1, i));
            }
            ArrayList<Object> list2 = new ArrayList<>();
            for (int i = 0; i < Array.getLength(o2); i++) {
                list2.add(Array.get(o2, i));
            }
            return Arrays.equals(list1.toArray(), list2.toArray());
        } else {
            switch (o1.getClass().getTypeName()) {
                case "java.lang.Integer":
                    return ((Integer) o1).equals((Integer) o2);

                default:
                    Util.log("Undefined Type For Compare", o1);
                    break;
            }
        }
        return false;
    }


}
