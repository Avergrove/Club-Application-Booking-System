Instructions:
	- Pull the project from Git to Eclipse
	- Extract version5.zip in the SQL folder, to any folder
		- Import these datasets into MYSQL
		
	- Right click on the project, Maven > Maven Update
	- Run on Server: Pivotal Server
	- Now browse 
		http://localhost:8080/iss/
			to your heart's content! \o/
			
Admin:
Username= george
Password= 101010

User:
Username= james
Password= 12345

*Note: 
-Booking is made on a per day basis per facility.
-We have successfully implemented cascaded drop-down list in the booking page:)
	-Facilities are auto populated based on category selection. If the list is empty, 
	it means no "active" facilities are available.
	-Booked dates are passed to the calendar pickers and disabled. 
	-Server validators have been set in placed to prevent duplicate booking too.
	-In case if the calendar picker isn't loading, either click on the comment box and reclick the date option,
	 or reselect the facilityId.
	 
 
	