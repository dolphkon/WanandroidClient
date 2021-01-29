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
open  class BaseResponse(var errorCode: String?, var errorMsg: String? ) {

       val isOk: Boolean
        get() = ResultCode.CODE_SUCCESS == errorCode

}