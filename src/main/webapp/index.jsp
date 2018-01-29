<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="latin1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search or Upload</title>
		<!-- Tomcat v9.0 Server at localhost (7) this is the servlet -->
	</head>
	<body>
		<center>
			<FORM METHOD=POST ACTION="ImageDeliverer">
					<!--  
										   Base64 file to upload: <input type=text name="base64" />
										        <br />
										        Description: <input type=text name="description" />
										        <br /> 
										        Please enter the corresponding tag("Food","Places","Fun","Events"):
										        <input type=TEXT name="tag" />
										        <br />
										        Type who is the user committing it:
										        <input type=TEXT name="user" />
										        <br />
										        Type days or pay for results ("DAYS","PFR"):
										        <input type=TEXT name="settingService" />
										        <br />
										        Tell us the number of DAYS or the number of users for which you are paying:
										        <input type=TEXT name="quantity">
										        Remember we have to set everything.
								    
									
											Set APIKEY assigned:
												<INPUT TYPE=TEXT NAME="apikey"><P>
											Set the name for your sticker:
												<INPUT TYPE=TEXT NAME="name"><P>
											Set the command (erase, add, edit):
												<INPUT TYPE=TEXT NAME="command"><P>
					-->
					Send image?
												<INPUT TYPE=SUBMIT>
				
			</FORM>
		</center>
	</body>
</html>
