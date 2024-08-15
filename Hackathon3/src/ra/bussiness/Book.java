package ra.bussiness;

import java.util.Scanner;

public class Book {
    Scanner scanner = new Scanner(System.in);
    private Integer bookId ;
    private String bookName ;
    private String author ;
    private String descriptions ;
    private Double importPrice ;
    private Double exportPrice ;
    private Float interest ;
    private Boolean bookStatus = true ;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String author, String descriptions, Double importPrice, Double exportPrice, Float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public Double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(Double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public  void inputData(Book[] books,int index){
        bookId = index+2 ;

        while (true){
            System.out.println("Enter book name :");
            bookName = scanner.nextLine().trim();
            if(bookName.length() > 0){
                break;
            }else {
                System.err.println("Length book name > 0 !");
            }
        }

        while (true){
            System.out.println("Enter author :");
            author = scanner.nextLine().trim();
            if(author.length() > 0){
                break;
            }else {
                System.err.println("Length  author  > 0 !");
            }
        }

        while (true){
            System.out.println("Enter description  :");
            descriptions = scanner.nextLine().trim();
            if(descriptions.length() >=  10){
                break;
            }else {
                System.err.println("Length description  >= 10 !");
            }
        }

        while (true){
            try {
                System.out.println("Enter importPrice :");
                importPrice = Double.parseDouble(scanner.nextLine().trim());
                if(importPrice > 0){
                    break;
                }else {
                    System.err.println("Import price > 0 !");
                }
            }catch (Exception e){
                System.err.println("Import price invalid");
            }
        }

        while (true){
            try {
                System.out.println("Enter export price :");
                exportPrice = Double.parseDouble(scanner.nextLine().trim());
                if(exportPrice >= importPrice + (importPrice*2)/10){
                    break;
                }else {
                    System.err.println("Export price > import Price 20% !");
                }
            }catch (Exception e){
                System.out.println("Export price invalid !");
            }
        }

        interest = (float) (exportPrice - importPrice);
    }

    public void updateBook(){
        while (true){
            System.out.println("Enter book name :");
            bookName = scanner.nextLine().trim();
            if(bookName.length() > 0){
                break;
            }else {
                System.err.println("Length book name > 0 !");
            }
        }

        while (true){
            System.out.println("Enter author :");
            author = scanner.nextLine().trim();
            if(author.length() > 0){
                break;
            }else {
                System.err.println("Length  author  > 0 !");
            }
        }

        while (true){
            System.out.println("Enter description  :");
            descriptions = scanner.nextLine().trim();
            if(descriptions.length() >=  10){
                break;
            }else {
                System.err.println("Length description  >= 10 !");
            }
        }

        while (true){
            try {
                System.out.println("Enter importPrice :");
                importPrice = Double.parseDouble(scanner.nextLine().trim());
                if(importPrice > 0){
                    break;
                }else {
                    System.err.println("Import price > 0 !");
                }
            }catch (Exception e){
                System.err.println("Import price invalid");
            }
        }

        while (true){
            try {
                System.out.println("Enter export price :");
                exportPrice = Double.parseDouble(scanner.nextLine().trim());
                if(exportPrice - importPrice >= (importPrice % 100)*20){
                    break;
                }else {
                    System.err.println("Export price > import Price 20% !");
                }
            }catch (Exception e){
                System.out.println("Export price invalid !");
            }
        }

        interest = (float) (exportPrice - importPrice);

        while (true){
            try {
                System.out.println("Enter status book (true or false ) : ");
                String status = scanner.nextLine().trim().toLowerCase();
                if(status.equals("true") || status.equals("false")){
                    bookStatus = Boolean.parseBoolean(status);
                    break;
                }else {
                    System.err.println("Enter true or false !");
                }
            }catch (Exception e){
                System.err.println("Book status invalid !");
            }
        }
    }

    public void displayData(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("[ %-6d | %-30s | %-30s | %-30s | %-15.2f | %-15.2f | %-15.2f | %-10s ]\n",bookId,bookName,author,descriptions,importPrice,exportPrice,interest,bookStatus);
    }
}
