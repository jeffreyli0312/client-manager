/* Client.java
Name: Jeffrey Li and Simon Feng

//Description: This program creates a Client Management System for AYJ VetTech */

import java.util.*;
import java.io.*;

abstract class Client { // Client Abstract Class
   protected int clientNumber;
   protected String firstName;
   protected String lastName;
   protected String petName;
   protected double balance; // protected instance fields
   
   /* Client (int cN, String fN, String lN, String pN, double b)
   This Constructor method takes in client number, name, pet name, and balance to create a Client */
   public Client (int cN, String fN, String lN, String pN, double b){
      this.clientNumber = cN;
      this.firstName = fN;
      this.lastName = lN;
      this.petName = pN; // constructor method initializes all fields of client object
      this.balance = b;
   }
   
   /* bill(double bill)
   This abstract method cacululates and returns a bill */
   abstract double bill(double bill); // bill
   
   /* Boolean acceptPayment(double payment)
   This abstract method takes a payment double and returns a boolean */
   abstract Boolean acceptPayment(double payment); // acceptPayment
   
   /* chargeForService(String type, double baseCost)
   This abstract method takes type of service and cost of service, and charges client */
   abstract public void chargeForService(String type, double baseCost); // chargeForService
   
   /* resetServices()
   This abstract method resets all yearly free services */
   abstract void resetServices(); // resetServices
   
   /* printBill()
   This abstract method prints the bills for all clients */
   abstract void printBill (); // printBill
   
   /* String toString()
   This abstract method converts all client into to a string */
   public String toString (){ // toString - returns info
      return this.clientNumber + " " + this.firstName + " " + this.lastName + " " + this.petName;
   }

}





