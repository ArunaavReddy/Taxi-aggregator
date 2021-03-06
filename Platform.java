import java.util.ArrayList;
import base.ess201a7.r16108.*;
import base.ess201a7.a7base.*;

public class Platform {

// all the methods in this class need to be implemented
 Trip t;
 Car c1,c2,c4,min;
 Fleet f1,f2;
 String colour;
 Location l1,l2;
 ArrayList<Fleet> f=new ArrayList<Fleet>();

 
 public Platform() {

 }

 public void addFleet(Fleet fl) {
   f.add(fl);
 }

 // for a request defined as a Trip, find the best car by checking each of its fleets
 // and assigns the car to this trip
 public Car assignCar(Trip trip) {
  int car_i=0,id,count=0;
  double time,min_time=0;
  Car temp;

  for(int i=0;i<f.size();i++)
  {
   temp=f.get(i).findNearestCar(trip.getStart());
   if(temp!=null){
    time=temp.distSqrd(trip.getStart())/temp.getSpeed();
    if(count==0 && temp.getStatus()==1){min_time=time;car_i=i;}
    else if(count!=0 && min_time>=time && temp.getStatus()==1)
    {
     min_time=time;
     car_i=i;
    }
   }
  }

  try{
   f.get(car_i).findNearestCar(trip.getStart()).assignTrip(trip);
   return  f.get(car_i).findNearestCar(trip.getStart());
  }

  catch(Exception e){
   System.out.println("Cars not avaliable");
   return null;
  }

}
 // returns list of all cars (in all the fleets) managed by this platform
 public ArrayList<Car> findCars() {
 ArrayList<Car>  c=new ArrayList<Car>();
  for(int i=0;i<f.size();i++){
   f2=f.get(i);
   c.addAll(f2.getCars());
  }
  return c;
 }
}
