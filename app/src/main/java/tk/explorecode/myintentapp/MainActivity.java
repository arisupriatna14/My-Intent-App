package tk.explorecode.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMoveActivity;
    private Button btnMoveWithData;
    private Button btnMoveWithObject;
    private Button btnDialNumber;
    private Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData = (Button)findViewById(R.id.btn_move_activity_with_data);
        btnMoveWithData.setOnClickListener(this);
        btnDialNumber = (Button)findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_with_object);
        btnMoveWithObject.setOnClickListener(this);
        btnMoveForResult = (Button)findViewById(R.id.btn_activity_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView)findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithData.class);
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "Dicoding Academy Boy");
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_with_object:
                Person mPerson = new Person();
                mPerson.setName("Ari");
                mPerson.setAge(18);
                mPerson.setCity("Banten");

                Intent moveWithDataObjectIntent = new Intent(MainActivity.this, MoveWithObject.class);
                moveWithDataObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, mPerson);
                startActivity(moveWithDataObjectIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "085777282844";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_activity_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResult.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResult.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil :" + selectedValue);
            }
        }
    }


}