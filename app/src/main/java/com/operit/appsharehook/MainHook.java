package com.operit.appsharehook;

import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    private static final String TAG = "AppShareHook";
    private static final int INFINITE_POINTS = 999999;
    private static final int INFINITE_VIP = 99;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("info.muge.appshare")) {
            return;
        }
        Log.d(TAG, "AppShare模块已加载");
        
        // Hook User.getPoints()
        XposedHelpers.findAndHookMethod(
            "info.muge.appshare.model.User", 
            lpparam.classLoader, 
            "getPoints", 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(INFINITE_POINTS);
                    Log.d(TAG, "getPoints() -> " + INFINITE_POINTS);
                }
            }
        );
        
        // Hook User.getVIPLevel()
        XposedHelpers.findAndHookMethod(
            "info.muge.appshare.model.User", 
            lpparam.classLoader, 
            "getVIPLevel", 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(INFINITE_VIP);
                    Log.d(TAG, "getVIPLevel() -> " + INFINITE_VIP);
                }
            }
        );
        
        // Hook UserBean.getPoints()
        XposedHelpers.findAndHookMethod(
            "info.muge.appshare.beans.UserBean", 
            lpparam.classLoader, 
            "getPoints", 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(INFINITE_POINTS);
                    Log.d(TAG, "UserBean.getPoints() -> " + INFINITE_POINTS);
                }
            }
        );
        
        // Hook UserBean.getCoins()
        XposedHelpers.findAndHookMethod(
            "info.muge.appshare.beans.UserBean", 
            lpparam.classLoader, 
            "getCoins", 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(INFINITE_POINTS);
                    Log.d(TAG, "UserBean.getCoins() -> " + INFINITE_POINTS);
                }
            }
        );
        
        // Hook VipStatus.getVipLevel()
        XposedHelpers.findAndHookMethod(
            "info.muge.appshare.model.VipStatus", 
            lpparam.classLoader, 
            "getVipLevel", 
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(INFINITE_VIP);
                    Log.d(TAG, "VipStatus.getVipLevel() -> " + INFINITE_VIP);
                }
            }
        );
        
        Log.d(TAG, "AppShare Hook完成 - 积分/会员已绕过");
    }
}
