import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

class Input
{
    public Input()
    {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.nextLine();
        InputExpression = new ArrayList<String>(Arrays.asList(s.split("\\s+")));
        if (InputExpression.get(0).equals("("))
            InfixToPrefix();
        else if (Precedence(InputExpression.get(0)) == 0)
            PostfixToPrefix();
        System.out.println();
        for (int i = 0; i < InputExpression.size(); i++)
            System.out.println(InputExpression.get(i));
    }

    public int Precedence(String Optr)
    {
        if (Optr.equals("not"))
            return 7;
        else if (Optr.equals("*") || Optr.equals("/") || Optr.equals("div") || Optr.equals("mod"))
            return 6;
        else if (Optr.equals("+") || Optr.equals("-"))
            return 5;
        else if (Optr.equals("<") || Optr.equals("<=") || Optr.equals(">") || Optr.equals(">="))
            return 4;
        else if (Optr.equals("==") || Optr.equals("!="))
            return 3;
        else if (Optr.equals("and"))
            return 2;
        else if (Optr.equals("or"))
            return 1;
        else
            return 0;
    }

    public void InfixToPrefix()
    {
        ArrayList<String> temp = new ArrayList<String>(InputExpression);
        InputExpression.clear();
        Stack<String> s = new Stack<String>();
        String temp1, temp2;

        Collections.reverse(temp);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals("("))
                temp.set(i, ")");
            else if (temp.get(i).equals(")"))
                temp.set(i, "(");
        }

        while (!temp.isEmpty()) {
            temp1 = temp.get(0);
            temp.remove(0);
            if (Precedence(temp1) > 0) {
                label :
                    if (s.empty())
                        s.push(temp1);
                    else {
                        if (s.peek() == "(")
                            s.push(temp1);
                        else if (Precedence(s.peek()) < Precedence(temp1))
                            s.push(temp1);
                        else if (Precedence(s.peek()) == Precedence(temp1)) {
                            temp2 = s.pop();
                            InputExpression.add(temp2);
                            s.push(temp1);
                        }
                        else if (Precedence(s.peek()) > Precedence(temp1)) {
                            temp2 = s.pop();
                            InputExpression.add(temp2);
                            break label;
                        }
                    }
            }
            else if (temp1 == "(") {
                s.push(temp1);
            }
            else if (temp1 == ")") {
                temp2 = s.pop();
                while (temp2 != "(") {
                    InputExpression.add(temp2);
                    temp2 = s.pop();
                }
            }
            else
                InputExpression.add(temp1);
        }
        while (!s.empty()) {
            temp1 = s.pop();
            InputExpression.add(temp1);
        }
        Collections.reverse(InputExpression);
    }

    public void PostfixToPrefix()
    {
    }

    private ArrayList<String> InputExpression;
};
