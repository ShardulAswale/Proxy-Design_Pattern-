package proxy;

import java.util.Scanner;

public class Proxy {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name");
        String name = s.nextLine();
        System.out.println("Enter opening balance");
        double bal = s.nextInt();
        proxybank b=new proxybank(bal,name);
        int x;
        boolean bol=true;
        while (bol==true){
            System.out.println("\nChoose \n1.deposit\n2.withdraw");
            x= s.nextInt();
            switch (x){
                case 1: System.out.println("enter money to deposit");
                        double money= s.nextDouble();
                        b.deposit(money);break;
                case 2: System.out.println("enter money to withdraw");
                        money= s.nextDouble();
                        b.withdraw(money);break;
                case 3:bol=false;break;
                default:System.out.println("invalid selection");break;
            }
        }
    }
    
}
class proxybank{
    private final String name;
    private double money=0.0;
    bank b;    
    public proxybank(double money,String name){
            b = new bank(money,name);
            this.money=money;
            this.name=name;
        }

        public void deposit(double money){
            this.money+=money;
            b.deposit(money);
        }
        public void withdraw(double money){
            if(this.money>money){
                this.money-=money;
                b.withdraw(money);
                System.out.println("Collect your cash");
            }
            else
                System.out.println("Insufficient funds");
        }
        
}
class bank{
    private final String name;
    private double money=0.0;
        public bank(double money,String name){
            this.money=money;
            this.name=name;
        }
        public void deposit(double money){
            this.money+=money;
        }
        public void withdraw(double money){
            if(this.money>money){
                this.money-=money;
                System.out.println("Collect your cash");
            }
            else
                System.out.println("Insufficient funds");
        }
        
}