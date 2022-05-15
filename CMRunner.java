/* CMRunner.java
   Programmer: Simon Feng and Jeffrey Li
   ___
 This is the main method for AYJ VetTech/

*/
import java.util.*;
import java.io.*;
// CMRunner
public class CMRunner {
   
   /* printList ()
   This method prints the menu or option for the user */
   public static void printList (){ // print menu method
      System.out.println("[1] See All Clients");
      System.out.println("[2] See All Services");
      System.out.println("[3] Change a Servicecost");
      System.out.println("[4] Use a Service"); 
      System.out.println("[5] Print All Client Bills");
      System.out.println("[6] Reset Yearly Free Services");
      System.out.println("[7] Add a New Client");
      System.out.println("[8] Delete a Client");
      System.out.println("[9] Upgrade a Client");
      System.out.println("[10] Downgrade a Client");
      System.out.println("[11] Save all Client Information");
      System.out.println("[12] Load all Client Information");
      System.out.println("[13] Search for a Client");
      System.out.println("[14] Sort all Clients");
      System.out.println("[15] List Premium Clients");
      System.out.println("[16] List Standard Clients");
      System.out.println("[17] List Owing Clients");
      System.out.println("[18] List Clients With Free Services Remaining");
      System.out.println("[19] Exit Program");
   }
   
   /* loadCosts ()
   This method loads all costs of services */
   public static void loadCosts (){
      //Load file for service and service costs
      try {
         String fileName = "ServiceCost.txt"; // variables, file name
         String lineIn;
         BufferedReader in = new BufferedReader(new FileReader(fileName)); // declare reader
               
         lineIn = in.readLine(); // read in each line and find prices
         double checkup = Integer.parseInt(lineIn);
         lineIn = in.readLine();
         double grooming = Integer.parseInt(lineIn);
         lineIn = in.readLine();
         double labTest = Integer.parseInt(lineIn);
         lineIn = in.readLine();
         double surgery = Integer.parseInt(lineIn);
               
         in.close(); // close reader
                  
      } catch (Exception e){
         System.out.println("Could not load service costs."); // print error if file exception
      }
   }
   
   /* main (String[] args)
   This is the main method. It performs all function that is required for AYJ VetTech to work properly */
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in); // scanner
      double checkup = 10; // variables
      double grooming = 15;
      double labTest = 30;
      double surgery = 85;
      int choice = 0; // choice: user input for menu
      String searchChoice = "";
      String service = "";
      Boolean flag = false; // flag to navigate each case (1-19)
      String fileName = "ServiceCost.txt"; // txt file of all service costs
      
      //Title
      System.out.println("--------------------------------");
      System.out.println("Welcome to AYJ VetTech");
      System.out.println("--------------------------------");
      
      printList(); // print menu
      loadCosts(); // load service costs on start-up
      
      do {
         System.out.print ("Enter an [option] to continue: "); // prompt user for input from menu
         Boolean x = false;
         do {
            try {
               choice = sc.nextInt(); // save input
               x = true;
            }
            catch (Exception e){
               System.out.println("Bad input type, please try again"); // output error if bad type
               sc.nextLine();
               x = false;
            }
         } while (!x);
         
         switch (choice){ // switch/case for each option (1-19)
            case 1: 
            
               ClientManager.listAllClients(); //calls method
            
               flag = false;
               break;
         
            case 2:
               //Load file for service and service costs
               System.out.println("Loading Service Costs...");
               try {
                  String lineIn;
                  BufferedReader in = new BufferedReader(new FileReader(fileName)); // declare reader
               
                  lineIn = in.readLine(); // read in each line and save values into variables
                  checkup = Integer.parseInt(lineIn);
                  lineIn = in.readLine();
                  grooming = Integer.parseInt(lineIn);
                  lineIn = in.readLine();
                  labTest = Integer.parseInt(lineIn);
                  lineIn = in.readLine();
                  surgery = Integer.parseInt(lineIn);
               
                  in.close(); // close reader
               
                  System.out.println("Load Successfull\nServices Available: "); // output message and prices for each service
                  System.out.println("Checkup: $" + checkup);
                  System.out.println("Grooming: $" + grooming);
                  System.out.println("Lab Test: $" + labTest);
                  System.out.println("Surgery: $" + surgery);
                  
               } catch (Exception e){
                  System.out.println("File Load Failed"); // catch error and output
                  System.out.println(e);
               }
               System.out.println("");
            
               flag = false;
               break;
         
            case 3:
               //CHANGE A SERVICE COST
               double change = 0; // variables
               Boolean check = false;
               System.out.println ("Enter a name of service or \"x\" to cancel. "); // prompt user for type of ervice
               service = sc.nextLine(); // get service type string
               
               while (check == false){ // loop
                  if (service.equalsIgnoreCase("Grooming")){ // if service is grooming
                     System.out.println ("The price of grooming is currently $" + grooming);
                     System.out.println ("What would you like to change the grooming costs to? ");
                     
                     Boolean b = false;
                     do { // error handling: if input is not a number
                        try {
                           change = sc.nextDouble(); // get input
                           b = true;
                        } catch (Exception e){
                           System.out.println ("Bad type. Enter a valid cost: "); // output error and loop again
                           sc.nextLine();
                           b = false;
                        }
                     } while (!b);
                     
                     grooming = change; // change cost and output
                     System.out.println ("Cost of grooming has been changed to $" + grooming);
                     check = true;
                  } else if (service.equalsIgnoreCase("Lab Test")){ // if service is lab test
                     System.out.println ("The price of a lab test is currently $" + labTest);
                     System.out.println ("What would you like to change the lab test costs to? "); // prompt user for change value
                     
                     Boolean b = false;
                     do { // error handling: if input is not a number
                        try {
                           change = sc.nextDouble();
                           b = true;
                        } catch (Exception e){
                           System.out.println ("Bad type. Enter a valid cost: "); // output error message and loop again
                           sc.nextLine();
                           b = false;
                        }
                     } while (!b);
                     
                     labTest  = change; // change value and output change
                     System.out.println ("Cost of Lab Test has been changed to $" + labTest);
                     check = true;
                  } else if (service.equalsIgnoreCase("surgery")){ // if service is surgery
                     System.out.println ("The price of surgery is currently $" + surgery); // prompt user for change value
                     System.out.println ("What would you like to change the surgery costs to? ");
                     
                     Boolean b = false;
                     do { // error handling: if input is not a number
                        try {
                           change = sc.nextDouble();
                           b = true;
                        } catch (Exception e){
                           System.out.println ("Bad type. Enter a valid cost: "); // print error and loop again
                           sc.nextLine();
                           b = false;
                        }
                     } while (!b);
                     
                     surgery = change; // change cost of surgery and output
                     System.out.println ("Cost of Surgery has been changed to $" + surgery);
                     check = true;
                  } else if (service.equalsIgnoreCase("x")){ // if input is x, exit loop
                     break;
                  } else { // if input String is not identified
                     System.out.println ("Not a service type. Enter a name of service or \"x\" to cancel. ");
                     service = sc.nextLine(); // output message and loop again
                     check = false;
                  }
               }
              
               try { // write to file (update cost)
                  BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
                  out.write("" + (int)checkup); // write each variable to file
                  out.newLine();
                  out.write("" + (int)grooming);
                  out.newLine();
                  out.write("" + (int)labTest);
                  out.newLine();
                  out.write("" + (int)surgery);
                  out.close();
               } catch (Exception e){
                  System.out.println ("Error accessing" + fileName); // catch and output error
               }
                  
               System.out.println ("Cost change finished.\n");
               
               flag = false;
               break;
         
            case 4:
               // CHARGE A SERVICE TO A CLIENT  
               double amount = 0;    // variables
               String first;
               String last;
               sc.nextLine();
               System.out.println ("Enter first name of client: ");
               first = sc.nextLine();
               System.out.println ("Enter last name of client: ");
               last = sc.nextLine();
               
               if ((ClientManager.searchClient(first, last)) instanceof PremiumClient){ // if client found is premium
                  System.out.println ("Enter type of service: "); // prompt user for type of service
                  
                  Boolean b = false;
                  do {
                     try {
                        service = sc.nextLine(); // promt servie
                        b = true;
                     } catch (Exception e){
                        System.out.println ("Please enter a valid service type:"); // catch error, output and loop
                        sc.nextLine();
                     }
                  } while (b = false);
                  
                  if (service.equalsIgnoreCase("Grooming")){ // if service is grooming
                     amount = grooming;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("Lab Test")){
                     amount = labTest;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("Checkup")){
                     amount = checkup;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("surgery")){
                     amount = surgery;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else {
                     System.out.println ("No service type found."); // print if no service is identified
                  }
                  
               } else if ((ClientManager.searchClient(first, last)) instanceof StandardClient){ // if client is standard
                  System.out.println ("Enter type of service: "); // prompt user for type of service to use
                  
                  Boolean b = false;
                  do {
                     try {
                        service = sc.nextLine(); // get input
                        b = true;
                     } catch (Exception e){
                        System.out.println ("Please enter a valid service type:"); // output error and loop again
                        sc.nextLine();
                     }
                  } while (b = false);
                  
                  if (service.equalsIgnoreCase("Grooming")){ // if service is grooming 
                     amount = grooming;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("Lab Test")){
                     amount = labTest;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("Checkup")){
                     amount = checkup;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else if (service.equalsIgnoreCase("surgery")){
                     amount = surgery;
                     ClientManager.enterService((ClientManager.searchClient(first, last).clientNumber), service, amount); // charge service using enterService and searchClient call
                  } else {
                     System.out.println ("No service type found."); // output error if no service type is identified
                  }
               } else {
                  System.out.println ("Client not found."); // output error if client is not found
               }
               
               System.out.println ("Service use finished.\n");
               flag = false;
               break;
         
            case 5:
               //PRINT ALL BILLS
               ClientManager.printAllBills(); // call printAllBills method
               flag = false;
               break;
         
            case 6:
               // RESET YEARLY SERVICES
               ClientManager.yearlyServiceReset(); // call yearlyServiceReset method
               System.out.println ("Services have been reset.\n");
               flag = false;
               break;
         
            case 7:
               // ADD A NEW CLIENT
               String type; // variables
               Boolean b = false;
               Boolean f = false;
               int number = 0;
               String fN, lN, petN;
               System.out.println ("Enter client type (Premium or Standard), or \"x\" to exit: "); // prompt user for client type
               sc.nextLine();
               do { //loops until "premium" or "client" or "x" is input
                  type = sc.nextLine();
                  if (type.equalsIgnoreCase("Premium")){ //premium
                     b = true;
                     // add premium client
                     do {
                        System.out.println ("Enter Client Number: ");
                        try {
                           number = sc.nextInt(); // ERROR HANDLING HERE
                           
                           if (ClientManager.searchClient(number) == null){ // no identical number is found
                              f = false;
                           } else { // identical number is found
                              System.out.println ("Error: Client number is already in use.");
                              f = true;
                           }
                           
                        } catch (Exception e){
                           System.out.println("Bad type."); // catch error and output, then loop again
                           f = true;
                        }
                        sc.nextLine();
                     } while (f);
                     System.out.println ("Enter Client first name: "); // promt first name
                     fN = sc.nextLine();
                     System.out.println ("Enter Client last name: "); // prompt last name
                     lN = sc.nextLine();
                     System.out.println ("Enter Client pet name: "); // prompt pet name
                     petN = sc.nextLine();
                  
                     // make client
                     PremiumClient pc = new PremiumClient(number, fN, lN, petN, 0.0, 5, 5); 
                  
                     // addClient
                     ClientManager.addClient(pc); // call method to add
                     
                  } else if (type.equalsIgnoreCase("Standard")){ //standard
                     b = true;
                     // add standard client
                     do {
                        System.out.println ("Enter Client Number: ");
                        try {
                           number = sc.nextInt(); // ERROR HANDLING HERE
                           
                           if (ClientManager.searchClient(number) == null){ // no identical number is found
                              f = false;
                           } else { // identical number is found
                              System.out.println ("Error: Client number is already in use.");
                              f = true;
                           }
                           
                        }
                        catch (Exception e){
                           System.out.println("Please enter a number"); // catch error and output, then loop
                           f = true;
                        }
                        sc.nextLine();
                     }
                     while (f);
                  
                     System.out.println ("Enter Client first name: "); // prompt first name
                     fN = sc.nextLine();
                     System.out.println ("Enter Client last name: "); // prompt last name
                     lN = sc.nextLine();
                     System.out.println ("Enter Client pet name: "); // prompt pet name
                     petN = sc.nextLine();
                  
                     // make client
                     StandardClient s = new StandardClient(number, fN, lN, petN, 0.0, 5);
                  
                     // addClient
                     ClientManager.addClient(s);
                  
                  } else if (type.equalsIgnoreCase("x")){ // if input is "x" then exit
                     b = true;
                  } else { // invalid
                     System.out.println ("Type not found. Enter a valid client type: "); // output error message
                     b = false;
                  }
               } while (!b);
            
               System.out.println ("Finished Add Client.\n");
            
               flag = false;
               break;
         
            case 8:
               int input = 0; // variables and declarations
               f = false;
               
               System.out.println ("Enter Client number to delete (\"-1\" to exit): "); // prompt user for client number
               
               do {   
                  try{
                     input = sc.nextInt(); // get client number
                     f = false;
                  } catch (Exception e){
                     System.out.println ("Bad type. Enter a valid number (\"-1\" to exit):"); // catch error and output, then loop
                     sc.nextLine();
                     f = true;
                  }
               } while (f);
                  
               if (input != -1){ // if inpuut is not -1, call method to delete client
                  ClientManager.deleteClient(input);
               }
               
               System.out.println ("Client delete finished.\n");
               
               flag = false;
               break;
         
            case 9: 
               int n; // variables
               String fName;
               String lName;
               String pet;
               double bal;
               sc.nextLine();
               System.out.println ("Enter client first name to search: "); // prompt user for first and last names
               fName = sc.nextLine();
               System.out.println ("Enter client last name to search: ");
               lName = sc.nextLine(); // save first and last names
               
               if (ClientManager.searchClient(fName, lName) == null){ // if not client found
                  System.out.println ("No Clients found."); 
               } else { // if a client is found
                  if (ClientManager.searchClient(fName, lName) instanceof PremiumClient){ // if premium
                     System.out.println ("Client is already Premium."); // no work is needed
                  } else { // if standard
                     n = ClientManager.searchClient(fName, lName).clientNumber; // save old info
                     fName = ClientManager.searchClient(fName, lName).firstName;
                     lName = ClientManager.searchClient(fName, lName).lastName;
                     pet = ClientManager.searchClient(fName, lName).petName;
                     bal = ClientManager.searchClient(fName, lName).balance;
                  // gather info from standard client and declare premium client
                     PremiumClient c = new PremiumClient(n, fName, lName, pet, bal, 5, 5);
                     // replace item in array;
                     ClientManager.replace(ClientManager.searchClient(fName, lName), c);
                     System.out.println ("Succesfully upgraded Client.");
                  }
               }
               
               System.out.println ("Upgrade Client finished.\n");
               flag = false;
               break;
         
            case 10:
               sc.nextLine();
               System.out.println ("Enter client first name to search: "); // prompt user for first and last name of client 
               fName = sc.nextLine();
               System.out.println ("Enter client last name to search: ");
               lName = sc.nextLine(); // save first and last name of client
            
               if (ClientManager.searchClient(fName, lName) == null){ // if client is not found
                  System.out.println ("No Clients found.\n"); // output error
               } else { // if client is found
                  if (ClientManager.searchClient(fName, lName) instanceof StandardClient){ // if standard client
                     System.out.println ("Client is already Standard."); // output error message
                  } else {
                     n = ClientManager.searchClient(fName, lName).clientNumber; // save all info of premium client
                     fName = ClientManager.searchClient(fName, lName).firstName;
                     lName = ClientManager.searchClient(fName, lName).lastName;
                     pet = ClientManager.searchClient(fName, lName).petName;
                     bal = ClientManager.searchClient(fName, lName).balance;
                  // gather info from premium client and declare standard client
                     StandardClient c = new StandardClient(n, fName, lName, pet, bal, 5);
                     // replace item in array;
                     ClientManager.replace(ClientManager.searchClient(fName, lName), c);
                     System.out.println ("Succesfully downgraded Client.");
                  }
               }
               flag = false;
               break;
         
            case 11: 
               try {
                  ClientManager.saveClientList(); //call saveClientList()
                  System.out.println("ClientList saved\n");
               }
               catch (Exception e){
                  System.out.println("Problem Saving to file"); // catch error and output
               }
            
               flag = false;
               break;
            case 12: 
               try {
                  ClientManager.loadClientList(); //call loadClientList()
                  System.out.println("ClientList loaded\n");
               }
               catch (Exception e){
                  System.out.println("Problem Loading to file"); // catch error and output
               }
               
               flag = false;
               break;
            case 13: //Search
               f = false; 
               sc.nextLine();
               System.out.println("Search by:"); // prompt user for search method
               System.out.println("[A] Name");
               System.out.println("[B] Client Number");
               System.out.println("[C] Pet Name");
               searchChoice = sc.nextLine(); // save type of search
               
               if (searchChoice.equalsIgnoreCase("a")){ //search by name
                  first = "";
                  last = "";
                  try {
                     do {
                        try {
                           System.out.println ("Enter first name: "); // prompt user for name
                           first = sc.nextLine();
                        }
                        catch (Exception e){
                           System.out.println("Bad input type, please try again"); // catch error and output, then loop
                           f = true;  
                        }
                     }
                     while (f);
                     
                     do {
                        try {
                           System.out.println ("Enter last name: "); // prompt user for last name
                           last = sc.nextLine(); 
                        }
                        catch (Exception e){
                           System.out.println("Bad input type, please try again"); // catch error and output, then loop
                           f = true;  
                        }
                     }
                     while (f);
                     
                     if (ClientManager.searchClient(first, last) instanceof PremiumClient){ // if client found is premium
                        System.out.println ("Client type: Premium"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(first, last).clientNumber);
                        System.out.println ("Client name: " + first + " " + last);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(first, last).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(first, last).balance);
                        System.out.println ("Free groomings left: " + ((PremiumClient)ClientManager.searchClient(first, last)).freeGroomingLeft);
                        System.out.println ("Free lab tests left: " + ((PremiumClient)ClientManager.searchClient(first, last)).freeLabTestsLeft);
                     } else if (ClientManager.searchClient(first, last) instanceof StandardClient){ // if client found is standard
                        System.out.println ("Client type: Standard"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(first, last).clientNumber);
                        System.out.println ("Client name: " + first + " " + last);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(first, last).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(first, last).balance);
                        System.out.println ("Free checkups left: " + ((StandardClient)ClientManager.searchClient(first, last)).freeCheckupsLeft);
                     } else {
                        System.out.println ("Could not find Client with name."); // output if client is not found
                     }
                  }
                  catch (Exception e){
                     System.out.println("Problem searching by Name"); // catch error and output
                  }
               }
                  
               else if (searchChoice.equalsIgnoreCase("b")){ //search by number
                  number = 0;
                  try {
                     do {
                        try {
                           System.out.println ("Enter Client Number: "); // prompt user for client number
                           number = sc.nextInt();
                        }
                        catch (Exception e){
                           System.out.println("Bad input type, please try again"); // catch error, output, then loop
                           f = true;  
                        }
                     }
                     while (f);
                     
                     if (ClientManager.searchClient(number) instanceof PremiumClient){ // if client found is premium
                        System.out.println ("Client type: Premium"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(number).clientNumber);
                        System.out.println ("Client name: " + ClientManager.searchClient(number).firstName + " " + ClientManager.searchClient(number).lastName);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(number).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(number).balance);
                        System.out.println ("Free groomings left: " + ((PremiumClient)ClientManager.searchClient(number)).freeGroomingLeft);
                        System.out.println ("Free lab tests left: " + ((PremiumClient)ClientManager.searchClient(number)).freeLabTestsLeft);
                     } else if (ClientManager.searchClient(number) instanceof StandardClient){ // if client found is standard
                        System.out.println ("Client type: Standard"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(number).clientNumber);
                        System.out.println ("Client name: " + ClientManager.searchClient(number).firstName + " " + ClientManager.searchClient(number).lastName);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(number).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(number).balance);
                        System.out.println ("Free checkups left: " + ((StandardClient)ClientManager.searchClient(number)).freeCheckupsLeft);
                     } else {
                        System.out.println ("Could not find Client with number."); // output error message if client is not found
                     }
                  }
                  catch (Exception e){
                     System.out.println("Problem searching by Client Number"); // catch error and output message
                  }
               }
                  
               else if (searchChoice.equalsIgnoreCase("c")){ // search by pet name 
                  petN = "";
                  try {
                     do {
                        try {
                           System.out.println ("Enter Pet Name: "); // prompt user for pet name
                           petN = sc.nextLine();
                        }
                        catch (Exception e){
                           System.out.println("Bad input type, please try again"); // catch error and output, then loop
                           f = true;  
                        }
                     }
                     while (f);
                     
                     if (ClientManager.searchClient(petN) instanceof PremiumClient){ // if client found is premium
                        System.out.println ("Client type: Premium"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(petN).clientNumber);
                        System.out.println ("Client name: " + ClientManager.searchClient(petN).firstName + " " + ClientManager.searchClient(petN).lastName);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(petN).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(petN).balance);
                        System.out.println ("Free groomings left: " + ((PremiumClient)ClientManager.searchClient(petN)).freeGroomingLeft);
                        System.out.println ("Free lab tests left: " + ((PremiumClient)ClientManager.searchClient(petN)).freeLabTestsLeft);
                     } else if (ClientManager.searchClient(petN) instanceof StandardClient){ // if client found is standard
                        System.out.println ("Client type: Standard"); // output all info
                        System.out.println ("Client number: " + ClientManager.searchClient(petN).clientNumber);
                        System.out.println ("Client name: " + ClientManager.searchClient(petN).firstName + " " + ClientManager.searchClient(petN).lastName);
                        System.out.println ("Pet Name: " + ClientManager.searchClient(petN).petName);
                        System.out.println ("Balance: " + ClientManager.searchClient(petN).balance);
                        System.out.println ("Free checkups left: " + ((StandardClient)ClientManager.searchClient(petN)).freeCheckupsLeft);
                     } else {
                        System.out.println ("Could not find Client with petname."); // output if client is not found
                     }
                  }
                  catch (Exception e){
                     System.out.println("Problem searching by Pet Name"); // catch error and output
                  }  
               } else {
                  System.out.println ("No type found.");
               }
               System.out.println("");
               flag = false;
               break; 
            
            case 14: //Sort
               sc.nextLine();
               System.out.println("Sort by:"); // prompt user for type of sort
               System.out.println("[A] Name");
               System.out.println("[B] Client Number");
               System.out.println("[C] Pet Name");
               searchChoice = sc.nextLine(); // save input
               
               if (searchChoice.equalsIgnoreCase("a")){ // sorting by name
                  try {
                     ClientManager.sortByName(); // sort by calling method
                  }
                  catch (Exception e){
                     System.out.println("Problem sorting by Name"); // catch error and output
                  }
               }
                  
               else if (searchChoice.equalsIgnoreCase("b")){ // sorting by client number
                  try {
                     ClientManager.sortByClientNumber(); // sort by calling method
                  }
                  catch (Exception e){
                     System.out.println("Problem sorting by Client Number"); // catch error and output
                  }
               }
                  
               else if (searchChoice.equalsIgnoreCase("c")){ // sort by pet name
                  try {
                     ClientManager.sortByPetName(); // call correspondng method to sort
                  }
                  catch (Exception e){
                     System.out.println("Problem sorting by Pet Name"); // catch error, output error message
                  }
               } else {
                  System.out.println ("No type found.");
               }
               System.out.println("List Sort finished\n");
               flag = false;
               break;
         
            case 15: //List Premium Clients
               System.out.println("PREMIUM CLIENTS");
               try {
                  ClientManager.listPremiumClients(); // call method to list all premium clients
                  flag = false;
                  break;
               }
               catch (Exception e){
                  System.out.println("No data found"); // catch error and output
               }
               
               flag = false;
               break;
            case 16: //List Standard Clients
               System.out.println("STANDARD CLIENTS");
               try {
                  ClientManager.listStandardClients(); // call method to list all standard clients
                  flag = false;
                  break;
               }
               catch (Exception e){
                  System.out.println("No data found"); // catch error and output
               }
               flag = false;
               break;
               
            case 17: //Clients with non-zero balance
               
               try {
                  ClientManager.listUnpaidClients(); // call method to output all clients with a non-zero balance
                  flag = false;
                  break;
               }
               catch (Exception e){
                  System.out.println("No data found"); // catch error, output
               }
               flag = false;
               break;
               
            case 18: //Clients with free services left
               System.out.println("Clients with free services left");
               try {
                  ClientManager.listUnusedClients(); // call method to output all clients with free services left
                  flag = false;
                  break;
               }
               catch (Exception e){
                  System.out.println("No data found"); // catch error and output
               }
               flag = false;
               break;
               
            case 19: //exit program by delcaring flag as true
               flag = true; 
               break;
         
            default:
               System.out.print ("Invalid option. "); // if not 1-19, output invalid
         } 
      }
      while (!flag); // looping condition: !flag
   
      System.out.println ("Succesfully closed program"); // outout message when 19 is entered
     
   
   }
}