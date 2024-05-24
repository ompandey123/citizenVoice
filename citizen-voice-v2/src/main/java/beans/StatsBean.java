/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import stats.AnswerStats;

/**
 *
 * @author root
 */
@Named(value = "statsBean")
@RequestScoped
public class StatsBean implements Serializable {
    
    @EJB AnswerStats stats;
    
    private BarChartModel barModel2;
    String category;
    int totalopt1;
    int totalopt2;
    int totalopt3;
    int totalopt4;
    int gtotal;
    int count=1;
    int rcount=1;
    
    
    String level;
    int pid;
    //int pid=12;
    int qid;
    Collection<StatsData> sdata= new ArrayList<>();
   

  
    

    
    public String showStat(int qid, String level, int pid)
    {
        System.out.println("Show Stat Level = " + level);
        this.qid=qid;
        this.level=level;
        this.pid=pid;
         createBarModel2();
         
        return "Stats.jsf";
    }
    
    
    public BarChartModel getBarModel2() {
        return barModel2;
    }

    public void setBarModel2(BarChartModel barModel2) {
        this.barModel2 = barModel2;
    }
    
    
    
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getTotalopt1() {
        return totalopt1;
    }

    public void setTotalopt1(int totalopt1) {
        this.totalopt1 = totalopt1;
    }

    public int getTotalopt2() {
        return totalopt2;
    }

    public void setTotalopt2(int totalopt2) {
        this.totalopt2 = totalopt2;
    }

    public int getTotalopt3() {
        return totalopt3;
    }

    public void setTotalopt3(int totalopt3) {
        this.totalopt3 = totalopt3;
    }

    public int getTotalopt4() {
        return totalopt4;
    }

    public void setTotalopt4(int totalopt4) {
        this.totalopt4 = totalopt4;
    }

    public int getGtotal() {
        return gtotal;
    }

    public void setGtotal(int gtotal) {
        this.gtotal = gtotal;
    }

    
     
     
    public Collection<StatsData> getSdata() {
        
        if((qid!=0) && (pid>0)){
        sdata= stats.getStats(qid, level, pid);
        if(count==1){
        for(StatsData s : sdata)
        {
            totalopt1+=s.option1;
            totalopt2+=s.option2;
            totalopt3+=s.option3;
            totalopt4+=s.option4;
            gtotal+=s.totalResponses;
            count++;
        }
        }
        
        }
        else if((qid!=0) && (pid==0)){
        sdata= stats.getStats(qid, level,0);
       
        if(rcount==1){
        for(StatsData s : sdata)
        {
            totalopt1+=s.option1;
            totalopt2+=s.option2;
            totalopt3+=s.option3;
            totalopt4+=s.option4;
            gtotal+=s.totalResponses;
            rcount++;
        }
        }
        }
//        System.out.println(totalopt1);
//        System.out.println(totalopt2);
//        System.out.println(totalopt3);
//        System.out.println(totalopt4);
//        System.out.println(gtotal);
//        
        
        
        return sdata;
        
            
        
    }
    
    
    
     public void createBarModel2() {
        barModel2 = new BarChartModel();
      System.out.println("In create chart");
        ChartData data = new ChartData();
         List<String> labels=new ArrayList<>();
        Collection<ChartDataSet> csets = new ArrayList<>();
        List<Number> values = new ArrayList<>();
        System.out.println("qid="+qid);
        System.out.println("level="+level);
        System.out.println("pid="+pid);
       Collection<StatsData> mdata= stats.getStats(qid,level, pid);
     
       for(int i=1;i<6;i++){
        ChartDataSet cd = new ChartDataSet(mdata, i);
        List<Number> vals = cd.setChartVaues();
       
        cd.setValues(vals);
       // cd.setLabel;
        csets.add(cd);
        }
       
        
        for(ChartDataSet s: csets)
        {
         
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel(s.getLabel());
        barDataSet.setBackgroundColor("rgba(255, 99, 132, 0.2)");
        barDataSet.setBorderColor("rgb(255, 99, 132)");
        barDataSet.setBorderWidth(1);
      
       // values.addAll(s.getValues());

        barDataSet.setData(s.getValues());
        data.addChartDataSet(barDataSet);      
//        labels.add(s.getLevelName());
        
        }
        
        for(StatsData s: mdata)
        {
            System.out.println("level=="+s.getLevelName());
           labels.add(s.getLevelName()); 
        }
        
        
        
        data.setLabels(labels);
        barModel2.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        //options.setMaintainAspectRatio(false);
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Bar Chart");
        options.setTitle(title);

        barModel2.setOptions(options);
    }

    public void setSdata(Collection<StatsData> sdata) {
        this.sdata = sdata;
    }

  public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
       public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

   

    public StatsBean() {
    }
    
}
