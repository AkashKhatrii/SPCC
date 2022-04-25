import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LA {

    static boolean iskeyword(String c){
        String []keywords = {"int", "float", "main", "void", "(", ")", "{", "}"};
        for(int i = 0; i < keywords.length; i ++){
            if(c.equals(keywords[i])){
                return true;
            }
        }

        return false;
    }

    static boolean isOperator(String c){
        String []operators = {"+", "-", "*", "/", "="};
        for(int i = 0; i < operators.length; i++){
            if(c.equals(operators[i])){
                return true;
            }
        }

        return false;
    }

    static boolean isIdentifier(String s){
        for(int i = 0; i < s.length(); i ++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }

        return true;
    }

    static boolean isConstant(String s){
        try {
            int intValue = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isDelimiter(String s){
        if(s.equals(";")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {


        List<String> keywords = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        List<String> identifiers = new ArrayList<>();
        List<String> constant = new ArrayList<>();
        List<String> delimiter = new ArrayList<>();


        File f1 = new File("lexical.txt");
        f1.exists();

        Scanner sc = new Scanner(f1);

        while(sc.hasNextLine()){

            String data=sc.nextLine();
//            System.out.println(data);

            String []words = data.split(" ");

//            List<String> arr = new ArrayList(Arrays.asList(words));

            List<String> arr = new ArrayList<String>();
            arr.addAll(Arrays.asList(words));

            String s = "", deli = "";
            int index = -1;
            boolean flag = false;
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i).charAt(arr.get(i).length() - 1) == ';'){
                    s = arr.get(i).substring(0, arr.get(i).length() - 1);
                    deli = Character.toString(arr.get(i).charAt(arr.get(i).length() - 1));
                    index = i;
                    flag = true;

                }
            }

            if(flag) {
                arr.remove(index);
                arr.add(s);
                arr.add(deli);
            }
            for(int i = 0; i < arr.size(); i ++){

                if(iskeyword(arr.get(i))){
                    keywords.add(arr.get(i));
                }

                else if(isOperator(arr.get(i))){
                    operators.add(arr.get(i));

                }

                else if(isIdentifier(arr.get(i))){
                    identifiers.add(arr.get(i));

                }

                else if(isConstant(arr.get(i))){
                    constant.add(arr.get(i));

                }

                else if(isDelimiter(arr.get(i))){
                    delimiter.add(arr.get(i));
                }
                else{
                    System.out.println("");
                }

            }
        }


        System.out.println("Keywords: " + Arrays.toString(keywords.toArray()) +"\n");
        System.out.println("Operators: " + Arrays.toString(operators.toArray()) +"\n");
        System.out.println("Identifiers: " + Arrays.toString(identifiers.toArray()) +"\n");
        System.out.println("Constants: " + Arrays.toString(constant.toArray()) +"\n");
        System.out.println("Delimiters: " + Arrays.toString(delimiter.toArray()) +"\n");


    }
}

