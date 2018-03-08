package com.theneversleepingwinds.vinylist.data.database.model

import io.realm.RealmObject

/**
 * @Author Nicolas BEGEY - 18-03-07.
 */
open class Vinyl(var id: String, var artist: String, var title: String, var label: String, var quantity: String, var buyDate: String, var buyPrice: String)