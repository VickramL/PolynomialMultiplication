import java.util.Scanner;

public class PolynomialExpression {
    static int numberOfExpression;
    static Expression[] expressions;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of Expressions : ");
        numberOfExpression = input.nextInt();
        expressions = new Expression[numberOfExpression];
        for(int i = 0;i < numberOfExpression;i++){
            Expression expression = new Expression();
            System.out.print("Enter the number of Terms of Expression"+(i+1)+" : ");
            int terms = input.nextInt();
            expression.insertTerm(terms);
            expressions[i] = expression;
        }

        for(int i = 1;i < numberOfExpression;i++){

            Expression expression = new Expression();
            expression.multiply(expressions[i-1],expressions[i]);
            expressions[i] = expression;
            for(int j = i;j<numberOfExpression;j++){
                printExpression(expressions[j]);
            }
            System.out.println();
        }
    }
    private static void printExpression(Expression expression) {
        System.out.print("(");
        Expression.Term temp1 = expression.termsList;
        while (temp1 != null){
            System.out.print(temp1.coefficient<0?"-":"+");
            System.out.print("("+Math.abs(temp1.coefficient));
            for(int i = 0;i<3;i++){
                if(temp1.variable[i]!=0) System.out.print((char)(i+'x')+"^"+temp1.variable[i]);
            }
            System.out.print(")");
            temp1 = temp1.next;
        }
        System.out.print(") ");
    }
}
