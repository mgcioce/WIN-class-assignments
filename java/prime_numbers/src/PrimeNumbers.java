import java.math.BigInteger;

public class PrimeNumbers {

    public static boolean isPrime(BigInteger n) {
        boolean returnValue = false;
        BigInteger one = new BigInteger("1");
        BigInteger nMinusOne = n.subtract(one);
        BigInteger nMinusOneFactorial = factorial(nMinusOne,one);
        if (nMinusOneFactorial.compareTo(new BigInteger("-1")) == 0 ) {
            throw new ArithmeticException("invalid factorial computation");
        }
        if (nMinusOneFactorial.mod(n).compareTo(nMinusOne) == 0 && n.compareTo(one) != 0) {
            returnValue = true;
        }
        return returnValue;
    }

    public static BigInteger factorial(BigInteger n, BigInteger one) {

        try{
            //validation testing
            BigInteger testOne = new BigInteger("1");
            if (one.compareTo(testOne) != 0) {
                one = testOne;
            }
            if (n.compareTo(new BigInteger("0")) < 0) {
                throw new ArithmeticException("factorials are not defined for negative numbers");
            }
            //algorithm
            if (n.compareTo(one) < 0) {
                return one;
            }
            BigInteger nMinusOne =  n.subtract(one);
            return n.multiply(factorial(nMinusOne,one));
        } catch (Exception e) {
            e.printStackTrace();
            return new BigInteger("-1");
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String nextInt = Integer.toUnsignedString(i);
            BigInteger nextN = new BigInteger(nextInt);
            if (isPrime(nextN)) {
                System.out.println(nextInt + " is prime");
            }
        }
    }
}
