package com.dolphkon.httplib.utils

import android.content.Context
import android.widget.Toast

class ToastUtil {
   companion object{
       fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
           return Toast.makeText(context, this.toString(), duration).apply { show() }
       }
   }

}


