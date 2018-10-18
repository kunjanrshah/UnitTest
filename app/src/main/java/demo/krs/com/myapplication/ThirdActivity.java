package demo.krs.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThirdActivity extends Activity {

    private Button btntext;
    private EditText editText;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
        btntext=findViewById(R.id.btnClick);
        editText=findViewById(R.id.edtText);
        txtView=findViewById(R.id.txtView);

        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setText(editText.getText().toString());
            }
        });

    }
}
