public class pr-1.3 {
    public static void main(String[] args) {
        if(args.length != 2)
        {
            System.out.println("please Enter two commandline arguments.");
            System.out.println("Example java pr3 10 20");
            return ;
        }
        Double num1 = Double.parseDouble(args[0]);
        Double num2 = Double.parseDouble(args[1]);
        Double sum = num1 + num2 ;
        Double product = num1 * num2 ;
        System.out.println("value of num1 :" + num1);
        System.out.println("value of num2 :" +num2);
        System.out.println("Sum is :" +sum);
        System.out.println("Product  is :" + product);
    }
}