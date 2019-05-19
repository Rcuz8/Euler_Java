import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    static void pr(Object o) {System.out.println(o);}
    static void pr(int o) {System.out.println(o);}
    static void pr(double o) {System.out.println(o);}
    static void prArr(ArrayList a) {
        System.out.print("\n[ ");
        for (Object o:a) {
            System.out.print(o  + " ");
        }
        System.out.print("]\n");
    }
    static void prArr(LinkedList a) {
        if (a == null) {
            pr("null");
            return;
        }
        System.out.print("\n[ ");
        for (Object o:a) {
            System.out.print(o  + " ");
        }
        System.out.print("]\n");
    }
    // 2

//    static int even_fib_sum(int max) {
//        int a = 1;
//        int b = 1;
//        int nth_time = 0;
//        int sum = 0;
//        for (int i = 2; i < max; i = a+b) {
//            if (nth_time % 2 == 0) {
//                sum+=i;
//                pr(i);
//            }
//            a = b;
//            b = i;
//            nth_time++;
//        }
//        return sum;
//    }
//    static ArrayList<BigInteger> fibs_under(int max) {
//        int a = 1;
//        int b = 2;
//        ArrayList<BigInteger> curr = new ArrayList<>();
//        curr.add(a);
//        return fibs_under(a,b,max,curr);
//    }
//    static ArrayList<BigInteger> fibs_under(int a, int b, int max, ArrayList<BigInteger> curr) {
//        if (b > max) return curr;
//        curr.add(b);
//        int temp = a;
//        a = b;
//        b = b + temp;
//        return fibs_under(a,b,max,curr);
//    }
//    static int Arr_sum(ArrayList<BigInteger> a) {
//        int sum = 0;
//        for (BigInteger o:a) {
//            sum += o.intValue();
//        }
//        return sum;
//    }
    static void removeEvens(ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            if (i % 2 == 0) a.set(i, null);
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == null) a.remove(i);
        }
    }
//    static void t1() {
//        long max = 4000000;
//        ArrayList<BigInteger> fibs = fibs_under(max);
//        prArr(fibs);
//        pr("-------");
//        removeEvens(fibs);
//        prArr(fibs);
//        pr("-------");
//        pr(Arr_sum(fibs));
//    }


    // 3

    static ArrayList<BigInteger> factorsOf(BigInteger n) {
        ArrayList<BigInteger> list = new ArrayList<>();
        for (long i = 1; i <= n.longValue()/2;i++)  {
                if (n.longValue() % i == 0)
                    list.add(new BigInteger(String.valueOf(i)));
        }
        return list;
    }

    static ArrayList<Long> factorsOf(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i <= n/2;i++)  {
            if (n % i == 0)
                list.add(i);
        }
        return list;
    }

    static int num_factors(long n) {
        int num = 0;
        for (long i = 1; i <= n/2;i++)  {
            if (n % i == 0)
                num++;
        }
        return num;
    }


    static int num_factors_MODIFIED(long n) {
        if (n % 2 != 0 || n % 3 != 0 || n % 5 != 0) return -1;
        int num = 0;
        for (long i = 1; i <= n/2;i++)  {
            if (n % i == 0)
                num++;
        }
        return num;
    }

    static boolean isPrime(BigInteger n) {
        ArrayList<BigInteger> list = factorsOf(n);
        if (list.size() > 0)
            list.remove(0);
//            list.remove(list.size()-1);
        return list.isEmpty();
    }

    static BigInteger largestPrimeFactor(BigInteger n) {
        ArrayList<BigInteger> list = factorsOf(n);
//        prArr(list);
//        return null;
        BigInteger largest = null;
        for (BigInteger i: list) {
            long _i = i.longValue();
            if (!(_i % 2 == 0 || _i % 3 == 0 ||  _i % 5 ==  0)) {
                if (isPrime(i))
                    if (largest == null || i.compareTo(largest) > 0) largest = i;
            }
        }
        return largest;
    }

    static void t2() {
        // 600851475143
        String s = "600851475143";
        BigInteger biggie = largestPrimeFactor(new BigInteger(s));
        if (biggie !=  null)
            pr(biggie.longValue());
        else pr("Biggie is null!");
    }

    static boolean String_isPalendrome(String s)  {
        if (s.length() % 2 == 1) {
            int mid = s.length()/2;
//            pr("mid is: " + mid);
            for (int i = 0; i < s.length()/2; i++) {
                int a = mid-i;
                int b = mid+i;
                char c1 = s.charAt(a);
                char c2 = s.charAt(b);
//                pr("a: " + a + " b: " + b);
//                pr("c1: " + c1 + " c2: " + c2);
                if (s.charAt(a) != s.charAt(b))
                    return false;
//                else pr("a=b!");
}
            return true;
        } else {
            int mid = s.length() / 2 - 1;
//            pr("mid is: " + mid);
            for (int i = 0; i < s.length() / 2; i++) {
                int a = mid - i;
                int b = mid + i + 1;
                char c1 = s.charAt(a);
                char c2 = s.charAt(b);
//                pr("a: " + a + " b: " + b);
//                pr("c1: " + c1 + " c2: " + c2);
                if (s.charAt(a) != s.charAt(b))
                    return false;
//                else pr("a=b!");
            }
            return true;
        }
        }

    static boolean isPalendrome(long n){ return String_isPalendrome(String.valueOf(n));}
    static boolean isPalendrome(int n){ return String_isPalendrome(String.valueOf(n));}

    static ArrayList<Integer> intlist_below(int max){
        ArrayList<Integer> list = new ArrayList<>();

        for (int n = 0; n < max; n++)
            list.add(n);
        return list;
    }

    static int maxForDig(int dig) {
        return (int) Math.pow(10,dig);
    }


    static int largestPalendromeMultiple(int dig) {
        int dig_max = maxForDig(dig);
        ArrayList<Integer> a_list = intlist_below(dig_max);
        ArrayList<Integer> b_list = intlist_below(dig_max);
        int max = 0;
        for (int ind = dig_max-1; ind >= 0; ind--) {
            int i = a_list.get(ind);

            for (int k = dig_max-1; k >= 0; k--) {
                int j =  b_list.get(k);
                int res = i*j;
                if (res > max) {
                    if (isPalendrome(res)) {
                        max=res;
                    }
                }
            }

        }
        return max;
    }

    static void t3()  {
        int digits = 3;
        pr(largestPalendromeMultiple(digits));
    }


    static boolean isDiv(int n, int by ) { return n % by == 0; }

    static boolean isDiv_by1to20(int n) {
        if (!isDiv(n, 19)) return false;
        if (!isDiv(n, 18)) return false;
        if (!isDiv(n, 17)) return false;
        if (!isDiv(n, 16)) return false;
        if (!isDiv(n, 15)) return false;
        if (!isDiv(n, 14)) return false;
        if (!isDiv(n, 13)) return false;
        if (!isDiv(n, 12)) return false;
        if (!isDiv(n, 11)) return false;
        if (!isDiv(n, 10)) return false;
        if (!isDiv(n, 9)) return false;
        if (!isDiv(n, 8)) return false;
        if (!isDiv(n, 7)) return false;
        if (!isDiv(n, 6)) return false;
        if (!isDiv(n, 5)) return false;
        if (!isDiv(n, 4)) return false;
        if (!isDiv(n, 3)) return false;
        if (!isDiv(n, 2)) return false;
        if (!isDiv(n, 1)) return false;
        return true;
    }

    static int smallest_divBy1to20() {
        int i = 2520;
        while (true){
            if (isDiv_by1to20(i)) return i;
            i++;
        }
    }

    static void t4() {
        pr(smallest_divBy1to20());
    }

    static int sum_of_squares(int up_to) {
        int sum = 0;
        for (int i = 1; i < up_to; i++) {
            sum+=(int) Math.pow(i,2);
        }
        return sum;
    }

    static int square_of_sum(int up_to) {
        int sum = 0;
        for (int i = 1; i < up_to; i++) {
            sum+=i;
        }
        return (int) Math.pow(sum,2);
    }

    static int diff_summSq_sqSum(int up_to) {
        return sum_of_squares(up_to) - square_of_sum(up_to);
    }

    static void t5() {
        pr(diff_summSq_sqSum(101));
    }

    static int getNth_prime(int n) {
        int k = 0;
        for (int i = 2; i > 0; i++) {
            if (isPrime(new BigInteger(String.valueOf(i)))) k++;
            if (k==n) return i;
        }
        return -1;
    }

    static void t6()  {
        pr(getNth_prime(10001));
    }

    static long int_str_product(String str) {
        long product = 1;
        for (char c: str.toCharArray()) {
            long i = Integer.parseInt(c+"");
            product*=i;
        }
        return product;
    }

    static int int_str_sum(String str) {
        int sum = 0;
        for (char c: str.toCharArray()) {
            int i = Integer.parseInt(c+"");
            sum+=i;
        }
        return sum;
    }

    static long substr_product(String s, int i, int j) { return int_str_product(s.substring(i, j)); }
    static int substr_sum(String s, int i, int j) { return int_str_sum(s.substring(i, j)); }

    static long max_substr(String s, int length) {
        long max = 0;
        int m = 0;
        for (int i = 0; i < s.length()-1 - length; i++) {
            long val = substr_product(s, i, i+length);
            if (val > max)  {
                max = val;
                m  = i;
            }
        }
//        pr(s.substring(m, m+length));
        return max;
    }

    public static void t7() {
        String s = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        pr(String.valueOf(max_substr(s, 13)));
    }

    public static boolean is_whole(double d) { return (double) Math.round(d) - d == 0; }

    public static boolean is_a_sq(int a) {
        double d = Math.sqrt(a);
        return is_whole(d);
    }

    public static int sq(int c) { return (int) Math.pow(c, 2); }

    /**
     * Takes a C and finds an A and B that would square it off
     */
    public static Tuple triplet_thatMatches(int c, int target) {
        int c_sq = sq(c);
        for (int b_sq = c_sq-1; b_sq > 0; b_sq--) {  // b ?
            if (is_a_sq(b_sq)) { // can be b^2
                int a_sq = (int)  c_sq - (b_sq); // a?
                if (is_a_sq(a_sq)) { // can be a^2
                    int a = (int) Math.sqrt(a_sq);
                    int b = (int) Math.sqrt(b_sq);
                    if (a + b + c == target)
                        return new Tuple(a, b);
                }
            }
        }
        return null;
    }


    public static boolean exists(Object o) { return o != null; }

    public static int find_1000_triplet() {
        int low = 1;
        int high = 990;
        for (int i = low; i < high; i++) {
            Tuple t = triplet_thatMatches(i, 1000);
            if (exists(t)) return t.a*t.b*i;
        }
        return -1;
    }

    public static void t8() {
        pr(find_1000_triplet());
    }

    public static boolean isPrime_web(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime_web(long num) {
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long sum_primes_below(long n) {
        long sum = 0;
        for (long i = 2; i < n; i++) {
            if (isPrime_web(i)) sum += i;
        }
        return sum;
    }

    public static long sum_even_primes_below(long n) {
        long sum = 0;
        for (long i = 2; i < n; i++) {
            if (isPrime_web(i)) sum += i;
        }
        return sum;
    }

    static void t9() {
        long cap = 2000000;
        String s = String.valueOf(sum_primes_below(cap));
        pr(s);
    }

    static int fibList_i(ArrayList<Integer> curr, int i) {
        if (i < 2) return 1;
        curr.add(fibList_i(curr,i-1) + (i-2));
        return fibList_i(curr,i-1);
    }

    static long fib(long n)  {
        if (n == 2) return 2;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    static ArrayList<Long> fibs_below(long n) {
        ArrayList<Long> fibs = new ArrayList<>();
        long fib_i = 0;
        for (long i = 1; fib_i < n; i++) {
            fib_i = fib(i);
            fibs.add(fib_i);
        }
        if (!fibs.isEmpty()) fibs.remove(fibs.size()-1);
        return fibs;
    }

    static ArrayList<Integer> fibList(int i) {
//        ArrayList<Integer> arr = fibList_i(new ArrayList<Integer>(), i);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        fibList_i(arr,i);
        arr.set(arr.size()-1, 2);
        return arr;
    }

    static void keep_evenValued(ArrayList<Number> list) {

        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).longValue() % 2 != 0) {
                list.remove(index);
                index--;
            }
        }
    }

    static long sum_list(ArrayList<Number> list) {
        long sum = 0;
        for (Number n: list) {
            sum += n.longValue();
        }
        return sum;
    }

    static void t1() {
        int max = 4000000;
        ArrayList arr = fibs_below(max);
        prArr(arr);
        keep_evenValued(arr);
        prArr(arr);
        pr(sum_list(arr));
    }


    public static void t10() {
        Table t =  new Table("source.txt");
       pr(String.valueOf(t.largest_diagonal()));
//        prArr(t.largest_diagonal_forPoint(12,6));
//        pr(t.downLeft_diagonal(12,6));
    }

    static long triangle_num_for(long n) {
        return n*(n-1)/2; // quick math shortcut
    }

    /**
     * The sequence of triangle numbers is generated by adding the natural numbers.
     * @return
     */
    static void add_next_triangle_number(LinkedList<Long> triangle_list) {
        long x = triangle_num_for(Long.valueOf(triangle_list.size()));
        triangle_list.add(x);
    }
    static void prr(Object o) {System.out.print(o);}

    static void t11() {
        LinkedList<Long> tls = new LinkedList<>();
        tls.add(Long.valueOf(1));
        int factorz = 1;
        int high = 0;
        while (factorz <500) {
            if (factorz != -1) {
                prr("\n"+ tls.size() + ". " + String.valueOf(tls.get(tls.size() - 1)) + " => " + factorz);
                if (factorz > 350) prr("   <<<<<<<<****************************************|||||||||       ");
                else if (factorz > 300) prr("   <<<<<<<<*********************************|||||||||         ");
                else if (factorz > 250) prr("   <<<<<<<<*****************************|||||||||             ");
                else if (factorz > 200) prr("   <<<<<<<<***********************|||||||||                   ");
                else if (factorz > 150) prr("   <<<<<<<<***************|||||||||                           ");
                else if (factorz > 100) prr("   <<<<<<<<***********|||||||||                               ");
                else if (factorz > 50) prr("    <<<<<<<<*******|||||||||                                   ");
                else prr("   <<<<<<<<******|||||||||                                                       ");
                pr("      (" + high+")");
            }
            add_next_triangle_number(tls);
            factorz = num_factors_MODIFIED(tls.get(tls.size()-1));
            if (factorz > high) high = factorz;
        }
        pr(String.valueOf(tls.get(tls.size()-1)));
    }


    public static void main(String[] args) {
        t11();
    }
}


