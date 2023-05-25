package com.example.framepro;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnMenu1, btnMenu2, btnMenu3, btnReserv, btn1;
    LinearLayout linear, linearMenu1, linearMenu2, linearMenu3, linearView, linearMenu4;
    Spinner spMovie;
    ImageView imgPoster;
    RadioGroup rgSelect;
    RadioButton rdoDay, rdoTime,rdoMovie,rdoSnack;
    CalendarView calDay;
    TimePicker tpTime;
    TextView txtReserv;
    ListView mList, listView1;
    CarAdapter mAdapter;
    ArrayList<Car> mArray;
    Car mItem;
    EditText Num1, Num2, Num3,Num4, Num5, Num6 ;
    TextView res1, res2;


    int syear, smonth, sday, shour, sminte;
    ArrayAdapter<String> adapter;
    ArrayList<String> choice=new ArrayList<String>();
    ArrayAdapter<String> ar;

    String[] mid={"유체이탈자들", "코스트버스터즈라이즈", "엔칸토:마법의 세계", "듄", "이터널스", "로그북"};
    String[] titles={"유체이탈자들", "코스트버스터즈라이즈", "엔칸토:마법의 세계", "듄", "이터널스", "로그북"};
    Integer[] posterID = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.move06};
    Integer[] poster={R.drawable.pop1,R.drawable.pop2, R.drawable.pop3, R.drawable.pop4,
            R.drawable.pop5,R.drawable.pop6,};

    String[] title={"고소팝콘(L)", "달콤팝콘(L)", "더블치즈팝콘(L)", "바질어니언팝콘(L)", "탄산음료(L)",
            "아메리카노(ICE)"};

    String[] genre={"5000원","6000원","6000원","6000원", "3000원", "4000원",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화 예매 하기");
        linear=findViewById(R.id.linear);
        linearView=findViewById(R.id.linearView);
        rgSelect=findViewById(R.id.rgSelect);
        rdoDay=findViewById(R.id.rdoDay);
        rdoTime=findViewById(R.id.rdoTime);
        rdoMovie=findViewById(R.id.rdoMovie);
        rdoSnack=findViewById(R.id.rdoSnack);
        calDay=findViewById(R.id.calDay);
        tpTime=findViewById(R.id.tpTime);
        btnReserv=findViewById(R.id.btnReserv);
        txtReserv=findViewById(R.id.txtReserv);
        btnMenu1=findViewById(R.id.btnMenu1);
        btnMenu2=findViewById(R.id.btnMenu2);
        btnMenu3=findViewById(R.id.btnMenu3);
        linearMenu1=findViewById(R.id.linearMenu1);
        linearMenu2=findViewById(R.id.linearMenu2);
        linearMenu3=findViewById(R.id.linearMenu3);
        linearMenu4=findViewById(R.id.linearMenu4);
        spMovie = findViewById(R.id.spMovie);
        imgPoster = findViewById(R.id.imgPoster);
        listView1=findViewById(R.id.listView1);
        btn1=findViewById(R.id.btn1);
        Num1=findViewById(R.id.Num1);
        Num2=findViewById(R.id.Num2);
        Num3=findViewById(R.id.Num3);
        Num4=findViewById(R.id.Num4);
        Num5=findViewById(R.id.Num5);
        Num6=findViewById(R.id.Num6);
        res1=findViewById(R.id.res1);
        res2=findViewById(R.id.res2);
        ar=new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mid);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(ar);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, titles);
        spMovie.setAdapter(adapter);
        spMovie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                imgPoster.setImageResource(posterID[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearMenu1.setVisibility(View.VISIBLE);
                linearMenu2.setVisibility(View.INVISIBLE);
                linearMenu3.setVisibility(View.INVISIBLE);
            }
        });
        btnMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearMenu1.setVisibility(View.INVISIBLE);
                linearMenu2.setVisibility(View.VISIBLE);
                linearMenu3.setVisibility(View.INVISIBLE);
            }
        });
        btnMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearMenu1.setVisibility(View.INVISIBLE);
                linearMenu2.setVisibility(View.INVISIBLE);
                linearMenu3.setVisibility(View.VISIBLE);
            }
        });
        rgSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rdoDay){
                    calDay.setVisibility(View.VISIBLE);
                    tpTime.setVisibility(View.INVISIBLE);
                    listView1.setVisibility(View.INVISIBLE);
                    linearMenu4.setVisibility(View.INVISIBLE);
                }else if(checkedId==R.id.rdoTime){
                    calDay.setVisibility(View.INVISIBLE);
                    tpTime.setVisibility(View.VISIBLE);
                    listView1.setVisibility(View.INVISIBLE);
                    linearMenu4.setVisibility(View.INVISIBLE);
                }else if(checkedId==R.id.rdoMovie) {
                    calDay.setVisibility(View.INVISIBLE);
                    tpTime.setVisibility(View.INVISIBLE);
                    listView1.setVisibility(View.VISIBLE);
                    linearMenu4.setVisibility(View.INVISIBLE);
                }else if(checkedId==R.id.rdoSnack) {
                    calDay.setVisibility(View.INVISIBLE);
                    tpTime.setVisibility(View.INVISIBLE);
                    listView1.setVisibility(View.INVISIBLE);
                    linearMenu4.setVisibility(View.VISIBLE);

                }


            }

        });

        calDay.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                syear=year;
                smonth=month;
                sday=dayOfMonth;

                Toast.makeText(MainActivity.this, year+"년"+smonth+"월"+
                        sday+"일", Toast.LENGTH_SHORT).show();
            }
        });
        tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                shour=hourOfDay;
                sminte=minute;
                Toast.makeText(MainActivity.this, shour+"시"+sminte+"분",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),mid[i]+"를 선택 하셨습니다.",Toast.LENGTH_SHORT).
                        show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sum1=Num1.getText().toString();
                String sum2=Num2.getText().toString();
                String sum3=Num3.getText().toString();
                String sum4=Num4.getText().toString();
                String sum5=Num5.getText().toString();
                String sum6=Num6.getText().toString();
                double sum=Double.parseDouble(sum1)*5000 + Double.parseDouble(sum2)*6000+
                        Double.parseDouble(sum3)*6000 + Double.parseDouble(sum4)*6000 + Double.parseDouble(sum5)*3000+
                        Double.parseDouble(sum6)*4000;
                double sum7=Double.parseDouble(sum1) + Double.parseDouble(sum2)+
                        Double.parseDouble(sum3) + Double.parseDouble(sum4) + Double.parseDouble(sum5)+
                        Double.parseDouble(sum6);
                res1.setText("총 주문갯수: "+sum7+"개 입니다");
                res2.setText(" 총 금액:  "+sum+"원입니다");
            }
        });
        btnReserv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, syear+"년 "+smonth+"월 "+sday+"일 "
                                +shour+"시 "+sminte+"분에 예약되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        mList=findViewById(R.id.listView);
        mArray=new ArrayList<Car>();

        for(int i=0;i<poster.length;i++){
            mItem=new Car(ContextCompat.getDrawable(this, poster[i]),title[i],genre[i]);
            mArray.add(mItem);
        }
        mAdapter=new CarAdapter(this, mArray);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long I) {
                Car item=(Car)mList.getItemAtPosition(i);
                String title=item.getTitle();
                Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.option, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.opLogin) {
            View loginv = View.inflate(getApplicationContext(),
                    R.layout.login, null);
            EditText edtId = loginv.findViewById(R.id.edtId);
            EditText edtPw = loginv.findViewById(R.id.edtPw);

            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setView(loginv);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String id = edtId.getText().toString();
                    String pw = edtPw.getText().toString();
                    if (id.equals("jinsu") && pw.equals("1234")) {
                        Toast.makeText(MainActivity.this, "로그인에 성공하였습니다.",
                                Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "로그인에 실패하였습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dlg.setNegativeButton("취소", null);
            dlg.show();

        } else if (item.getItemId() == R.id.opLogout) {
            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.opWhite) {
            linear.setBackgroundColor(Color.WHITE);
        } else if (item.getItemId() == R.id.opDark) {
            linear.setBackgroundColor(Color.GRAY);
        }
        return true;

    }
}