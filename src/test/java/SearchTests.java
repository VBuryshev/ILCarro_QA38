import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "08/28/2023", "03/19/2024");
        app.getSearch().pause(2000);
        app.getSearch().submitForm();
    }


}
