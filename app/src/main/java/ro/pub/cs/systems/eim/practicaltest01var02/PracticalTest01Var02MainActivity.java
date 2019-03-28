package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private Button navigateToSecondaryActivityButton = null;

    private EditText firstnumber = null;
    private EditText secondNumber = null;
    private TextView viewResult = null;
    private Button addButton = null;
    private Button minusButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int firstnb = Integer.valueOf(firstnumber.getText().toString());
            int secondnb = Integer.valueOf(secondNumber.getText().toString());

            switch(view.getId()) {
                case R.id.second:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    intent.putExtra("result", viewResult.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                case R.id.addButton:
                    int sum = firstnb + secondnb;

                    viewResult.setText(String.valueOf(firstnb) + " + " + String.valueOf(secondnb) + " = " + String.valueOf(sum));
                    break;
                case R.id.minusButton:
                    int dif = firstnb - secondnb;
                    viewResult.setText(String.valueOf(firstnb) + " - " + String.valueOf(secondnb) + " = " + String.valueOf(dif));
                    break;
            }




        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        firstnumber = (EditText)findViewById(R.id.firstNumber);
        secondNumber = (EditText)findViewById(R.id.secondNumber);
        viewResult = (TextView)findViewById(R.id.viewResult);

        addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(buttonClickListener);
        minusButton = (Button)findViewById(R.id.minusButton);
        minusButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("first")) {
                firstnumber.setText(savedInstanceState.getString("first"));
            } else {
                firstnumber.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("second")) {
                secondNumber.setText(savedInstanceState.getString("second"));
            }
            if (savedInstanceState.containsKey("view")) {
                viewResult.setText(savedInstanceState.getString("view"));
            }
        }

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.second);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("first", firstnumber.getText().toString());
        savedInstanceState.putString("second", secondNumber.getText().toString());
        savedInstanceState.putString("view", viewResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("first")) {
            firstnumber.setText(savedInstanceState.getString("first"));
        }
        if (savedInstanceState.containsKey("second")) {
            secondNumber.setText(savedInstanceState.getString("second"));
        }
        if (savedInstanceState.containsKey("view")) {
            viewResult.setText(savedInstanceState.getString("view"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }


}
