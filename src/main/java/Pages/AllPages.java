package Pages;
public class AllPages {
    public AllPages(){}
    private MainPage mainPage;
    private LoginPage loginPage;
    public MainPage mainPage(){
        if (mainPage==null){
            mainPage=new MainPage();
        }
        return mainPage;
    }
    public LoginPage loginPage(){
        if (loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }
}
