package com.keepon.sushicounter01.ui.notifications



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.keepon.sushicounter01.R
import org.json.JSONObject


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var ktorGetText: TextView
    private lateinit var ktorDeleteText: TextView
    private lateinit var editDeleteText: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        ktorGetText = root.findViewById(R.id.text_notifications)
        ktorDeleteText = root.findViewById(R.id.text_ktor_delete)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            ktorGetText.text = it
        })

        val provaKTorButt : Button = root.findViewById(R.id.provaKTorButt)
        provaKTorButt.setOnClickListener{provaKTorCaller()}

        val provaKTorButtDelete : Button = root.findViewById(R.id.provaKTorButtDelete)

        editDeleteText = root.findViewById(R.id.ktorDeleteEditText)

        provaKTorButtDelete.setOnClickListener{
            val indiceToDelete = (editDeleteText.text ?: "-1").toString()
            provaKTorDelete(indiceToDelete)
        }

        return root
    }

    fun provaKTorCaller(){

        val queue = Volley.newRequestQueue(activity?.applicationContext)
        val url = "http://192.168.1.182:8080/book/lista"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->
                    // questo è il listener in caso di successo
                    ktorGetText.text = "Response is: $response"
                },
                { ktorGetText.text = "GET didn't work!" })    // questo è il listener in caso di errore

// Add the request to the RequestQueue.
        queue.add(stringRequest)

    }


    fun provaKTorDelete(indiceStr: String){

        val queue = Volley.newRequestQueue(activity?.applicationContext)

        val url = "http://192.168.1.182:8080/book/$indiceStr"

        val params = HashMap<String,String>()
        params["id"] = indiceStr
        //params["foo2"] = "bar2"
        val jsonObject = JSONObject(params as Map<*, *>)


        // Request a string response from the provided URL.
        val jsonRequest = StringRequest(Request.Method.DELETE, url,
                { response ->
                    // questo è il listener in caso di successo
                    ktorDeleteText.text = "Response is: $response"
                },
                { ktorDeleteText.text = "DELETE didn't work!" })    // questo è il listener in caso di errore

// Add the request to the RequestQueue.
        queue.add(jsonRequest)



    }
}