class RecursionProbs {

  static int numEars(int bunnies) {
    if (bunnies == 1) {
      return 2;
    } else {
      return 2 + numEars(bunnies - 1);
    }
  }

  static void countdown(int num) {
    if (num == 0) {
      System.out.println("blastoff!");
    } else {
      System.out.println(num);
      countdown(num - 1);
    }
  }

  static int factorial(int num) {
    if (num == 0 || num == 1) {
      return 1;
    } else {
      return num * factorial(num - 1);
    }
  }

  static String cheerlead(String str, int i) {
    if (i == 0) {
      return "";
    }
    if (i == 1) {
      return str;
    } else {
      return cheerlead(str, i - 2).repeat(i);
    }
  }

  static int pow(int base, int exp) {
    if (exp == 0) {
      return 1;
    } else {
      return base * pow(base, exp - 1);
    }
  }

  static int nthFib(int num) {
    if (num == 0) {
      return 0;
    }
    if (num == 1) {
      return 1;
    } else {
      return nthFib(num - 1) + nthFib(num - 2);
    }
  }

  static void printPattern(int num) {
    if (num < 0) {
      System.out.println(num);
    } else {
      System.out.println(num);
      printPattern(num - 5);
    }
  }

  static int countNumA(String str) {
    if (str.indexOf('a') == -1) {
      return 0;
    } else {
      // Loop approach for reference purposes
      int count = 0;
      char[] list = str.toCharArray();
      for (char ch : list) {
        if (ch == 'a') {
          count++;
        }
      }
      return count;
    }
  }

  static void printAtoBbyC(int a, int b, int c) {
    if (c == 1) {
      for (int i = a; i <= b; i++) {
        System.out.println(i + "");
      }
    }
  }

  static int countOdds(int num) {
    int numOdd = 0;
    String str = String.valueOf(num);
    for (int i = 0; i < str.length(); i++) {
      if (((int) str.charAt(i)) % 2 != 0) {
        numOdd++;
      }
    }
    if (numOdd == 0) {
      return 0;
    } else {
      return 0;
    }
  }

  static int sumDigits(int num) {
    if (num == 0) {
      return 0;
    }
    if (String.valueOf(num).length() == 1) {
      return num;
    } else {
      return num % 10 + sumDigits(num / 10);
    }
  }
}
