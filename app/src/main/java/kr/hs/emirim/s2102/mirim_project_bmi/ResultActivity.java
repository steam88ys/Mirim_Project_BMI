package kr.hs.emirim.s2102.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textComment;
    ImageView imgV;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textComment = findViewById(R.id.text_bmi);
        imgV = findViewById(R.id.img);
        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(btnHomeListener);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        double weight = Double.parseDouble(intent.getStringExtra("weight"));
        double height = Double.parseDouble(intent.getStringExtra("height"));
        bmi = weight / Math.pow(height/100, 2);
        textComment.setText(name + "님의 BMI지수는 "+String.format("%.2f", bmi)+"입니다.");

        if(bmi < 18.5)  {
            imgV.setImageResource(R.drawable.under);
            textComment.append("\n저체중 입니다.");
        }
        else if(bmi < 25 ) {
            imgV.setImageResource(R.drawable.normal);
            textComment.append("\n정상체중 입니다.");
        }
        else if(bmi < 30 ) {
            imgV.setImageResource(R.drawable.over);
            textComment.append("\n과체중 입니다.");
        }
        else if(bmi < 35 ) {
            imgV.setImageResource(R.drawable.obese);
            textComment.append("\n비만 입니다.");
        }
        else {
            imgV.setImageResource(R.drawable.extremlyobese);
            textComment.append("\n고도비만 입니다.");
        }
    }

    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };


}