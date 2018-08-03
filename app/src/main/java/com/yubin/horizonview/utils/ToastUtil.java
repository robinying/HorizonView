package com.yubin.horizonview.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * author : Yubin.Ying
 * time : 2018/8/2
 */
public class ToastUtil {
    private static Toast mToast;

    static {
        ToastUtil.mToast = null;
    }

    public static void destory() {
        if (ToastUtil.mToast != null) {
            ToastUtil.mToast = null;
        }
    }

    public static void makeText(Activity activity, final String msg) {
        makeText(activity, msg, Gravity.BOTTOM);
    }

    public static void makeText(Context context, final String msg) {
        makeText(context, msg, Gravity.BOTTOM);
    }

    public static void makeText(final Activity activity, final String msg, final int gravity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (ToastUtil.mToast == null) {
                    ToastUtil.mToast = Toast.makeText(activity, (CharSequence) msg, Toast.LENGTH_SHORT);
                } else {
                    ToastUtil.mToast.setText(msg);
                    if (msg.length() < 20) {
                        ToastUtil.mToast.setDuration(Toast.LENGTH_SHORT);
                    } else {
                        ToastUtil.mToast.setDuration(Toast.LENGTH_LONG);
                    }
                }
                ToastUtil.mToast.setGravity(gravity, 0, 0);
                ToastUtil.mToast.show();
            }
        });
    }


    public static void makeText(Context context, CharSequence msg, int gravity) {
        if (msg == null) {
            return;
        }
        if (ToastUtil.mToast == null) {
            ToastUtil.mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            ToastUtil.mToast.setText(msg);
            ToastUtil.mToast.setDuration(Toast.LENGTH_SHORT);
        }
        ToastUtil.mToast.setGravity(gravity, 0, 0);
        ToastUtil.mToast.show();
    }

}
