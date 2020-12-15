package com.kathleenwang.interactivestory.model

class Choice(var textId: Int, var nextPage: Int)

//simplified from:
//class Choice (user_textId:Int, user_nextPage:Int) {
//    var textId:Int = user_textId
//    var nextPage:Int = user_nextPage
//}
// note these are all non-private variables so can be accessible directly w/o getter/setters