package br.com.thalesnishida.newagenda.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.thalesnishida.newagenda.R
import br.com.thalesnishida.newagenda.dao.FormAgendaDao
import br.com.thalesnishida.newagenda.module.Contact

class FormContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_contact)

        val buttonSave = findViewById<Button>(R.id.activity_form_button_save)
        buttonSave.setOnClickListener {
            val newContact = createContact()

            val dao = FormAgendaDao()
            dao.add(newContact)
            finish()
        }
    }

    private fun createContact(): Contact {
        val fieldName = findViewById<EditText>(R.id.activity_form_name)
        val name = fieldName.text.toString()
        val fieldNumber = findViewById<EditText>(R.id.activity_form_number)
        val number = fieldNumber.text.toString()

        return Contact(
            name = name,
            number = number
        )
    }
}