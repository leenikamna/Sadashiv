package com.step_defination;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cucumber.api.java.ca.Cal;


public class ViewOrderPageFactory {

	WebDriver driver;
	//Initializing Constructor
	public ViewOrderPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	//Locators for all Webdriver Elements
	@FindBy(xpath="//*[@class='ctaText i-understand-btn text-uppercase']")
	@CacheLookup
	WebElement Iunderstand;
	
	@FindBy(xpath="//*[@class='spriteIcon-Firstfold profileIcon']")
	@CacheLookup
	WebElement myprofileIIIcon;
	
	@FindBy(how=How.ID,using="loginMobile")
	@CacheLookup
	WebElement loginMobile;
	
	//ctaText modal__variant-login--submit
	@FindBy(xpath="//*[@class='ctaText modal__variant-login--submit']")
	@CacheLookup
	WebElement submit;
	
	@FindBy(how=How.ID,using="loginOtp")
	@CacheLookup
	WebElement loginOtp;
	
	@FindBy(xpath="//*[@class='ctaText validate-login  modal__variant-login--submit']")
	@CacheLookup
	WebElement loginOtpSubmit;
	
	@FindBy(xpath="//*[@class='spriteIcon-Firstfold profileIcon-active']")
	@CacheLookup
	WebElement registredmyprofileicon;
	
	@FindBy(xpath="//div[@class='logged-in-dropdown']/ul/li")
	@CacheLookup
	List<WebElement> profileIconElements;
	
	@FindBy(xpath="//*[@id=\"loginDropdown\"]/div/ul/li[1]/a")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how=How.ID, using="editProfile")
	@CacheLookup
	WebElement editProfile;
	
	@FindBy(xpath="//*[@class='details-inputs row personal_info_error']/ul/li")
	@CacheLookup
	List<WebElement> myProfileDetailslements;
	
	@FindBy(how=How.NAME, using="profile_fname")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how=How.NAME, using="profile_lname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(how=How.NAME, using="profile_dob")
	@CacheLookup
	WebElement dateofBirth;
	
	@FindBy(xpath="//*[@data-handler='selectYear']")
	@CacheLookup
	WebElement year;
	
	@FindBy(xpath="//*[@data-handler='selectMonth']")
	@CacheLookup
	WebElement month;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[2]/a")
	@CacheLookup
	WebElement date;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")
	@CacheLookup
	WebElement date1;
	
	@FindBy(how=How.NAME, using="profile_mobile")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(xpath="//span[text()=' Select']")
	@CacheLookup
	WebElement gender;
	
	@FindBy(xpath="//span[text()=' Male']")
	@CacheLookup
	WebElement male;
	
	@FindBy(xpath="//*[@class='global-button-white btn-style2 ap_user_profile_btn']")
	@CacheLookup
	WebElement update;
	
	@FindBy(xpath="//*[@class='iconLinks iconLinks__cart cart-js-handle spriteIcon-Firstfold cartIcon border-0 bg-transparent track_minicart']")
	@CacheLookup
	WebElement cart;
	
	@FindBy(xpath="//*[@id=\"uploadProfilePic\"]")
	@CacheLookup
	WebElement uploadimg;
	
	@FindBy(xpath="//*[@id=\"as-smart-tab\"]/li[3]/a")
	@CacheLookup
	WebElement myorder;
	
	@FindBy(xpath="//*[@id=\"p-details\"]/div/div[2]/div[1]/div[2]/a")
	@CacheLookup
	WebElement viewdetails1;
	
	@FindBy(xpath="//*[@id=\"p-details\"]/div/div[2]/div[1]/div[2]/a")
	@CacheLookup
	WebElement viewdetailsclose1;
	
	@FindBy(xpath="//*[@id='usr-doc-upl']")
	@CacheLookup
	WebElement addnewbill;
	
	@FindBy(xpath="//*[@class='deleteFile']")
	@CacheLookup
	WebElement deletebill;
	
	@FindBy(xpath="//a[@data-file='Bill']")
	@CacheLookup
	WebElement deletebill1;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"as-smart-tab\"]/li[4]/a")
	WebElement mydocuments;
	
	@FindBy(xpath="//*[@class='description-text mb-3 mt-3']")
	WebElement cartisempty;
	
	@FindBy(how=How.LINK_TEXT, using="Start Shopping")
	WebElement startshopping;
	
	@FindBy(xpath="//*[@class='ctaText w-100 active']")
	@CacheLookup
	WebElement checkout;
	
	@FindBy(xpath="//*[@class='spriteIcon-Firstfold wishListIcon']")
	@CacheLookup
	WebElement mywishlist;
	
	@FindBy(xpath="//h2[text()='Your wishlist is empty!']")
	@CacheLookup
	WebElement wishlistisempty;
	
	@FindBy(xpath="//*[@class='ctaText trackCTA']")
	@CacheLookup
	WebElement continueShopping;
	
	@FindBy(xpath="//*[@data-attr-title='Kids Ships Sailor Birds - Wall Stickers & Decals by Asian Paints']")
	@CacheLookup
	WebElement wishlistProductClose1;
	
	@FindBy(xpath="//*[@data-attr-title='Kids Musical Robots - Wall Stickers & Decals by Asian Paints']")
	@CacheLookup
	WebElement wishlistProductClose2;
	
	@FindBy(xpath="//*[@class='logout-link']")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath="//*[@id=\"thin-banner-info\"]/ul/li[1]/div[2]/a/span[1]")
	@CacheLookup
	WebElement addToCartProduct1;
	
	@FindBy(xpath="//*[@id=\"thin-banner-info\"]/ul/li[2]/div[2]/a/span[1]")
	@CacheLookup
	WebElement addToCartProduct2;
	
	@FindBy(xpath="//*[@title='ap-shop-wall-stickers-thumbnail-asian-paints']")
	@CacheLookup
	WebElement wallStickerShopping;
	
	@FindBy(xpath="//span[@data-attr-entry='0']")
	@CacheLookup
	WebElement RemoveCartProduct1;
	
	@FindBy(xpath="//span[@data-attr-entry='1']")
	@CacheLookup
	WebElement RemoveCartProduct2;
	
	//Getter Methods for all Locators
	public WebElement getLogot() {
		return logout;
	}
	
	public WebElement getWishlistProductClose1() {
		return wishlistProductClose1;
	}
	
	public WebElement getWishlistProductClose2() {
		return wishlistProductClose2;
	}
	
	public WebElement getAddNewBill() {
		return addnewbill;
	}
	
	public WebElement getMyDocuments() {
		return mydocuments;
	}
	
	public WebElement getDeleteBill() {
		return deletebill;
	}
	
	public WebElement getIUnderstand() {
		return Iunderstand;
	}
	
	public WebElement getmyprofileIIIcon() {
		return myprofileIIIcon;
	}
	
	public WebElement getLoginMobile() {
		return loginMobile;
	}
	
	public WebElement getSubmit() {
		return submit;
	}
	
	public WebElement getLoginOtp() {
		return loginOtp;
	}
	
	public WebElement getLoginOtpSubmit() {
		return loginOtpSubmit;
	}
	
	public WebElement getRegistredMyProfileIcon() {
		return registredmyprofileicon;
	}

	public List<WebElement> getMyProfileIconElements() {
		return profileIconElements;
	}
	
	public List<WebElement> getMyProfileDetailslements() {
		return myProfileDetailslements;
	}
	
	
	public WebElement getCustomerName() {
		return CustomerName;
	}

	public WebElement getEditProfile() {
		return editProfile;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDateofBirth() {
		return dateofBirth;
	}

	public WebElement getYear() {
		return year;
	}
	
	public WebElement getMonth() {
		return month;
	}
	
	public WebElement getDate() {
		return date;
	}
	
	public WebElement getDate1() {
		return date1;
	}
	
	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getGender() {
		return gender;
	}
	
	public WebElement getGenderMale() {
		return male;
	}
	
	public WebElement getCart() {
		return cart;
	}
	
	public WebElement getUpdate() {
		return update;
	}
	
	public WebElement getMyOrder() {
		return myorder;
	}
	
	public WebElement getMyOrderViewDetails1() {
		return viewdetails1;
	}
	
	public WebElement getMyOrderViewDetailsClose1() {
		return viewdetailsclose1;
	}
	
	public WebElement getCartIsEmpty() {
		return cartisempty;
	}
	
	public WebElement getCheckout() {
		return checkout;
	}
	
	public WebElement getMyWishList() {
		return mywishlist;
	}
	
	public WebElement getWishListIsEmpty() {
		return wishlistisempty;
	}
	
	public WebElement getContinueShopping() {
		return continueShopping;
	}
	
	public WebElement getAddToCartProduct1() {
		return addToCartProduct1;
	}
	
	public WebElement getAddToCartProduct2() {
		return addToCartProduct2;
	}
	
	public WebElement getWallStickerShopping() {
		return wallStickerShopping;
	}
	
	public WebElement getRemoveCartProduct1() {
		return RemoveCartProduct1;
	}
	
	public WebElement getRemoveCartProduct2() {
		return RemoveCartProduct2;
	}
	
	
	//Setter Method For all Locators
	public void setWishListProductClose1() {
		this.wishlistProductClose1.click();
	}
	
	public void setWishListProductClose2() {
		this.wishlistProductClose2.click();
	}
	
	public void setIUnderstand() {
		this.Iunderstand.click();
	}

	public void setmyprofileIIIcon() {
		this.myprofileIIIcon.click();
	}
	
	public void setLoginMobile(String loginMobile) {
		this.loginMobile.sendKeys(loginMobile);
	}
	
	public void setSubmit() {
		this.submit.click();
	}
	
	public void setloginOtp() {
		//Scanner class Initialized
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP");
		//OTP send throw scanner class
	    String otp = sc.nextLine();
		this.loginOtp.sendKeys(otp);
	}
	
	public void setloginOtpSubmit() {
		this.loginOtpSubmit.click();
	}
	
	public void setRegistredMyProfileIcon() {
		this.registredmyprofileicon.click();
	}

	public void setCustomerName(String customerName) {
		this.CustomerName.sendKeys(customerName);
	}

	public void setEditProfile() {
		this.editProfile.click();
	}

	public void setClearFirstName() {
		this.firstName.clear();
	}
	
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void setClearLastName() {
		this.lastName.clear();
	}
	
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void setClearDateofBirth() {
		this.dateofBirth.clear();
	}
	
	public void setDateofBirth() {
		this.dateofBirth.click(); 
	}
	
	public void setDate() {
		this.date.click(); 
	}
	
	public void setDate1() {
		this.date1.click(); 
	}
	 
	public void setClearMobile() {
		this.mobile.clear();
	}
	
	public void setMobile(String mobile) {
		this.mobile.sendKeys(mobile);
	}

	public void setGender() {
		this.gender.click();
	}
	
	public void setGenderMale() {
		this.male.click();
	}
	
	public void setUpdate() {
		this.update.click();
	}
	
	public void setUploadImage(String uploadimg) {
		this.uploadimg.sendKeys(uploadimg);
	}
	
	public void setMyOrder() {
		this.myorder.click();
	}
	
	public void setMyOrderViewDetails1() {
		this.viewdetails1.click();
	}
	
	public void setMyOrderViewDetailsClose1() {
		this.viewdetailsclose1.click();
	}
	
	public void setCart() {
		this.cart.click();
	}
	
	public void setAddNewBill(String addnewbill) {
		this.addnewbill.sendKeys(addnewbill);
	}
	
	public void setDeleteBill() {
		this.deletebill.click();
	}
	
	public void setDeleteBill1() {
		this.deletebill1.click();
	}
	
	public void setMyDocuments() {
		this.mydocuments.click();
	}
	
	public void setCartIsEmpty() {
		this.cartisempty.click();
	}
	
	public void setStartShopping() {
		this.startshopping.click();
	}
	
	public void setCheckout() {
		this.checkout.click();
	}
	
	public void setMyWishList() {
		this.mywishlist.click();
	}
	
	public void setWishListIsEmpty() {
		this.wishlistisempty.click();
	}
	
	public void setContinueShopping() {
		this.continueShopping.click();
	}

	public void setLogout() {
		this.logout.click();
	}
	
	public void setAddToCartProduct1() {
		this.addToCartProduct1.click();
	}
	
	public void setAddToCartProduct2() {
		this.addToCartProduct2.click();
	}
	
	public void setWallStickerShopping() {
		this.wallStickerShopping.click();
	}
	
	public void setRemoveCartProduct1() {
		this.RemoveCartProduct1.click();
	}
	
	public void setRemoveCartProduct2() {
		this.RemoveCartProduct2.click();
	}
}
