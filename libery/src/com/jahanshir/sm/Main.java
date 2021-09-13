package com.jahanshir.sm;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
Liberay liberay=new Liberay();
        Scanner inputScanner = new Scanner(System.in);
        String commandInput;
        while (true) {
            System.out.println("enter Command to exit enter q : ");
            commandInput = inputScanner.nextLine();
            String[] splitCommand = (commandInput.split(" "));
            try {
                if (splitCommand[0].equalsIgnoreCase("addBook")) {
                    if (liberay.indexBooks < 50) {
                       liberay.books[liberay.indexBooks] = Liberay.addBook(splitCommand[1], liberay.indexBooks++, Integer.parseInt(splitCommand[2]));
                        System.out.println("book is added.");

                    } else {
                        System.out.println("Book's capacity is completed!!");

                    }
                } else if (splitCommand[0].equalsIgnoreCase("addMember")) {
                    if (liberay.indexMembers < 50) {
                        liberay.members[liberay.indexMembers] = Liberay.addMember(splitCommand[1], splitCommand[2], liberay.indexMembers++);
                        System.out.println("member is added.");
                    } else {
                        System.out.println("Member's capacity is completed!!");
                    }
                } else if (splitCommand[0].equalsIgnoreCase("get")) {
                    Liberay.getBook(Integer.parseInt(splitCommand[1]), Integer.parseInt(splitCommand[2]), liberay.books, liberay.members);
                } else if (splitCommand[0].equalsIgnoreCase("return")) {
                    Liberay.returnBook(Integer.parseInt(splitCommand[1]), Integer.parseInt(splitCommand[2]), liberay.books, liberay.members);
                } else if (commandInput.equalsIgnoreCase("bookstat")) {
                    Liberay.bookStat(liberay.indexBooks);
                } else if (commandInput.equalsIgnoreCase("memberstat")) {
                    Liberay.memberStat(liberay.indexMembers);
                } else if (commandInput.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("your command is invalid!! please enter again...");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error ===> you should enter number in index :");
                continue;

            } catch (Exception e) {
                System.out.println("Error ===> invalid input !! try again :");
                continue;
            }
        }
    }



}
