package com.example.exampleretrofitrxmvvmmovies.Models


class MessageResponse()  {
    var Code: String? = null
    var Message: String? = null

    constructor(code: String, message: String?) : this() {
        this.Code = code
        this.Message = message
    }

}