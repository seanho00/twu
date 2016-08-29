/*
 * The Towers Of Hanoi
 * Java
 * Copyright (C) 1999 Amit Singh. All Rights Reserved.
 * http://hanoi.kernelthread.com
 *
 * Tested under Linux jdk-1.1.?
 */

public class Hanoi {
  public static void main (String args[]) {
    if (args.length != 1) {
      System.err.println("error: a single integer argument needed");
      System.exit(1);
    }
    Integer N = new Integer(args[0]);
    dohanoi(N.intValue(), 3, 1, 2);
    System.exit(0);
  }

  static void dohanoi(int n, int t, int f, int u) {
    if (n > 0) {
      dohanoi(n-1, u, f, t);
      move(f, t);
      dohanoi(n-1, t, u, f);
    }
  }

  static void move(int from, int to) {
    System.out.print("move ");
    System.out.print(from);
    System.out.print(" --> ");
    System.out.println(to);
  }
}
