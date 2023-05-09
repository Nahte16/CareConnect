package com.example.careconnect1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Dr. Andrea Carla Adajar", "Online Clinic  ","2 years", "150"},
                    {"Dr. Sheila Marie Casasola", "Online Clinic  ","1 year", "150"},
                    {"Dr. Michelle Joan Tagle-Ortega", "Online Clinic ","5 years", "-"},
                    {"Dr. Eduardo Jr Fillaro", "Online Clinic ","9 years", "200"},
                    {"Dr. Polli Kathlene Paulo", "Online Clinic ","4 years", "270"},
            };
    private String[][] doctor_details2 =
            {
                    {"Dr. Lyka Erika Labsan", "Online Clinic ","3 years", "300"},
                    {"Dr. Benson Panaguiton", "Online Clinic ","5 years", "285"},
                    {"Dr. Francis Joshua Beloy", "Online Clinic ","2 years", "335"},
                    {"Dr. Anna Lorraine Bantugay", "Online Clinic ","8 years", "800"},
                    {"Dr. Reynaldo Cruz", "Online Clinic ","20 years", "880"},
            };
    private String[][] doctor_details3 =
            {
                    {"Dr. Jiren Mare Jamantoc", "Online Clinic/St. Michael's Dental Care ","8 years", "700"},
                    {"Dr. Doctor Name : Rose Eden Tanoja", "Online Clinic/SmartSmile Dental Clinic ","19 years", "500"},
                    {"Dr. Catherine Han", "Online Clinic/Catherine Andaya-Han Dental Clinic ","11 years", "500"},
                    {"Dr. Hana Jeishel Flores", "Online Clinic/Roxas Dental Clinic","4 years","-"},
                    {"Dr. John Daniel Villegas", "Online Clinic/Zahn Aesthetix Dental Clinic ","6 years", "500"},
            };
    private String[][] doctor_details4 =
            {
                    {"Dr. Paul Julius Medina", "Online Clinic/Mercy Spine Center ","15 years","800"},
                    {"Dr. Alembert Lee-Ong", "Online Clinic/MDH Rm 1107","17 years", "-"},
                    {"Dr. Anthony Dofitas", "Online Clinic/Manila Med Surgery Clinic ","13 years", "-"},
                    {"Dr. Doctor Name : Adrian Fernando", "Online Clinic/305 UERM ","12 years", "1000"},
                    {"Dr. Leonardo Ona", "Online Clinic/ using NowServing app and Leonardo Ona M.D.","27 years", "1000"},
            };
    private String[][] doctor_details5 =
            {
                    {"Dr. Ma Minerva Boac", "Online Clinic/South Imus Specialist Hospital ","8 years", "700"},
                    {"Dr. Emiliano Jr Canonigo", "Online Clinic/Rm 210 ASIAN HOSPITAL","47 years", "-"},
                    {"Dr. Nannette Rey", "Online Clinic/De La Salle University Medical Center ","20 years", "-"},
                    {"Dr. Doctor Name : Roi Joseph Mendoza", "Online Clinic ","8 years", "500"},
                    {"Dr. DRoy Sasil Jr", "One Heart @ Maria Reyna ","7 years", "900"},
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
        btn = findViewById(R.id.buttonAppBack);
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
             item.put("line1", "Doctor Name: " + doctor_details[i][0]);
             item.put("line2", "Hospital Address: " + doctor_details[i][1]);
             item.put("line3", "Experience: " +doctor_details[i][2]);
             item.put("line4", "Cons Fees: ₱ "+doctor_details[i][3]);
             list.add(item);
        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4"},
                new int [] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,}
                );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                startActivity(it);
            }
        });
    }
}