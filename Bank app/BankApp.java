import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Acc {
    private static int NAccN = 1001;
    private String AccH;
    private int AccN;
    private double Ball;
    private ArrayList<String> TransH;

    public Acc(String H, double IB) {
        this.AccH = H;
        this.Ball = IB;
        this.AccN = NAccN++;
        this.TransH = new ArrayList<>();
        TransH.add("Account Created with Balance:" + IB + " | On: " + new Date());
    }

    public int getAccNo() {
        return AccN;
    }

    public double getBalance() {
        return Ball;
    }

    public void deposit(double A) {
        if (A > 0) {
            Ball += A;
            TransH.add("Deposit:" + A + " | Balance:" + Ball + " | Date: " + new Date());
            System.out.println("Deposit Successful.... Current Balance is:" + Ball);
        } else {
            System.out.println("Invalid Amount...");
        }
    }

    public void withdraw(double A) {
        if (A > 0 && A <= Ball) {
            Ball -= A;
            TransH.add("Withdraw:" + A + " | Balance: " + Ball + " | On: " + new Date());
            System.out.println("Withdrawal Successful... Current Balance: " + Ball);
        } else {
            System.out.println("Insufficient Balance or Invalid Amount");
        }
    }

    public void showAccDetails() {
        System.out.println("Account Details:");
        System.out.println("Holder: " + AccH);
        System.out.println("Account No: " + AccN);
        System.out.println("Balance:" + Ball);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for A/C No: " + AccN);
        for (String H : TransH) {
            System.out.println(H);
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Acc> accounts = new ArrayList<>();

        while (true) {
            System.out.println("===== BANK HOME PAGE =====");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Account Details");
            System.out.println("4. Transaction History");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance:");
                    double initialBalance = sc.nextDouble();
                    Acc newAcc = new Acc(name, initialBalance);
                    accounts.add(newAcc);
                    System.out.println("Account created successfully!");
                    newAcc.showAccDetails();
                    break;

                case 2:
                    Acc acc2 = findAccount(accounts, sc);
                    if (acc2 != null) {
                        System.out.println("Current Balance:" + acc2.getBalance());
                    }
                    break;

                case 3:
                    Acc acc3 = findAccount(accounts, sc);
                    if (acc3 != null) {
                        acc3.showAccDetails();
                    }
                    break;

                case 4:
                    Acc acc4 = findAccount(accounts, sc);
                    if (acc4 != null) {
                        acc4.printTransactionHistory();
                    }
                    break;

                case 5:
                    Acc acc5 = findAccount(accounts, sc);
                    if (acc5 != null) {
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        acc5.deposit(dep);
                    }
                    break;

                case 6:
                    Acc acc6 = findAccount(accounts, sc);
                    if (acc6 != null) {
                        System.out.print("Enter withdrawal amount:");
                        double with = sc.nextDouble();
                        acc6.withdraw(with);
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the bank app!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice......");
            }
        }
    }

    public static Acc findAccount(ArrayList<Acc> accounts, Scanner sc) {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        for (Acc account : accounts) {
            if (account.getAccNo() == accNo) {
                return account;
            }
        }
        System.out.println("Account not found....!");
        return null;
    }
}
