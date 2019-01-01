# SpringBoot

This is the sample application with Spring Boot with REST methods.

Testing instructions:-
1. To check all the interest data with GET as request method
localhost:9999/interest/all

2. To add a new entry
localhost:9999/interest/add and request method should be POST
and put below data in body payload
{
	"id": "1",
	"address": "VJA",
	"name": "Rames",
	"amount": "100.00",
	"datetime": "2019-JAN-15",
	"rate": "3.50"
}

3. To check a particular entry (let us say 1) with GET as request method
localhost:9999/interest/1
you should get output like
{
    "id": 1,
    "name": "Rames",
    "address": "VJA",
    "amount": 3.5,
    "datetime": "2019-01-15T00:00:00.000+05:30",
    "status": false,
    "rate": null
}

4. To update an existing entry
localhost:9999/interest/update with request method as PUT
and body should contain data like this
{
    "id": 1,
    "name": "Rames",
    "address": "VJA",
    "amount": 3.5,
    "datetime": "2019-01-15T00:00:00.000+05:30",
    "status": false,
    "rate": null
}

5. To delete an existing record
localhost:9999/interest/1 with request method as DELETE

6. To get all inactive entries(where status = 0)
This is still pending
6. 
