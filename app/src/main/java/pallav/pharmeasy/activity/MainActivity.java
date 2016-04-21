package pallav.pharmeasy.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import pallav.pharmeasy.Adapter.ViewPagerAdapter;
import pallav.pharmeasy.R;
import pallav.pharmeasy.model.Medicine;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter adapter;
    List<Medicine> medicines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medicines = Medicine.findWithQuery(Medicine.class,"Select * from Medicine");
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(MainActivity.this, medicines);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
