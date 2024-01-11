package com.yusufarisoy.enuyguncase.data.repository

import com.yusufarisoy.enuyguncase.data.entity.Data

interface ApiRepository {

    suspend fun search(): Data
}
