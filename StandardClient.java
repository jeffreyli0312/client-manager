/* StandardClient.java
Name: Jeffrey Li and Simon Feng

Description: This program (StandardClient) extends client */

import java.util.*;
import java.io.*;
// StandardClient
class StandardClient extends Client {
   private static int YEARLYFREECHECKUPS = 5; // constants
   protected int freeCheckupsLeft = YEARLYFREECHECKUPS; // protected variables
   
   /* StandardClient(int cN, String fN, String lN, String pN, double b, int fCL)
   This constructor method constructs a new Standard Client with client number,
   first and last name, pet name, balance, and free checkups */
   public StandardClient (int cN, String fN, String lN, String pN, double b, int fCL){ // constructor method
      super(cN, fN, lN, pN, b); // call super constructor
      this.freeCheckupsLeft = fCL;
   }
   
   /* int getfreeCheckupsLeft() 
   This accessor method returns the number of free checkups remaining */
   public int getfreeCheckupsLeft() {
      return freeCheckupsLeft; // return remaining amount
   }
   
   /* double bill (double bill)
   This accessor method returns the balance of a standard client */
   public double bill (double bill){ 
      return this.balance; // return balance
   }
   
   /* Boolean acceptPayment (double payment)
   This method accepts a payment from a standard client, and returns is balance is paid off or not */
   public Boolean acceptPayment (double payment){
      if (this.balance == payment){ // paid off
         this.balance = 0; // set balance
         return true;
      } else { // not paid off
         return false;
      } 
   }
   
   /* chargeForService (String name, double baseCost)
   This method charges a standard client for a service */
   public void chargeForService (String name, double baseCost){
      if (name.equals("Checkup") || name.equals("checkup")){ // checkup
         if (this.freeCheckupsLeft > 0){ // has free checkups remaining
            this.freeCheckupsLeft = this.freeCheckupsLeft - 1; // reduce number
         } else {
            this.balance = this.balance + baseCost; // add to balance
         }
      } else {
         this.balance = this.balance + baseCost; // add to balance
      }  
   }
   
   /* resetServices ()
   This method resets all free yearly services for a standard client */
   public void resetServices (){
      this.freeCheckupsLeft = YEARLYFREECHECKUPS; // reset free checkups left
   }
   
   /* printBill ()
   This method prints the bill for a standard client with all their info */
   public void printBill (){ 
      System.out.println ("Name: " + this.firstName + " " + this.lastName);
      System.out.println ("Client Number : " + this.clientNumber);
      System.out.println ("Pet name: " + this.petName); // print all info
      System.out.println ("Your balance: " + this.balance);
      System.out.println ("You have " + freeCheckupsLeft + " checkups remaining.");
      System.out.println ("You owe $" + this.balance + ".");
   }
   
   /* String toString ()
   This method converts all info of a standard client to a string and returns it */
   public String toString (){
      return "Standard " + super.toString(); // print standard, call super
   }

}



