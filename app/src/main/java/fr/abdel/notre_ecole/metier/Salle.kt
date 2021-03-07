package fr.abdel.notre_ecole.metier

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Salle")
data class Salle(
    @ColumnInfo(name = "idSalle") @PrimaryKey(autoGenerate = true) var idSalle: Long,
    @ColumnInfo(name = "code") var code: String,
    @ColumnInfo(name = "libelle") var libelle: String
)