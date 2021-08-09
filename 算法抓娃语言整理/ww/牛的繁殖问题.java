package com.qimo.undo;
/*
Description

Cows in the FooLand city are interesting animals. One of their specialties is related to producing offsprings. A cow in FooLand produces its first calve (female calf) at the age of two years and proceeds to produce other calves (one female calf a year).

Now the farmer Harold wants to know how many animals would he have at the end of N years, if we assume that none of the calves die, given that initially, he has only one female calf?

explanation:At the end of 1 year, he will have only 1 cow, at the end of 2 years he will have 2 animals (one parent cow C1 and other baby calf B1 which is the offspring of cow C1).At the end of 3 years, he will have 3 animals (one parent cow C1 and 2 female calves B1 and B2, C1 is the parent of B1 and B2).At the end of 4 years, he will have 5 animals (one parent cow C1, 3 offsprings of C1 i.e. B1, B2, B3 and one offspring of B1).


Input

The first line contains a single integer T denoting the number of test cases. Each line of the test case contains a single integer N as described in the problem.


Output

For each test case print in new line the number of animals expected at the end of N years modulo 10^9 + 7.


Sample Input 1

2
2
4
Sample Output 1

2
5
* */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 牛的繁殖问题 {
    private static final int MOD = 1_000_000_000+7;

    public static void main (String[] args) {
        Map<Long, Integer> cache = new HashMap<>();
        cache.put(0L, 0);
        cache.put(1L, 1);
        cache.put(2L, 1);

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            System.out.println(f(n+1, cache));
        }
    }

    private static int f(long n, Map<Long, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long t;
        if (n % 2 == 0) {
            long fn = f(n/2, cache);
            long fn1 = f(n/2+1, cache);
            long d = (2*fn1-fn);
            if (d < 0) {
                d += MOD;
            }
            t = fn*d;
        } else {
            long fn = f(n/2, cache);
            long fn1 = f(n/2+1, cache);
            t = fn1*fn1 + fn*fn;
        }

        t %= MOD;
        cache.put(n, (int)t);
        return (int)t;
    }
}
