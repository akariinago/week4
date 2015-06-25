
import java.io.*;
import java.util.*;

public class IsOpenNow {
  
  public static boolean isOpenNow(int dayOfWeek, int hour) {
	  double a[]=new double[1000];
	  String b[]=new String[100];
	  int calender[] =new int[100];
      int i,j;
      i=0;
      j=0;
      try
      {
    	  	  File file = new File("src/opennow.txt");
              FileReader fr=new FileReader(file);     //FileReaderオブジェクトの作成
              StreamTokenizer st=new StreamTokenizer(fr);     //StreamTokenizerオブジェクトの作成
              
              File file2 = new File("src/holiday.txt");
              FileReader fr2=new FileReader(file2);     //FileReaderオブジェクトの作成
              StreamTokenizer st2=new StreamTokenizer(fr2);     //StreamTokenizerオブジェクトの作成
              
              while(st.nextToken()!=StreamTokenizer.TT_EOF)   //ファイルの終わりに達するとTT_EOFが返されるので、そこでループ終了
              {
                      a[i]=st.nval;   //読み取った時間を配列に代入
                      i++;
                      
             }
              while(st2.nextToken()!=StreamTokenizer.TT_EOF)
              {
            		  b[j]=st2.sval;    //読み取った曜日を配列に代入
                      j++;
                      
              }
              fr.close();
      }
      catch(Exception e)
      {
              System.out.println(e);  //エラーが起きたらエラー内容を表示
      }
      for(i=0; i<b.length; i++){    //dayOfWeekが休日だったらfalseを返す
    	 if ("Sunday".equals(b[i])){
    	  calender[i]=1;
       	}else if ("Monday".equals(b[i])){
    	  calender[i]=2;
    	  
    	}else if ("Tuesday".equals(b[i])){
      	  calender[i]=3;
      	}else if ("Wednesday".equals(b[i])){
      	  calender[i]=4;
      	}else if ("Thursday".equals(b[i])){
      	  calender[i]=5;
      	}else if ("Friday".equals(b[i])){
      	  calender[i]=6;
      	}else if ("Saturday".equals(b[i]))
      	  calender[i]=7;
    	 if (dayOfWeek == calender[i])
    	      return false;	
      }
 
    if(a[0]>a[1]){
    	return a[0] <= hour || hour < a[1]; //営業時間が別れてなくて日をまたぐ場合
    }

    else if(a[2]>a[3]){
    	return a[0] <= hour && hour < a[1]||a[2] <= hour || hour < a[3];	 //営業時間が別れていて日をまたぐ場合
    }
    else{
    	if(a.length==2){
    	    return a[0] <= hour && hour < a[1];//営業時間が別れてなくて日も跨がない場合
    	}
    	else{
    	    return (a[0] <= hour && hour < a[1])||(a[2] <= hour && hour < a[3]);//営業時間が別れていて日も跨がない場合
	
    	    }
    }
    	

  }
  
  public static boolean isOpenNow() {
    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    return isOpenNow(dayOfWeek, hour);
  }
}