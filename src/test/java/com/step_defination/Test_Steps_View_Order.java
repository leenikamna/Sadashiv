package com.step_defination;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lib.ExcelSheet;
import com.lib.ScreenShot;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps_View_Order {

	private WebDriver driver;
	private ViewOrderPageFactory order;
	private ExcelSheet file;
	
	@Before
	public void launch_Browser() throws InterruptedException
	{
		//System.setProperty("webdriver.edge.driver", "C:\\Cucumber_Training\\com.asianpaintsj26\\Driver\\msedgedriver.exe");
		//driver = new EdgeDriver();
		//EdgeOptions option1 = new EdgeOptions();
		//option1.set
		System.setProperty("webdriver.chrome.driver", "C:\\Cucumber_Training\\com.asianpaintsj26\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "localhost:9222");
		driver=new ChromeDriver(); //options
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.asianpaints.com/");
		Thread.sleep(2000);
		
		options.addArguments("--disable-notifications");
		// Creating a Object of ViewOrderPageFactory class
		order = new ViewOrderPageFactory(driver);
		//using pagefactory file as reference....
		order = PageFactory.initElements(driver, ViewOrderPageFactory .class);
		//Creating a Object of ExcelSheet class
		file = new ExcelSheet();
		
	}
	
	//Scenario : My Porfile Customer Login
	@Given("User is on Home Page") 
	public void userIsOnHomePage() throws Exception { 
		driver.get("https://www.asianpaints.com/"); 
		ScreenShot.takeScreenShot(driver,"HomePage");
		Thread.sleep(2000); 
		
	}

	@Then("User Click on Notification")
	public void userClick_onNotification() {
		ScreenShot.takeScreenShot(driver,"Notification");
		order.setIUnderstand(); ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); 
	}


	@When("User Click on My Profile Icon")
	public void userClickonMyProfileIcon() throws InterruptedException {
	   order.setmyprofileIIIcon();
	   ScreenShot.takeScreenShot(driver,"MyProfileIcon");
	   Thread.sleep(2000);
	}
	
	@Then("User Enter Mobile number")
	public void userEnterMobilenumber() throws InterruptedException {
		order.setLoginMobile(file.getData(0, 2, 5));
		ScreenShot.takeScreenShot(driver,"MobileNumber");
		Thread.sleep(2000);
	}
	
	@When("User Click on Submit Button")
	public void userClick_onSubmitButton() throws InterruptedException {
		order.setSubmit();
		ScreenShot.takeScreenShot(driver,"BlankOtp");
		Thread.sleep(2000);
	}
	
	@When("User Enter OTP")
	public void userEnterOTP() throws InterruptedException {
		order.setloginOtp();
		ScreenShot.takeScreenShot(driver,"OtpEntered");
		Thread.sleep(20000);
	}
	
	@When("User Click on OTP Submit Button")
	public void userClick_onOTPSubmitButton() {
		order.setloginOtpSubmit();
		ScreenShot.takeScreenShot(driver,"AfterSubmitOtp");
	}
	
	//Scenario: My Profile Customer Name Display
	@Given("User is on Registred Home Page")
	public void user_is_onRegistredHomePage( ) throws Exception {
		System.out.println("Given User is on Registred Home Page");
		ScreenShot.takeScreenShot(driver,"RegistredHomePage");
		Thread.sleep(8000);
	}

	@When("User Click on Registred My Profile Icon")
	public void user_Click_on_Registred_My_Profile_Icon() throws InterruptedException {
	    order.setRegistredMyProfileIcon();
	    ScreenShot.takeScreenShot(driver,"RegistredMyProfileIcon");
	    Thread.sleep(2000);
	}

	@Then("User can See Name of Person")
	public void userCanSeeNameofPerson() throws Exception {
		int number=order.getMyProfileIconElements().size();
		System.out.println("Number of Element in list are = "+number);

		for (WebElement element: order.getMyProfileIconElements()) {
			if(element.getText().trim().equals("Hello! Sadashiv"))
			{
				System.out.println(element.getText());
				break;
			}
		}
		ScreenShot.takeScreenShot(driver,"NameOfPerson");
	}

	
	//@My_Profile_Data_Update
	@When("User Click on My Profile Link")
	public void userClickonMyProfileLink() {
		int number=order.getMyProfileIconElements().size();
		System.out.println("Number of Element in My Prfile Icon are = "+number);

		//Searching for My Profile from list ans selecting it
		for (WebElement element: order.getMyProfileIconElements()) {
			if(element.getText().trim().equals("My Profile"))
			{
				ScreenShot.takeScreenShot(driver,"MyProfileLink");
				element.click();
				break;
			}
		}
	}

	@Then("It Display My Profile Page")
	public void itDisplayMyProfilePage() throws InterruptedException {
	   System.out.println("User is on My Profile Page");
	   ScreenShot.takeScreenShot(driver,"MyProfilePage");
	   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	   Thread.sleep(2000);
	}

	@When("User Click on Edit Image Button")
	public void userClickonEditImageButton() throws Exception {
	   order.setEditProfile();
	   ScreenShot.takeScreenShot(driver,"EditButtonEnable");
	   Thread.sleep(2000);
	}

	@Then("User Update First Name")
	public void userUpdateFirstName() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		ScreenShot.takeScreenShot(driver,"MyProfileDetailsAfterFirstTimeLogin");
		int number1=order.getMyProfileDetailslements().size();
		System.out.println("Number of Element in My Prfile Link are = "+number1);
		
		String variable="FIRST NAME";
		for(int i=0;i<order.getMyProfileDetailslements().size();i++){
			if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
				System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
				System.out.println("Element is exist at Index = "+i);
				order.setClearFirstName();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				order.setFirstName(file.getData(0, 1, 0));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				break;
			}
		}
	   Thread.sleep(2000);
	}

	@Then("user Update Last Name")
	public void userUpdateLastName() throws Exception {
		
		String variable="LAST NAME";
		for(int i=0;i<order.getMyProfileDetailslements().size();i++){
			if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
				System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
				System.out.println("Element is exist at Index = "+i);
				order.setClearLastName();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				order.setLastName(file.getData(0, 1, 1));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				break;
			}
		}
	   Thread.sleep(2000);
	}

	
	  @Then("User Update Date of Birth") 
	  public void userUpdateDateofBirth() throws Exception {

		  String year =file.getData(0, 1, 2);
		  order.setDateofBirth();
		  Select selectyear = new Select(order.getYear());
		  List<WebElement> y = selectyear.getOptions();
		  for(WebElement options : y) {
			  System.out.println(options.getText());
			  
			  if(year.equalsIgnoreCase(options.getText()))
			  {
				  selectyear.selectByVisibleText(year);
				  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				  break;
			  }
		  }
		  
			  String month =file.getData(0, 1, 3);
			  //order.setDateofBirth();
			  Select selectmonth = new Select(order.getMonth());
			  List<WebElement> m = selectmonth.getOptions();
			  for(WebElement options1 : m) {
				  System.out.println(options1.getText());
				  
				  if(month.equalsIgnoreCase(options1.getText()))
				  {
					  selectmonth.selectByVisibleText(month);
					  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					  order.setDate();
					  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					  break;
				  }
			  }
	  }


	
	  @Then("User Update Mobile Number") 
	  public void userUpdateMobileNumber() throws InterruptedException {
			
			String variable="MOBILE";
			for(int i=0;i<order.getMyProfileDetailslements().size();i++){
				if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
					System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
					System.out.println("Element is exist at Index = "+i);
					order.setClearMobile();
					order.setMobile(file.getData(0, 1, 5));
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					System.out.println("Number Updated");
					break;
				}
			}
		   Thread.sleep(2000);
		   ScreenShot.takeScreenShot(driver,"ProfileDataUpdatedFor1stTime");
	  }

	@Then("Click on Update Link")
	public void clickonUpdateLink() {
	   order.setUpdate();
	   ScreenShot.takeScreenShot(driver,"UpdateButtonPressed");
	}
	
	
	//Scenario: My Profile Data Update Again
	@Then("User Update First Name Again")
	public void userUpdateFirstNameAgain() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		int number1=order.getMyProfileDetailslements().size();
		System.out.println("Number of Element in My Prfile Link are = "+number1);
		
		String variable="FIRST NAME";
		for(int i=0;i<order.getMyProfileDetailslements().size();i++){
			if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
				System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
				System.out.println("Element is exist at Index = "+i);
				order.setClearFirstName();
				//Fetching data From Excel
				//Parameterization
				order.setFirstName(file.getData(0, 2, 0));
				ScreenShot.takeScreenShot(driver,"FirstNameUpdatedAgain");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				break;
			}
		}
	   Thread.sleep(2000);
	}
	
	@Then("user Update Last Name Again")
	public void userUpdateLastNameAgain() throws Exception {
		String variable="LAST NAME";
		for(int i=0;i<order.getMyProfileDetailslements().size();i++){
			if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
				System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
				System.out.println("Element is exist at Index = "+i);
				order.setClearLastName();
				//Fetching data From Excel
				//Parameterization
				order.setLastName(file.getData(0, 2, 1));
				ScreenShot.takeScreenShot(driver,"LastNameUpdatedAgain");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				break;
			}
		}
	   Thread.sleep(2000);
	}
	
	@Then("User Update Date of Birth Again")
	public void userUpdateDateOfBirthAgain() {
		//Fetching data From Excel
		//Parameterization
		String year =file.getData(0, 2, 2);
		  order.setDateofBirth();
		  Select selectyear = new Select(order.getYear());
		  List<WebElement> y = selectyear.getOptions();
		  for(WebElement options : y) {
			  System.out.println(options.getText());
			  
			  if(year.equalsIgnoreCase(options.getText()))
			  {
				  selectyear.selectByVisibleText(year);
				  ScreenShot.takeScreenShot(driver,"YearUpdatedAgain");
				  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				  break;
			  }
		  }
		  
		//Fetching data From Excel
			//Parameterization
			  String month =file.getData(0, 2, 3);
			  Select selectmonth = new Select(order.getMonth());
			  List<WebElement> m = selectmonth.getOptions();
			  for(WebElement options1 : m) {
				  System.out.println(options1.getText());
				  
				  if(month.equalsIgnoreCase(options1.getText()))
				  {
					  selectmonth.selectByVisibleText(month);
					  ScreenShot.takeScreenShot(driver,"MonthUpdatedAgain");
					  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					  order.setDate1();
					  ScreenShot.takeScreenShot(driver,"DateUpdatedAgain");
					  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					  break;
				  }
			  }
	}
	
	@Then("User Update Mobile Number Again")
	public void userUpdateMobileAgain() throws Exception {
		String variable="MOBILE";
		for(int i=0;i<order.getMyProfileDetailslements().size();i++){
			//Fetching data From Excel
			//Parameterization
			if(variable.equals(order.getMyProfileDetailslements().get(i).getText())){
				System.out.println(order.getMyProfileDetailslements().get(i).getText() +" --- "+" Variable exist ");
				System.out.println("Element is exist at Index = "+i);
				order.setClearMobile();
				//Parameterization
				order.setMobile(file.getData(0, 2, 5));
				ScreenShot.takeScreenShot(driver,"MobileNumberUpdatedAgain");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println("Number Updated");
				break;
			}
		}
	   Thread.sleep(2000);
	}
	
	
	//Scenario: My Profile Image Upload
	@When("User Click on Upload Button to Update Profile Image")
	public void userClick_onUploadButton_toUpdateProfileImage() {
		ScreenShot.takeScreenShot(driver,"BeforeUpdadingProfileImage");
	   order.setUploadImage("C:\\Cucumber_Training\\com.asianpaintsj26\\Profile Picture and Bill\\ProfilePicture2.png");
	   ScreenShot.takeScreenShot(driver,"AfterUpdatingPrfileImage");
	}
	
	
	//Scenario: My Profile Image Upload Again
	@When("User Click on Upload Button to Update Profile Image Again")
	public void userClick_onUploadButton_toUpdateProfileImageAgain() {
		 order.setUploadImage("C:\\Cucumber_Training\\com.asianpaintsj26\\Profile Picture and Bill\\download.png");
		 ScreenShot.takeScreenShot(driver,"AfterUpdatingProfilePictureAgain");
	}
	
	@Then("Profile Image is Updated")
	public void profileImage_isUpdated() {
	   System.out.println("Profile Picture Updated");
	   
	}

	
	//Scenario: My Order Accessbility
	@When("User Click on My Order Link") 
	public void user_Click_on_My_Order_Link() throws InterruptedException {
		order.setMyOrder();
		ScreenShot.takeScreenShot(driver,"MyOrderPage");
		Thread.sleep(3000);
	}

	@Then("User will Display Ordered Products") 
	public void user_will_Display_Ordered_Products() throws InterruptedException {
		System.out.println("User is on My Order Page");
		//Scrolling code using java script
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)", "");
		ScreenShot.takeScreenShot(driver,"MyOrderPage2");
		Thread.sleep(3000);
	}

	@When("User Click on View Details Link of first product")
	public void user_Click_on_View_Details_Link() throws InterruptedException {
		order.setMyOrderViewDetails1();
		ScreenShot.takeScreenShot(driver,"MyOrderViewDetails");
		Thread.sleep(3000);
	}

	@Then("User See Detailed Information of Product") 
	public void user_See_Detailed_Information_of_Product() {
		System.out.println("Product details are displayed");
	}

	@When("User Click on Close Link of first product") 
	public void userClick_onCloseLink_ofFirstProduct() throws InterruptedException {
		order.setMyOrderViewDetailsClose1();
		ScreenShot.takeScreenShot(driver,"ViewOrderDetailsClose");
		Thread.sleep(3000);
	}
	
	
	//Scenario: Add Bill in My Documents
	@Then("User Click on My Documents link")
	public void userClick_onMyDocumentsLink() throws InterruptedException {
		order.setMyDocuments();
		ScreenShot.takeScreenShot(driver,"MyDocuments");
		Thread.sleep(3000);
	}
	
	@When("User Click on Add New Bill Button to Upload Bill")
	public void userClick_onAddNewBill() {
		//Bill image is Uploaded
		order.setAddNewBill("C:\\Cucumber_Training\\com.asianpaintsj26\\Profile Picture and Bill\\Bill.png");
		ScreenShot.takeScreenShot(driver,"BillUploaded");
	}
	
	@Then("Bill is Displayed in My Documnets Page")
	public void Bill_isAdded_inMyDocuments() throws Exception {
		System.out.println("Bill is Added");
		Thread.sleep(2000);
	}
	
	
	//Scenario: Removing of Bill Form My Documents
	@When("User Click on Delete Button")
	public void userClick_onDeleteButton() {
		//order.setDeleteBill();
		order.setDeleteBill1();
		ScreenShot.takeScreenShot(driver,"BillDeleted");
	}
	
	@Then("Bill is Deleted From My Documents Page")
	public void bill_isDeletedFromMyDocumentsPage() {
		System.out.println("Bill is Deleted");
	}
	 
	
	//Scenario: My_Cart_Empty
	@When("User Click on My Cart Icon")
	public void userClick_onMyCartIcon() throws Exception {
		Thread.sleep(15000);
	    order.setCart();
	    ScreenShot.takeScreenShot(driver,"MyCart");
	}
	
	@Then("User See Message Cart Is Empty")
	public void userSeeMessageCartIsEmpty() throws Exception {
		ScreenShot.takeScreenShot(driver,"CartIsEmpty");
		//Thread.sleep(15000);
		System.out.println(order.getCartIsEmpty().getText());
	}
	
	@When("User Click on Start Shopping Link")
	public void userClick_onStartShoppingLink() throws Exception {
		Thread.sleep(15000);
		order.setStartShopping();
		ScreenShot.takeScreenShot(driver,"ClickonStartShoppingLink");
	}
	
	@Then("User Naviagte to Shopping Page")
	public void userNaviagte_toShoppingPage() throws Exception {
		System.out.println("User is on Shopping Page");
		ScreenShot.takeScreenShot(driver,"ShoppingPage");
		Thread.sleep(8000);
	}
	
	@When("User Click on Wall Stickers")
	public void serClick_onWallStickers() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		ScreenShot.takeScreenShot(driver,"ScrolledShoppingPage");
		Thread.sleep(15000);
		order.setWallStickerShopping();
		ScreenShot.takeScreenShot(driver,"WallStickersPage");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	@When("User Click on Add To Cart Button")
	public void userClick_onAddToCartButton() throws Exception {
		Thread.sleep(15000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)", "");
		
		Thread.sleep(15000);
		ScreenShot.takeScreenShot(driver,"ScrolledWallStickerPage");
		order.setAddToCartProduct1();
		ScreenShot.takeScreenShot(driver,"Product1AddedToCart");
		//Thread.sleep(2000);
		//order.setAddToCartProduct2();
		//ScreenShot.takeScreenShot(driver,"Product2AddedToCart");
	}
	
	@Then("Product Is Added To Cart")
	public void productIsAddedToCart() throws Exception {
		System.out.println("Product is added to Cart");
	}
	
	
	//Scenario: Proceed To CheckOut
	@Then("User Click on Checkout Button")
	public void userClick_onCheckoutButton() throws Exception {
		Thread.sleep(10000);
		order.setCheckout();
		ScreenShot.takeScreenShot(driver,"ClickedOnAddToCheckout");
	}
	
	
	//Scenario: Remove Product From Cart
	@Then("User Can See The Products Which are Added From Shop Page")
	public void userCanSeeTheProductsWhich_areAddedFromShopPage() throws Exception {
		Thread.sleep(15000);
		ScreenShot.takeScreenShot(driver,"ProductAvailableInCart");
		System.out.println("Products Are Visible");
		Thread.sleep(15000);
	}
	
	@When("User Click on Delete Symbol To Remove Product From Cart")
	public void userClick_onDeleteSymbolToRemoveProductFromCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		order.setRemoveCartProduct1();
		ScreenShot.takeScreenShot(driver,"RemovedProduct1FromCart");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//order.setRemoveCartProduct1();
		//ScreenShot.takeScreenShot(driver,"RemovedProduct2FromCart");
	}
	
	@Then("Product is Reomved from My Cart")
	public void product_isReomvedfromMyCart() {
		System.out.println(order.getCartIsEmpty().getText());
	}
	
	
	//Scenario: My wishList Accessibility
	@When("User Click on My WishList Icon")
	public void userClick_onMyWishListIcon() {
		order.setMyWishList();
		ScreenShot.takeScreenShot(driver,"MyWishlistIconClicked");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	@Then("User See My WishList Empty")
	public void userSeeMyWishListEmpty() throws Exception {
		System.out.println(order.getWishListIsEmpty().getText());
		ScreenShot.takeScreenShot(driver,"EmptyWishList");
		Thread.sleep(15000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}
	
	@When("User Click on Continue Shopping to Add Product")
	public void userClick_onContinueShopping_toAddProduct() throws InterruptedException {
		Thread.sleep(15000);
		ScreenShot.takeScreenShot(driver,"ScrolledWishlist");
		order.setContinueShopping();
		ScreenShot.takeScreenShot(driver,"ClickedOnContinueShopping");
	}
	
	@When("User Click on Wall Stickers From WishList")
	public void serClick_onWallStickersFromWishList() throws InterruptedException {
		Thread.sleep(5000);
		ScreenShot.takeScreenShot(driver,"ShoppingPageFromWishlist");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)", "");
		ScreenShot.takeScreenShot(driver,"ScrolledShoppingPageFromWishlist");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		order.setWallStickerShopping();
		ScreenShot.takeScreenShot(driver,"ClickedOnWallStickersFromWishList");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	@Then("User Clink on Add to WishList Button")
	public void userClink_onAdd_toWishListButton() throws Exception {
		Thread.sleep(15000);
		order.setWishListProductClose1();
		ScreenShot.takeScreenShot(driver,"Product1IsAddedToWishList");
		Thread.sleep(8000);
		order.setWishListProductClose2();
		ScreenShot.takeScreenShot(driver,"Product2IsAddedToWishList");
	}
	
	@Then("Product Is Added To WishList")
	public void productIsAddedToWishList() {
		System.out.println("Then Product Is Added To WishList");
	}
	
	
	//Scenario: Remove Product From wishList
	@When("User Click on Cross Symbol")
	public void userClickonCrossSymbol() throws Exception {
		Thread.sleep(8000);		
		ScreenShot.takeScreenShot(driver,"WishListWithProduct");
		Actions act= new Actions(driver);
		WebElement x= driver.findElement(By.xpath("//*[@title='Kids Ships Sailor Birds - Wall Stickers & Decals by Asian Paints']"));
		act.moveToElement(x).perform();
		Thread.sleep(5000);
	
		order.setWishListProductClose1();
		ScreenShot.takeScreenShot(driver,"Product1IsRemovedFromWishlist");
		Thread.sleep(8000);
		WebElement y = driver.findElement(By.xpath("//*[@title='Kids Musical Robots - Wall Stickers & Decals by Asian Paints']"));
		act.moveToElement(y).perform();
		Thread.sleep(5000);
		ScreenShot.takeScreenShot(driver,"Product2IsRemovedToWishList");
		order.setWishListProductClose2();
		Thread.sleep(3000);
	}
	
	@Then("Product is Removed From My WishList")
	public void Product_isReomvedFromMyCart() {
		System.out.println(order.getWishListIsEmpty().getText());
	}
	
	
	//Scenario: Logout Account
	@When("User Click on Signout link")
	public void userClick_onSignoutLink() {
		order.setLogout();
		ScreenShot.takeScreenShot(driver,"ClickedOnSigout");
	}
	
	@Then("User Gets Signout From Account")
	public void userGetsSignoutFromAccount() {
		System.out.println("User is SignOut");
		ScreenShot.takeScreenShot(driver,"Signout");
	}
}
