package gt201101;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ceki G&uuml;c&uuml;
 */

class JavaEuler7 {

  List<Integer> primes = new ArrayList<Integer>();
  int limit = 10001;

  JavaEuler7() {
    primes.add(2);
  }

  void initPrimeList() {
  int i = 3;
    while (primes.size() < limit) {
      if (isPrime(i))
        primes.add(i);
      i += 2;
    }
  }

  boolean isPrime(int n) {
    for (int i = 0; i < primes.size(); i++) {
      int p = primes.get(i);
      if (n % p == 0) return false;
      if (p * p > n) return true;
    }
    throw new IllegalStateException("failed to determine primality of [" + n + "]" + primes);
  }


  // runs in about 21 milliseconds
  public static void main(String[] args) {
    JavaEuler7 je7 = new JavaEuler7();
    long start = System.currentTimeMillis();
    je7.initPrimeList();
    long end = System.currentTimeMillis();
    System.out.println("initPrimeList() operation took "+(end-start)+"milliseconds");

  }
}