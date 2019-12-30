package com.example.lib_core.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.lib_core.entity.BaseEntity;

public class SPUtils {

        private Context context;
        private SharedPreferences sharedPreferences;
        private SharedPreferences.Editor editor;
        private static SPUtils spUtils;


        private SPUtils(){
            init();
        }

        public synchronized static SPUtils getInstance(){
            if(spUtils == null)
                spUtils = new SPUtils();
            return spUtils;
        }

        public void init(){
            context = BaseApplication.context;
        }

    /**
     * 添加数据
     * @param key
     * @param value
     * @return
     */
        public boolean putData(String key,Object value){
            sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            if(value instanceof String){
                editor.putString(key,value.toString());
            }
            else if(value instanceof Integer){
                editor.putInt(key,Integer.parseInt(value.toString()));
            }
            else if(value instanceof Boolean){
                editor.putBoolean(key,Boolean.parseBoolean(value.toString()));
            }
            else {
                editor.putLong(key,Long.parseLong(value.toString()));
            }
            return editor.commit();
        }

        public String getString(String key,String defaultValue){
            SharedPreferences sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
            return sharedPreferences.getString(key,defaultValue);
        }

        public int getInt(String key,int defaultValue){
            SharedPreferences sharedPreferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
            return sharedPreferences.getInt(key,defaultValue);
        }

        public void remove(String key){
            SharedPreferences preferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            edit.remove(key);
            edit.commit();
        }

}
