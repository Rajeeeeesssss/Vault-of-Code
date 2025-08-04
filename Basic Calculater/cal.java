import java.util.Scanner;

class Add{
    int add(int a, int b){
         return a+b;
     }
    }
class Sub{
    int sub(int a, int b){
         return a-b;
     }
    }
class Mul{
    int mul(int a, int b){
         return a*b;
     }
    }
class Div {
    Double div(int a, int b) {
        if (b == 0) { 
            System.out.println("Division not possible.......");
            return 0.0; 
        } else {
            return (double) a / b;
        }
    }
}

public class cal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Add ob1 = new Add();
        Sub ob2 = new Sub();
        Mul ob3 =new Mul();
        Div ob4 = new Div();

        while (true) {
            
        
        System.out.println(" Enter your choice:");
        System.out.println("1: Addition");
        System.out.println("2: Subtraction");
        System.out.println("3: Multiplecation");
        System.out.println("4: Division");
        System.out.println("5: exit");
        int c = sc.nextInt();
         if ( c==5){
            System.out.println("Exiting...");
            break;
         }
        
        System.out.println("Enter 1st No:");
        int a = sc.nextInt();
         System.out.println("Enter 2nd No:");
        int b = sc.nextInt();
       
        switch (c) {
            case 1:
                System.out.println("Addition is :"+ob1.add(a,b));
                break;
            case 2:
                System.out.println("Subtraction is :"+ob2.sub(a,b));
                break;
            case 3:
                System.out.println("Multiplection is :"+ob3.mul(a,b));
                break;
            case 4:
                System.out.println("Addition is :"+ob4.div(a,b));
                break;
            default:
                System.out.println("invalid choice......");
                break;
        }
     }
    
       sc.close();
        
       
    }
}