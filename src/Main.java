import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Ships sh = new Ships();
        Board br = new Board();

        Scanner in = new Scanner(System.in);
        for(int y = 0 ; y < 2; y++ ){
            System.out.println("Please enter column and row");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            if(sh.getHit(num1,num2)){
                br.hit(num1,num2);
            }else br.miss(num1,num2);

        }
        Thread.sleep(4000);
        System.out.println("\n\nBoard Now");
        br.write();
    }
}
