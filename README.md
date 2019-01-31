# Taxi-aggregator
This is a implmentation of taxi aggregator service.The design uses the MVC or Model-View-Control pattern: Platform, Fleet and Car form the Model, App represents the Control, and Display the View.

# Structure:
The system consists of the following main parts:
1. Platform : this is the core of the aggregator service. It manages the fleets and cars
attached to it, and helps customers find taxis for their rides
2. Fleet::One or more fleets attach themselves to the platform, so that they can be included
in assigning rides to customers
3. Car: A fleet consists of a set of Cars, and these are managed by the fleet.
4. Location: (x,y) coordinates of the position of a car or customer
5. Trip: contains the start Location and end Location as requested by a customer.
6. App: This manages the front end and the interactions with the user, and intermediates
between the user and the platform and other classes
7. Display: The interactive front-end that a user of the system sees. Implemented using
Java Swing
# Functionality
The system has the following functionality
1. Fleet:
a. Adds Cars to itself, creating the car in the process.
b. Find its “nearest” available car for a given location
c. Each fleet has a distinct colour, assigned when it is created
d. Each fleet has a unique id, the last 4 digits of your roll number.
2. Car:
a. Each car has a unique id, the fleet id followed by an integer unique to that fleet.
b. A car has a max speed - specified at create time. We can assume that the car
always travels at this speed.
c. Check the status of a car. A car is in one of the following states:
i. Idle: available for assignment to a customer/trip
ii. Booked: assigned to a customer, but has not yet picked up the customer
iii. OnTrip: ferrying a customer from source to destination
d. Assigned to a Trip
e. Updates its location when notified of change in time. Updates its status if needed.
f. Reports its location.
3. Platform
a. Can attach a fleet to it
b. Manages the list of fleets
c. Decides which car should be assigned for a trip request
4. App:
a. Manages the Display
b. Handles user (customer) requests
c. Simulates time - asks each car to update its location by specifying the delta-time
since the last call. You can assume this delta-t is small enough that you will get
the impression of fairly smooth motion of the cars.
d. Updates the display periodically showing the position of cars and the status of a
trip
5. Display:
a. A “map” showing the location of cars and trips
b. A way for the user of the app to request a ride by clicking on the source and
destination points on the map

The app functions as follows:

● The main instantiates the fleets and cars of the fleet by reading an input file (format
defined later) and hands over control to the App

● The app displays a map (a rectangular area) showing the status of all cars and trips.
Cars are shown as small circles/rectangles/images, in the colour of their fleet, and with
their id/name next to it. Idle cars have a special indication (colour, font or any other
means to distinguish them)

● Trips are shown by lines

● If in Booked state, a line from the car to the pickup point

● If OnTrip, a line from source to destination

● A customer (user of the app) requests a ride by clicking on a “Request” button and
clicking two points on the map. The system searches through the fleets and assigns an
available car to this user

● The App periodically checks the status and locations of all cars and trips and updates
the Display

