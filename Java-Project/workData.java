public class workData{
    private String Name;//�u�@�W��
    private int Fintime;//�����ɶ�
    private int Percent;//�����ʤ���
    private String State;//���A
    private String Number;//�s��
    private String Workclass;//����
    private String Workdetail;//�u�@���e

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
    public boolean setName(String name)     //�u�@�W��
    {
         if(name == null)
         {
          System.out.println("�S����J�u�@�W��");
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

    public boolean setFintime(int fintime)     //�����ɶ�
    {

	Fintime = fintime;
	return true;
    }

    public int getfintime()  
    {
    return Fintime;
    }
    public boolean setPercent(int percent)     //�ʤ���
    {
         if(percent < 0 || percent > 100 )
         {
          System.out.println("�W�X�ʤ���d��");
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

    public boolean setState(String state)     //���A�]�w
    {

	State = state;
	return true;

    }

    public String getState() 
    {
    return State;
    }

    public boolean setNumber(String number)     //�s���]�w(�H���ӭ^��r���}�Y�A���۬O����Ʀr)
    {
	if(number == null)
	{	
		System.out.println("���~�s���榡");
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

    public boolean setWorkclass(String workclass)     //����
    {
         if(workclass == null)
         {
          System.out.println("����J����");
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

    public boolean setWorkdetail(String workdetail)     //�u�@���e
    {
         if(workdetail == null)
         {
          System.out.println("����J�u�@���e");
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