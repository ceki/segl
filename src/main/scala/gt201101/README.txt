
The code found in this folder solves Euler project's problem 7:

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
see that the 6th prime is 13.

What is the 10001st prime number?

Source: http://projecteuler.net/index.php?section=problems&id=7

Remarks
=======

The code found in OptimizedEuler7, completing in ~100ms, is about 5 times slower
than the code in JavaEuler7, completing in ~20ms. However, JavaEuler7 only tests
for known primes whereas OptimizedEuler7  tests for 3,5,7,..,n,n+2. Given that for
numbers approaching 10'000, the frequency of prime numbers (see [1]) is 1 in ln(10000),
the 5 fold drop in performance is due to the algorithm and not the language,
which is rather remarkable in light of the differences in style.

With Scala 2.7.1, the slowness of ImplerativeEuler7.scala which completes
in 1.2 seconds, is rather surprising and still baffles me. An earlier
version which used a mutable ListBuffer was even slower and just as
baffling. With Scala 2.8.1, ImplerativeEuler7.scala using a ListBuffer
completes in 55 milliseconds.

[1] http://en.wikipedia.org/wiki/Prime_number_theorem

