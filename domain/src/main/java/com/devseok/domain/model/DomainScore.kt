package com.devseok.domain.model

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */
data class DomainScore(
    // 남자 이름
    val man : String,
    // 여자 이름
    val woman : String,
    // 확률
    val percentage : Int,
    // 시간
    val date : String
) {
    constructor() : this("오류","오류",0, "오류")
}
