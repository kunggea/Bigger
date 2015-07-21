package com.kunggea.bigger.base;
//package com.kunggea.base;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.app.Activity;
//import android.app.Application;
//import android.content.Intent;
//import android.content.IntentFilter;
//import cn.jpush.android.api.JPushInterface;
//
//import com.android.common.CMApplication;
//import com.android.common.CMApplication.CMAppCrashListener;
//import com.xiaoma.financial.client.controler.DaoControler;
//import com.xiaoma.financial.client.receiver.XiaomaBroadcastReceiver;
//import com.xiaoma.financial.client.ui.MainTabActivity;
//import com.xiaoma.financial.client.util.XiaomaCountDownTimer;
//
// 
//public class BiggerApplication extends Application implements CMAppCrashListener {
//
//    
//
//    private static BiggerApplication mXiaoMaApplication = null;
//
//    public static BiggerApplication getInstance() {
//        return mXiaoMaApplication;
//    }
//
//    private List<Activity> activityList = new ArrayList<Activity>();
//
//    public void deleteActivity(Activity activity) {
//        activityList.remove(activity);
//    }
//
//    public void exitApp() {
//        if (activityList != null) {
//            for (int i = activityList.size() - 1; i >= 0; i--) {
//                Activity activity = activityList.get(i);
//                if (activity != null) {
//                    activity.finish();
//                }
//            }
//            activityList.clear();
//        }
//        DaoControler.clearAllListeners();
//        XiaomaCountDownTimer.getInstance().stop();
//    }
//
//    public Activity getActivityByName(String activityName) {
//        Activity activity = null;
//        for (int i = activityList.size() - 1; i >= 0; i--) {
//            Activity activity2 = activityList.get(i);
//            if (activity2.getClass().getSimpleName().equals(activityName)) {
//                activity = activity2;
//            }
//        }
//        return activity;
//    }
//
//    public MainTabActivity getMainTabActivity() {
//        return (MainTabActivity) getActivityByName("MainTabActivity");
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mXiaoMaApplication = this;
//        CMApplication.onCreate(this).setUncaughtExceptionSaveTpSDcardUpload(true, false, this);
//        startScreenBroadcastReceiver();
//
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
//
//    }
//
//    /**
//     * 软件崩溃后的处理; 1,删除Activity的堆栈
//     */
//    @Override
//    public void onMyAppCrash(String crashLog, int otherFlag) {
//        exitApp();
//    }
//
//    public void remoreActivity(Activity activity) {
//        activityList.remove(activity);
//    }
//
//    public void saveActivity(Activity activity) {
//        activityList.add(activity);
//    }
//
//    public void startActivity(Class clazz) {
//        Intent intent2 = new Intent(BiggerApplication.getInstance(), clazz);
//        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        BiggerApplication.getInstance().startActivity(intent2);
//    }
//
//    public void startActivity(Class clazz, String keyName, boolean isValue) {
//        Intent intent2 = new Intent(BiggerApplication.getInstance(), clazz);
//        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent2.putExtra(keyName, isValue);
//        BiggerApplication.getInstance().startActivity(intent2);
//    }
//
//    public void startActivity(Class clazz, String keyName, int value) {
//        Intent intent2 = new Intent(BiggerApplication.getInstance(), clazz);
//        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent2.putExtra(keyName, value);
//        BiggerApplication.getInstance().startActivity(intent2);
//    }
//
//    public void startActivity(Class clazz, String keyName, String value) {
//        Intent intent2 = new Intent(BiggerApplication.getInstance(), clazz);
//        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent2.putExtra(keyName, value);
//        BiggerApplication.getInstance().startActivity(intent2);
//    }
//
//    /**
//     * 启动screen状态广播接收器
//     */
//    private void startScreenBroadcastReceiver() {
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Intent.ACTION_SCREEN_ON);
//        filter.addAction(Intent.ACTION_SCREEN_OFF);
//        registerReceiver(new XiaomaBroadcastReceiver(), filter);
//    }
// }
