
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class menuImplement extends workData  {

        public static ArrayList<workData> workdata=new ArrayList<workData>();

        public static void loadData()//讀取檔案
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
               String Name;//工作名稱
               int Fintime;//完成時間
               int Percent;//完成百分比
               String State;//狀態
               String Number;//編號
               String Workclass;//分類
               String Workdetail;//工作內容
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

	public static void writeData( ) //寫入檔案
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

        public static void sort(){ //顯示資料
        System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
            String Name;//工作名稱
            int Fintime;//完成時間
            int Percent;//完成百分比
            String State;//狀態
            String Number;//編號
            String Workclass;//分類
            String Workdetail;//工作內容
            workData newWork = new workData( );
            try{
                System.out.println("工作名稱:");
		Name = scan.next( );
		while( !newWork.setName( Name ) )
			Name = scan.next( );
                System.out.println("完成時間:");
		Fintime = scan.nextInt( );
		while( !newWork.setFintime( Fintime ) )
			Fintime = scan.nextInt( );
                System.out.println("完成百分比:");
		Percent = scan.nextInt( );
		while( !newWork.setPercent( Percent ) )
			Percent = scan.nextInt( );
                System.out.println("狀態:");
		State = scan.next( );
		while( !newWork.setState( State ) )
			State = scan.next( );
                System.out.println("編號:");
		Number = scan.next( );
		while( !newWork.setNumber( Number ) )
			Number = scan.next( );
                System.out.println("分類:");
		Workclass = scan.next( );
		while( !newWork.setWorkclass( Workclass ) )
			Workclass = scan.next( );
                System.out.println("工作內容:");
		Workdetail = scan.next( );
		while( !newWork.setWorkdetail( Workdetail ) )
			Workdetail = scan.next( );
                workdata.add(new workData(Name,Fintime,Percent,State,Number,Workclass,Workdetail));
                System.out.println("寫入成功");
            }catch(Exception e){
                System.out.println("不明錯誤 請檢查輸入格式 錯誤資訊:"+e);
            }
            
        }

     public static void modifyData()     //修改功能
     {
      System.out.println("行號 |工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
      System.out.println("請選擇欲修改資料的行號：");
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
	System.out.println("\n請選擇欲修改的工作欄位：");
	System.out.println("1.工作名稱   2.完成時間   3.百分比   4.狀態");
	System.out.println("5.編號       6.分類       7.工作內容");
	int j = scan.nextInt();
        int afterConvert = 0;
	System.out.printf("取代資料：");
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
              System.out.println("~~請輸入1到7~~");
              break;
        }

     }
        
        
        public static void deleteData(){//刪除資料
            Scanner scan =new Scanner(System.in);
            String name;
            boolean find=false;
        System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
            System.out.println("請輸入要刪除的資料姓名:");
            name=scan.next();
            for(int i=0;i<workdata.size();i++){
                if(workdata.get(i).getName().equals(name)){
                    workdata.remove(i);
                    find=true;
                    System.out.println("刪除成功!");
                }
            }
            if(find==false){
                System.out.println("找不到此名字,請檢查有無輸入錯誤或新增資料");
            }
            find=false;//reset
        }

        public static void searchData(){
            Scanner scan =new Scanner(System.in);
            int search;
            boolean find=false;//確定有沒有找到
            String name;//工作名稱
            int time;//完成時間
            int percent;//完成百分比
            String state;//狀態
            String number;//編號
            String workclass;//分類
            String workdetail;//工作內容
            System.out.println("請輸入搜尋條件\n(1.工作名稱 2.完成時間 3.完成百分比 4.狀態 5.編號 6.分類 7.工作內容):");
            try{
                search=scan.nextInt();
                switch(search){
                case 1://工作名稱
                    System.out.println("請輸入工作名稱:");
                    name=scan.next();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+name);
                    }
                    break;
                case 2://完成時間
                    System.out.println("請輸入完成時間:");
                    time=scan.nextInt();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+time);
                    }
                    break;
                case 3://依照完成百分比
                    System.out.println("請輸入完成百分比:");
                    percent=scan.nextInt();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+percent);
                    }
                    break;
                case 4://依照狀態
                    System.out.println("請輸入狀態:");
                    state=scan.next();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+state);
                    }
                    break;
                case 5://依照編號
                    System.out.println("請輸入編號:");
                    number=scan.next();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+number);
                    }
                    break;
                case 6://依照分類
                    System.out.println("請輸入分類:");
                    workclass=scan.next();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+workclass);
                    }
                    break;
                case 7://依照工作內容
                    System.out.println("請輸入工作內容:");
                    workdetail=scan.next();
                    System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
                        System.out.println("未找到 "+workdetail);
                    }
                    break;
                }
                
            }catch(Exception e){
                System.out.println("不明錯誤 請檢查輸入格式 錯誤資訊:"+e);
            }
            find=false;//reset
        }
   
 public static void pagination()      //分業顯示
 {
        Scanner scan =new Scanner(System.in);
 	int i, page = 1;
        System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
		       System.out.printf("第%d頁", page);
        	       System.out.println("");
		       page++;
		       System.out.println("前往下一頁案 1");
		       int input = scan.nextInt();
		          if(input==1)
		               nextpage(i, page);
		          else
		               System.out.println("輸入指令錯誤" );
                       }
	    }
 }

 public static void nextpage(int i, int page)    //下一頁
 {
      Scanner scan =new Scanner(System.in);
      int j=i+1, nextpage;
      nextpage = page;
      if(j == workdata.size() - 1 ){
        System.out.println("工作名稱 |  完成時間 |百分比| 狀態 |   編號   | 分類 |  工作內容");
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
		       System.out.printf("第%d頁", page);
        	       System.out.println("");
		       page++;
		       System.out.println("前往下一頁案 1");
		       int input = scan.nextInt();
		          if(input==1)
		               nextpage(i, nextpage);
		          else
		               System.out.println("輸入指令錯誤" );
		}
	}
      }
 }   




}
    
