/* PremiumClient.java
   Programmer: Simon Feng and Jeffrey Li
   ___
 The subclass of Client for the Premium Clients */


//PremiumClient
class PremiumClient extends Client {
   private static int YEARLYFREEGROOMING = 5; // constants
   private static int YEARLYFREELABTESTS = 5;
   private static double PERCENTDISCOUNT = 0.05;
   private static double MEMBERSHIPFEE = 50;
   private static double INTERESTRATE = 0.02;
   private double outstandingBalance;
   protected int freeGroomingLeft = YEARLYFREEGROOMING; // protected variables
   protected int freeLabTestsLeft = YEARLYFREELABTESTS; 

   /* PremiumClient(int cN, String fN, String lN, String pN, double b, int freeGL, int freeLTL)
   This constructor method constructs a new Premium Client with client number,
   first and last name, pet name, balance, yearly grooming, and yearly lab tests */
   public PremiumClient(int cN, String fN, String lN, String pN, double b, int freeGL, int freeLTL) {
      super(cN, fN, lN, pN, b); // call super
      this.freeGroomingLeft = freeGL;
      this.freeLabTestsLeft = freeLTL;
   }

   /* int getfreeGroomingLeft() 
   This accessor method returns the number of free grooming left of a premium client */
   public int getfreeGroomingLeft() {
      return freeGroomingLeft; // return how many remaining
   }

   /* int getfreeLabTestsLeft() 
   This accessor method returns the number of free lab tests left of a premium client */
   public int getfreeLabTestsLeft() {
      return freeLabTestsLeft; // return number remaining
   }
   
   /* double bill(double bill) 
   This method returns the updated bill of a client */
   public double bill(double bill) {
      return this.balance + this.outstandingBalance + MEMBERSHIPFEE; // return total bill
   }
   
   /* Boolean acceptPayment(double payment)
   This method returns boolean, if a payment is paid or or not */
   public Boolean acceptPayment(double payment) {
      if (payment >= this.balance) { //good, paid off entire balance
         this.balance = this.balance - payment; // calculate balance

         return true;
      }
      else { // still owing balance
         this.outstandingBalance = this.outstandingBalance + (this.balance - payment);
         this.balance = 0; // set balance, add outstanding balance and interest
         this.outstandingBalance = this.outstandingBalance * (1 + INTERESTRATE);

         return false;
      }
   }
   
   /* chargeForService(String type, double baseCost)
   This method charges a service to a premium client */
   public void chargeForService(String type, double baseCost) {
      if (type.equals("Grooming") || type.equals("grooming")){ // grooming
         if (this.freeGroomingLeft > 0){
            this.freeGroomingLeft --; // use free grooming
         } else {
            this.balance = this.balance + (baseCost * (1.0 - PERCENTDISCOUNT)); // add balance
         } // lab test
      } else if (type.equals("Lab Test") || type.equals("lab test") || type.equals("Lab test")){
         if (this.freeLabTestsLeft > 0){
            this.freeLabTestsLeft--; // use free lab test
         } else {
            this.balance = this.balance + (baseCost * (1.0 - PERCENTDISCOUNT)); // add to balance
         }
      }
   }
   
   /* resetServices()
   This method resets all free yearly services for a premium client */
   public void resetServices() {
      this.freeGroomingLeft = YEARLYFREEGROOMING; // reset grooming
      this.freeLabTestsLeft = YEARLYFREELABTESTS; // reset lab tests
   }
   
   /* printBill() 
   This method prints the bill for a client with all their info */
   public void printBill() {
      System.out.println ("Name: " + this.firstName + " " + this.lastName);
      System.out.println ("Client Number : " + this.clientNumber);
      System.out.println ("Pet name: " + this.petName);  // print all info
      System.out.println ("Your balance: " + this.balance);
      System.out.println ("You have " + freeGroomingLeft + " groomings remaining.");
      System.out.println ("You have " + freeLabTestsLeft + " lab tests remaining.");
      System.out.println ("You owe $" + this.balance + ".");
   }
   
   /* String toString()
   This method prints all info of a premium client in the form of a string */
   public String toString() {
      return "Premium " + super.toString(); // print premium, call super
   } 
}