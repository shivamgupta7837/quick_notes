package com.example.quicknotes.database.cloud_database

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import java.util.UUID

class CloudDatabase {
    @SuppressLint("StaticFieldLeak")
    companion object{
    private val db = Firebase.firestore

        fun setAIGeneratedNotesData(note: String, tag: String){
            try {
                val isDocExists = db.collection("users").document("test_user")
                    .collection("ai_generated_note").document("ai_generated_note")
                    .get()

                val id = UUID.randomUUID()
                isDocExists.addOnSuccessListener {
                    document->if(document.exists()){
                        Log.i("is exsist","document exists")
                    val map = document.data?.get("ai_notes") as MutableList<Map<String, String>>
                    map.add(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))

//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("ai_generated_note").document("ai_generated_note")
                        .set(mapOf("ai_notes" to map))
                    }else{
    //                    setting data in database
                        db.collection("users").document("test_user")
                            .collection("ai_generated_note").document("ai_generated_note")
                            .set(mapOf("ai_notes" to listOf(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))))
                    }
                }
            } catch (e: Exception) {
                throw Exception(e)
            }
        }


        fun setNotes(note: String, tag: String){
            try {
                val isDocExists = db.collection("users").document("test_user")
                    .collection("notes").document("notes")
                    .get()

                val id = UUID.randomUUID()
                isDocExists.addOnSuccessListener {
                        document->if(document.exists()){
                    Log.i("is exsist","document exists")
                    val map = document.data?.get("notes") as MutableList<Map<String, String>>
                    map.add(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))

//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("notes").document("notes")
                        .set(mapOf("notes" to map))
                }else{
                    //                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("notes").document("notes")
                        .set(mapOf("notes" to listOf(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))))
                }
                }
            } catch (e: Exception) {
                throw Exception(e)
            }
        }

        fun setArchivedNotesData(note: String, tag: String){
            try {
                val isDocExists = db.collection("users").document("test_user")
                    .collection("archived_notes").document("archived_notes")
                    .get()

                val id = UUID.randomUUID()
                isDocExists.addOnSuccessListener {
                        document->if(document.exists()){
                    Log.i("is exsist","document exists")
                    val map = document.data?.get("archived_notes") as MutableList<Map<String, String>>
                    map.add(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))

//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("archived_notes").document("archived_notes")
                        .set(mapOf("archived_notes" to map))
                }else{
//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("archived_notes").document("archived_notes")
                        .set(mapOf("archived_notes" to listOf(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))))
                }
                }
            } catch (e: Exception) {
                throw Exception(e)
            }
        }


        fun setLockedNotesData(note: String, tag: String){
            try {
                val isDocExists = db.collection("users").document("test_user")
                    .collection("locked_notes").document("locked_notes")
                    .get()

                val id = UUID.randomUUID()
                isDocExists.addOnSuccessListener {
                        document->if(document.exists()){
                    Log.i("is exsist","document exists")
                    val map = document.data?.get("locked_notes") as MutableList<Map<String, String>>
                    map.add(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))

//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("locked_notes").document("locked_notes")
                        .set(mapOf("locked_notes" to map))
                }else{
//                    setting data in database
                    db.collection("users").document("test_user")
                        .collection("locked_notes").document("locked_notes")
                        .set(mapOf("locked_notes" to listOf(mapOf("note" to note, "tag" to tag,"note_id" to id.toString() ))))
                }
                }
            } catch (e: Exception) {
                throw Exception(e)
            }
        }

        fun getAIGeneratedNotesData(){
            Log.i("pressed: ","pressed")
            db.collection("users").document("test_user").collection("ai_generated_note")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("Firebase Tag", "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("Firebase tag", "Error getting documents.", exception)
                }
        }

        fun getArchivedNotesData(){
            Log.i("pressed: ","pressed")
            db.collection("users").document("test_user").collection("archived_notes")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("Firebase Tag", "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("Firebase tag", "Error getting documents.", exception)
                }
        }
    }


    fun getLockedNotesData(){
        Log.i("pressed: ","pressed")
        db.collection("users").document("test_user").collection("locked_notes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Firebase Tag", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase tag", "Error getting documents.", exception)
            }
    }
}