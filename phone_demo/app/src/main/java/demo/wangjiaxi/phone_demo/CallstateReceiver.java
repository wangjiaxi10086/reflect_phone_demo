package demo.wangjiaxi.phone_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * 作者：will-wjx
 * 时间：18-8-21:下午3:21
 * 邮箱：103444209@qq.com
 * 说明：
 */

public class CallstateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //callApp = intent.getStringExtra("callingApp");

        final String action = intent.getAction();
        //if (action.equals("android.intent.action.PHONE_STATE")) {
        if (action.equals("android.intent.action.SUBSCRIPTION_PHONE_STATE")) {
            int phoneid = intent.getIntExtra("slot",-1);
            int subId = intent.getIntExtra("subscription",-1);
            android.util.Log.e("wjx","wjx-----------SUBSCRIPTION_PHONE_STATE------slot="+phoneid
            + "   subId="+subId);


            /*try {
                //create input params
                SubscriptionManager sm = (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);


                Method method2 = sm.getClass().getDeclaredMethod("getSubId", new Class[] { int.class });
                method2.setAccessible(true);

                int [] mSubid = (int []) method2.invoke(sm, new Object[] {phoneid});
                Log.d("wjx", "MainActivity Leave getSubId   mSubid = " + mSubid);

            } catch (NoSuchMethodException e) {
                Log.d("wjx", "installSilentWithReflection E1");
                e.printStackTrace();
            } catch (Exception e) {
                Log.d("wjx", "installSilentWithReflection E2");
                e.printStackTrace();
            }*/

            try {
               //create input params
                //SubscriptionManager sm = (SubscriptionManager) context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);


                /*Method method2 = sm.getClass().getDeclaredMethod("getSubId", new Class[] { int.class });
                method2.setAccessible(true);


                int [] mSubid = (int []) method2.invoke(sm, new Object[] { phoneid});
                Log.d("wjx", "MainActivity Leave getSubId   mSubid = " + mSubid);

                for (int i =0; i<mSubid.length; i++) {

                    Log.d("wjx", "MainActivity Leave getSubId   mSubid11111 = " + mSubid[i]);
                }*/


                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

                Method method = tm.getClass().getDeclaredMethod("getLine1Number", new Class[] { int.class });
                method.setAccessible(true);


                String r = (String) method.invoke(tm, new Object[] { subId });
                Log.d("wjx", "MainActivity Leave getLine1Number   r = " + r);

            } catch (NoSuchMethodException e) {
                Log.d("wjx", "installSilentWithReflection E1");
                e.printStackTrace();
            } catch (Exception e) {
                Log.d("wjx", "installSilentWithReflection E2");
                e.printStackTrace();
            }

        }
    }
}
