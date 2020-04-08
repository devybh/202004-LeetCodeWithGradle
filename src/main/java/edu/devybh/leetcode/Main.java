package edu.devybh.leetcode;

import edu.devybh.leetcode.solutions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {

    public static String packageName = "edu.devybh.leetcode.solutions";
    public static String solutionName = "Solution_0007_Reverse";

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Util.log("Start Main");

        // get class
        @SuppressWarnings("unchecked")
        Class<? extends AbstractSolution> solutionClass
                = (Class<? extends AbstractSolution>) Class.forName(packageName + "." + solutionName);

        // create instance
        AbstractSolution solution = solutionClass.getConstructor().newInstance();

        // get testCases
        ArrayList<AbstractSolution.TestCase> testCases = solution.setTestCases().getTestCases();

        // execute test
        for (AbstractSolution.TestCase testCase : testCases) {
            System.out.println("");

            Object[] input = testCase.getInput();
            Util.log("input", input);

            Object output = solution.getMethod().invoke(solution, input);
            Util.log("output", output);

            boolean compareResult = solution.compare(output, testCase.output);
            if (compareResult) {
                Util.log("TRUE");
            } else {
                Util.log("Expected", testCase.output);
            }
        }

        Util.log("End Main");
    }
}
