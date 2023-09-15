package br.com.thalesnishida.newagenda.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.thalesnishida.newagenda.R
import br.com.thalesnishida.newagenda.dao.FormAgendaDao
import br.com.thalesnishida.newagenda.module.Contact
import br.com.thalesnishida.newagenda.recyclerview.adapter.ListAgendaAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListAgendaActivity : AppCompatActivity() {

    private val dao = FormAgendaDao()
    private val adapter =  ListAgendaAdapter(context = this, contacts = dao.findAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_agenda)
        configRecyclerview()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_list_agenda_fab)
        fab.setOnClickListener {
            val intent = Intent(this, FormContactActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configRecyclerview() {
        val recyclerview = findViewById<RecyclerView>(R.id.activity_list_agenda_recyclerview)
        recyclerview.adapter = adapter
    }
}