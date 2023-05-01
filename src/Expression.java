import java.util.Scanner;

public class Expression {
    Term termsList;
    Term temp;

    public static class Term{
        int coefficient;
        int[] variable;
        Term next;

        public Term(int coefficient,int[] variable){
            this.coefficient = coefficient;
            this.variable = variable;
            this.next = null;
        }
    }

    public Expression(){
        this.termsList = null;
        this.temp = null;
    }
    public void insertTerm(int numberOfTerms){
        Scanner input = new Scanner(System.in);
        int coefficient,numberOfVar;

        for(int i = 0;i<numberOfTerms;i++){
            System.out.print("Enter the coefficient"+(i+1)+" : ");
            coefficient = input.nextInt();
            System.out.print("Enter the number of variables (0-3) : ");
            numberOfVar = input.nextInt();
            int[] variables = new int[3];
            for(int j = 0; j <numberOfVar; j++){
                System.out.print("Enter the variable"+(j+1)+" : ");
                char var = input.next().charAt(0);
                System.out.print("Enter the exponent"+(j+1)+" : ");
                variables[var-'x'] = input.nextInt();
            }
            insert(new Term(coefficient,variables));
        }
    }

    public void insert(Term currTerm){
        if(termsList == null){
            termsList = currTerm;
            temp = termsList;
        }else {
            temp.next = currTerm;
            temp = temp.next;
        }
    }

    public void multiply(Expression expression1, Expression expression2) {
        Term temp1 = expression1.termsList, temp2 = expression2.termsList;
        while(temp1 != null){
            temp2 = expression2.termsList;
            while (temp2 != null){
                int coeff = temp1.coefficient*temp2.coefficient;
                int[] variables = new int[3];
                for(int i =  0;i<3;i++){
                    variables[i] = temp1.variable[i]+temp2.variable[i];
                }
                insert(new Term(coeff,variables));
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }
}
