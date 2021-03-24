package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String[] userData = new String[3];
    static Scanner scan = new Scanner(System.in);
    static User[] users = new User[4];
    static String line;
    static BufferedReader reader = null;
    static int i = 0;
    
    public static void main(String[] args) throws IOException {
        populateUsersArray();
        boolean loggedIn = false;
        int logInAttempts = 0;

        while(logInAttempts < 5 && !loggedIn){
        System.out.println("Enter your email: ");
        String userEmail = scan.nextLine();
        System.out.println("Enter your password: ");
        String userPassword = scan.nextLine();

        for(i = 0; i < 4; i++) {
            if ((userEmail.equalsIgnoreCase(users[i].getUsername()) && (userPassword.equals(users[i].getPassword())))) {
                System.out.println("Welcome, " + users[i].getName());
                loggedIn = true;
            }
       }
        if(loggedIn == false){
                System.out.println("Invalid login, try again!");
                logInAttempts++;
            }
        if(logInAttempts == 5) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }
       }
        scan.close();
    }

    private static void populateUsersArray() throws IOException {

        try {
            reader = new BufferedReader(new FileReader("usersData.txt"));

            while((line = reader.readLine()) != null){

                userData = line.split(",");
                users[i] = new User(userData);
             //   System.out.println("user"+i +": "+ users[i]);
                i++;
            }

        }
        finally {
           // System.out.println("Closing file reader");
            reader.close();
        }
    }




}
