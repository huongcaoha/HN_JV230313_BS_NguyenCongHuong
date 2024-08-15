package ra.run;

import ra.Common.Method;
import  ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static Book[] books = new Book[100];
    public static int currentIndex = -1 ;

    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("*********************************************JAVA-HACKATHON-05-BASIC-MENU******************************************");
            System.out.println("|                                                                                                                                                                                                                             |");
            System.out.println("|                                          1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách                                              |");
            System.out.println("|                                          2. Hiển thị thông tin tất cả sách trong thư viện                                                                                             |");
            System.out.println("|                                          3. Sắp xếp sách theo lợi nhuận tăng dần                                                                                                         |");
            System.out.println("|                                          4. Xóa sách theo mã sách                                                                                                                                   |");
            System.out.println("|                                          5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả                                                                               |");
            System.out.println("|                                          6. Thay đổi thông tin sách theo mã sách                                                                                                        |");
            System.out.println("|                                          7. Thoát                                                                                                                                                                    |");
            System.out.println("|                                                                                                                                                                                                                             |");
            System.out.println("******************************************************************************************************************************* ");
            int  choise = 0 ;
            while (true){
                try {
                    System.out.println("Enter choice : ");
                    choise = Integer.parseInt(scanner.nextLine().trim());
                    if(choise > 0 && choise < 8){
                        break;
                    }else {
                        System.err.println("Enter choice from 1 to  7 !");
                    }
                }catch (Exception e){
                    System.err.println("Choice invalid");
                }
            }

            switch (choise){
                case 1 : {
                            Method.addBook();
                    break;
                }
                case 2 : {
                    Method.displayListBook(BookManagement.books);
                    break;
                }

                case 3 : {
                    Method.sortForInterest(BookManagement.books,BookManagement.currentIndex);
                    break;
                }

                case 4 : {
                    Method.deleteBook();
                    break;
                }

                case 5 : {
                    Method.searchBookByNameOrDescription();
                    break;
                }

                case 6 : {
                    Method.updateBook();
                    break;
                }

                case 7 : {
                    System.out.println("Goodbye !!!");
                    return;
                }
            }

        }
    }
}
