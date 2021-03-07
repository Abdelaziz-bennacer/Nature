package fr.abdel.notre_ecole.metier

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import fr.abdel.notre_ecole.dao.Converters
import java.security.Timestamp
import java.sql.Date
import java.time.Instant
import java.time.LocalDate
import java.util.*

@Entity(tableName = "Etudiant")
data class Etudiant(
    @ColumnInfo(name = "Identifiant") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "Nom") var nom: String,
    @ColumnInfo(name = "Prenom") var prenom: String,
    @ColumnInfo(name = "DateDeNaissance") @TypeConverters(Converters::class) var dateDeNaissance: Date,
    @ColumnInfo(name = "Adresse") var adresse: String){

    override fun toString(): String {
        return "Etudiant(id=$id, nom='$nom', prenom='$prenom', dateDeNaissance=$dateDeNaissance, adresse='$adresse')"
    }
}
