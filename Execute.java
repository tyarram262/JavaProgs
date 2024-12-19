public class Execute {
    static void runMethod(Object x, String methodName, Object[] args) throws InvalidMethodNameException, IncorrectNumberOfArgsException, MismatchedParametersException {
        //The methodName given exists in the Object x class. If the method does not exist, then throw InvalidMethodNameException
        if(x.getClass().getMethods().length == 0){
            throw new InvalidMethodNameException("No methods found in the class.");
        }
        //The Number of arguments in the method, methodName, matches the number of arguments given in the Object [] given exists in the Object x class. If the number of arguments is wrong, then throw IncorrentNumberOfArgsException exception. [3 points]
        try {
            if(x.getClass().getMethod(methodName, new Class[args.length]).getParameterCount() != args.length){
                    throw new IncorrectNumberOfArgsException("Incorrect number of arguments found in the method.");
            }
        } catch (NoSuchMethodException e) {
            throw new InvalidMethodNameException("Method not found in the class.");
        }
        // Check if the types of the args match the expected parameter in the method. This should be a comparison where the first arg should match the first expected parameter. Throw an exception "MismatchedParametersException" with the message "Type mismatch for arg <index + 1>" where <index> is the placeholder for the array index at which the mismatch is found. For example, if the first argument is mismatched (index 0) then the message would be "Type mismatch for arg 1". [5 points]
        for (int i = 0; i < args.length; i++) {
            try {
                if (args[i].getClass() != x.getClass().getMethod(methodName, new Class[args.length]).getParameterTypes()[i]) {
                    throw new MismatchedParametersException("Type mismatch for arg " + (i + 1));
                }
            } catch (NoSuchMethodException e) {
                throw new InvalidMethodNameException("Method not found in the class.");
            }
        }
    }
}