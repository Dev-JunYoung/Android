package com.example.listviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 준비
       // ArrayList<String> data=new ArrayList<>();
        ArrayList<Weather> data=new ArrayList<>();
        data.add(new Weather("수원","25","맑음"));
        data.add(new Weather("서울","26","비"));
        data.add(new Weather("안양","25","구름"));
        data.add(new Weather("부산","29","구름"));
        data.add(new Weather("인천","23","맑음"));
        data.add(new Weather("대구","28","비"));
        data.add(new Weather("용인","25","비"));

        //어댑터
        /*ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1,dada);*/

        //리스트에 하나의아이템을 구성하는 레이아웃
        MyFirstAdapter adapter=new MyFirstAdapter(data);

        //뷰
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i+"번째 아이템 선택", Toast.LENGTH_SHORT).show();
            }
        });

    }
}