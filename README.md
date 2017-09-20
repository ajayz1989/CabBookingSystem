# CabBookingSystem
A small system to book cabs for the given set of request. Developed using core Java.

# Problem Statement

The city in which the cab operates is divided into 100 sectors each having 6 digits area codes ranging
from 100001 to 100100. The distance between two adjacent sectors is 2 km
I.e. distance between area 100008 and 100009 is 2 km, similarly between 100008 and 100015 is 14 km.
Time taken by a cab to travel 1 km is 2 minutes. The company incurs a cost of Rs. 5/ km but charges a fare
of Rs.10/ km.

The system takes a batch of booking requests and finds suitable cabs for serving the requests. It can be
assumed that requests can only have pickup time on the same day. A request comprises of unique
request id, pick up area code, and drop area code and pickup time.
