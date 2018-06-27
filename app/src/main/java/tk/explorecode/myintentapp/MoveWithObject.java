package tk.explorecode.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";
    TextView tvObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObj = (TextView)findViewById(R.id.tv_object_received);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mPerson.getName()+", Age : "+mPerson.getAge()+", City : "+ mPerson.getCity();
        tvObj.setText(text);
    }
}
