package Lab14_TestNGAnnotationAttribute;

import org.testng.annotations.Test;

public class BamkingApp {
	
	@Test(priority = 1, enabled = true)
    public void openApp() {
        System.out.println("App opened.");
    }

    @Test(priority = 2, dependsOnMethods = {"openApp"}, enabled = true)
    public void login() {
        System.out.println("User logged in.");
    }

    @Test(priority = 3, enabled = false)
    public void checkBalance() {
        System.out.println("Balance checked. Rs: 90000");
    }

    @Test(priority = 4, dependsOnMethods = {"login"}, enabled = true)
    public void transferMoney() {
        System.out.println("Money transferred successfully.");
    }

    @Test(priority = 5, enabled = true)
    public void logout() {
        System.out.println("User logged out.");
    }

}
