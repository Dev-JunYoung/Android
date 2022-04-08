package com.example.listviewex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//Weather 클래스 연결
public class MyFirstAdapter extends BaseAdapter {
    private List<Weather> mdata;
    //외부에서 생성하게되면 data정보(<Weather>)를 갖고 생성.
    public MyFirstAdapter(List<Weather> data) {
        this.mdata = data;
    }

    @Override
    //아이템 갯수
    public int getCount() {
        return mdata.size();
    }

    @Override
    //몇번째에 어떤데이터가 있는지 알려줌
    public Object getItem(int i) {
        return mdata.get(i);
    }

    @Override //db 사용 할 때 기본키(?)
    public long getItemId(int i) {
        return i;
    }

    @Override
    //실제로 한칸에 보여질 레이아웃을 정함.
    //각각 표시되는
    public View getView(int i, View view, ViewGroup viewGroup) {
        //레이아웃 재사용 ( 내용만 변경 )
        ViewHolder holder;
        if(view==null){ //최초는 null 그 다음에 호출했을때는 레이아웃재사용
            holder= new ViewHolder();
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather,viewGroup,false);
            // 이 세가지를 담는 객체생성 -> 이것이 뷰 홀더
            ImageView weatherImage=view.findViewById(R.id.weather_image);
            TextView citiText=view.findViewById(R.id.city_text);
            TextView tempText=view.findViewById(R.id.temp_text);

            //viewHolder에 담는다.
            holder.weatherImage=weatherImage;
            holder.citiText=citiText;
            holder.tempText=tempText;

            //view와 viewHolder 연결
            view.setTag(holder);
        }else { //재사용할때는 홀더를 가져오겠다.
            holder= (ViewHolder) view.getTag();
        }
        //해당 포지션의 데이터
        Weather weather=mdata.get(i);
        //holder.Weather weather=mdata.get(i);
        holder.citiText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        //레이아웃을 들고와서 처리.
        return view;
    }
    static class ViewHolder{ //new class for 뷰홀더패턴 구현
        ImageView weatherImage;
        TextView citiText;
        TextView tempText;
    }
}
