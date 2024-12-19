public class Q1 {
    public void printBarChart(String keys[], int freq[]) {
        if (!(keys.length == freq.length)) {
            throw new RuntimeException("Invalid Barchart");
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 30 || freq[i] < 1) {
                throw new RuntimeException("Invalid frequency for key " + keys[i]);
            }
        }
        if(freq.length == 0){
            return;
        }
        int maxLength = 0;
        for (String key : keys) {
            if (key.length() > maxLength) {
                maxLength = key.length();
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if(keys[i] == ""){
                continue;
            }
            System.out.print(keys[i]);
            for (int k = keys[i].length(); k < maxLength + 3; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < freq[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        String[] keys = {"Apple", "Orange", "Mango"};
        int[] freq = {3, 5, 2};
        q1.printBarChart(keys, freq);
    }
}