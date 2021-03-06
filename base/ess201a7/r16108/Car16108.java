package base.ess201a7.r16108;

import base.ess201a7.a7base.*;

class Car16108 extends Car {
 int id,max_speed,status;
 double d,k=0,l=0,m=0,n=0,a,b; 

 Location l1,l3,l2;
 Trip t;
 public Car16108(int fid,int speed) {
  super(fid,speed);
  id=fid;
  max_speed=speed;
  status=1;
 }
 public int distSqrd(Location loc){
 int d;
 d=(int) Math.sqrt(Math.pow(loc.getX()-l1.getX(), 2)+Math.pow(loc.getY()-l1.getY(),2));
 return d;
 }
 @Override
 public void setLocation(Location l) {
  // TODO Auto-generated method stub
  l1=l;
 }

 @Override
 public Location getLocation() {
  // TODO Auto-generated method stub
  return l1;
 }
 public int getSpeed(){
  return max_speed;
 }
 @Override
 public void setStatus(int s) {
  // TODO Auto-generated method stub
  status=s;  
 }

 @Override
 public int getStatus() {
  // TODO Auto-generated method stub
  return status;
 }

 @Override
 public void assignTrip(Trip trip) {
  // TODO Auto-generated method stub
  
  if(getStatus()==1){
  t=trip;
  l2=t.getStart(); 
  l3=t.getDest();
   setStatus(2);
  }
 }

// @Override
 public Location getStart() {
  // TODO Auto-generated method stub
   
  return l2;
 }

// @Override
 public Location getDest() {
  // TODO Auto-generated method stub
  
  return l3;
 }
 @Override
 public Trip getTrip(){
if(getStatus()!=1) { return t;
 }
 else{return null;}
}
 @Override

 public void updateLocation(double deltaT) {
  // TODO Auto-generated method stub
    if(getStatus()==3)
    {
      Location l2=getStart();
    Location l3=getDest();
      int speed=getSpeed();
    d=(int) ((speed)*(deltaT));
      int f=(int) Math.pow((l3.getX()-l1.getX()),2)+(int) Math.pow((l3.getY()-l1.getY()),2);
      int o=(int) Math.pow(f,0.5);
      a=(l1.getX())+((d)*((l3.getX())-(l1.getX())))/o;
      b=(l1.getY())+((d)*((l3.getY())-(l1.getY())))/o;
      if((d>=o)){
        a=l3.getX();b=l3.getY();
        setStatus(1);
      }
      l1.set((int)a,(int)b);
    }
    if(getStatus()==2)
    {
      Location l2=getStart();
    Location l3=getDest();
      int speed=getSpeed();
    k=(int) Math.pow(((l2.getX())-(l1.getX())),2)+(int) Math.pow(((l2.getY())-(l1.getY())),2);
    l=(int) Math.pow(k,0.5);
    m=(int) Math.pow(((l3.getX())-(l2.getX())),2)+(int) Math.pow(((l3.getY())-(l2.getY())),2);
    n=(int) Math.pow(m,0.5);
    d=(int) ((speed)*(deltaT));
      if(l>d)
      {
        a=(l1.getX())+((d)*((l2.getX())-(l1.getX())))/l;
        b=(l1.getY())+((d)*((l2.getY())-(l1.getY())))/l;
        
      l1.set((int)a,(int)b);
      }
      if(l<d)
      {
        d=d-l;
        a=(l2.getX())+((d)*((l3.getX())-(l2.getX())))/n;
        b=(l2.getY())+((d)*((l3.getY())-(l2.getY())))/n;
        setStatus(3);
        
      l1.set((int)a,(int)b);
      }
    }
    setLocation(l1);
 }
}
