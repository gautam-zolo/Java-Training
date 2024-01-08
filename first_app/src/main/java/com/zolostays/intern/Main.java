//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

package com.zolostays.intern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the calculator");
        float a=5,b=0,result=-1;
        char op ='/';

        do{

          if(op == '+'){
            result = a+b;
            break;
          }
          else if(op =='-'){
            result = a-b;
            break;
          }

          else if(op =='/'){

            try{
                result = a/b;
                break;
            }
            catch(ArithmeticException e){
                System.out.println("Dont use 0 as divisor. ");
                System.out.println("Error Generated: " + e);
            }

            break;
          }
          else if(op =='x'){
            result = a*b;
            break;
          }
          else if(op =='%'){
            result = a%b;
            break;
          }
          else
            System.out.println("Incorrect operand, choose again: ");
        }while( op !='+'||op!='-'||op!='%'||op!='x'||op!='/');

      System.out.println("The result is: "+result);

    }
}

int year,int month,int day;
int curDate= LocalDate.of(year,month,day);
