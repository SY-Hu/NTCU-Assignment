public class workData{
    private String Name;//工作名稱
    private int Fintime;//完成時間
    private int Percent;//完成百分比
    private String State;//狀態
    private String Number;//編號
    private String Workclass;//分類
    private String Workdetail;//工作內容

    workData(){
        
    }
    workData(String name,int fintime,int percent,String state,String number,String workclass,String workdetail){
            Name=name;
            Fintime=fintime;
            Percent=percent;
            State=state;
            Number=number;
            Workclass=workclass;
            Workdetail=workdetail;
    }
    public boolean setName(String name)     //工作名稱
    {
         if(name == null)
         {
          System.out.println("沒有輸入工作名稱");
	return false;
         }
         else
	{
	Name = name;
	return true;
	}
    }

    public String getName()    
    {
    return Name;
    }

    public boolean setFintime(int fintime)     //完成時間
    {

	Fintime = fintime;
	return true;
    }

    public int getfintime()  
    {
    return Fintime;
    }
    public boolean setPercent(int percent)     //百分比
    {
         if(percent < 0 || percent > 100 )
         {
          System.out.println("超出百分比範圍");
	return false;
         }
         else
	{
	Percent = percent;
	return true;
	}
    }

    public int getPercent()
    {
    return Percent;
    }

    public boolean setState(String state)     //狀態設定
    {

	State = state;
	return true;

    }

    public String getState() 
    {
    return State;
    }

    public boolean setNumber(String number)     //編號設定(以１個英文字母開頭，接著是５位數字)
    {
	if(number == null)
	{	
		System.out.println("錯誤編號格式");
		return false;
	}
                else
	{
		if(number.substring(0,1).matches("[a-zA-Z]") && number.substring(1,6).matches("[0-9]"))
		Number = number;
		return true;
	}
    }

    public String getNumber()  
    {
    return Number;
    }

    public boolean setWorkclass(String workclass)     //分類
    {
         if(workclass == null)
         {
          System.out.println("未輸入分類");
	return false;
         }
         else
	{
	Workclass = workclass;
	return true;
	}
    }

    public String getWorkclass()  
    {
    return Workclass;
    }

    public boolean setWorkdetail(String workdetail)     //工作內容
    {
         if(workdetail == null)
         {
          System.out.println("未輸入工作內容");
	return false;
         }
         else
	{
	Workdetail =workdetail;
	return true;
	}
    }

    public String getWorkdetail()
    {
    return Workdetail;
    }

    
}