package dataSource;



import org.testng.annotations.DataProvider;

public class DataParameters
{

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[2][2];

        data[0][0]="Tapa";
        data[0][1]="False";
    //    data[1][0]="Chatterjee";
     //   data[1][1]="True";

        return data;

        

    }
}


