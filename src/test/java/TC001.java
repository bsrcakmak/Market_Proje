import Base.BaseTest;
import Listener.Listener;
import Pages.AllPages;
import Utilities.ConfigReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static ExtentReports.ExtentTestManager.startTest;

@Listeners({Listener.class})

public class TC001 extends BaseTest {
    AllPages allPages=new AllPages();
    @Test(description = "Kullanıcı girişi yapılarak sepete ürün eklenmesi")
    public void test01(Method method) throws IOException, CsvException {

        startTest(method.getName(),"Kullanıcı girişi yapılarak sepete ürün eklenmesi");
        allPages.mainPage().go_To_Url(ConfigReader.getProperty("baseURL"));
        allPages.mainPage().hoverOverGirisYapButon();
        allPages.loginPage().loginHepsiBurada(ConfigReader.getProperty("UserMail"),ConfigReader.getProperty("UserPassword"));
        allPages.userDashboardPage().verifyValidLogin("test");
        allPages.userDashboardPage().searchProduct("robot süpürge");
        allPages.searchResultPage().SearchResultSummary("robot süpürge");
        allPages.searchResultPage().selectProduct();
        allPages.productDetailPage().add_To_Cart();
        allPages.cartPage().go_To_Cart();
        allPages.cartPage().verify_To_ProductsOnCart();


    }


}

//1. Kullanıcı girişi yapılarak sepete ürün eklenmesi
// Kullanıcı Hepsiburada.com sitesini ziyaret eder.
// Kullanıcı giriş işlemi yapılır.
// Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
// Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
// Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
// Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
// Seçilen ürünün doğru olarak eklendiği 'Sepetim' sayfasında doğrulanmalıdır.

//2. Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme
// Kullanıcı Hepsiburada.com sitesini ziyaret eder.
//  Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
// Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
// Seçilen ürünün doğru olarak eklendiği 'Sepetim' sayfasında doğrulanmalıdır.