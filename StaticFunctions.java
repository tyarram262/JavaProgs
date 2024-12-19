import java.util.Scanner;

public class StaticFunctions {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static double triangleArea(double a, double b, double c) throws IllegalArgumentException{
        if(a+b<=c || b+c <= a || c+a<=b){
            throw new IllegalArgumentException("Fails triangle inequality theorom. Pick valid sides.");
        }
        double s = 0.5*(a+b+c);
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }
int binarySearch(String sortedArray[], String stringToFind){
    int left = 0;
    int right = sortedArray.length -1;
    while(left<=right){
        int mid = (left + right) /2;
        if(sortedArray[mid].equals(stringToFind)){
            return mid;
        }
        if(sortedArray[mid].compareTo(stringToFind) < 0){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return -1;
}

    

    public static void main(String[] args) {
        System.out.println("Enter the number you want to test with: ");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sides of the triangle: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        try {
            System.out.println("Area of the triangle: " + triangleArea(a, b, c));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scan.close();
    }
}