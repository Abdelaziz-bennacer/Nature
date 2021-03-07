package fr.abdel.notre_ecole.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.abdel.notre_ecole.metier.Adresse
import fr.abdel.notre_ecole.metier.Etudiant
import fr.abdel.notre_ecole.metier.Salle

@Database(entities = [(Etudiant::class), (Adresse::class), (Salle::class)], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MaBdd: RoomDatabase()
{
    abstract fun etudiantDao(): EtudiantDao
    abstract fun adresseDao(): AdresseDao
    abstract  fun salleDao(): SalleDao
}