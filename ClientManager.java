/* ClientManager.java
Name: Jeffrey Li and Simon Feng

Description: This program manages and carries out various client tasks*/

import java.util.*;
import java.io.*;
// ClientManager
public class ClientManager{
   static Client [] clientList = new Client[0]; // size will be updated upon user entry
   
   /* listAllClients ()
   This method lists all clients and their info in the clientList array */
   public static void listAllClients (){
      if (clientList.length == 0){ // if no clients in array
         System.out.println ("No clients found.");
         System.out.println ("");
      } else {
         for (int i = 0; i < clientList.length; i++){ // clientList > 0
            if (clientList[i] instanceof PremiumClient){ // if premium
               System.out.println ("Client type: Premium"); // print info
               System.out.println ("Client Number: " + clientList[i].clientNumber);
               System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
               System.out.println ("Pet Name: " + clientList[i].petName);
            } else {
               System.out.println ("Client type: Standard"); // if standard
               System.out.println ("Client Number: " + clientList[i].clientNumber); // print info
               System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
               System.out.println ("Pet Name: " + clientList[i].petName);
            }
            
            System.out.println ("");
         }
      }
   }
   
   /* listPremiumClients ()
   This method lists all premium clients and their info in the clientList array */
   public static void listPremiumClients (){
      int test = 0;
      for (int i = 0; i < clientList.length; i++){ // loop through entire array
         if (clientList[i] instanceof PremiumClient){ // only output if premium
            System.out.println ("Client Number: " + clientList[i].clientNumber);
            System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
            System.out.println ("Pet Name: " + clientList[i].petName);
            System.out.println ("");
            test++;
         }
      }
      if (test == 0){
         System.out.println ("No clients found.\n");
      }
   }
   
   /* listStandardClients ()
   This method lists all standard clients and their info in the clientList array */
   public static void listStandardClients (){
      int test = 0;
      for (int i = 0; i < clientList.length; i++){ // loop through entire array
         if (clientList[i] instanceof StandardClient){ // only output if standard
            System.out.println ("Client Number: " + clientList[i].clientNumber);
            System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
            System.out.println ("Pet Name: " + clientList[i].petName);
            System.out.println ("");
         }
      }
      if (test == 0){
         System.out.println ("No clients found.\n");
      }
   }
   
   /* listUnpaidClients ()
   This method lists all unpaid clients and their info in the clientList array */
   public static void listUnpaidClients (){
      int test = 0;
      System.out.println("Clients with non-zero balance");
      for (int i = 0; i < clientList.length; i++){ // loop through entire array
         if (clientList[i].balance != 0){ // if balance is not 0
            test++;
            System.out.println ("Client Number: " + clientList[i].clientNumber);
            System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
            System.out.println ("Pet Name: " + clientList[i].petName);
            System.out.println ("");
         }
      }
      if (test == 0){
         System.out.println ("No clients found.\n");
      }
   }
   
   /* listUnusedClients ()
   This method lists all unused clients and their info in the clientList array */
   public static void listUnusedClients (){
      int test = 0;
      for (int i = 0; i < clientList.length; i++){ //loop entire array
         if (clientList[i] instanceof PremiumClient){ // if premium
            if (((PremiumClient)clientList[i]).getfreeGroomingLeft() > 0 || ((PremiumClient)clientList[i]).getfreeLabTestsLeft() > 0){
               System.out.println ("Client Number: " + clientList[i].clientNumber);
               System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
               System.out.println ("Pet name: " + clientList[i].petName); // output all info
               test++;
            }
         } else if (clientList[i] instanceof StandardClient){ // if standard
            if (((StandardClient)clientList[i]).getfreeCheckupsLeft() > 0){
               System.out.println ("Client Number: " + clientList[i].clientNumber);
               System.out.println ("Name: " + clientList[i].firstName + " " + clientList[i].lastName);
               System.out.println ("Pet name: " + clientList[i].petName); // output info
               test++;
            }
         }
         System.out.println ("");
      }
      if (test == 0){
         System.out.println ("No clients found.\n");
      }
   }  
   
   /* addClient (Client c)
   This method adds a new client into the array */
   public static void addClient (Client c){ // parameters: a client object
      Client [] add = new Client [clientList.length + 1]; // declare new array with one size larger
      
      for (int i = 0; i < clientList.length; i++){
         add[i] = clientList[i]; // loop and copy items
      }
      add[add.length - 1] = c; // new array gets parameter object value
      clientList = add; // old array has new array values (one size larger)
   }
   
   /* deleteClient (int number)
   This method deletes a client from the array using client number */
   public static void deleteClient (int number){
      if (clientList.length <= 0){
         // error: size of array is 0 and cannot be reduced
         System.out.println ("Error: already at minimum number of clients.");
      } else { // size of array > 0
         Client [] delete = new Client [clientList.length - 1]; // declare new array with 1 size smaller
         int save = -1;
         for (int i = 0; i < clientList.length; i++){
            if (clientList[i].clientNumber == number){ // find item and save location
               save = i;
            }
         }
         
         if (save == -1){
            // error: client number is not in array
            System.out.println ("Error: client not found.");
         } else { // client number was found
            for (int i = 0; i < save; i++){
               delete[i] = clientList[i]; // save first half of list
            }
            for (int j = delete.length - 1; j >= save; j--){
               delete[j] = clientList[j + 1]; // save second half of list
            }
            System.out.println (clientList[save].firstName + " has been successfully removed.");
         }
         
         clientList = delete; // make clientList new array with 1 size smaller
      }
   }
   
   /* enterService (int number, String serviceName, double serviceCost)
   This method calls chargeForService in PremiumClient or StandardClient and charges a service */
   public static void enterService (int number, String serviceName, double serviceCost){
      for (int i = 0; i < clientList.length; i++){
         if (clientList[i].clientNumber == number){ // if the client is found
            if (clientList[i] instanceof PremiumClient){ // if PremiumClient
               (((PremiumClient)clientList[i])).chargeForService(serviceName, serviceCost);
               // call chargeForService method in PremiumClient
            } else if (clientList[i] instanceof StandardClient){ // if StandardClient
               (((StandardClient)clientList[i])).chargeForService(serviceName, serviceCost);
               // call chargeForService method in StandardClient
            }
         } else {
            System.out.println ("Error: client not found"); // print if no client is found
         }
      }
   }
   
   /* printAllBills ()
   This method prints the bills for all clients */
   public static void printAllBills (){
      if (clientList.length == 0){ // array is empty
         System.out.println ("No clients found.\n");
      } else {
         for (int i = 0; i < clientList.length; i++){ // loop through array
            if (clientList[i] instanceof PremiumClient){ // if PremiumClient
               (((PremiumClient)clientList[i])).printBill();// print their bill
               System.out.println ("");
                  // call printBill method in PremiumClient
            } else if (clientList[i] instanceof StandardClient){ // if StandardClient
               (((StandardClient)clientList[i])).printBill(); // print their bill
               System.out.println ("");
                  // call printBill method in StandardClient
            }
         }
      }
   }
   
   /* saveClientList ()
   This method saves the clientList array to a text file */
   public static void saveClientList (){
      try {
         String fileName = "clientList.txt"; // text file name
         BufferedWriter out = new BufferedWriter(new FileWriter(fileName)); // declare writer
      
         for (int i = 0; i < clientList.length; i++){ // loop thtough array
            if (clientList[i] instanceof PremiumClient){ // if PremiumClient
               out.write(((PremiumClient)clientList[i]).toString()); // write info
               out.write (" " + clientList[i].balance);
               out.write (" " + ((PremiumClient)clientList[i]).freeGroomingLeft);
               out.write (" " + ((PremiumClient)clientList[i]).freeLabTestsLeft);
            } 
            else if (clientList[i] instanceof StandardClient){ // if StandardClient
               out.write(((StandardClient)clientList[i]).toString());// write info
               out.write (" " + clientList[i].balance);
               out.write (" " + ((StandardClient)clientList[i]).freeCheckupsLeft);
            }
            out.newLine();
         }
      
         out.close(); // close writer
      
      }
      catch (Exception e){
         System.out.println("Error saving to file"); // output error if cannot access file
      }
   }
   
   /* loadClientList ()
   This method loads the clientList array from a text file */
   public static void loadClientList (){
      try {
         String fileName = "clientList.txt"; // file name
         int numClients = 0; // variables
         String lineIn;
         BufferedReader in = new BufferedReader(new FileReader(fileName)); // declare reader
      
         lineIn = in.readLine(); // read in line
         
         while (lineIn != null){ // This section determines number of clients (Number of lines in txt file)
            numClients = numClients + 1;
            lineIn = in.readLine(); // save number of clients in file
         }
         in.close();
         
         BufferedReader in2 = new BufferedReader(new FileReader(fileName)); // new writer
         Client [] clientListIn = new Client [numClients]; // declare new array
         for (int i = 0; i < numClients; i++){ //This section gets each line and breaks up the info
            lineIn = in2.readLine();
            
            if (lineIn.charAt(0) == 'P'){ // premium client
               
               lineIn = lineIn.substring(8, lineIn.length()); // remove "Premium "
               int count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               int number = Integer.parseInt(lineIn.substring(0, count)); // save client number       
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove number               
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String first = lineIn.substring(0, count); // save first name          
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove first name              
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String last = lineIn.substring(0, count); // save last name             
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove last name
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String pet = lineIn.substring(0, count); // save pet name
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove pet name
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               double b = Double.parseDouble(lineIn.substring(0, count)); // save balance
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove balance
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               int g = Integer.parseInt(lineIn.substring(0, count)); // save free grooming
               lineIn = lineIn.substring(count + 1, lineIn.length());
               int l = Integer.parseInt(lineIn); // save free lab tests
               // declare premium client with variables as parameters
               PremiumClient p = new PremiumClient(number, first, last, pet, b, g, l);
               clientListIn[i] = p; // make location in array equal to new client

            } else if (lineIn.charAt(0) == 'S'){ // standard client
               
               lineIn = lineIn.substring(9, lineIn.length()); // remove "Standard "
               int count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               int number = Integer.parseInt(lineIn.substring(0, count)); // save client number              
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove number               
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String first = lineIn.substring(0, count); // save first name               
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove first name              
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String last = lineIn.substring(0, count); // save last name             
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove last name
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               String pet = lineIn.substring(0, count); // save pet name
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove pet name
               count = 0;
               while (lineIn.charAt(count) != ' '){ // find next section seperated by space
                  count++; 
               }
               double b = Double.parseDouble(lineIn.substring(0, count)); // save balance
               lineIn = lineIn.substring(count + 1, lineIn.length()); // remove balance

               int l = Integer.parseInt(lineIn); // save freecheckups
               // declare new standard client
               StandardClient p = new StandardClient(number, first, last, pet, b, l);
               clientListIn[i] = p; // make location in array equal to new standard client
            }
            
         }
         
         clientList = clientListIn; // make clientList have all info from txt file array
         
         in2.close(); // close writer
      }
      catch (Exception e){ //in case of error
         System.out.println(e + " Error accessing clientList");
      }
   }
   
   /* Client searchClient (String first, String last)
   This overloaded method finds and returns the client given first and last name */
   public static Client searchClient (String first, String last){
      for (int i = 0; i < clientList.length; i++){ // loop through array
         if (clientList[i].firstName.equals(first) && clientList[i].lastName.equals(last)){
            return clientList[i]; // if identical, return client
         }
      }
      return null; // else, return null
   }
   
   /* Client searchClient (int number)
   This overloaded method finds and returns the client given client number */
   public static Client searchClient (int number){
      for (int i = 0; i < clientList.length; i++){ // loop through array
         if (clientList[i].clientNumber == number){
            return clientList[i]; // if identical number, return object
         }
      }
      return null; // else return null
   }
   
   /* Client searchClient (String pName)
   This overloaded method finds and returns the client given the client's pet's name */
   public static Client searchClient (String pName){
      for (int i = 0; i < clientList.length; i++){ // loop through entire array
         if (clientList[i].petName.equals(pName)){ 
            return clientList[i]; // if pet name is identical, return client
         }
      }
      return null; // else return null
   }
   
   /* sortByName()
   This method sorts the list of clients alphabetically by name */
   public static void sortByName(){
      boolean sorted = false; // variables
      int n = clientList.length;
      Client temp;
      int test = 0;
   
      for (int i = 0; i < n - 1 && sorted == false; i++){ // loop
         sorted = true;
         for (int j = 0; j < n - i - 1; j++){
            if (clientList[j].lastName.compareTo(clientList[j + 1].lastName) > 0){  
               // sorting by last name
               //Swap
               temp = clientList[j];
               clientList[j] = clientList[j + 1];
               clientList[j + 1] = temp;
               test++;
               sorted = false;
            } else if (clientList[j].lastName.compareTo(clientList[j + 1].lastName) == 0){ // if same last name
               if (clientList[j].firstName.compareTo(clientList[j + 1].firstName) > 0){ // different first name
                  // sorting by first name
                  //Swap
                  temp = clientList[j];
                  clientList[j] = clientList[j + 1];
                  clientList[j + 1] = temp;
                  test++;
                  sorted = false;
               } else if (clientList[j].firstName.compareTo(clientList[j + 1].firstName) == 0){ // same first name
                  // sort By Client Number
                  if (clientList[j].clientNumber > clientList[j + 1].clientNumber){
                     // sorting by client number
                     //Swap
                     temp = clientList[j];
                     clientList[j] = clientList[j + 1];
                     clientList[j + 1] = temp;
                     test++;
                     sorted = false;
                  }
               }
            }
         }
      }
      if (test == 0){
         System.out.println ("No clients found.");
      } else {
         System.out.println ("Finished sort");
      }
   }
   
   /* sortByClientNumber ()
   This method sorts the list of clients using their client numbers */
   public static void sortByClientNumber (){
      boolean sorted = false; // variables
      int n = clientList.length;
      Client temp;
      int test = 0;
   
      for (int i = 0; i < n - 1 && sorted == false; i++){ // loop to swap
         sorted = true;
         for (int j = 0; j < n - i - 1; j++){
            if (clientList[j].clientNumber > clientList[j + 1].clientNumber){ 
            // if previous is larger then next
                    //Swap
               temp = clientList[j];
               clientList[j] = clientList[j + 1];
               clientList[j + 1] = temp;
               test++;
               sorted = false;
            }
         }
      }
      if (test == 0){
         System.out.println ("No clients found.");
      } else {
         System.out.println ("Finished sort");
      }
   }
   
   /* sortByPetName ()
   This method sorts the list of clients using their pet names */
   public static void sortByPetName (){
        boolean sorted = false; // variables
        int n = clientList.length;
        Client temp;
        int test = 0;

        for (int i = 0; i < n - 1 && sorted == false; i++){ // loop to swap
            sorted = true;
            for (int j = 0; j < n - i - 1; j++){ // if previous is alphabetically higher than next
                if (clientList[j].petName.compareTo(clientList[j + 1].petName) > 0){
                    //Swap
                    temp = clientList[j];
                    clientList[j] = clientList[j + 1];
                    clientList[j + 1] = temp;
                    test++;
                    sorted = false;
                }
            }
        }
        if (test == 0){
            System.out.println ("No clients found.");
        } else {
         System.out.println ("Finished sort");
      }
   }
   
   /* yearlyServiceReset ()
   This method resets all yearly services for all clients */
   public static void yearlyServiceReset (){
      for (int i = 0; i < clientList.length; i++){ // loop through entire client list array
            if (clientList[i] instanceof PremiumClient){ // if PremiumClient
               ((PremiumClient)(clientList[i])).resetServices(); // reset yearly free service count
            } else if (clientList[i] instanceof StandardClient){ // if StandardClient
               ((StandardClient)(clientList[i])).resetServices(); // reset
            }
         }
   }
   
   /* replace (Client o, Client c)
   This method replaces one client in the array with another (Both clients are parameters)
   Client o is being replaced by Client c */
   public static void replace (Client o, Client c){
      int save = -1; // variable
      for (int i = 0; i < clientList.length; i++){ // loop through entire array
         if (clientList[i] == o){ // if client is identical to one in array
            save = i; // save location
         }
      }
      clientList[save] = c; // replace that item at the location with Client c
   }
   
}



