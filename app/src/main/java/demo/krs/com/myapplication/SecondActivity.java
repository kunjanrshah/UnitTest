package demo.krs.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {

    RelativeLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        mContainer=findViewById(R.id.fragment_container);
        getFragmentManager().beginTransaction().add(mContainer.getId(),new FragmentToTest()).commitAllowingStateLoss();
    }
}
