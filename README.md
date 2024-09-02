## Project Setup Steps

- git clone {url_of_repo}
- open CSD-Case-Study-Repo folder and navigate to the Group 1-Python,Java
- use command cd and the folder name for the windows os
- then go to the folder name "26081743"
- extract the zip file name "26081743" 
- install jdk 8 or above version
- install any java support IDE suggested intelij
- open restaurent management system in the IDE and navigate to source folder
- run the main.java file
  

## Features

- ### addMenuItem()
  - this method adds the item in the in-memory as well as in persistent memory (menuitem.txt).
- ### removeMenuItem()
  - this mehtod remove the item in the in-memory as well as in persistent memory (menuitem.txt).
- ### searchMenuItem()
  - this method search the item in the in-memory as well as in persistent memory (menuitem.txt).
- ### placeOrder()
  - this method place the order choosen by the user through console.
- ### processOrder()
  - this mehtod process the order and update the status of the order from pendinto to served.
- ### helper()
   - this method is execute every time when ever the run time error is hitted.


## Additional Features

- ### updateMenuFileItemWithCategory()
  - this method genraly make sure that category in the file must be in a Lexicographical order.
- ### genrateBill()
  - this method genrate the bill on the basis of order id which is unique for every order.
- ### showCategory()
  - this method is used to show the menu card by first showing category and choosing specific category than show item inside it.

## Helper method()

- ### updateMenuFileAfterRemoval()
  - this method help to update the menuItem.txt after remove the item from the list.
- ### formateMenuItemForFile()
  - this method help to formate the item into file so that programmer easily map into orderList.
  
 
## Exception Handling
- ### IOException
  - this exception is using in the program where ever the input file i.e menuitem.txt is used for read and write operations.
- ### InputMismatchException
  - this exception is used where application take the input from the user to ensure no wrong input is provided.
