package Morpheme;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Morpheme {
    public static List<String> evaluation(String expression){
        List<String> tokens = new ArrayList<>();

        int i = 0;
        while(i < expression.length()){
            switch (expression.charAt(i)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':{
                    StringBuilder number = new StringBuilder();
                    while(i < expression.length() && Character.isDigit(expression.charAt(i))){
                        number.append(expression.charAt(i));
                        i++;
                    }
                    tokens.add(number.toString());
                }
                break;

                case '-':{
                    if((tokens.size() == 0)
                            || tokens.get(tokens.size()-1).equals("(")
                            || tokens.get(tokens.size()-1).equals("+")
                            || tokens.get(tokens.size()-1).equals("-")
                            || tokens.get(tokens.size()-1).equals("/")
                            || tokens.get(tokens.size()-1).equals("*")){
                        StringBuilder number = new StringBuilder();
                        number.append('-');
                        i++;
                        if(!Character.isDigit(expression.charAt(i))){
                            throw new InvalidParameterException("Invalid expression");
                        }
                    }

                }
                break;

                case '+':
                case '*':
                case '/':
                case '(':
                case ')':{
                    tokens.add(String.valueOf(expression.charAt(i)));
                    i++;
                }

                break;

                case ' ':
                case '\t':{
                    i++;
                }
                break;

                default:
                {
                    throw new InvalidParameterException("Invalid expression");
                }
            }
        }
        return tokens;
    }
}

/* String syn;
    List<String> list = new ArrayList(){};
    public Morpheme(String syn){
        this.syn = syn;
        char[] array = syn.toCharArray();
        for(int i = 0;i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println();

    }
    public void ArrayMorpheme(){
        String[] c = {"/","+","*","-"};

    }

    public static void main(String[] args) {
        Morpheme mp1 = new Morpheme("123456+3");
        Morpheme mp2 = new Morpheme("(1+2)/4");
    }

*/
