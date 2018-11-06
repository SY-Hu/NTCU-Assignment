import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class menu extends menuImplement{

    private static int chooseitem;
    public static void main(String[] args) {


        String InUserID,InUserPW;
	String UserID="cis",UserPW="1234"; 
	Scanner Input = new Scanner(System.in); 
		
	System.out.println("請輸入使用者帳號：");	
	InUserID = Input.nextLine();
	System.out.println("請輸入使用者密碼：");	
	InUserPW = Input.nextLine();

	if (InUserID.equals(UserID)&&InUserPW.equals(UserPW))
	    {
		System.out.println("登入成功!");
            loadData();
        while(1<2){
              
            System.out.println("1.顯示所有資料    "+"2.新增資料    "+"3.資料查詢    "+"4.修改資料");
            System.out.println("5.分頁顯示        "+"6.刪除資料    "+"7.存檔        "+"8.離開");
            Scanner scan =new Scanner(System.in);
            chooseitem=scan.nextInt();
            try{
                
                switch(chooseitem){
                    case 1://顯示資料

                        sort();
                        break;
                    case 2://加入
                        addData();
                        break;
                    case 3://查詢
                        searchData();
                        break;
                    case 4://修改資料
                        modifyData();
                        break;
                    case 5://分頁顯示
                        pagination();
                        break;
                    case 6://刪除資料
                        deleteData();
                        break;
                    case 7://存檔
                        writeData();
                        System.out.println("存檔成功");
                        break;
                    case 8://離開
                         writeData();
                        break;
                    default :
                        System.out.println("~~請輸入1到8~~");
                        break;
                }
                
            }catch(Exception e){
                    System.out.println("有無法辨識的錯誤");
                    System.out.println(e);
            }
            if(chooseitem==8){
                break;
            }    
        }//while	
	    }
	else
	    {
		System.out.println("登入失敗!");

            }
	
    }

}
