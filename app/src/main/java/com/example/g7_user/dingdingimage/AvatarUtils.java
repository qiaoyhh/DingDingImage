package com.example.g7_user.dingdingimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.List;

/**
 * Created by qyh on 2017/8/18.
 * Describe: 自动生成拼图工具类
 */

public class AvatarUtils {

    private static final int marginWhiteWidth = 6; // 中间白色宽度

    /**
     * 生成频道头像
     * @param bitmapList
     * @param width
     * @param height
     */
    public static Bitmap getAvatar(List<Bitmap> bitmapList, int width, int height){
        final Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        final int listSize = bitmapList.size();
        switch (listSize) {
            case 1:
                Bitmap _p11 = Bitmap.createScaledBitmap(bitmapList.get(0), width, height, false);
                canvas.drawBitmap(_p11, 0, 0, null);
                break;
            case 2:
                // 比例缩放
                Bitmap _p21 = Bitmap.createScaledBitmap(bitmapList.get(0), width, height, false);
                Bitmap _p22 = Bitmap.createScaledBitmap(bitmapList.get(1), width, height, false);
                // 裁取中间部分(从x点裁取置顶距离)
                Bitmap __p21 = Bitmap.createBitmap(_p21, width / 4 + marginWhiteWidth / 2, 0, width / 2 - marginWhiteWidth / 2,  height); // 中间留有1px白条
                Bitmap __p22 = Bitmap.createBitmap(_p22, width / 4 + marginWhiteWidth / 2, 0, width / 2 - marginWhiteWidth / 2,  height); // 中间留有1px白条
                // 绘图
                canvas.drawBitmap(__p21, 0, 0, null);
                canvas.drawBitmap(__p22, width / 2 + marginWhiteWidth / 2, 0, null);
                break;
            case 3:
                // 1-图1
                Bitmap _p31 = Bitmap.createScaledBitmap(bitmapList.get(0), width, height, false);
                Bitmap __p31 = Bitmap.createBitmap(_p31, width / 4 + marginWhiteWidth / 2, 0, width / 2 - marginWhiteWidth / 2,  height);
                // 2-图2,3
                Bitmap _p32 = Bitmap.createScaledBitmap(bitmapList.get(1), width / 2 - marginWhiteWidth / 2 , height / 2 - marginWhiteWidth / 2, false);
                Bitmap _p33 = Bitmap.createScaledBitmap(bitmapList.get(2), width / 2 - marginWhiteWidth / 2, height / 2 - marginWhiteWidth / 2, false);
                // 3-拼接
                canvas.drawBitmap(__p31, 0, 0, null);
                canvas.drawBitmap(_p32, width / 2 + marginWhiteWidth / 2, 0, null);
                canvas.drawBitmap(_p33, width / 2 + marginWhiteWidth / 2, height / 2 + marginWhiteWidth / 2, null);
                break;
            case 4:
                // 比例缩放
                Bitmap _p41 = Bitmap.createScaledBitmap(bitmapList.get(0), width / 2 - marginWhiteWidth / 2, height / 2 - marginWhiteWidth / 2, false);
                Bitmap _p42 = Bitmap.createScaledBitmap(bitmapList.get(1), width / 2 - marginWhiteWidth / 2, height / 2 - marginWhiteWidth / 2, false);
                Bitmap _p43 = Bitmap.createScaledBitmap(bitmapList.get(2), width / 2 - marginWhiteWidth / 2, height / 2 - marginWhiteWidth / 2, false);
                Bitmap _p44 = Bitmap.createScaledBitmap(bitmapList.get(3), width / 2 - marginWhiteWidth / 2, height / 2 - marginWhiteWidth / 2, false);
                // 多图拼接
                canvas.drawBitmap(_p41, 0, 0, null);
                canvas.drawBitmap(_p42, width / 2 + marginWhiteWidth / 2 , 0, null);
                canvas.drawBitmap(_p43, 0, height / 2 + marginWhiteWidth / 2, null);
                canvas.drawBitmap(_p44, width / 2 + marginWhiteWidth / 2, height / 2 + marginWhiteWidth / 2, null);
                break;
            default:
                break;
        }
        return  result;
    }
}
