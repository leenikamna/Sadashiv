#Gherkin
@vieworder
Feature: vieworder

Background: 
Given User is on Home Page
Then User Click on Notification
When User Click on My Profile Icon
Then User Enter Mobile number
And User Click on Submit Button
When User Enter OTP
And User Click on OTP Submit Button


@My_Profile_Customer_Name_Display
Scenario: My Profile Customer Name Display
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
Then User can See Name of Person

@My_Profile_Data_Update
Scenario: My Profile Data Update
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then It Display My Profile Page
When User Click on Edit Image Button
Then User Update First Name
Then user Update Last Name
Then User Update Date of Birth
Then User Update Mobile Number
And Click on Update Link

@My_Profile_Image_Upload
Scenario: My Profile Image Upload
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then It Display My Profile Page
When User Click on Upload Button to Update Profile Image
Then Profile Image is Updated

@My_Profile_Data_Update_Again
Scenario: My Profile Data Update Again
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then It Display My Profile Page
When User Click on Edit Image Button
Then User Update First Name Again
Then user Update Last Name Again
Then User Update Date of Birth Again
Then User Update Mobile Number Again
And Click on Update Link

@My_Profile_Image_Upload_Again
Scenario: My Profile Image Upload Again
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then It Display My Profile Page
When User Click on Upload Button to Update Profile Image Again
Then Profile Image is Updated


@My_Order_Accessbility
Scenario: My Order Accessbility
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
When User Click on My Order Link
Then User will Display Ordered Products 
And User Click on View Details Link of first product
Then User See Detailed Information of Product
Then User Click on Close Link of first product

@Add_Bill_in_My_Documents
Scenario: Add Bill in My Documents
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then User Click on My Documents link
When User Click on Add New Bill Button to Upload Bill
Then Bill is Displayed in My Documnets Page

@Removing_of_Bill_from_My_Documents
Scenario: Removing of Bill Form My Documents
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on My Profile Link
Then User Click on My Documents link
When User Click on Delete Button
Then Bill is Deleted From My Documents Page
 
@My_Cart_Empty
Scenario: My_Cart_Empty
Given User is on Registred Home Page
When User Click on My Cart Icon
Then User See Message Cart Is Empty
And User Click on Start Shopping Link
Then User Naviagte to Shopping Page
And User Click on Wall Stickers
When User Click on Add To Cart Button
Then Product Is Added To Cart

@Proceed_To_CheckOut
Scenario: Proceed To CheckOut
Given User is on Registred Home Page
When User Click on My Cart Icon
Then User Click on Checkout Button

@Remove_Product_From_Cart
Scenario: Remove Product From Cart
Given User is on Registred Home Page
When User Click on My Cart Icon
Then User Can See The Products Which are Added From Shop Page
And User Click on Delete Symbol To Remove Product From Cart
Then Product is Reomved from My Cart

@My_wishList_Empty
Scenario: My wishList Accessibility
Given User is on Registred Home Page
When User Click on My WishList Icon
Then User See My WishList Empty
And User Click on Continue Shopping to Add Product
Then User Naviagte to Shopping Page
And User Click on Wall Stickers From WishList
Then User Clink on Add to WishList Button
Then Product Is Added To WishList

@Remove_Product_From_wishList
Scenario: Remove Product From wishList
Given User is on Registred Home Page
When User Click on My WishList Icon
Then User Can See The Products Which are Added From Shop Page
And User Click on Cross Symbol
Then Product is Removed From My WishList

@Logout_Account
Scenario: Logout Account
Given User is on Registred Home Page
When User Click on Registred My Profile Icon
And User Click on Signout link
Then User Gets Signout From Account