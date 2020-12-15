package com.kathleenwang.interactivestory.model

class Page {
    var imageId: Int
    var textId: Int
    lateinit var choice1: Choice
    lateinit var choice2: Choice
    var isFinalPage = false

    constructor(imageId: Int, textId: Int) {
        this.imageId = imageId
        this.textId = textId
        isFinalPage = true
    }

    constructor(imageId: Int, textId: Int, choice1: Choice?, choice2: Choice?) {
        this.imageId = imageId
        this.textId = textId
        if (choice1 != null) {
            this.choice1 = choice1
        }
        if (choice2 != null) {
            this.choice2 = choice2
        }
    }

}
