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
		
	System.out.println("�п�J�ϥΪ̱b���G");	
	InUserID = Input.nextLine();
	System.out.println("�п�J�ϥΪ̱K�X�G");	
	InUserPW = Input.nextLine();

	if (InUserID.equals(UserID)&&InUserPW.equals(UserPW))
	    {
		System.out.println("�n�J���\!");
            loadData();
        while(1<2){
              
            System.out.println("1.��ܩҦ����    "+"2.�s�W���    "+"3.��Ƭd��    "+"4.�ק���");
            System.out.println("5.�������        "+"6.�R�����    "+"7.�s��        "+"8.���}");
            Scanner scan =new Scanner(System.in);
            chooseitem=scan.nextInt();
            try{
                
                switch(chooseitem){
                    case 1://��ܸ��

                        sort();
                        break;
                    case 2://�[�J
                        addData();
                        break;
                    case 3://�d��
                        searchData();
                        break;
                    case 4://�ק���
                        modifyData();
                        break;
                    case 5://�������
                        pagination();
                        break;
                    case 6://�R�����
                        deleteData();
                        break;
                    case 7://�s��
                        writeData();
                        System.out.println("�s�ɦ��\");
                        break;
                    case 8://���}
                         writeData();
                        break;
                    default :
                        System.out.println("~~�п�J1��8~~");
                        break;
                }
                
            }catch(Exception e){
                    System.out.println("���L�k���Ѫ����~");
                    System.out.println(e);
            }
            if(chooseitem==8){
                break;
            }    
        }//while	
	    }
	else
	    {
		System.out.println("�n�J����!");

            }
	
    }

}
