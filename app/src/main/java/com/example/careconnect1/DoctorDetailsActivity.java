package com.example.careconnect1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr. Andrea Carla Adajar", "Hospital Address: Online Clinic using NowServing app ","Experience: 2 years", "150"},
                    {"Doctor Name : Dr. Sheila Marie Casasola", "Hospital Address: Online Clinic using NowServing app ","Experience: 1 year", "150"},
                    {"Doctor Name : Dr. Michelle Joan Tagle-Ortega", "Hospital Address: Online Clinic using NowServing app ","Experience: 5 years", "-"},
                    {"Doctor Name : Dr. Eduardo Jr Fillaro", "Hospital Address: Online Clinic using NowServing app ","Experience: 9 years", "200"},
                    {"Doctor Name : Dr. Polli Kathlene Paulo", "Hospital Address: Online Clinic using NowServing app ","Experience: 4 years", "270"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr. Lyka Erika Labsan", "Hospital Address: Online Clinic using NowServing app ","Experience: 3 years", "300"},
                    {"Doctor Name : Dr. Benson Panaguiton", "Hospital Address: Online Clinic using NowServing app ","Experience: 5 years", "285"},
                    {"Doctor Name : Dr. Francis Joshua Beloy", "Hospital Address: Online Clinic using NowServing app ","Experience: 2 years", "335"},
                    {"Doctor Name : Dr. Anna Lorraine Bantugay", "Hospital Address: Online Clinic using NowServing app ","Experience: 8 years", "800"},
                    {"Doctor Name : Dr. Reynaldo Cruz", "Hospital Address: Online Clinic using NowServing app ","Experience: 20 years", "880"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr. Jiren Mare Jamantoc", "Hospital Address: Online Clinic using NowServing app and St. Michael's Dental Care ","Experience: 8 years", "700"},
                    {"Doctor Name : Dr. Rose Eden Tanoja", "Hospital Address: Online Clinic using NowServing app and SmartSmile Dental Clinic ","Experience: 19 years", "500"},
                    {"Doctor Name : Dr. Catherine Han", "Hospital Address: Online Clinic using NowServing app and Catherine Andaya-Han Dental Clinic ","Experience: 11 years", "500"},
                    {"Doctor Name : Dr. Hana Jeishel Flores", "Hospital Address: Online Clinic using NowServing app and Roxas Dental Clinic","Experience: 4 years","-"},
                    {"Doctor Name : Dr. John Daniel Villegas", "Hospital Address: Online Clinic using NowServing app and Zahn Aesthetix Dental Clinic ","Experience: 6 years", "500"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr. Paul Julius Medina", "Hospital Address: Online Clinic using NowServing app and Mercy Spine Center ","Experience: 15 years","800"},
                    {"Doctor Name : Dr. Alembert Lee-Ong", "Hospital Address: Online Clinic using NowServing app and MDH Rm 1107","Experience: 17 years", "-"},
                    {"Doctor Name : Dr. Anthony Dofitas", "Hospital Address: Online Clinic using NowServing app and Manila Med Surgery Clinic ","Experience: 13 years", "-"},
                    {"Doctor Name : Dr. Adrian Fernando", "Hospital Address: Online Clinic using NowServing app and 305 UERM ","Experience: 12 years", "1000"},
                    {"Doctor Name : Dr. Leonardo Ona", "Hospital Address: Online Clinic using NowServing app and Leonardo Ona M.D.","Experience: 27 years", "1000"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr. Ma Minerva Boac", "Hospital Address: Online Clinic using NowServing app and South Imus Specialist Hospital ","Experience: 8 years", "700"},
                    {"Doctor Name : Dr. Emiliano Jr Canonigo", "Hospital Address: Online Clinic using NowServing app and Rm 210 ASIAN HOSPITAL","Experience: 47 years", "-"},
                    {"Doctor Name : Dr. Nannette Rey", "Hospital Address: Online Clinic using NowServing app and De La Salle University Medical Center ","Experience: 20 years", "-"},
                    {"Doctor Name : Dr. Roi Joseph Mendoza", "Hospital Address: Online Clinic using NowServing app ","Experience: 8 years", "500"},
                    {"Doctor Name : Dr. Roy Sasil Jr", "Hospital Address: One Heart @ Maria Reyna ","Experience: 7 years", "900"},
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietitian")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
             item = new HashMap<String,String>();
             item.put("line1", doctor_details[i][0]);
             item.put("line2", doctor_details[i][1]);
             item.put("line3", doctor_details[i][2]);
             item.put("line4", "Cons Fees: ₱ "+doctor_details[i][3]);
             list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4"},
                new int [] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,}
                );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
    }
}