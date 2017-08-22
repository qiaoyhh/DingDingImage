package com.example.g7_user.dingdingimage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by qyh on 2017/8/18.
 * Describe:
 */
public class MainActivity extends AppCompatActivity {

    private CircleImageView iv_item_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayList<String> list2 = new ArrayList<>();
        final ArrayList<String> list3 = new ArrayList<>();
        final ArrayList<String> list4 = new ArrayList<>();
         list.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");

        list2.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list2.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");

        list3.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list3.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list3.add("https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png");

        list4.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list4.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list4.add("https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png");
        list4.add("https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg");

        iv_item_avatar = (CircleImageView) findViewById(R.id.iv_item_avatar);
        getAvatarList(list);

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAvatarList(list2);
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAvatarList(list3);
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAvatarList(list4);
            }
        });
    }

    private void getAvatarList(final List<String>  avatarList){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<Bitmap> bitmapList = new ArrayList<>();
                for (String decodePic : avatarList) {
                    try {
                        //生成bitmap对象
                        Bitmap b = Picasso.with(MainActivity.this).load(decodePic).get();
                        if(b != null) {
                            bitmapList.add(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                final Bitmap result = AvatarUtils.getAvatar(bitmapList, 200, 200);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv_item_avatar.setImageBitmap(bitmapList.size() == 1 ? bitmapList.get(0) : result);
                    }
                });
            }
        }).start();
    }
}
