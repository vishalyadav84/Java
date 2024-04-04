//WAP to find gratest number is two unequal number
import java.util.*;
class Kiet{
    public static void main(String [] a){
        int num1,num2;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number:");
        num1=sc.nextInt();
        System.out.print("Enter the second number:");
        num2=sc.nextInt();
        if(num1>num2){
            System.out.println("gratest number="+num1);
        }
        else{
            System.out.println("greatest number="+num2);
        }
    }
}