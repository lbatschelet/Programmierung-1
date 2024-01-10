public class Theory {
    
    public static void main(String[] args) {
        
        int result1, num1 =25, num2 = 4;
        double result2, num3 = 16.0;

        // result1 = num1 / num3;

        // System.out.println("result1 = " + result1);


        result2 = (double) num1 / num2;

        System.out.println("result2 = " + result2);

        result2 = num1 / num2;

        System.out.println("result2 = " + result2);

        // result1 = num3 / num2;

       //  System.out.println("result1 = " + result1);

        result2 = num1 / (int) num3;

        System.out.println("result2 = " + result2);

        Integer val = 5;

        System.out.println("val = " + val);

        tripple(val);

        System.out.println("val = " + val);

    

    }

    private static Integer tripple(Integer val) {
        val *= 3;
        System.out.println("val = " + val);
        return val;
    }
}
