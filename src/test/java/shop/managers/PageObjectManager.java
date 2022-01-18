package shop.managers;

import shop.pages.HomePage;
import shop.pages.IdentityPage;
import shop.pages.LoginPage;
import shop.pages.MyAccountPage;

public class PageObjectManager {

    private HomePage homePage;
    private IdentityPage identityPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }

    public IdentityPage getIdentityPage() {
        return (identityPage == null) ? identityPage = new IdentityPage() : identityPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public MyAccountPage getMyAccountPage() {
        return (myAccountPage == null) ? myAccountPage = new MyAccountPage() : myAccountPage;
    }
}
