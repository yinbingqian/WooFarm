package com.lnpdit.woofarm.page.activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.lnpdit.woofarm.R;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast; 

public class MainActivity extends ExpandableListActivity {  
    // 百度地图控件  
    private MapView mMapView = null;  
    // 百度地图对象  
    private BaiduMap mBaiduMap;  
    //右侧伸缩列表
//    private ExpandableListView expandablelist;
     // 创建一级条目容器
    List<Map<String, String>> gruops = new ArrayList<Map<String, String>>();
     //存放内容, 以便显示在列表中
    List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext  
        //注意该方法要再setContentView方法之前实现  
        SDKInitializer.initialize(getApplicationContext());  
        setContentView(R.layout.activity_main);  
        init(); 
        setListData();
    }  
  
    /** 
     * 初始化方法 
     */  
    private void init() { 
        //获取地图控件引用  
        mMapView = (MapView) findViewById(R.id.bmap_View); 
        mBaiduMap = mMapView.getMap();    
      //普通地图    
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);   
        mapview();

        //     // 设置地图当前缩放级别  
//        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(21).build()));
        //右侧可伸缩列表
//        list = (ExpandableListView) findViewById(R.id.list);
    }  
    
    private void mapview(){
      
        //定义Maker坐标点  
//        LatLng point = new LatLng(39.963175, 116.400244);  
        LatLng point = new LatLng(123.474429,41.732025); 
        //构建Marker图标  
        BitmapDescriptor bitmap = BitmapDescriptorFactory  
            .fromResource(R.drawable.unread_count_bg);  
        //构建MarkerOption，用于在地图上添加Marker  
        OverlayOptions option = new MarkerOptions()  
            .position(point)  
            .icon(bitmap);  
        //在地图上添加Marker，并显示  
        mBaiduMap.addOverlay(option);
        
       
////        //设置可拖拽
//        OverlayOptions options = new MarkerOptions()
//                .position(point)  //设置marker的位置
//                .icon(bdA)  //设置marker图标
//                .zIndex(9)  //设置marker所在层级
//                .draggable(true);  //设置手势拖拽
////            //将marker添加到地图上
//         marker = (Marker) (mBaiduMap.addOverlay(options));
            
            //设置监听方法
          //调用BaiduMap对象的setOnMarkerDragListener方法设置marker拖拽的监听
            mBaiduMap.setOnMarkerDragListener(new OnMarkerDragListener() {
                public void onMarkerDrag(Marker marker) {
                    //拖拽中
                }
                public void onMarkerDragEnd(Marker marker) {
                    //拖拽结束
                }
                public void onMarkerDragStart(Marker marker) {
                    //开始拖拽
                }
            });
    }
    
    /**
     * 设置列表内容
     */
    public void setListData() {
      // 创建二个一级条目标题
      Map<String, String> title_1 = new HashMap<String, String>();
      Map<String, String> title_2 = new HashMap<String, String>();
      Map<String, String> title_3 = new HashMap<String, String>();
      title_1.put("group", "货架");
      title_2.put("group", "预定日历");
      title_3.put("group", "购物车");
      gruops.add(title_1);
      gruops.add(title_2);
      gruops.add(title_3);

      // 创建二级条目内容
      // 内容一
      Map<String, String> title_1_content_1 = new HashMap<String, String>();
      Map<String, String> title_1_content_2 = new HashMap<String, String>();
      Map<String, String> title_1_content_3 = new HashMap<String, String>();
      Map<String, String> title_1_content_4 = new HashMap<String, String>();
      Map<String, String> title_1_content_5 = new HashMap<String, String>();
      Map<String, String> title_1_content_6 = new HashMap<String, String>();
      title_1_content_1.put("child", "苹果");
      title_1_content_2.put("child", "樱桃");
      title_1_content_3.put("child", "西红柿");
      title_1_content_4.put("child", "油桃");
      title_1_content_5.put("child", "草莓");
      title_1_content_6.put("child", "多宝鱼");

      List<Map<String, String>> childs_1 = new ArrayList<Map<String, String>>();
      childs_1.add(title_1_content_1);
      childs_1.add(title_1_content_2);
      childs_1.add(title_1_content_3);
      childs_1.add(title_1_content_4);
      childs_1.add(title_1_content_5);
      childs_1.add(title_1_content_6);

      // 内容二
      Map<String, String> title_2_content_1 = new HashMap<String, String>();
      Map<String, String> title_2_content_2 = new HashMap<String, String>();
      Map<String, String> title_2_content_3 = new HashMap<String, String>();
      Map<String, String> title_2_content_4 = new HashMap<String, String>();
      Map<String, String> title_2_content_5 = new HashMap<String, String>();
      Map<String, String> title_2_content_6 = new HashMap<String, String>();
      Map<String, String> title_2_content_7 = new HashMap<String, String>();
      Map<String, String> title_2_content_8 = new HashMap<String, String>();
      Map<String, String> title_2_content_9 = new HashMap<String, String>();
      Map<String, String> title_2_content_10 = new HashMap<String, String>();
      Map<String, String> title_2_content_11 = new HashMap<String, String>();
      Map<String, String> title_2_content_12 = new HashMap<String, String>();
      title_2_content_1.put("child", "一月");
      title_2_content_2.put("child", "二月");
      title_2_content_3.put("child", "三月");
      title_2_content_4.put("child", "四月");
      title_2_content_5.put("child", "五月");
      title_2_content_6.put("child", "六月");
      title_2_content_7.put("child", "七月");
      title_2_content_8.put("child", "八月");
      title_2_content_9.put("child", "九月");
      title_2_content_10.put("child", "十月");
      title_2_content_11.put("child", "十一月");
      title_2_content_12.put("child", "十二月");
      List<Map<String, String>> childs_2 = new ArrayList<Map<String, String>>();
      childs_2.add(title_2_content_1);
      childs_2.add(title_2_content_2);
      childs_2.add(title_2_content_3);
      childs_2.add(title_2_content_4);
      childs_2.add(title_2_content_5);
      childs_2.add(title_2_content_6);
      childs_2.add(title_2_content_7);
      childs_2.add(title_2_content_8);
      childs_2.add(title_2_content_9);
      childs_2.add(title_2_content_10);
      childs_2.add(title_2_content_11);
      childs_2.add(title_2_content_12);

      // 内容三
      Map<String, String> title_3_content_1 = new HashMap<String, String>();
      Map<String, String> title_3_content_2 = new HashMap<String, String>();
      Map<String, String> title_3_content_3 = new HashMap<String, String>();
      Map<String, String> title_3_content_4 = new HashMap<String, String>();
      title_3_content_1.put("child", "苹果");
      title_3_content_2.put("child", "樱桃");
      title_3_content_3.put("child", "西红柿");
      title_3_content_4.put("child", "油桃");

      List<Map<String, String>> childs_3 = new ArrayList<Map<String, String>>();
      childs_3.add(title_3_content_1);
      childs_3.add(title_3_content_2);
      childs_3.add(title_3_content_3);
      childs_3.add(title_3_content_4);

      childs.add(childs_1);
      childs.add(childs_2);
      childs.add(childs_3);

      /**
       * 创建ExpandableList的Adapter容器 参数: 1.上下文 2.一级集合 3.一级样式文件 4. 一级条目键值
       * 5.一级显示控件名 6. 二级集合 7. 二级样式 8.二级条目键值 9.二级显示控件名
       */
      SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(
          this, gruops, R.layout.activity_groups, new String[] { "group" },
          new int[] { R.id.textgroup }, childs, R.layout.activity_childs,
          new String[] { "child" }, new int[] { R.id.textchild });
      // 加入列表
      setListAdapter(sela);
    }

    /**
     * 列表内容按下
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
        int groupPosition, int childPosition, long id) {
      Toast.makeText(  MainActivity.this, "您选择了" + gruops.get(groupPosition).toString()
              + "子编号"+ childs.get(groupPosition).get(childPosition)
                  .toString(), Toast.LENGTH_SHORT).show();
      return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }

    /**
     * 二级标题按下
     */
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
        boolean shouldExpandGroup) {
      return super.setSelectedChild(groupPosition, childPosition,
          shouldExpandGroup);
    }

    /**
     * 一级标题按下
     */
    @Override
    public void setSelectedGroup(int groupPosition) {
      super.setSelectedGroup(groupPosition);
    }
    
    @Override  
    protected void onResume() {  
       
        super.onResume();  
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理  
        mMapView.onResume();  
    }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理  
        mMapView.onPause();  
    }  
    @Override  
    protected void onDestroy() {  
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
        mMapView.onDestroy();  
        mMapView = null;  
        super.onDestroy();  
    }

}  
