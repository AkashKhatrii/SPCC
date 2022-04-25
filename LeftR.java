import java.util.Scanner;

public class LeftR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of productions: ");
        int n = sc.nextInt();
        String []prods = new String[n];

        System.out.println("Enter productions: ");
        for(int i = 0; i < n; i ++){
            prods[i] = sc.next();
        }

        System.out.println("\nGrammar Without Left Recursion(# indicates epsilon): ");
        for(int i = 0; i < n; i ++){
            char non_t = prods[i].charAt(0);
            String alpha = "";
            String beta = "";
            if(prods[i].charAt(3) == non_t){
                int index = 4;

                while(prods[i].charAt(index) != '|' && index < prods[i].length() ){

                    alpha += prods[i].charAt(index);
                    index ++;
                }

                if(index == prods[i].length()){
                    System.out.println("Can't be reduced");
                }


                else {
                    index++;

                    while (index < prods[i].length())
                    {
                        beta += prods[i].charAt(index);
                        index++;
                    }

                }

                System.out.println(non_t  + "->" + beta + non_t +"'");
                System.out.println(non_t + "'->" + alpha + non_t + "'|#" );
            }

            else{
                System.out.println(prods[i]);
            }


        }

    }
}
