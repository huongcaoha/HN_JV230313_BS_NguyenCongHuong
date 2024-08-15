package ra.Common;

import ra.bussiness.Book;
import ra.run.BookManagement;

import java.util.Scanner;

public class Method {
    static Scanner scanner = new Scanner(System.in);
    public static void displayListBook(Book[] books){
        if(BookManagement.currentIndex < 0){
            System.out.println("List book empty !");
        }else {
            System.out.println();
            System.out.printf("[ %-6s | %-30s | %-30s | %-30s | %-15s | %-15s | %-15s | %-10s ]\n","ID","BookName","Author","Descriptions","ImportPrice","ExportPrice","Interest","Status");
            for(Book book : books){
                if(book != null){
                    book.displayData();
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public  static void sortForInterest(Book[] books , int currentIndex){
        for(int i = 0 ; i <=  currentIndex ; i++){
            for(int j = i+1 ; j <= currentIndex ; j++ ){
                if(books[j].getInterest() < books[i].getInterest()){
                    Book tmp = books[i];
                    books[i] = books[j];
                    books[j] = tmp ;
                }
            }
        }
        System.out.println("List Book after sort is : ");
        Method.displayListBook(BookManagement.books);
    }

    public static void addBook(){
        int number = 0 ;
        while (true){
            try {
                System.out.println("Enter number book want add : ");
                number = Integer.parseInt(scanner.nextLine().trim());
                if(number > 0){
                    break;
                }else {
                    System.err.println("Enter number > 0 !");
                }
            }catch (Exception e){
                System.err.println("number invalid !");
            }
        }
        for(int  i = 1 ; i <= number ; i++){
            System.out.println("Enter book number " + i );
            Book book = new Book();
            book.inputData(BookManagement.books,BookManagement.currentIndex);
            BookManagement.currentIndex++ ;
            BookManagement.books[BookManagement.currentIndex] = book ;
            System.out.println("----------------------------------------------------------------------------------------");
        }
        Method.displayListBook(BookManagement.books);
    }

    public  static void deleteBook(){
        int bookId = 0 ;
        while (true){
            try {
                System.out.println("Enter book Id to delete : ");
                bookId = Integer.parseInt(scanner.nextLine().trim());
                if(bookId > 0){
                    break;
                }else {
                    System.err.println("Enter book id > 0 !");
                }
            }catch (Exception e){
                System.err.println("Book id invalid !");
            }
        }
        int index = -1 ;
        for(int i = 0 ; i <= BookManagement.currentIndex ;i++){
            if(BookManagement.books[i].getBookId() == bookId){
                index = i ;
                break;
            }
        }
        if(index < 0){
            System.err.println("Not found book id !");
        }else {
            for(int i = index ; i < BookManagement.currentIndex ; i++){
                BookManagement.books[i] = BookManagement.books[i+1];
            }
            BookManagement.books[BookManagement.currentIndex] = null ;
            BookManagement.currentIndex-- ;
            System.out.println("Delete successfully !");
            Method.displayListBook(BookManagement.books);
        }
    }

    public static void searchBookByNameOrDescription(){
        String search = "" ;
        while (true){
            System.out.println("Enter name book or description to search : ");
             search = scanner.nextLine().trim().toLowerCase();
            if(search.length() <= 0){
                System.err.println("Search cannot be empty  !");
            }else {
                break;
            }
        }
        Book[] rs = new Book[100];
        int indexRs = -1 ;
        for(int i = 0 ; i <= BookManagement.currentIndex ; i++){
            if(BookManagement.books[i].getBookName().toLowerCase().contains(search) || BookManagement.books[i].getDescriptions().toLowerCase().contains(search)){
                indexRs++ ;
                rs[indexRs] = BookManagement.books[i];
            }
        }
        if(indexRs < 0){
            System.err.println("Not found book !");
        }else {
            System.out.println("Result after search : ");
            Method.displayListBook(rs);
        }
    }

    public static void updateBook(){
        int idBook = 0 ;
        while (true){
            try {
                System.out.println("Enter book id to update :");
                idBook = Integer.parseInt(scanner.nextLine().trim());
                if(idBook > 0){
                    break;
                }else {
                    System.err.println("Enter book id > 0 !");
                }
            }catch (Exception e){
                System.err.println("Book id invalid !");
            }
        }
        int indexBook = -1 ;
        for(int  i = 0 ; i <= BookManagement.currentIndex ; i++){
            if(BookManagement.books[i].getBookId() == idBook){
                indexBook = i ;
                break;
            }
        }
        if(indexBook < 0){
            System.err.println("Not found id book !");
        }else {
            BookManagement.books[indexBook].updateBook();
            System.out.println("Update successfully !");
            Method.displayListBook(BookManagement.books);
        }
    }
}
