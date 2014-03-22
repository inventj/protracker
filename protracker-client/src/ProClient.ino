//Serial Relay - Arduino will patch a 
//serial link between the computer and the GPRS Shield
//at 19200 bps 8-N-1
//Computer is connected to Hardware UART
//GPRS Shield is connected to the Software UART 
#include <SoftwareSerial.h>
SoftwareSerial GPRS(7, 8);
unsigned char buffer[64]; // buffer array for data recieve over serial port
int count=0;     // counter for buffer array 
int dLine[30];
void setup()
{
 GPRS.begin(19200);               // the GPRS baud rate   
 Serial.begin(19200);             // the Serial port of Arduino baud rate.
}

void loop()
{
  delay(5000);
  Serial.println("Looping");
  SubmitHttpRequest();
}

///SubmitHttpRequest()
///this function is submit a http request
///attention:the time of delay is very important, it must be set enough 
void SubmitHttpRequest()
{
  GPRS.println("AT+CSQ");
  delay(100);
 
  ShowSerialData();// this code is to show the data from gprs shield, in order to easily see the process of how the gprs shield submit a http request, and the following is for this purpose too.
 
  GPRS.println("AT+CGATT?");
  delay(100);
 
  ShowSerialData();
 
  GPRS.println("AT+SAPBR=3,1,\"CONTYPE\",\"GPRS\"");//setting the SAPBR, the connection type is using gprs
  delay(1000);
 
  ShowSerialData();
 
  GPRS.println("AT+SAPBR=3,1,\"APN\",\"WEB.BE\"");//setting the APN, the second need you fill in your local apn server
  delay(5000);
  ShowSerialData();
  
  GPRS.println("AT+SAPBR=3,1,\"USER\",\"web\"");
  delay(5000);
  ShowSerialData();
  
  GPRS.println("AT+SAPBR=3,1,\"PWD\",\"web\"");
  delay(5000);
  ShowSerialData();
 
  GPRS.println("AT+SAPBR=1,1");//setting the SAPBR, for detail you can refer to the AT command mamual
  delay(10000);
 
  ShowSerialData();
 
  GPRS.println("AT+HTTPINIT"); //init the HTTP request
 
  delay(2000); 
  ShowSerialData();
 
  GPRS.println("AT+HTTPPARA=\"URL\",\"www.protracker.be/hello.php\"");// setting the httppara, the second parameter is the website you want to access
  delay(1000);
 
  ShowSerialData();
 
  GPRS.println("AT+HTTPACTION=0");//submit the request 
  delay(10000);//the delay is very important, the delay time is base on the return from the website, if the return datas are very large, the time required longer.
  //while(!GPRS.available());
 
  ShowSerialData();
 
  GPRS.println("AT+HTTPREAD");// read the data from the website you access
  delay(10000);
 
  Serial.write("i have a response");
  
  checkForResponse();
 
  GPRS.println("");
  delay(100);
}

void ShowSerialData()
{
 while(GPRS.available()!=0)
 Serial.write(GPRS.read());
}
void checkForResponse(){ //this part for text parsing and processing. get 10101010 from
// the website and parse it.

int i = 0;

 while(GPRS.available()!=0 && i < 10){
  // Serial.write('receiving');
   Serial.write(GPRS.read());
   i++;
 }
}
