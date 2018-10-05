import controller.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập từ bạn muốn tra:");
            String test = sc.nextLine();
            String detail = controller.findWord(test);
            //String[] detail = controller.suggestionWord(test);
            //String[] result = detail.split(";");
//            for(int i=0 ; i<detail.length; i++){
//                System.out.println(detail[i]);
//            }

            if(detail.equals("") || detail==null){
                System.out.println("Từ bạn nhập không có trong từ điển");
            }
            else{
                System.out.println(test + " : " + detail);
            }
        }
    }
}