# caddy-management
Online Cart Manager with EJB JSP under mysql data source managed by webserver wildfly 11.

Steps:
- Set a managed datasource in your wildfly server and make sure the connection test has succeded
- Make sure you have jdbc jar on the ejb project root folder
- Make sure you have jstl jar on your web project root folder
- Create an ear project and add both web project and ejb project to your ear
