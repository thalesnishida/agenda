package br.com.thalesnishida.newagenda.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.thalesnishida.newagenda.R
import br.com.thalesnishida.newagenda.module.Contact

class ListAgendaAdapter(
    private val context: Context,
    contacts: List<Contact>
) : RecyclerView.Adapter<ListAgendaAdapter.ViewHolder>() {

    private val contacts = contacts.toMutableList()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun vincula(contact: Contact) {
            val name = itemView.findViewById<TextView>(R.id.contact_item_name)
            name.text = contact.name
            val number = itemView.findViewById<TextView>(R.id.contact_item_number)
            number.text = contact.number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.vincula(contact)
    }

    override fun getItemCount(): Int = contacts.size

    fun update(contacts: List<Contact>) {
        this.contacts.clear()
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }
}
