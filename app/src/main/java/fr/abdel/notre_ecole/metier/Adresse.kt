package fr.abdel.notre_ecole.metier

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Adresse")
data class Adresse(
    @ColumnInfo(name = "idAdresse") @PrimaryKey(autoGenerate = true) var idAdresse: Long = 0,
    @ColumnInfo(name= "numRue") var numRue: Long,
    @ColumnInfo(name = "nomRue") var nomRue: String,
    @ColumnInfo(name = "codePostal") var codePostal: Long,
    @ColumnInfo(name = "ville") var ville: String,
    @ColumnInfo(name = "pays") var pays: String
) {
    override fun toString(): String {
        return "Adresse(idAdresse=$idAdresse, numRue=$numRue, nomRue='$nomRue', codePostal=$codePostal, ville='$ville', pays='$pays')"
    }
}

