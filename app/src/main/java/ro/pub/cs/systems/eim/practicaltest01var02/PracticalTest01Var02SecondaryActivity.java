package ro.pub.cs.systems.eim.practicaltest01var02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView viewResult = null;
    private Button corect = null;
    private Button incorect = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.corect:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.incorect:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_service);

        viewResult = (TextView)findViewById(R.id.viewResult2);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("result")) {
            String result = intent.getStringExtra("result");
            viewResult.setText(result);
        }

        corect = (Button)findViewById(R.id.corect);
        corect.setOnClickListener(buttonClickListener);
        incorect = (Button)findViewById(R.id.incorect);
        incorect.setOnClickListener(buttonClickListener);
    }
}
