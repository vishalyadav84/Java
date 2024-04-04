// WAP to find gratest number in three unequal number
import java.util.*;
class p5{
    public static void main(String[]arg){
        int a,b,c;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number:");
        a=sc.nextInt();
        System.out.print("Enter the Second number:");
        b=sc.nextInt();
        System.out.print("Enter the third number");
        c=sc.nextInt();
        if(a>b&&a>c){
            System.out.println("Gratest number="+a);
        }
        else if (b>a && b>c){
            System.out.println("Gratest number="+b);
        }
        else {
            System.out.println("Gratest numbetr="+c);
        }
    }

}