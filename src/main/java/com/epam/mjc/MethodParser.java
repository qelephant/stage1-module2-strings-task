package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        String methodName = "", accessModifier = "", returnType = "";

        List<MethodSignature.Argument> arguments = new ArrayList<>();
        StringTokenizer stringTokenizer1 = new StringTokenizer(signatureString);
        StringTokenizer stringTokenizer2 = new StringTokenizer("");

        stringTokenizer2 = new StringTokenizer(stringTokenizer1.nextToken("(,)"));

        for (int i = 0; stringTokenizer2.hasMoreTokens(); i++) {
            String temp = stringTokenizer2.nextToken();
            if (i == 0) {
                if (temp.contains("public") || temp.contains("private")) {
                    accessModifier = temp;
                } else {
                    accessModifier = null;
                    returnType = temp;
                    methodName = stringTokenizer2.nextToken();
                }
            }
            if (i == 1) {
                returnType = temp;
                methodName = stringTokenizer2.nextToken();
            }
        }

        while (stringTokenizer1.hasMoreTokens()) {
            arguments.add(new MethodSignature.Argument(stringTokenizer1.nextToken("(,) "), stringTokenizer1.nextToken("(,) ")));
        }

        MethodSignature signature = new MethodSignature(methodName, arguments);
        signature.setAccessModifier(accessModifier);
        signature.setReturnType(returnType);

        return signature;
    }
}
