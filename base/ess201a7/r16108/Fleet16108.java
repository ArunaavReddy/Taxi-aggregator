package base.ess201a7.r16108;
import java.util.*;
import base.ess201a7.a7base.*;

public class Fleet16108 extends Fleet {
 ArrayList<Car16108> c=new ArrayList<Car16108>();
  ArrayList<Car16108> c3=new ArrayList<Car16108>();
 public Car16108 c1,c2,min;
 private int id,x1,x2,y1,y2,i=0;
 private double temp1,temp2;
 public Location l1,l2;
 public String clr;
 public Fleet16108(String colour) {
  super(16108,colour);
  clr=colour;
 }
 public String getColour()
 {
  return clr;
 }
 @Override
 public void addCar(int speed) {
  c1=new Car16108(16108,speed);
  c.add(c1);
 }

 @Override
 public Car findNearestCar(Location loc) {
  int ci=0,a=0,d=0;
  int dist,min=0,temp;
 for(int i=0;i<c.size();i++){
   c1=c.get(i);
    if(c1.getStatus()==1){
      a=1;
      dist=c1.distSqrd(loc);
      if(d==0){
        min=dist;
        ci=i;
        d=1;
      }
      else if(d!=0&&min>=dist){min=dist;ci=i;}
    }
   }
 if(a==1){return c.get(ci);}
 else{return null;}
 }
 

 
 @Override
 public ArrayList<? extends Car> getCars(){
   return c;
 }
}
