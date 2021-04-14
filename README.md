A Documentation On URLShortener Project.

Introduction : The project is on URL Shortening. It shortens a Long URL into a short URL. The Short URL gives some user & long URL information like device name, browser name, IP address, OS name. The project store the all information into an Embedded database like H2 Database. The project question has been provided by OrangeToolz Ltd.  
Technology Usage : Programming language Java 8. SpringBoot Framework, H2 Database, Spring Web,
                                      Spring DevTool, Spring Data JPA, 
Project Link : https://gitlab.com/gitsayed/orange-toolz-url-shortening.git
•	REST API DOCUMENTATION 
The project default host and port = localhost:8080/
a)	http://localhost:8080/postlongurl 	Method=”POST”     ;  Required = JSON  ;  Return = JSON
JSON Example = { 

"longurl" : "https://www.baeldung.com/manually-set-user-authentication-spring-security"  ,
"parameters": [    "optional_param1"  ," optional_param2"  ]
}
N.B: This API or End point is used to make short a long URL into a short URL .
b)	http://localhost:8080/shorturlserver/{ shorturl }      Method=”GET”;       Return = JSON .
Return JSON Example =       {
    "id": 6,
    "longurl": "https://www.baeldung.com/manually-set-user-authentication-spring-security",
    "shorturl": "JHUPVA",
    "parameters": [  "a",     "b"      ],
    "ipaddress": "192.168.0.114",
    "devicename": "DESKTOP-6P7G13O",
    "browsername": "Unknown - vnull",
    "osname": "Unknown"
}
N.B: Please use short url value from return JSON  “ a)”.
 

c)	 http://localhost:8080/getrecordbyid/{id}                                  Method=”GET”    ; Return = JSON
Return JSON Example =       {
   "id": 6,
    "longurl": "https://www.baeldung.com/manually-set-user-authentication-spring-security",
    "shorturl": "JHUPVA",
    "parameters": [  "a",     "b"      ],
    "ipaddress": "192.168.0.114",
    "devicename": "DESKTOP-6P7G13O",
    "browsername": "Unknown - vnull",
    "osname": "Unknown"
}
N.B: Please use ID value from return JSON  “ a)”or “ b)”.

d)	http://localhost:8080/golongurl /{short_url}   ;  Method = “GET”  ; 

 N.B: Please use short_url value from return JSON  “ a)” or, “ b)”,or,  “ c)”.  This url redirect you to your long url address with your parameters value.

e)	http://localhost:8080/renderalldata   ;  Method = “GET” 
N.B: You will get all data about short and long url as well as others in a JSON  format from H2 Database.
        f)   http://localhost:8080/shorturlcount     ;   Method= “GET”
N.B: You will get total count on short url in JSON format.

**If any other query about the project please let me know.
@Documentation & Project Created By:
MD. ABU SAYED
abucollege@gmail.com
#01763732124 
