package com.theneversleepingwinds.vinylist.data.database.model;

import io.realm.RealmObject;

/**
 * @author Nicolas BEGEY
 */
public class VinylData extends RealmObject {

    public String id;
    public String artist;
    public String title;
    public String label;
    public String quantity;
    public String buyDate;
    public String buyPrice;
}
