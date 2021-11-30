package com.wposs.usersp

import com.wposs.usersp.VO.User

interface OnClickListener {
    fun onClick(user:User, position:Int)
}