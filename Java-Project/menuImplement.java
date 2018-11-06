
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class menuImplement extends workData  {

        public static ArrayList<workData> workdata=new ArrayList<workData>();

        public static void loadData()//Ū���ɮ�
         {
             Scanner loadData = null;
	 	try
		{
		 loadData = new Scanner( new FileInputStream( "datafile.txt" ) );
		}
		catch(FileNotFoundException e)
		{
                	System.out.println("File datafile.txt was not found");
        		System.out.println("or could not be opened.");
          		System.exit(0);
		}
               String Name;//�u�@�W��
               int Fintime;//�����ɶ�
               int Percent;//�����ʤ���
               String State;//���A
               String Number;//�s��
               String Workclass;//����
               String Workdetail;//�u�@���e
		while( loadData.hasNext( ) )
        		{
			workData temp = null;

			Name  = loadData.next( );
			Fintime  = loadData.nextInt( );
			Percent   = loadData.nextInt( );
			State  = loadData.next( );
			Number  = loadData.next( );
			Workclass  = loadData.next( );
			Workdetail  = loadData.next( );
			temp = new workData(Name,Fintime,Percent,State,Number,Workclass,Workdetail);
			workdata.add( temp );
		}
		loadData.close( );

         }  

	public static void writeData( ) //�g�J�ɮ�
	{
		PrintWriter writeData = null;
		try
		{
			writeData = new PrintWriter( new FileOutputStream("datafile.txt") );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file datafile.txt.");
			System.exit(0);
		}

		for( int i = 0 ; i < workdata.size( ) ; i++ ) {
			writeData.printf( "%-10s", workdata.get( i ).getName() );
			writeData.printf( "%-10d", workdata.get( i ).getfintime() );
			writeData.printf( "%-5d", workdata.get( i ).getPercent() );
			writeData.printf( "%-8s", workdata.get( i ).getState() );
			writeData.printf( "%-10s", workdata.get( i ).getNumber() );
			writeData.printf( "%-10s", workdata.get( i ).getWorkclass() );
			writeData.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			writeData.println( );
		}

		writeData.close( );
	}

        public static void sort(){ //��ܸ��
        System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
        System.out.println("============================================================================");
            for(int i=0;i<workdata.size();i++){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
             }   
        }  

        public static void addData(){
            Scanner scan =new Scanner(System.in);
            String Name;//�u�@�W��
            int Fintime;//�����ɶ�
            int Percent;//�����ʤ���
            String State;//���A
            String Number;//�s��
            String Workclass;//����
            String Workdetail;//�u�@���e
            workData newWork = new workData( );
            try{
                System.out.println("�u�@�W��:");
		Name = scan.next( );
		while( !newWork.setName( Name ) )
			Name = scan.next( );
                System.out.println("�����ɶ�:");
		Fintime = scan.nextInt( );
		while( !newWork.setFintime( Fintime ) )
			Fintime = scan.nextInt( );
                System.out.println("�����ʤ���:");
		Percent = scan.nextInt( );
		while( !newWork.setPercent( Percent ) )
			Percent = scan.nextInt( );
                System.out.println("���A:");
		State = scan.next( );
		while( !newWork.setState( State ) )
			State = scan.next( );
                System.out.println("�s��:");
		Number = scan.next( );
		while( !newWork.setNumber( Number ) )
			Number = scan.next( );
                System.out.println("����:");
		Workclass = scan.next( );
		while( !newWork.setWorkclass( Workclass ) )
			Workclass = scan.next( );
                System.out.println("�u�@���e:");
		Workdetail = scan.next( );
		while( !newWork.setWorkdetail( Workdetail ) )
			Workdetail = scan.next( );
                workdata.add(new workData(Name,Fintime,Percent,State,Number,Workclass,Workdetail));
                System.out.println("�g�J���\");
            }catch(Exception e){
                System.out.println("�������~ ���ˬd��J�榡 ���~��T:"+e);
            }
            
        }

     public static void modifyData()     //�ק�\��
     {
      System.out.println("�渹 |�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
      System.out.println("============================================================================");
            for(int i=0;i<workdata.size();i++){
	                System.out.printf("%-6d", i+1);
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
             }
      Scanner scan = new Scanner(System.in);
      System.out.println("�п�ܱ��ק��ƪ��渹�G");
      int i = scan.nextInt();
	                System.out.printf("%-6d", i);
			System.out.printf( "%-8s", workdata.get( i-1 ).getName() );
			System.out.printf( "%-10d", workdata.get( i-1 ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i-1 ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i-1 ).getState() );
			System.out.printf( "%-10s", workdata.get( i-1 ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i-1 ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i-1 ).getWorkdetail() );
	 System.out.println("");
	System.out.println("\n�п�ܱ��ק諸�u�@���G");
	System.out.println("1.�u�@�W��   2.�����ɶ�   3.�ʤ���   4.���A");
	System.out.println("5.�s��       6.����       7.�u�@���e");
	int j = scan.nextInt();
        int afterConvert = 0;
	System.out.printf("���N��ơG");
	String rewrite = scan.next();
        switch(j){
	  case 1:
	     workdata.get(i-1).setName(rewrite);
             break;
	  case 2:
	     afterConvert = Integer.parseInt(rewrite);
	     workdata.get(i-1).setFintime(afterConvert);
             break;
	  case 3:
	     afterConvert = Integer.parseInt(rewrite);
	     workdata.get(i-1).setPercent(afterConvert);
             break;
	  case 4:
	     workdata.get(i-1).setState(rewrite);
             break;
	  case 5:
	     workdata.get(i-1).setNumber(rewrite);
             break;
	  case 6:
	     workdata.get(i-1).setWorkclass(rewrite);
             break;
	  case 7:
	     workdata.get(i-1).setWorkdetail(rewrite);
             break;
           default :
              System.out.println("~~�п�J1��7~~");
              break;
        }

     }
        
        
        public static void deleteData(){//�R�����
            Scanner scan =new Scanner(System.in);
            String name;
            boolean find=false;
        System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
        System.out.println("============================================================================");
            for(int i=0;i<workdata.size();i++){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
             }
            System.out.println("�п�J�n�R������Ʃm�W:");
            name=scan.next();
            for(int i=0;i<workdata.size();i++){
                if(workdata.get(i).getName().equals(name)){
                    workdata.remove(i);
                    find=true;
                    System.out.println("�R�����\!");
                }
            }
            if(find==false){
                System.out.println("�䤣�즹�W�r,���ˬd���L��J���~�ηs�W���");
            }
            find=false;//reset
        }

        public static void searchData(){
            Scanner scan =new Scanner(System.in);
            int search;
            boolean find=false;//�T�w���S�����
            String name;//�u�@�W��
            int time;//�����ɶ�
            int percent;//�����ʤ���
            String state;//���A
            String number;//�s��
            String workclass;//����
            String workdetail;//�u�@���e
            System.out.println("�п�J�j�M����\n(1.�u�@�W�� 2.�����ɶ� 3.�����ʤ��� 4.���A 5.�s�� 6.���� 7.�u�@���e):");
            try{
                search=scan.nextInt();
                switch(search){
                case 1://�u�@�W��
                    System.out.println("�п�J�u�@�W��:");
                    name=scan.next();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getName().equals(name)){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+name);
                    }
                    break;
                case 2://�����ɶ�
                    System.out.println("�п�J�����ɶ�:");
                    time=scan.nextInt();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getfintime()==time){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+time);
                    }
                    break;
                case 3://�̷ӧ����ʤ���
                    System.out.println("�п�J�����ʤ���:");
                    percent=scan.nextInt();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getPercent()==percent){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+percent);
                    }
                    break;
                case 4://�̷Ӫ��A
                    System.out.println("�п�J���A:");
                    state=scan.next();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getState().equals(state)){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+state);
                    }
                    break;
                case 5://�̷ӽs��
                    System.out.println("�п�J�s��:");
                    number=scan.next();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getNumber().equals(number)){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+number);
                    }
                    break;
                case 6://�̷Ӥ���
                    System.out.println("�п�J����:");
                    workclass=scan.next();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getWorkclass().equals(workclass)){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+workclass);
                    }
                    break;
                case 7://�̷Ӥu�@���e
                    System.out.println("�п�J�u�@���e:");
                    workdetail=scan.next();
                    System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
                    System.out.println("============================================================================");
                    for(int i=0;i<workdata.size();i++){
                        if(workdata.get(i).getWorkdetail().equals(workdetail)){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
                            find=true;
                        }
                    }
                    if(find==false){
                        System.out.println("����� "+workdetail);
                    }
                    break;
                }
                
            }catch(Exception e){
                System.out.println("�������~ ���ˬd��J�榡 ���~��T:"+e);
            }
            find=false;//reset
        }
   
 public static void pagination()      //���~���
 {
        Scanner scan =new Scanner(System.in);
 	int i, page = 1;
        System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
        System.out.println("============================================================================");
            for(i=0;i<workdata.size();i++){
			System.out.printf( "%-8s", workdata.get( i ).getName() );
			System.out.printf( "%-10d", workdata.get( i ).getfintime() );
			System.out.printf( "%-7d", workdata.get( i ).getPercent() );
			System.out.printf( "%-7s", workdata.get( i ).getState() );
			System.out.printf( "%-10s", workdata.get( i ).getNumber() );
			System.out.printf( "%-6s", workdata.get( i ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( i ).getWorkdetail() );
			System.out.println( );
	                if((i+1)%10 ==0 && i <= workdata.size())
		         {
		       System.out.printf("��%d��", page);
        	       System.out.println("");
		       page++;
		       System.out.println("�e���U�@���� 1");
		       int input = scan.nextInt();
		          if(input==1)
		               nextpage(i, page);
		          else
		               System.out.println("��J���O���~" );
                       }
	    }
 }

 public static void nextpage(int i, int page)    //�U�@��
 {
      Scanner scan =new Scanner(System.in);
      int j=i+1, nextpage;
      nextpage = page;
      if(j == workdata.size() - 1 ){
        System.out.println("�u�@�W�� |  �����ɶ� |�ʤ���| ���A |   �s��   | ���� |  �u�@���e");
        System.out.println("============================================================================");
            for(j=i+1;i<workdata.size();j++){
			System.out.printf( "%-8s", workdata.get( j ).getName() );
			System.out.printf( "%-10d", workdata.get( j ).getfintime() );
			System.out.printf( "%-7d", workdata.get( j ).getPercent() );
			System.out.printf( "%-7s", workdata.get( j ).getState() );
			System.out.printf( "%-10s", workdata.get( j ).getNumber() );
			System.out.printf( "%-6s", workdata.get( j ).getWorkclass() );
			System.out.printf( "%-1s", workdata.get( j ).getWorkdetail() );
			System.out.println( );
	     if(((j+1)%10 ==0 && j <= workdata.size()))
		{
		       System.out.printf("��%d��", page);
        	       System.out.println("");
		       page++;
		       System.out.println("�e���U�@���� 1");
		       int input = scan.nextInt();
		          if(input==1)
		               nextpage(i, nextpage);
		          else
		               System.out.println("��J���O���~" );
		}
	}
      }
 }   




}
    
