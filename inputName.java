import java.lang.reflect.*;
import java.util.Random;
import java.util.Scanner;

public class inputName {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scan.nextLine();
        scan.close();
        try {
            Class<?> c = Class.forName(className);
            Method[] methods = c.getDeclaredMethods();
            Random random = new Random();

            for (Method method : methods) {
                Class<?>[] paramTypes = method.getParameterTypes();
                boolean validMethod = true;
                for (Class<?> paramType : paramTypes) {
                    if (!(paramType.equals(int.class) || paramType.equals(double.class) || paramType.equals(String.class))) {
                        validMethod = false;
                        break;
                    }
                }
                if (!validMethod) {
                    System.out.println("Invalid parameter type in method: " + method.getName());
                    continue;
                }

                if (Modifier.isStatic(method.getModifiers())) {
                    System.out.println("Method under test: " + method.toString());
                    for (int i = 1; i <= 100; i++) {
                        Thread testThread = new Thread(new Runnable1(method, null, paramTypes, random, i));
                        testThread.start();
                    }
                } else {
                    Constructor<?> constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Object instance = constructor.newInstance();
                    System.out.println("Method under test: " + method.toString());
                    for (int i = 1; i <= 100; i++) {
                        Thread testThread = new Thread(new Runnable1(method, instance, paramTypes, random, i));
                        testThread.start();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid class name");
        } 
    }

    private static class Runnable1 implements Runnable {
        private final Method method;
        private final Object instance;
        private final Class<?>[] paramTypes;
        private final Random random;
        private final int testNumber;

        public Runnable1(Method method, Object instance, Class<?>[] paramTypes, Random random, int testNumber) {
            this.method = method;
            this.instance = instance;
            this.paramTypes = paramTypes;
            this.random = random;
            this.testNumber = testNumber;
        }

        private Object[] generateRandomParams(Class<?>[] paramTypes, Random random) {
            Object[] params = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                if (paramTypes[i] == int.class) {
                    params[i] = random.nextInt(1000);
                } else if (paramTypes[i] == double.class) {
                    params[i] = random.nextDouble() * 1000;
                } else if (paramTypes[i] == String.class) {
                    params[i] = Integer.toString(random.nextInt(1000));
                }
            }
            return params;
        }

        @Override
        public void run() {
            Object[] params = null;
            try {
                params = generateRandomParams(paramTypes, random);
                Object result = method.invoke(instance, params);
                if (instance == null) {
                    System.out.println("Test " + testNumber + ": " + method.getDeclaringClass().getName() + "." + method.getName() + "(" + paramsToString(params) + ") = " + result);
                } else {
                    System.out.println("Test " + testNumber + ": " + method.getDeclaringClass().getName() + "(" + instance.toString() + ")." + method.getName() + "(" + paramsToString(params) + ") = " + result);
                }
            } catch (Exception e) {
                System.out.println("Test " + testNumber + ": " + method.getDeclaringClass().getName() + "." + method.getName() + "(" + paramsToString(params) + ")");
                System.out.println("*** Exception found *** : " + e.getCause().getMessage());
            }
        }

        private String paramsToString(Object[] params) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                sb.append(params[i]);
                if (i < params.length - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }
    }
}