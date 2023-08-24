package com.epam.mjc;

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
        String[] parts = signatureString.split("\\s+");
        
        int modifierIndex = 0;
        if (isAccessModifier(parts[0])) {
            modifierIndex++;
        }
        
        String returnType = parts[modifierIndex];
        String methodName = parts[modifierIndex + 1];
        
        int openingParenthesisIndex = signatureString.indexOf("(");
        int closingParenthesisIndex = signatureString.indexOf(")");
        
        String argumentList = signatureString.substring(openingParenthesisIndex + 1, closingParenthesisIndex);
        String[] arguments = argumentList.split(",");
        
        List<Argument> parsedArguments = new ArrayList<>();
        for (String argument : arguments) {
            String[] argumentParts = argument.trim().split("\\s+");
            String argumentType = argumentParts[0];
            String argumentName = argumentParts[1];
            parsedArguments.add(new Argument(argumentType, argumentName));
        }
        
        String accessModifier = modifierIndex > 0 ? parts[0] : null;
        
        return new MethodSignature(accessModifier, returnType, methodName, parsedArguments);
    }
}
