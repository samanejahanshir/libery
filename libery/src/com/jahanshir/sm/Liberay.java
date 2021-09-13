package com.jahanshir.sm;

public class Liberay {
    public static Member[] members = new Member[50];
    public static Book[] books = new Book[50];
    int indexBooks = 0, indexMembers = 0;

    public static int findMemberIndex(int memberId) {
        for (int i = 0; i < members.length && members[i] != null; i++) {
            if (members[i].getId() == memberId) {
                return i;
            }
        }
        return -1;
    }

    public static int findBookIndex(Book[] books, int bookId) {
        for (int i = 0; i < books.length && books[i] != null; i++) {
            if (books[i].getId() == bookId) {
                return i;
            }
        }
        return -1;
    }

    public static Book addBook(String name, int id, int count) {
        return new Book(name, 1000 + id, count);
    }

    public static Member addMember(String name, String birthDate, int id) {
        return new Member(name, birthDate, 20 + id);
    }

    public static void getBook(int memberId, int bookId, Book[] books, Member[] members) {
        int bookIndex = -1, memberIndex = -1;
        bookIndex = findBookIndex(books, bookId);
        memberIndex = findMemberIndex(memberId);
        if (bookIndex != -1 && memberIndex != -1) {
            if (books[bookIndex].getCount() > 0) {
                if (members[memberIndex].getIndexBook() < 5) {
                    members[memberIndex].addBooks(books[bookIndex]);
                    members[memberIndex].setIndexBook(members[memberIndex].getIndexBook() + 1);
                    books[bookIndex].setCount(books[bookIndex].getCount() - 1);
                    System.out.println("book added to " + members[memberIndex].getName() + "'s books");
                } else {
                    System.out.println("MaxReached : [" + members[memberIndex].getName() + "] [" + memberId + "]");
                }
            } else {
                System.out.println("NotAvailable : [" + books[bookIndex].getName() + "] [" + bookId + "]");
            }
        } else {
            System.out.println(bookIndex == -1 ? " this book not find! " : " this member not find!");

        }

    }

    public static void returnBook(int memberId, int bookId, Book[] books, Member[] members) {
        int bookIndex = -1, memberIndex = -1;
        bookIndex = findBookIndex(books, bookId);
        memberIndex = findMemberIndex(memberId);
        if (bookIndex != -1 && memberIndex != -1) {
            if (members[memberIndex].getIndexBook() > 0) {
                if (members[memberIndex].returnBook(bookId)) {
                    books[bookIndex].setCount(books[bookIndex].getCount() + 1);
                    System.out.println(" return book is successfully .");
                } else if (!members[memberIndex].returnBook(bookId)) {
                    System.out.println(" not find this book in " + members[memberIndex].getName() + "'s book list ! ");

                }
            }
        } else {
            System.out.println(bookIndex == -1 ? " this book not find! " : " this member not find!");

        }


    }

    public static void memberStat(int indexMembers) {
        System.out.println("******  Member Stat  ****** ");
        System.out.println("Name "+"  Id "+"  Birth Date "+"  Books Name And Id");

        for (int i = 0; i < indexMembers; i++) {
            System.out.print( members[i].getName() + "    " + members[i].getId() + "    " + members[i].getBirthDate() + "    " );
            if (members[i].getIndexBook() > 0) {
                for (int j = 0; j < members[i].getIndexBook(); j++) {
                    System.out.print( members[i].getBooks()[j].getName() + "  " + members[i].getBooks()[j].getId() + "  ");

                }
            } else {
                System.out.print("not books!");

            }
            System.out.println();
        }

    }

    public static void bookStat(int indexBooks) {
        System.out.println("******  Book Stat  ****** ");
        System.out.println("Name  " + "  Id  " + "  count ");

        for (int i = 0; i < indexBooks; i++) {
            System.out.println(books[i].getName() + "   " + books[i].getId() + "   " + books[i].getCount());
        }

    }


}
