import java.util.Random;

class Test1 {
    // Simple test:
    // static methods only no exceptions
    // 
    public static void method1(){

    }

    public static int method2(){
        // No exceptions. 
        Random r = new Random();
        return r.nextInt(1000); 
    }

    public static String method3(){
        Random r = new Random();
        return Integer.toString(r.nextInt(1000));
    }

    public static void method4(int a){
    }

    public static String method5(int a){
        return Integer.toString(a);
    }

    public static int method5(int a, int b){
        return a + b;
    }

    public static double method6(int a, double b){
        return a + b;
    }

    public static String method6(int a, double b, String c){
        return c + Double.toString(a + b);
    }

}