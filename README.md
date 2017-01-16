# smartcity

Smart City Architecture

For The bus system, there are existing service manager, master data manager, and event data manager packeges.
Existing service manager sends the query to the existing bus services to acquire the data and translate the obtained data. 
It obtains the address for the bus service through the URL generator, and sends the query to the address to receive the XML 
formatted data. The received data is converted into bus object through the translator. The converted data is then transferred to 
the master data manager and the event data manager, respectively. Data manager converts the bus object into EPCIS master data 
and event data and registers them in EPCIS.

