/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author root
 */
public class ChartDataSet implements Serializable {
    
    String label;
   List<Number> values= new ArrayList<>();
   Collection<StatsData> data= new ArrayList<>();
   int option;

    public ChartDataSet(Collection<StatsData> data, int option) {
        this.data = data;
        this.option=option;
    }
   

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    

    public List<Number> setChartVaues()
    {
        System.out.println("option="+option);
          for(StatsData s: data)
       {
              switch (option) {
                  case 1:
                      values.add(s.option1);
                      System.out.println("cval="+s.getOption1());
                      this.label = s.getQ().getOption1();
                      break;
                  case 2:
                      values.add(s.option2);
                      this.label = s.getQ().getOption2();
                      break;
                  case 3:
                      values.add(s.option3);
                      this.label = s.getQ().getOption3();
                      break;
                  case 4:
                      values.add(s.option4);
                      this.label = s.getQ().getOption4();
                      break;
                  case 5:
                      values.add(s.totalResponses);
                      this.label = "Total Response";
                      break;
                  default:
                      break;
              }
           
                    
                       
       }
          return values;
         
    }
    
    public List<Number> getValues() {
        return values;
    }

    public void setValues(List<Number> values) {
     
      
        
        
        this.values = values;
    }
   
   
    
}
