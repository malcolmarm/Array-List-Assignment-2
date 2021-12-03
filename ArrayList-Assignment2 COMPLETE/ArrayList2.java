//Malcolm Armstrong
//ArrayList Assignment 2
import java.util.ArrayList;
class ArrayList2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>(7);
        ArrayList<Integer> arr2 = new ArrayList<Integer>(7);
        for (int i = 0; i < 6; i++) {
            arr1.add((int)(Math.random() * 10));
        }
        for (int i = 0; i < 6; i++) {
            arr2.add((int)(Math.random() * 10));
        }
        System.out.println(arr1 + " + " + arr2);
        System.out.println(add(arr1, arr2));
    }
    
    /**
     * Finds all prime numbers less than the given value
     * @param int n Value to find up to
     * @return An ArrayList of the primes
     */
    public static ArrayList<Integer> primeFinder(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            ans.add(i);
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int k = i + 1; k < ans.size();) {
                if (ans.get(k)  % ans.get(i) == 0) {
                    ans.remove(k);
                } else {
                    k++;
                }
            }
        }
        return ans;
    }
    
    /**
     * Prints two prime numbers that add up to the parameter
     * @param int n An even number 
     */
    public static void primePair(int n) {
        ArrayList<Integer> primes = primeFinder(n);
        boolean notFound = true;
        for (int i = 0; i < primes.size() && notFound; i++) {
            if (primes.contains(n - primes.get(i))) {
                System.out.println(n + " = " + primes.get(primes.indexOf(n - primes.get(i))) + " + " + primes.get(i));
                notFound = false;
            }
        }
    }
    
    public static ArrayList<Integer> add(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean addOne = false;
        for (int i = (Math.max(num1.size(), num2.size()) - 1); i >= 0; i--) {
            int val1, val2, sum;
            if (num1.size() > num2.size()) {
                while(num1.size() != num2.size()) {
                    num2.add(0,0);
                }
            } else if (num2.size() > num1.size()) {
                while(num1.size() != num2.size()) {
                    num1.add(0,0);
                }
            }
            val1 = num1.get(i);
            val2 = num2.get(i);
            if (addOne) sum = 1; else sum = 0;
            sum += val1 + val2;
            addOne = false;
            if (sum % 10 != sum) {
                //System.out.println("Carried the one from " + sum + " at value " + i);
                sum %= 10;
                addOne = true;
            } 
            ans.add(0, sum);
        }
        if (addOne) ans.add(0, 1);
        return ans;
    }
}