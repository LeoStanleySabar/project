# shoppingcart
Steps :
1. Unzip the angularJS file and run the commands:                      npm install http-server --save
2. Unzip the server file and run the the command:                      java -jar server-0.0.1-SNAPSHOT.jar -Dskip.tests=true
3. Go back to unzipped angularJs folder and run the command:           http-server -o

4. Setup PstgresDB or MySqLDB  [this proj uses postgresDB] and make a new DB with name  ' shopdbnew '
5. Check maven setup in local and run command:                         mvn install -Dmaven.test.skip=true
6. GOTO target folder and run command:                                 java -jar ShoppingCart-0.0.1-SNAPSHOT.jar -Dskip.tests=true

7. use the url : http://127.0.0.1:8081/#!/login
User Login:  user@gmail.com/password 
