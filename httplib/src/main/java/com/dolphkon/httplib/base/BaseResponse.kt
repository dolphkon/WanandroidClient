package com.dolphkon.httplib.base

import com.dolphkon.httplib.ResultCode

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseResponse
 * Author: kongdexi
 * Date: 2020/10/14 16:41
 * Description:TODO
 * *****************************************************
 */
data class BaseResponse( var ret_code: String?,var ret_msg: String? ) {

       val isOk: Boolean
        get() = ResultCode.CODE_SUCCESS == ret_code
}